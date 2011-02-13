var CreateATMoPSNWizard = Class.create(CreateWizard, {
    initializeValidators: function() {
        this.validatorMap[1] = this.validateStep1;
        this.validatorMap[2] = this.validateStep2;
        this.validatorMap[3] = this.validateStep3;

        jQuery(window).ready(function() {
            var callback = function() {
                createATMoPSN.validateStep()
                };
            helperUtils.registerValidator("serviceATMoPSN:deviceName1", callback);
            helperUtils.registerValidator("serviceATMoPSN:moduleName1", callback);
            helperUtils.registerValidator("serviceATMoPSN:physicalPortName1", callback);

            helperUtils.registerValidator("serviceATMoPSN:deviceName2", callback);
            helperUtils.registerValidator("serviceATMoPSN:moduleName2", callback);
            helperUtils.registerValidator("serviceATMoPSN:physicalPortName2", callback);
            
            helperUtils.registerValidator("serviceATMoPSN:nameInput", callback);
            helperUtils.registerValidator("serviceATMoPSN:externalIdInput", callback);
            helperUtils.registerValidator("serviceATMoPSN:orderNumberInput", callback);
            helperUtils.registerValidator("serviceATMoPSN:VCIdInput", callback);
            helperUtils.registerValidator("serviceATMoPSN:encapsulationMenu", callback);
            helperUtils.registerValidator("serviceATMoPSN:CellPackingOptionCheckbox", callback);
            helperUtils.registerSpinnerValidator("serviceATMoPSN:CellPackingMaximumNumberOfCellsSpinner", callback);
            
            helperUtils.registerSpinnerValidator("serviceATMoPSN:vci", callback);
            helperUtils.registerSpinnerValidator("serviceATMoPSN:vpi", callback);
            helperUtils.registerValidator("serviceATMoPSN:CoSType", callback);
            
            helperUtils.registerSpinnerValidator("serviceATMoPSN:rate", callback);
            helperUtils.registerSpinnerValidator("serviceATMoPSN:outputMcr", callback);
            helperUtils.registerSpinnerValidator("serviceATMoPSN:outputScr", callback);
            helperUtils.registerSpinnerValidator("serviceATMoPSN:outputMaxBurstSize", callback);
      
        });
    },

    initializeStep: function(stepNumber){
        if (stepNumber == 2) {
            document.getElementById('serviceATMoPSN:TransportTypeMenu:0').onchange();
            this.getVCIdBetweenNEs();
        } else if (stepNumber == 3) {
            // trigger server-side VPI/VCI validation
            jQuery(helperUtils.escapeId('#serviceATMoPSN:vpi input'))[0].onchange();
        }
    },
    
    initializeIDs: function($super) {
        $super();
        this.stepBase = "serviceATMoPSN-step";
        this.stepTitleBase = "createATMoPSNTitle";
    },
    
    toggleCellPacking: function(){
        var disabled;
        var cellPackingOptionCheckBox = document.getElementById('serviceATMoPSN:CellPackingOptionCheckbox');

        if(cellPackingOptionCheckBox.checked){
            disabled = helperUtils.spinnerState.enabled;
        }
        else {
            disabled = helperUtils.spinnerState.disabled;
        }
        helperUtils.changeSpinnerState("serviceATMoPSN:CellPackingMaximumNumberOfCellsSpinner", disabled);
        helperUtils.changeElementStateById('serviceATMoPSN:CellPackingTimerMenu', disabled);
        helperUtils.changeTextState("serviceATMoPSN:CellPackingMaximumNumberOfCellsSpinnerRange", disabled);
    },
    
    setInputRowVisibility: function(parameterId, visible) {
    	// Get the parameter input box' table row (tr)
    	var parameterInput = helperUtils.getJQueryElementById(parameterId).parents("tr")[0];
    	
    	if (visible) {
    		parameterInput.style.display = "";
    	} else {
    		parameterInput.style.display = "none";
    	}
    },
    
    _validateStep1NE: function(NEId) {
        var result = true;
        
        if(document.getElementById('serviceATMoPSN:deviceProviderCore' + NEId).value == 'false'){
        	helperUtils.addMessageInfoTip("serviceATMoPSN:errorMessageId" + NEId, helperUtils.infoTipSeverity.error,
        			"NE must be Provider Core");
            result = false;
        }
        else {
            helperUtils.removeMessageInfoTip("serviceATMoPSN:errorMessageId" + NEId);
        }

        if(document.getElementById('serviceATMoPSN:deviceName' + NEId).value == '')
            result = false;

        if(document.getElementById('serviceATMoPSN:moduleName' + NEId).value == '')
            result = false;

        var physicalPortName = document.getElementById('serviceATMoPSN:physicalPortId' + NEId).value;
        if(physicalPortName == '')
            result = false;
        if (physicalPortName != document.getElementById('serviceATMoPSN:validPort' + NEId).value) {
            document.getElementById('serviceATMoPSN:validPort' + NEId).value = physicalPortName;
            document.getElementById('serviceATMoPSN:validPort' + NEId).onchange();
        }
        var physicalPortMessageId = "serviceATMoPSN:physicalPortMessageId" + NEId;
        var validPortMessageId = "serviceATMoPSN:validPort" + NEId + "Message";
        if (helperUtils.getInfoTipMessage(physicalPortMessageId) != helperUtils.getInfoTipMessage(validPortMessageId)) {
        	var validPortMessage = helperUtils.getJQueryElementById(validPortMessageId);
        	helperUtils.addMessageInfoTip("serviceATMoPSN:physicalPortMessageId" + NEId, helperUtils.infoTipSeverity.error,
        			validPortMessage.text());
        }
        if(helperUtils.hasInfoTipWarnOrHigher(physicalPortMessageId))
            result = false;
        
        return result;
    },
    
    /*
     * VBR-rt and VBR-nrt have similar validations (although the fields names vary)
     * so the same function can be used to perform these validations.
     */
    _validateStep3CoSVBR: function(pcrId, scrId, burstId, messageId, comparisonMessage) {
    	var result = true;
    	
    	var pcrValid = true;
		var scrValid = true;
		var pcrInput = helperUtils.getJQueryElementById(pcrId + " input")[0];
		var scrInput = helperUtils.getJQueryElementById(scrId + " input")[0];
		var burstInputs = helperUtils.getJQueryElementById(burstId + " input");
		var scrMessage = helperUtils.getJQueryElementById(messageId);
		
		if (!validatorUtils.validateNumberInputSpinner(pcrId, true, "serviceATMoPSN:rateMessage", true)) {
			pcrValid = false;
			result = false;
		}
		if (!validatorUtils.validateNumberInputSpinner(scrId, true, "serviceATMoPSN:outputScrMessage", true)) {
			scrValid = false;
			result = false;
		}
		
		var messageText = "";
		var burstState = helperUtils.spinnerState.enabled;
		if (pcrValid && scrValid) {
		    if (parseInt(scrInput.value) > parseInt(pcrInput.value)) {
				messageText = comparisonMessage;
				result = false;
			} else if (scrInput.value == pcrInput.value) {
				burstInputs[0].value = "1";
				burstState = helperUtils.spinnerState.readonly;
			}
		}
		if(messageText != ""){
			helperUtils.addMessageInfoTip("serviceATMoPSN:outputScrMessage", helperUtils.infoTipSeverity.error,	messageText);
		} else if(scrValid){
			helperUtils.removeMessageInfoTip("serviceATMoPSN:outputScrMessage");
		}
		helperUtils.changeElementState(burstInputs, burstState);
		
		if(scrInput.value != pcrInput.value){
			if (!validatorUtils.validateNumberInputSpinner(burstId, true, "serviceATMoPSN:outputMaxBurstSizeMessage", true)) {
				result = false;
			}
    	} else {
    		helperUtils.removeMessageInfoTip("serviceATMoPSN:outputMaxBurstSizeMessage");
    	}
		
    	return result;
    },
    
    _validateStep3CoS: function() {
    	var result = true;
    	var cosTypeInput = helperUtils.getJQueryElementById("serviceATMoPSN:CoSType")[0];
    	index = cosTypeInput.selectedIndex;
    	var cosType = cosTypeInput.options[index].value;
    	
    	createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", false);
    	createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputMcr", false);
    	createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputScr", false);
    	createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputMaxBurstSize", false);
    	
    	if (cosType == "CBR") {
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", true);
    		
    		if (!validatorUtils.validateNumberInputSpinner("serviceATMoPSN:rate", true, "serviceATMoPSN:rateMessage", true))
    			result = false;
    	} else if (cosType == "UBR") {
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", true);
    		
    		if (!validatorUtils.validateNumberInputSpinner("serviceATMoPSN:rate", true, "serviceATMoPSN:rateMessage", true))
    			result = false;
    	} else if (cosType == "UBR_Plus") {
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", true);
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputMcr", true);
    		
    		if (!validatorUtils.validateNumberInputSpinner("serviceATMoPSN:rate", true, "serviceATMoPSN:rateMessage", true))
    			result = false;
    		else {
    			var outputPcrInput = helperUtils.getJQueryElementById("serviceATMoPSN:rate input")[0];
    		}
    			
    		if (!validatorUtils.validateNumberInputSpinner("serviceATMoPSN:outputMcr", true, "serviceATMoPSN:outputMcrMessage", true))
    			result = false;
    	} else if (cosType == "VBR_NRT") {
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", true);
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputScr", true);
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputMaxBurstSize", true);
    		
    		// TODO string internationalization
    		if (!createATMoPSN._validateStep3CoSVBR("serviceATMoPSN:rate",
    				"serviceATMoPSN:outputScr", "serviceATMoPSN:outputMaxBurstSize",
    				"serviceATMoPSN:outputScrMessage", natMessagesBundle.error_ScrLessEqualPcr))
    			result = false;
     	} else if (cosType == "VBR_RT") {
     		createATMoPSN.setInputRowVisibility("serviceATMoPSN:rate", true);
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputScr", true);
    		createATMoPSN.setInputRowVisibility("serviceATMoPSN:outputMaxBurstSize", true);
     		
     		// TODO string internationalization
     		if (!createATMoPSN._validateStep3CoSVBR("serviceATMoPSN:rate",
     				"serviceATMoPSN:outputScr", "serviceATMoPSN:outputMaxBurstSize", 
     				"serviceATMoPSN:outputScrMessage",  natMessagesBundle.error_ScrLessEqualPcr))
    			result = false;
     	}
    	
    	helperUtils.updateMandatoryFields();
    	return result;
    },

    validateStep1: function() {
    	var result = createATMoPSN._validateStep1NE("1");
        result &= createATMoPSN._validateStep1NE("2");
      	
		if(document.getElementById('serviceATMoPSN:deviceName1').value != '' &&
				document.getElementById('serviceATMoPSN:deviceName1').value ==
				document.getElementById('serviceATMoPSN:deviceName2').value) {
			helperUtils.addMessageInfoTip("serviceATMoPSN:errorMessageId1", helperUtils.infoTipSeverity.error, natMessagesBundle.error_nesMustBeDifferent);
			result = false;
		}

        if (helperUtils.getJQueryElementById('serviceATMoPSN:serviceCapabilities1').data("supportsServiceType") === false) {
        	helperUtils.addMessageInfoTip("serviceATMoPSN:physicalPortMessageId1", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_portServiceTypeNotSupported);
            result = false;
        } else {
           	helperUtils.removeMessageInfoTip("serviceATMoPSN:physicalPortMessageId1");
        }

        if (helperUtils.getJQueryElementById('serviceATMoPSN:serviceCapabilities2').data("supportsServiceType") === false) {
           	helperUtils.addMessageInfoTip("serviceATMoPSN:physicalPortMessageId2", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_portServiceTypeNotSupported);
            result = false;
        } else {
           	helperUtils.removeMessageInfoTip("serviceATMoPSN:physicalPortMessageId2");
        }
  
        return result;
    },

    validateStep2: function() {
    	var result = true;
    	
        if(document.getElementById('serviceATMoPSN:nameInput').value == '')
            result = false;

        if(document.getElementById('serviceATMoPSN:externalIdInput').value == '')
        	result = false;

        if(!validatorUtils.validateNumberInput('serviceATMoPSN:orderNumberInput', 0, 2147483647, true, "serviceATMoPSN:orderNumberInputMessage", true))
        	result = false;

        if (!validatorUtils.validateNumberInput("serviceATMoPSN:VCIdInput", 1, 4294967295, true, "serviceATMoPSN:VCIdInputErrorMessage", true))
        	result = false;
        

        result = result && createATMoPSN.validateVCIdBetweenNEs();

        if(helperUtils.hasInfoTip('serviceATMoPSN:transportTypeMenuMessage')) {
    		helperUtils.changeElementStateById('serviceATMoPSN:TransportTypeMenu:2', helperUtils.spinnerState.disabled);
    	} else {
    		helperUtils.changeElementStateById('serviceATMoPSN:TransportTypeMenu:2', helperUtils.spinnerState.enabled);
    	}
    	
    	var transportType = helperUtils.getSelectedValueFromRadioButtonGroup("serviceATMoPSN:TransportTypeMenu");
    	cosControllerATMoPSN.updateAllRangesForTransportType(transportType);

        return result;
    },
    
    validateStep3: function() {
    	// Components visibility
    	var vcTransportParametersPanel = document.getElementById("serviceATMoPSN:DetailsTransportParametersPanel");
    	var cellPackingParametersPanel = document.getElementById("serviceATMoPSN:CellPackingParametersPanel");
    	var cellPackingOptionCheckbox = document.getElementById('serviceATMoPSN:CellPackingOptionCheckbox');
    	var cellPackingCells = 'serviceATMoPSN:CellPackingMaximumNumberOfCellsSpinner';
    	var cellPackingTimerSelectBox = document.getElementById("serviceATMoPSN:CellPackingTimerMenu");
    	
    	var selectedTransportType = helperUtils.getSelectedValueFromRadioButtonGroup("serviceATMoPSN:TransportTypeMenu");
    	if (selectedTransportType == "vcTransport" ||
    			selectedTransportType == "vpTransport") {
    		vcTransportParametersPanel.style.display = '';
    		
    		if (selectedTransportType == "vpTransport") {
    			createATMoPSN.setInputRowVisibility("serviceATMoPSN:vci", false);
    			createATMoPSN.setInputRowVisibility("serviceATMoPSN:encapsulationMenu", false);
    			
    			helperUtils.changeElementState(jQuery(cellPackingOptionCheckbox), helperUtils.spinnerState.enabled );
				helperUtils.changeSpinnerState(cellPackingCells, helperUtils.spinnerState.enabled );
				helperUtils.changeElementState(jQuery(cellPackingTimerSelectBox), helperUtils.spinnerState.enabled );
    		} else {
    			createATMoPSN.setInputRowVisibility("serviceATMoPSN:vci", true);
    			createATMoPSN.setInputRowVisibility("serviceATMoPSN:encapsulationMenu", true);
    			
		    	var encapsulationSelectBox = document.getElementById("serviceATMoPSN:encapsulationMenu");
		    	index = encapsulationSelectBox.selectedIndex;
				if(encapsulationSelectBox.options[index].value == "AAL0") {
					helperUtils.changeElementState(jQuery(cellPackingOptionCheckbox), helperUtils.spinnerState.enabled );
					helperUtils.changeSpinnerState(cellPackingCells, helperUtils.spinnerState.enabled );
					helperUtils.changeElementState(jQuery(cellPackingTimerSelectBox), helperUtils.spinnerState.enabled );
				} else {
					helperUtils.changeElementState(jQuery(cellPackingOptionCheckbox), helperUtils.spinnerState.disabled );
					helperUtils.changeSpinnerState(cellPackingCells, helperUtils.spinnerState.disabled );
					helperUtils.changeElementState(jQuery(cellPackingTimerSelectBox), helperUtils.spinnerState.disabled );
				}
    		}
    	} else {
    		vcTransportParametersPanel.style.display = 'none';
			helperUtils.changeElementState(jQuery(cellPackingOptionCheckbox), helperUtils.spinnerState.enabled );
			helperUtils.changeSpinnerState(cellPackingCells, helperUtils.spinnerState.enabled );
			helperUtils.changeElementState(jQuery(cellPackingTimerSelectBox), helperUtils.spinnerState.enabled );
    	}
		
    	// Validation
    	var result = true;
    	if (selectedTransportType == "vcTransport" ||
    			selectedTransportType == "vpTransport") {
	    	if(!validatorUtils.validateNumberInputSpinner('serviceATMoPSN:vpi', true, '', true))
	        	result = false;
	    	if(helperUtils.hasInfoTipWarnOrHigher('serviceATMoPSN:vpiMessage'))
	    		result = false;
	    	var vciRange = helperUtils.getJQueryElementById('serviceATMoPSN:vciEdit').data("spinner");
	    	if (helperUtils.getJQueryElementById('serviceATMoPSN:vpi input')[0].value === "0") {
	    		if (vciRange.min != 1) {
	    			helperUtils.updateSpinnerRange({min: 1, max: vciRange.max}, 'serviceATMoPSN:vci');
	    		}
	    	} else {
	    		if (vciRange.min != 0) {
	    			helperUtils.updateSpinnerRange({min: 0, max: vciRange.max}, 'serviceATMoPSN:vci');
	    		}
	    	}
    	}
    	if (selectedTransportType == "vcTransport") {
	    	if(!validatorUtils.validateNumberInputSpinner('serviceATMoPSN:vci', true, '', true))
	        	result = false;
	    	if(helperUtils.hasInfoTipWarnOrHigher('serviceATMoPSN:vciMessage'))
	    		result = false;
    	}
    	
		if(cellPackingOptionCheckbox.checked && !cellPackingOptionCheckbox.disabled){
			if (!validatorUtils.validateNumberInputSpinner(cellPackingCells, true, "serviceATMoPSN:CellPackingMaximumNumberOfCellsSpinnerMessage", true))
				result = false;
        } else {
			helperUtils.changeSpinnerState(cellPackingCells, helperUtils.spinnerState.disabled );
			helperUtils.changeElementState(jQuery(cellPackingTimerSelectBox), helperUtils.spinnerState.disabled );
        }
    
		if (!createATMoPSN._validateStep3CoS())
			result = false;
    
		return result;
    }
});

var createATMoPSN = new CreateATMoPSNWizard(4, "serviceATMoPSN", "createATMoPSNPanel");

