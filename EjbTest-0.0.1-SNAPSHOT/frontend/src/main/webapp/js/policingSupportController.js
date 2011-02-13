var PolicingSupportController = Class.create(BaseController, {
    initialize: function($super, formId, panelId, dialogId) {
        $super(formId, panelId, dialogId);

		this.formId = formId;
		this.panelId = panelId;

        this.policingSupported = false;
    },

    setupDialog: function(formSubmitted) {
        if(formSubmitted) {
            this.enablePolicingFields(false);
            this.enableSymmetricField(false);
        }
    },

    resetFormCallback: function() {
        this.enablePolicingFields(false);
        this.enableSymmetricField(false);
    },

    deviceCapabilitiesCallback: function(serviceCapabilities) {
        this.updatePolicingFromCapabilitites(serviceCapabilities.deviceCapabilities);
    },

    updatePolicingFromCapabilitites: function(capabilities) {
    	if(capabilities !== "") {
            var policing = capabilities[natConstantsBundle.capabilities_policingSupportName];
            if(helperUtils.isVariableDefined(policing)) {
                 this.policingSupported = Boolean(policing);
            }

    		this.enablePolicingFields(this.policingSupported);

            // Both endpoints must support policing to be able to perform symmetric SLA configurations
            // These variables are the global ones created in createELine.xhtml
            if (policingSupportController1.policingSupported && policingSupportController2.policingSupported) {
            	this.enableSymmetricField(true);
        	} else {
        		this.enableSymmetricField(false);
        	}
        }
    },
    
    enablePolicingFields: function(enable) {
        var spinnerState;
        var automaticBustSizeState;
        if(enable){
        	spinnerState = helperUtils.spinnerState.enabled;
        	automaticBustSizeState = spinnerState;
        	
          if(helperUtils.getJQueryElementById(this.formId + ":autoBurstSizeCheckbox" + this.panelId).attr('checked')){
            automaticBustSizeState = helperUtils.spinnerState.readonly;
          }        	      	
        } else {
        	spinnerState = helperUtils.spinnerState.disabled; 
        	automaticBustSizeState = spinnerState;       	       	
        }
        
        helperUtils.changeElementStateById(this.formId + ":autoBurstSizeCheckbox" + this.panelId, spinnerState);
        helperUtils.changeElementStateById(this.formId + ":networkPrio" + this.panelId + "Menu", spinnerState);

        helperUtils.changeSpinnerState(this.formId + ":cirSpinner" + this.panelId, spinnerState);
        helperUtils.changeSpinnerState(this.formId + ":pirSpinner" + this.panelId, spinnerState);
        helperUtils.changeSpinnerState(this.formId + ":cbsSpinner" + this.panelId, automaticBustSizeState);
        helperUtils.changeSpinnerState(this.formId + ":pbsSpinner" + this.panelId, automaticBustSizeState);
        

        helperUtils.getJQueryElementById(this.formId + ":policingSupported" + this.panelId).attr('value', enable);
    },
    
    enableSymmetricField: function(enable) {
    	var checkState;
        if(enable){
        	checkState = helperUtils.spinnerState.enabled;        	      	
        } else {
        	checkState = helperUtils.spinnerState.disabled;        	       	
        }
    	helperUtils.changeElementState(helperUtils.getJQueryElementById(this.formId + ":symmetricConfigCheckbox"), checkState);
    	
    	if (enable) {
    		createELineWizard.fireSymmetricConfiguration("#"+this.formId+"\\:symmetricConfigCheckbox");
    	}
    }
});
