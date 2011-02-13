var CreateWizard = Class.create({
    initialize: function(numberOfSteps, formId, dialogId, dialogTitleId) {
        this.currentStep = 1;
        this.previouslyActiveStep = 0;
        this.startBack = false;

        this.validatorMap = [];
        this.buttonsLocked = false;

        this.numberOfSteps = numberOfSteps;
        this.formId = formId;
        this.dialogId = dialogId;
        this.dialogTitleId = dialogTitleId;

        this.initializeIDs();
        this.initializeValidators();

        this.vcIds = new Array();
        
        jQuery(window).ready(function() {
            document.getElementById(dialogId + "CDiv").oncontextmenu = function(event) {
                helperUtils.stopEvent(event);
                helperUtils.cancelEvent(event);
            }
        });
    },

    initializeIDs: function() {
        this.buttonIds = {
            back: this.formId + ":backButton",
            next: this.formId + ":nextButton",
            nextAjax: this.formId + ":nextButtonA4j",
            finish: this.formId + ":finishButton"
        };
        this.stepTitleBase = "stepTitle1";
        this.stepBase = "step";
    },

    initializeValidators: function() {
    //do nothing, to be overridden if necessary
    //use something like:
    //this.validatorMap[stepNumber] = callback;
    },

    updateTitle: function() {
        if(this.previouslyActiveStep > 0) {
            helperUtils.toggleVisibility(this.stepTitleBase + this.previouslyActiveStep, false);
        }
        helperUtils.toggleVisibility(this.stepTitleBase + this.currentStep, true);
    },

    back: function() {
        if(this.currentStep == this.numberOfSteps){
            this.startBack = true;
        }
        if(this.currentStep > 1) {
            this.previouslyActiveStep = this.currentStep--;
        }

        this.switchStep();
    },

    next: function() {
        if(this.currentStep < this.numberOfSteps) {
            this.previouslyActiveStep = this.currentStep++;
        }

        this.switchStep();
    },
    
    close: function() {
        if(typeof(this.dialogId) !== "undefined"){
            helperUtils.hideDialog(this.dialogId);
            this.previouslyActiveStep = this.currentStep;
            this.currentStep = 1;
            this.switchStep();
        } else {
            window.location = "/nat-web";
        }
    },

    cancel: function() {
        document.getElementById(this.formId).reset();
        // FF3 does not clear hidden fields during form reset
        helperUtils.getJQueryElementById(this.formId).find("input[type=hidden]").val("");
        
        //clear mandatory fields
        helperUtils.getJQueryElementById(this.formId).find(".mandatoryInput").trigger("stateChange");
        //clear mandatory spinners
        helperUtils.getJQueryElementById(this.formId).find(".mandatoryInput input:text").trigger("stateChange");
        this.close();
    },
    
    finish: function() {
        this.close();
        this.initializeValidators();
        this.formSubmitted();
    },

    initializeStep: function() {
        
    },
    
    /* Lock command bar buttons. To be used when performing server-side validations,
     * for example. The unlockButtons() method should be called afterwards which
     * in turn will call validateStep() to check which buttons should be re-enabled. 
     */
    lockButtons: function() {
        this.buttonsLocked = true;
    	
        var backButton = this.getButton(this.buttonIds.back);
        var nextStepButton = this.getButton(this.buttonIds.next);
        var nextReviewButton = this.getButton(this.buttonIds.nextAjax);
        var finishButton = this.getButton(this.buttonIds.finish);
        
        backButton.disabled = 'disabled';
        nextStepButton.disabled = 'disabled';
        nextReviewButton.disabled = 'disabled';
        finishButton.disabled = 'disabled';
    },
    
    /* Unlock command bar buttons and validate step. Refer to lockButtons().
     */
    unlockButtons: function() {
        this.buttonsLocked = false;
    	
        var backButton = this.getButton(this.buttonIds.back);
        if (this.currentStep == 1) {
            backButton.disabled = 'disabled';
        } else {
            backButton.disabled = '';
        }
        this.validateStep();
    },

    runValidation: function(stepNumber) {
        if(typeof(this.validatorMap[stepNumber]) === "function"){
            return this.validatorMap[stepNumber]();
        }
        return true;
    },

    validateStep: function() {
        var result = this.runValidation(this.currentStep);
        
        if (!this.buttonsLocked) {
            var nextButton = document.getElementById(this.buttonIds.next);
            if (this.currentStep == this.numberOfSteps - 1) {
                // change button to review button if it exists
                var button =  document.getElementById(this.buttonIds.nextAjax);
                if(button !== null) {
                    nextButton = button;
                }
            }
	
            if (result && this.currentStep != this.numberOfSteps) {
                nextButton.disabled = '';
            } else {
                nextButton.disabled = 'disabled';
            }
        }

        return result;
    },

    getButton: function(id){
        if(typeof(id) !== "undefined"){
            return document.getElementById(id);
        }
        return null;
    },

    switchStep: function() {
        var backButton = this.getButton(this.buttonIds.back);
        var nextStepButton = this.getButton(this.buttonIds.next);
        var nextReviewButton = this.getButton(this.buttonIds.nextAjax);
        var finishButton = this.getButton(this.buttonIds.finish);


        if(this.currentStep == 2){//TO DO: this should be called in step one
            currentWizard = this;
        }
        for (var i = 1; i <= this.numberOfSteps; i++) {
            var step = document.getElementById(this.stepBase + i);
            if (i == this.currentStep) {
                step.style.display = '';
            } else {
                step.style.display = 'none';
            }
        }

        // navigation buttons are enabled or not according to step
        if (!this.buttonsLocked) {
            if (this.currentStep == 1) {
                backButton.disabled = 'disabled';
            } else {
                backButton.disabled = '';
            }
	
            if (this.currentStep == this.numberOfSteps) {
                if(nextReviewButton !== null){
                    nextReviewButton.disabled = 'disabled';
                }
                nextStepButton.disabled = 'disabled';
                finishButton.disabled = '';
            } else {
                if (this.currentStep == this.numberOfSteps - 1) {
                    if(nextReviewButton !== null){
                        nextStepButton.style.display = 'none';
                        nextReviewButton.style.display = '';
                    }
                } else {
                    if(nextReviewButton !== null){
                        nextStepButton.style.display = '';
                        nextReviewButton.style.display = 'none';
                    }
                }
	
                finishButton.disabled = 'disabled';
            }
        }

        this.updateTitle();
        this.initializeStep(this.currentStep);
        this.validateStep();
        helperUtils.updateMandatoryFields();
    },

    populateNEs: function(endpoints) {
        if(typeof(endpoints) === "undefined" || endpoints.length === 0){
            return;
        }

        switch(endpoints.length){
            case 2:
                this.updateNEDetails(this.formId, 2, endpoints[1]);
            //no break to handle the first endpoint as well
            case 1:
                this.updateNEDetails(this.formId, 1, endpoints[0]);
            default:
                break;
        }
    } ,

    updateNEDetails: function(formBase, endpointNumber, ne){
        var deviceId = document.getElementById(formBase+":deviceId"+endpointNumber);

        if(deviceId !== null){
            // Don't use the long number because of javascript limitations
            deviceId.value = ne.neIdAsString;

            var deviceProviderCore = document.getElementById(formBase+":deviceProviderCore"+endpointNumber);
            deviceProviderCore.value = ne.providerCore;

            var deviceName = document.getElementById(formBase+":deviceName"+endpointNumber);
            deviceName.value = ne.name;
            jQuery(deviceName).trigger("stateChange");

            var capabilitiesString = ne.neConvertedCapabilities.replace(/\\'/g, "'");

            deviceChanged(formBase, endpointNumber, capabilitiesString);
        }
    },

    formSubmitted: function() {
        jQuery(window).trigger("formSubmitted." + this.formId);
    } ,
	

    // 2 functions to be used on a wizard step that needs to have a loadign indicator
    // nextWithLoading - to be called before server call
    //    --> panelId - id of panel to be displayed when screen is loaded
    //    --> loaderId - id of activity indicator
    nextWithLoading : function (panelId , loaderId) {
        this.next();
        this.loader = helperUtils.getJQueryElementById(this.formId + ":" + loaderId);
        this.panel = helperUtils.getJQueryElementById(this.formId + ":" + panelId);
        this.loader.show();
        this.panel.hide();
    } ,

    // doneLoading - to be called on complete
    doneLoading : function() {
        this.loader.hide();
        this.panel.show();
    } ,
    
    validateVCIdBetweenNEs: function() { 
        var valid = !validatorUtils.validateNumberInputInSet(this.formId+':VCIdInput' , currentWizard.vcIds);
        if(valid) {
            helperUtils.removeMessageInfoTip(this.formId+":VCIdInputErrorMessage");
        } else {
            helperUtils.addMessageInfoTip(this.formId+":VCIdInputErrorMessage",
                helperUtils.infoTipSeverity.error , natMessagesBundle.error_InvalidVCid);
        }
        return valid;
    },

    getVCIdBetweenNEs: function(){
        var ne1Id = document.getElementById(this.formId+':deviceId1').value;
        var ne2Id = document.getElementById(this.formId+':deviceId2').value;

        updateVcidsForNES(Number(ne1Id) , Number(ne2Id));
    },

    setUsedVcIds: function(ids){
        this.vcIds = ids;
    }
});
