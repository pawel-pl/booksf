var MTUController = Class.create(BaseController, {
    initialize: function($super, formId, panelId, dialogId) {
        $super(formId, panelId, dialogId);

        this.mtuId = "serviceELine:mtu" + parseInt(panelId);
        this.formId = formId;
        this.panelId = panelId;

        this.mtu = {min:0, max:0};
        this.mtuPSvi = {min:0, max:0};
    },

    setupDialog: function(formSubmitted) {
        if(formSubmitted) {
            this.bindMappingMenu(this.panelId, this.formId);
        }
    },

    resetFormCallback: function() {
        var mtuSpinner = helperUtils.getJQueryElementById(this.mtuId + "Edit").data("spinner");
        if (typeof(mtuSpinner) !== "undefined") {
            mtuSpinner.resetRanges();
        }
    },

    portCapabilitiesCallback: function(serviceCapabilities) {
        this.updateRangesFromCapabilities(serviceCapabilities.portCapabilities);
    },

    updateRangesFromCapabilities: function(capabilities) {
        if(capabilities !== "") {
            if(helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuName])
                    && helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuName].min)
                    && helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuName].max) ){

                this.mtu.min = parseInt(Number(capabilities[natConstantsBundle.capabilities_mtuName].min));
                this.mtu.max = parseInt(Number(capabilities[natConstantsBundle.capabilities_mtuName].max));
            }

	        if(helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuPSviName])
	                && helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuPSviName].min)
	                && helperUtils.isVariableDefined(capabilities[natConstantsBundle.capabilities_mtuPSviName].max) ){

                this.mtuPSvi.min = parseInt(Number(capabilities[natConstantsBundle.capabilities_mtuPSviName].min));
                this.mtuPSvi.max = parseInt(Number(capabilities[natConstantsBundle.capabilities_mtuPSviName].max));
            }


            this.updateMtuSpinnerRange();
        }
    },

    updateMtuSpinnerRange: function() {
        var endpointMappingMenu = helperUtils.getJQueryElementById("serviceELine:endpointMappingMenu" + this.panelId)[0];

        var mtuField = helperUtils.getJQueryElementById(this.mtuId + "Edit");
        var mtuTextField = mtuField.find("input[type=text]");
        var mtuSpinner = mtuField.data("spinner");

        if (endpointMappingMenu.value.toLowerCase() == "port"|| (this.mtuPSvi.min == 0 && this.mtuPSvi.max == 0)) {
        	mtuSpinner.changeRange(this.mtu.min, this.mtu.max, mtuSpinner.delta);
        } else if (endpointMappingMenu.value.toLowerCase() == "vlan") {
        	mtuSpinner.changeRange(this.mtuPSvi.min, this.mtuPSvi.max, mtuSpinner.delta);
        }

        mtuTextField.change();
    },

    bindMappingMenu: function(panelId, formId) {
    	var context = this;
    	var callback = function() {
    		context.updateMtuSpinnerRange();
    	};

    	var mappingMenuId = formId + ":endpointMappingMenu" + panelId;
    	helperUtils.registerValidator(mappingMenuId, callback);
    }

});
