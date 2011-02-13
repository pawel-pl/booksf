var CoSController = Class.create(BaseController, {
    initialize: function($super, formId, dialogId) {
        $super(formId, [1, 2], dialogId);

        this.rateId = formId + ":rate";
        this.outputMcrId = formId + ":outputMcr";
        this.outputScrId = formId + ":outputScr";
        this.outputMaxBurstSizeId = formId + ":outputMaxBurstSize";
        this.formId = formId;
        
        this.transportType = "";

        this.rates = [{min:0, max:0}, {min:0, max:0}];
        this.outputMcrs = [{min:0, max:0}, {min:0, max:0}];
        this.outputScrs = [{min:0, max:0}, {min:0, max:0}];
        this.outputMaxBurstSizes = [{min:0, max:0}, {min:0, max:0}];
        
        this.rate = {min:0, max:0};
        this.outputMcr = {min:0, max:0};
        this.outputScr = {min:0, max:0};
        this.outputMaxBurstSize = {min:0, max:0};
        
        this.cos = [[], []];
        this.cosSupportedBy = [[], []];
        this.capabilities = [];
    },
    
    resetSpinner: function(spinnerId) {
    	var spinner = helperUtils.getJQueryElementById(spinnerId + "Edit").data("spinner");
    	if (typeof(spinner) !== "undefined") {
    		spinner.resetRanges();
    	}
    },

    resetFormCallback: function() {
    	this.resetSpinner(this.rateId);
    	this.resetSpinner(this.outputMcrId);
    	this.resetSpinner(this.outputScrId);
    	this.resetSpinner(this.outputMaxBurstSizeId);
    },

    portCapabilitiesCallback: function(capabilities, panelId) {
    	if(capabilities !== "") {
        	this.capabilities[panelId - 1] = capabilities.portCapabilities;
        	this.updateRangesFromCapabilities(panelId);
        	this.updateAvailableCoSTypes(panelId);
    	}
    },
    
    updateAllRangesForTransportType: function(transportType) {
    	if (helperUtils.isVariableDefined(transportType) && transportType === this.transportType) {
    		// Transport type didn't change, no need to update
    		return;
    	}
    	this.updateRangesFromCapabilities(1, transportType);
    	this.updateRangesFromCapabilities(2, transportType);
    	this.updateAvailableCoSTypes(1);
    	this.updateAvailableCoSTypes(2);
    },
    
    updateRangesFromCapabilities: function(panelId, transportType) {
    	var capabilities = this.capabilities[panelId - 1];
    	if(capabilities === "") {
    		return;
    	}
    	
    	if (!helperUtils.isVariableDefined(transportType)) {
    		transportType = helperUtils.getSelectedValueFromRadioButtonGroup("serviceATMoPSN:TransportTypeMenu");
    	}
    	this.transportType = transportType;
    	var minimumGuaranteedCellRate = "";
    	var maximumBurstSize = "";
    	if (transportType == "vcTransport") {
    		minimumGuaranteedCellRate = natConstantsBundle.capabilities_vcMinimumGuaranteedCellRate;
    		maximumBurstSize = natConstantsBundle.capabilities_vcMaximumBurstSize;
    	} else if (transportType == "vpTransport") {
    		minimumGuaranteedCellRate = natConstantsBundle.capabilities_vpMinimumGuaranteedCellRate;
    		maximumBurstSize = natConstantsBundle.capabilities_vpMaximumBurstSize;
    	}

    	this.updateRangeFromCapability(capabilities[natConstantsBundle.capabilities_peakCellRate],
    			panelId, this.rates, this.rate, this.rateId);
    	this.updateRangeFromCapability(capabilities[minimumGuaranteedCellRate],
    			panelId, this.outputMcrs, this.outputMcr, this.outputMcrId);
    	this.updateRangeFromCapability(capabilities[natConstantsBundle.capabilities_sustainableCellRate],
    			panelId, this.outputScrs, this.outputScr, this.outputScrId);
    	this.updateRangeFromCapability(capabilities[maximumBurstSize],
    			panelId, this.outputMaxBurstSizes, this.outputMaxBurstSize, this.outputMaxBurstSizeId);
    },

    updateAvailableCoSTypes: function(panelId) {
    	var capabilities = this.capabilities[panelId - 1];
    	if(capabilities === "") {
    		return;
    	}
    	
    	var panelCoS = capabilities[natConstantsBundle.capabilities_cos];
    	var panelCoSSuportedBy = capabilities[natConstantsBundle.capabilities_cosSuportedBy];
    	
    	if (!helperUtils.isVariableDefined(panelCoS)) {
    		return;
    	}
    	this.cos[panelId - 1] = panelCoS;
    	this.cosSupportedBy[panelId -1] = panelCoSSuportedBy;
    
    	var fullCoS ="";
    	if(this.cosSupportedBy[0].contains(this.transportType) && this.cosSupportedBy[1].contains(this.transportType)){
    		fullCoS = helperUtils.arrayIntersection(this.cos[0], this.cos[1]);
    	} else if(this.cosSupportedBy[0].contains(this.transportType)){
    		fullCoS = this.cos[0];
    	} else if(this.cosSupportedBy[1].contains(this.transportType)){
    		fullCoS = this.cos[1];
    	}
    	
    	var cosTypeMenuItems = jQuery(helperUtils.escapeId("#" + this.formId + ":CoSType option"));
    	for (var i = 0; i < cosTypeMenuItems.length; i++) {
    		cosTypeMenuItem = cosTypeMenuItems[i]; 
    		if (helperUtils.isValueInList(fullCoS, cosTypeMenuItem.value)) {
    			cosTypeMenuItem.disabled = false;
    		} else {
    			cosTypeMenuItem.disabled = true;
    		}
    	}
    }

});
