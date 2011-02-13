var TransportTypeController = Class.create(BaseController, {
    initialize: function($super, formId, dialogId) {
        $super(formId, [1, 2], dialogId);

        this.transportTypeId = formId + ":TransportTypeMenu input";
        this.maximumNumberOfCellsId = formId + ":CellPackingMaximumNumberOfCellsSpinner";
        this.maximumNumberOfCellsRanges = [{min:0, max:0}, {min:0, max:0}];
        this.maximumNumberOfCellsRange = {min:0, max:0};
        
        this.formId = formId;
        this.serviceTypes = [[], []];
        this.encapsulation = [[], []];
    },
    
    resetSpinner: function(spinnerId) {
    	var spinner = helperUtils.getJQueryElementById(spinnerId + "Edit").data("spinner");
    	if (typeof(spinner) !== "undefined") {
    		spinner.resetRanges();
    	}
    },
    
    resetFormCallback: function() {
    	this.resetSpinner(this.maximumNumberOfCellsId);
    },
    
    portCapabilitiesCallback: function(serviceCapabilities, panelId) {
        this.updateSupportedTransportTypeFromCapabilities(serviceCapabilities.portCapabilities, panelId);
        this.updateAvailableEncapsulation(serviceCapabilities.portCapabilities, panelId);
        this.updateMaxNumberOfCellsFromCapabilities(serviceCapabilities.portCapabilities, panelId);
    },
    
    updateSupportedTransportTypeFromCapabilities: function(capabilities, panelId) {
        if(capabilities === "") {
        	return;
        }
        var serviceTypes = capabilities[natConstantsBundle.capabilities_serviceTypeName];
        if(!helperUtils.isVariableDefined(serviceTypes)){
        	return;
        }
        this.serviceTypes[panelId - 1] = serviceTypes;
        var fullServiceTypes = helperUtils.arrayIntersection(this.serviceTypes[0], this.serviceTypes[1]);
        var transportRadioGroup = helperUtils.getJQueryElementById(this.transportTypeId);
    	for(var i = 0; i < transportRadioGroup.length; i++){
    		var transportRadio = transportRadioGroup[i];
    		var transportRadioId = transportRadio.id;
    		if(!helperUtils.isValueInList(fullServiceTypes, transportRadio.value)){
    			helperUtils.changeElementStateById(transportRadioId, helperUtils.spinnerState.disabled);
    		} else {
    			helperUtils.changeElementStateById(transportRadioId, helperUtils.spinnerState.enabled);
    		}
    	}          
    },
    
    updateMaxNumberOfCellsFromCapabilities: function(capabilities, panelId) {
    	if(capabilities === "") {
    		return;
    	}
    	this.updateRangeFromCapability(capabilities[natConstantsBundle.capabilities_maxNumberOfCells],
    			panelId, this.maximumNumberOfCellsRanges, this.maximumNumberOfCellsRange, this.maximumNumberOfCellsId);
    },

    updateAvailableEncapsulation: function(capabilities, panelId) {
    	if(capabilities === "") {
    		return;
    	}
    	var panelEncapsulation = capabilities[natConstantsBundle.capabilities_vcEncapsulation];
    	if (!helperUtils.isVariableDefined(panelEncapsulation)) {
    		return;
    	}
    	this.encapsulation[panelId - 1] = panelEncapsulation;
    	var fullEncapsulation = helperUtils.arrayIntersection(this.encapsulation[0], this.encapsulation[1]);
    	var encapsulationTypeMenuItems = jQuery(helperUtils.escapeId("#" + this.formId + ":encapsulationMenu option"));
    	for (var i = 0; i < encapsulationTypeMenuItems.length; i++) {
    		encapsulationTypeMenuItem = encapsulationTypeMenuItems[i]; 
    		if (helperUtils.isValueInList(fullEncapsulation, encapsulationTypeMenuItem.value)) {
    			encapsulationTypeMenuItem.disabled = false;
    		} else {
    			encapsulationTypeMenuItem.disabled = true;
    		}
    	}
    }

});
