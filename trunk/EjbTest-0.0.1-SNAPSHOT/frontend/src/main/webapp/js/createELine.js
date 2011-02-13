var CreateELineWizard = Class.create(CreateWizard, {
    initializeValidators: function() {
        this.validatorMap[1] = this.validateStep1;
        this.validatorMap[2] = this.validateStep2;
        this.validatorMap[3] = this.validateStep3;
         
        jQuery(window).ready(function() {
            var callback = function(){
                createELineWizard.validateStep();
            };
            helperUtils.registerValidator("serviceELine:nameInput", callback);
            helperUtils.registerValidator("serviceELine:externalIdInput", callback);
            helperUtils.registerValidator("serviceELine:orderNumberInput", callback);
            helperUtils.registerValidator("serviceELine:VCIdInput", callback);

            helperUtils.registerValidator("serviceELine:deviceName1", callback);
            helperUtils.registerValidator("serviceELine:moduleName1", callback);
            helperUtils.registerValidator("serviceELine:physicalPortName1", callback);

            helperUtils.registerValidator("serviceELine:deviceName2", callback);
            helperUtils.registerValidator("serviceELine:moduleName2", callback);
            helperUtils.registerValidator("serviceELine:physicalPortName2", callback);
            
            helperUtils.registerValidator("serviceELine:endpointMappingMenu1", callback);
            helperUtils.registerValidator("serviceELine:endpointMappingMenu2", callback);
            helperUtils.registerSpinnerValidator("serviceELine:endpointMappingVlanSpinner1", callback);
            
            helperUtils.registerSpinnerValidator("serviceELine:mtu1", callback);
            helperUtils.registerSpinnerValidator("serviceELine:mtu2", callback);
        });
    },
    
    initializeIDs: function($super) {
        $super();
        this.stepBase = "serviceELine-step";
        this.stepTitleBase = "createELineTitle";
    },

    validateStep1: function() {

    	var result = true;
        if (document.getElementById('serviceELine:deviceProviderCore1').value == 'false') {
        	helperUtils.addMessageInfoTip("serviceELine:errorMessageId1", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_neNotProviderCore);
            result = false;
        } else {
        	helperUtils.removeMessageInfoTip("serviceELine:errorMessageId1");
        }
        
        if (helperUtils.getJQueryElementById('serviceELine:serviceCapabilities1').data("supportsServiceType") === false) {
        	helperUtils.addMessageInfoTip("serviceELine:physicalPortMessageId1", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_portServiceTypeNotSupported);
            result = false;
        } else {
        	helperUtils.removeMessageInfoTip("serviceELine:physicalPortMessageId1");
        }

        if (document.getElementById('serviceELine:deviceName1').value == '' ||
                document.getElementById('serviceELine:moduleName1').value == '' ||
                document.getElementById('serviceELine:physicalPortName1').value == '') {
            result = false;
        }
        
        if(document.getElementById("serviceELine:endpointMappingMenu1").value == 'VLAN') {
	        var vlanSpinnerId = "serviceELine:endpointMappingVlanSpinner1";
	        var vlanSpinnerField = helperUtils.getJQueryElementById(vlanSpinnerId + "Edit");
	        var vlanSpinnerTextField = vlanSpinnerField.find("input[type=text]");
	        var vlanSpinner = vlanSpinnerField.data("spinner");
	        
	    	if (!validatorUtils.validateNumberInputSpinner(vlanSpinnerId, true)) {
				result = false;
			}
        }

        var mtuId = "serviceELine:mtu1";
        var mtuSpinner = helperUtils.getJQueryElementById(mtuId + "Edit").data("spinner");
    	if (!validatorUtils.validateNumberInputSpinner(mtuId, false)) {
			result = false;
		}
        
		//
		// TODO: (1/2) Commented in accordance with user story #304 (E-line OAM - NE configuration correction)
		//       Domain Level should be disabled/readonly until mediation is changed to accept it
		//
        var spinnerElements = helperUtils.getJQueryElementById("serviceELine:ccmDomainLevel input");
        //if(spinnerElements[0].value != ''){
        	helperUtils.changeElementState(spinnerElements, helperUtils.spinnerState.readonly);
        //} else {
        //	helperUtils.changeElementState(spinnerElements, helperUtils.spinnerState.enabled);
        //}
    	
        return result;
    },

	validateStep2: function() {

    	var result = true;

    	helperUtils.removeMessageInfoTip("serviceELine:errorMessageId2");
   
    	if (document.getElementById('serviceELine:deviceName2').value != '') {
	    	var selectedMapping = document.getElementById('serviceELine:endpointMappingMenu2').value;
	    	if (jQuery.inArray(selectedMapping, mappingTypeController2.serviceMappingType) == -1) {
	    		helperUtils.addMessageInfoTip("serviceELine:errorMessageId2", helperUtils.infoTipSeverity.error,
	    				"Selected NE doesn't support '" + selectedMapping + "' mapping type.");
	    		result = false;
	    	}
    	}
    	
    	if (document.getElementById('serviceELine:deviceProviderCore2').value == 'false') {
    		helperUtils.addMessageInfoTip("serviceELine:errorMessageId2", helperUtils.infoTipSeverity.error,
    				natMessagesBundle.error_neNotProviderCore);
            result = false;
        }

        if (helperUtils.getJQueryElementById('serviceELine:serviceCapabilities2').data("supportsServiceType") === false) {
        	helperUtils.addMessageInfoTip("serviceELine:physicalPortMessageId2", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_portServiceTypeNotSupported);
            result = false;
        }
        else {
        	helperUtils.removeMessageInfoTip("serviceELine:physicalPortMessageId2");
        }

        if(document.getElementById('serviceELine:deviceName1').value ==
        		document.getElementById('serviceELine:deviceName2').value) {
        	helperUtils.addMessageInfoTip("serviceELine:errorMessageId2", helperUtils.infoTipSeverity.error,
        			natMessagesBundle.error_nesMustBeDifferent);
        	result = false;
        }
        
        if (document.getElementById('serviceELine:deviceName2').value == '' ||
        		document.getElementById('serviceELine:moduleName2').value == '' ||
        		document.getElementById('serviceELine:physicalPortName2').value == '') {
        	result = false;
        }
        
        var mtuId = "serviceELine:mtu2";
        var mtuSpinner = helperUtils.getJQueryElementById(mtuId + "Edit").data("spinner");
    	if (!validatorUtils.validateNumberInputSpinner(mtuId, false)) {
			result = false;
		}
        
        return result;
    },

    validateStep3: function() {

        var result = true;
        if (document.getElementById('serviceELine:nameInput').value == '' ||
            document.getElementById('serviceELine:externalIdInput').value == '' ||
            document.getElementById('serviceELine:orderNumberInput').value == '' ||
            document.getElementById('serviceELine:VCIdInput').value == '') {
            result = false;
        }

        if(!validatorUtils.validateNumberInput('serviceELine:orderNumberInput', 1, 2147483647)){
            result = false;
        }

        result = result 
            && validatorUtils.validateNumberInput("serviceELine:VCIdInput", 1, 4294967295, true)
            && createELineWizard.validateVCIdBetweenNEs();
        //
        // TODO: (2/2) Commented in accordance with user story #304 (E-line OAM - NE configuration correction)
        //       Domain Level should be disabled/readOnly until mediation is changed to accept it
        //
        //var spinnerElements = helperUtils.getJQueryElementById("serviceELine:ccmDomainLevel input");
        //if(spinnerElements[0].value == ''){
        //      result = false
        //}
        
        return result;
    },
    
    fireSymmetricConfiguration: function(check) {
        jQuery().trigger("symmetric.createELine", jQuery(check).attr('checked'));
    },

    initializeStep: function(stepNumber) {
        if(stepNumber == 2) {
            this.fireSymmetricConfiguration("#serviceELine\\:symmetricConfigCheckbox");
        }

        if(stepNumber == 3){
            this.getVCIdBetweenNEs();
        }
    }

});

var createELineWizard = new CreateELineWizard(4, "serviceELine", "createELinePanel");

