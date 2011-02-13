var CreateSAToPWizard = Class.create(CreateWizard, {
    initializeValidators: function() {
        this.validatorMap[1] = this.validateStep1;
        this.validatorMap[2] = this.validateStep2;
    	
        jQuery(window).ready(function() {
            var callback = function(){
                createSAToPWizard.validateStep()
                };
            helperUtils.registerValidator("serviceSAToP:deviceName1", callback);
            helperUtils.registerValidator("serviceSAToP:moduleName1", callback);
            helperUtils.registerValidator("serviceSAToP:physicalPortName1", callback);

            helperUtils.registerValidator("serviceSAToP:deviceName2", callback);
            helperUtils.registerValidator("serviceSAToP:moduleName2", callback);
            helperUtils.registerValidator("serviceSAToP:physicalPortName2", callback);
    	    
            helperUtils.registerValidator("serviceSAToP:nameInput", callback);
            helperUtils.registerValidator("serviceSAToP:externalIdInput", callback);
            helperUtils.registerValidator("serviceSAToP:orderNumberInput", callback);
            helperUtils.registerValidator("serviceSAToP:VCIdInput", callback);
            helperUtils.registerValidator("serviceSAToP:PayloadSizeMenu", callback);
    	    
            helperUtils.registerValidator("serviceSAToP:JitterMenu", callback);
            helperUtils.registerValidator("serviceSAToP:idlePatternInputEdit", callback);
        });
    },

    initializeStep: function(stepNumber) {
        if(stepNumber == 2){
            this.getVCIdBetweenNEs();
        }
    },
	
   initializeIDs: function($super) {
	$super();
        this.stepBase = "satopstep";
        this.stepTitleBase = "createSAToPTitle"
    },
	
	validateStep1: function() {
    	
    	var result = true;
    	
    	  if (helperUtils.getJQueryElementById('serviceSAToP:serviceCapabilities1').data("supportsServiceType") === false) {
    		  helperUtils.addMessageInfoTip("serviceSAToP:physicalPortMessageId1", helperUtils.infoTipSeverity.error,
          			natMessagesBundle.error_portServiceTypeNotSupported);
              result = false;
          }
          else {
              document.getElementById("serviceSAToP:physicalPortMessageId1").innerHTML = '';
          }
    	
    	  if (helperUtils.getJQueryElementById('serviceSAToP:serviceCapabilities2').data("supportsServiceType") === false) {
    		  helperUtils.addMessageInfoTip("serviceSAToP:physicalPortMessageId2", helperUtils.infoTipSeverity.error,
          			natMessagesBundle.error_portServiceTypeNotSupported);
              result = false;
          }
          else {
              document.getElementById("serviceSAToP:physicalPortMessageId2").innerHTML = '';
          }
    	      	  
	    if (document.getElementById('serviceSAToP:deviceProviderCore1').value == 'false'){
	    	helperUtils.addMessageInfoTip("serviceSAToP:errorMessageId1", helperUtils.infoTipSeverity.error,
	    			"NE must be Provider Core");
	        result = false;
	    } else {
	    	helperUtils.removeMessageInfoTip("serviceSAToP:errorMessageId1");
	    }
	    
	    if(document.getElementById('serviceSAToP:deviceName1').value == '')
	    	result =  false;
	
	    if(document.getElementById('serviceSAToP:moduleName1').value == '')
	    	result =  false;
	
	    if(document.getElementById('serviceSAToP:physicalPortName1').value == '')
	    	result =  false;
	
	    if(document.getElementById('serviceSAToP:deviceProviderCore2').value == 'false'){
	    	helperUtils.addMessageInfoTip("serviceSAToP:errorMessageId2", helperUtils.infoTipSeverity.error, 
	    			"NE must be Provider Core");
	        result = false;
	    } else {
	    	helperUtils.removeMessageInfoTip("serviceSAToP:errorMessageId2");
	    }
	
	    if(document.getElementById('serviceSAToP:deviceName2').value == '')
	    	result =  false;
	
	    if(document.getElementById('serviceSAToP:moduleName2').value == '')
	    	result =  false;
	
	    if(document.getElementById('serviceSAToP:physicalPortName2').value == '')
	    	result =  false;

	    if(document.getElementById('serviceSAToP:deviceName1').value != '' &&
	    	document.getElementById('serviceSAToP:deviceName1').value ==
        	document.getElementById('serviceSAToP:deviceName2').value) {
                helperUtils.addMessageInfoTip("serviceSAToP:errorMessageId1", helperUtils.infoTipSevery.error, "NEs must be different.");
        	result = false;
	    }
	
	    return result;
	},

	validateStep2: function() {
		
        var result = true;

        if(document.getElementById('serviceSAToP:nameInput').value == '')
            result = false;
	
        if(document.getElementById('serviceSAToP:externalIdInput').value == '')
            result = false;
	
        if(document.getElementById('serviceSAToP:orderNumberInput').value == '')
            result = false;
        else if(!validatorUtils.validateNumberInput('serviceSAToP:orderNumberInput', 1, 2147483647, true))
            result = false;

        if (!validatorUtils.validateNumberInput("serviceSAToP:VCIdInput", 1, 4294967295, true, "serviceSAToP:VCIdInputErrorMessage"))
            result = false;
	
        if (!validatorUtils.validateNumberInputSpinner("serviceSAToP:PayloadSizeMenu", true))
            result = false;

        if (!validatorUtils.validateNumberInputSpinner("serviceSAToP:JitterMenu", true))
            result = false;
	
        if (!validatorUtils.validateNumberInputSpinner("serviceSAToP:idlePatternInput", 0, 255, true))
            result = false;
	
        result = result && createSAToPWizard.validateVCIdBetweenNEs();
	
        return result;
    }
});

var createSAToPWizard = new CreateSAToPWizard(3, "serviceSAToP","createSAToPPanel");
