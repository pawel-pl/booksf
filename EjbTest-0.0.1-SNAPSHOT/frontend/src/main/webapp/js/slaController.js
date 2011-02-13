var SlaController = Class.create(BaseController, {
    initialize: function($super, formId, panelId, dialogId, autoBurstSizeCheckId, cirId, cbsId, pirId, pbsId) {
        $super(formId, panelId, dialogId);

        this.autoBurstSizeCheckId = autoBurstSizeCheckId;
        this.cirId = cirId;
        this.cbsId = cbsId;
        this.pirId = pirId;
        this.pbsId = pbsId;
        this.formId = formId;
        this.panelId = panelId;
    },

    setupDialog: function(formSubmitted) {
        var autoBurstSizeCheck = helperUtils.getJQueryElementById(this.autoBurstSizeCheckId);
        this.switchAutoBurstSizeCheck(autoBurstSizeCheck);

        if(formSubmitted) {
            /** fix for IE behavior with the change event of check boxes */
            helperUtils.checkboxChangeStateFix(autoBurstSizeCheck);

            var context = this;
            autoBurstSizeCheck.change(function(){
                context.switchAutoBurstSizeCheck(this);
            });

            this.bindRangeDependency(this.cirId + "Edit", this.pirId + "Edit");
            this.bindRangeDependency(this.cbsId + "Edit", this.pbsId + "Edit");

            this.bindAutomaticBurstSize(this.cirId + "Edit", this.cbsId + "Edit");
            this.bindAutomaticBurstSize(this.pirId + "Edit", this.pbsId + "Edit");
        }
    },

    switchAutoBurstSizeCheck: function(element) {
        // update the spinner state depending on the mapping used.
        if (jQuery(element).attr('checked')) {
            helperUtils.changeSpinnerState(this.cbsId, helperUtils.spinnerState.readonly);
            helperUtils.changeSpinnerState(this.pbsId, helperUtils.spinnerState.readonly);
 
            // update cbs and pbs with automatic burst size formula
            this.updateBurstSize();
        }
        else {
            helperUtils.changeSpinnerState(this.cbsId, helperUtils.spinnerState.enabled);
            helperUtils.changeSpinnerState(this.pbsId, helperUtils.spinnerState.enabled);
        }
    },

    bindSymmetryDependency: function(source, current) {
        var context = this;
        jQuery().bind("symmetric.createELine", function(event, checked){
            context.symmetricConfigurationTriggered(source, current, checked);
        });

    },

    bindRangeDependency: function(sourceId, destinationId) {
        var sourceField = helperUtils.getJQueryElementById(sourceId);
        var sourceTextField = sourceField.find("input[type=text]");
        var destinationField = helperUtils.getJQueryElementById(destinationId);

        var callback = function() {
            var sourceSpinnerObject = sourceField.data("spinner");
            var destinationSpinnerObject = destinationField.data("spinner");

            // pbs and pir must be greater or equal than cbs and cir
            var value = sourceTextField.val();

            if(value !== "" && !isNaN(value)){
                var min = parseInt(Number(value));

                if(min < sourceSpinnerObject.min){
                    min = sourceSpinnerObject.min;
                }
                else if(min > sourceSpinnerObject.max) {
                    min = sourceSpinnerObject.max;
                }

                destinationField.data("spinner").changeRange(min, destinationSpinnerObject.max, destinationSpinnerObject.delta);
            }
        };

        helperUtils.registerValidatorElement(sourceTextField, callback);
    },

    resetFormCallback: function() {
        var cirSpinner = helperUtils.getJQueryElementById(this.cirId + "Edit").data("spinner");
        var pirSpinner = helperUtils.getJQueryElementById(this.pirId + "Edit").data("spinner");
        cirSpinner.resetRanges();
        pirSpinner.resetRanges();
    },

    portCapabilitiesCallback: function(serviceCapabilities) {
        if(serviceCapabilities.deviceCapabilities === "") {
            return;
        }
        var policingSupported = serviceCapabilities.deviceCapabilities[natConstantsBundle.capabilities_policingSupportName];
        var serviceTypesList = serviceCapabilities.portCapabilities[natConstantsBundle.capabilities_serviceTypeName];
        if(helperUtils.isVariableDefined(policingSupported) && helperUtils.isVariableDefined(serviceTypesList)) {
            var serviceTypeSupported = helperUtils.isValueInList(serviceTypesList, natConstantsBundle.capabilities_serviceTypeELine);
            if(Boolean(policingSupported) && serviceTypeSupported) {
                this.updateSlaRangesFromCapabilities(serviceCapabilities.portCapabilities);
            }
        }
    },

    updateSlaRangesFromCapabilities: function(capabilities) {
        if(capabilities === "") {
            return;
        }
        var cirRange = this.getCirPirRanges(capabilities, natConstantsBundle.capabilities_cirName);
        var pirRange = this.getCirPirRanges(capabilities, natConstantsBundle.capabilities_pirName);

        var cirField = helperUtils.getJQueryElementById(this.cirId + "Edit");
        var cirTextField = cirField.find("input[type=text]");
        var cirSpinner = cirField.data("spinner");

        var pirField = helperUtils.getJQueryElementById(this.pirId + "Edit");
        var pirTextField = pirField.find("input[type=text]");
        var pirSpinner = pirField.data("spinner");

        if(helperUtils.isVariableDefined(cirRange) && helperUtils.isVariableDefined(pirRange)) {
            var cirValue = cirTextField.val();
            if(cirValue !== "" && !isNaN(cirValue)){
                var currentCir = parseInt(Number(cirValue));

                if(currentCir < pirRange.min){
                    currentCir = pirRange.min;
                }

                cirSpinner.changeRange(cirRange.min, cirRange.max, cirSpinner.delta);
                pirSpinner.changeRange(currentCir, pirRange.max, pirSpinner.delta);
                cirTextField.change();
                pirTextField.change();
            }
        }
        else {
            cirSpinner.resetRanges();
            pirSpinner.resetRanges();
        }
    },

    getCirPirRanges: function(capabilities, rangeName) {
        var range = capabilities[rangeName];
        if(helperUtils.isVariableDefined(range)) {
            range.min = capabilities[rangeName].min;
            range.max = capabilities[rangeName].max;
            if( helperUtils.isVariableDefined(range.min) && helperUtils.isVariableDefined(range.max) ){

                var kbps_to_bps = natConstantsBundle.factor_kbps_to_bps;
                if(kbps_to_bps !== 0){
                    range.min = parseInt(Number(range.min)) / kbps_to_bps;
                    range.max = parseInt(Number(range.max)) / kbps_to_bps;
                }
                else {
                    range.min = parseInt(Number(range.min));
                    range.max = parseInt(Number(range.max));
                }
             }
        }
        return range;
    },

    bindAutomaticBurstSize: function(sourceId, destinationId) {
        var sourceTextField = helperUtils.getJQueryElementById(sourceId).find("input[type=text]");
        var callback = this.burstSizeCallback(sourceId, destinationId);
        
        helperUtils.registerValidatorElement(sourceTextField, callback);
    },

    symmetricConfigurationTriggered: function(source, current, checked) {
    	if (!helperUtils.getJQueryElementById("serviceELine:symmetricConfigCheckbox").attr('disabled')) {
            var sourcePanel = helperUtils.getJQueryElementById(source);
            var currentPanel = helperUtils.getJQueryElementById(current);
	        var sourceInputList = sourcePanel.find('input');
	        var currentInputList = currentPanel.find('input');
	
	        for(var i = 0; i < sourceInputList.length; i++) {
	            var currentInputField = jQuery(currentInputList[i]);
	
	            if(checked) {
	                currentInputField.val(jQuery(sourceInputList[i]).val());
	                helperUtils.changeElementState(currentInputField, helperUtils.spinnerState.readonly );
	            }
	            else {
	                helperUtils.changeElementState(currentInputField, helperUtils.spinnerState.enabled );
	            }
	        }
	
            var autoBurstSizeCheck = helperUtils.getJQueryElementById(this.autoBurstSizeCheckId);
	        if(checked){
	        	helperUtils.changeElementState(autoBurstSizeCheck, helperUtils.spinnerState.disabled );
	        }
	        else {
	        	helperUtils.changeElementState(autoBurstSizeCheck, helperUtils.spinnerState.enabled );
	            this.switchAutoBurstSizeCheck(autoBurstSizeCheck);
	        }
    	}
    },

    updateBurstSize: function() {
        var updateCbs = this.burstSizeCallback(this.cirId + "Edit", this.cbsId + "Edit");
        updateCbs();

        var updatePbs = this.burstSizeCallback(this.pirId + "Edit", this.pbsId + "Edit");
        updatePbs();
    },

    burstSizeCallback: function(sourceId, destinationId) {
        var sourceField = helperUtils.getJQueryElementById(sourceId);
        var sourceTextField = sourceField.find("input[type=text]");
        var sourceSpinner = sourceField.data("spinner");
        var destinationTextField = helperUtils.getJQueryElementById(destinationId).find("input[type=text]");
        var autoBurstSizeCheck = helperUtils.getJQueryElementById(this.autoBurstSizeCheckId);
        var context = this;

        var callback = function() {

            if(autoBurstSizeCheck.attr('checked') && sourceSpinner.isCurrentValueValid()){
                var sourceValue = sourceTextField.val();
                destinationTextField.val( context.calculateBurstSize(sourceValue) ).change();
            }
        };

        return callback;
    },

    calculateBurstSize: function(sourceValue){
        return Math.ceil(((sourceValue * 1000) / 8) * 1.5);
    }
});
