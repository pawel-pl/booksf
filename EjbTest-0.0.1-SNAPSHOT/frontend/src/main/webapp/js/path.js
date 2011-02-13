var Path = Class.create({
    initialize: function(formId) {
        this.formId = formId;
        this.initializeIDs();
    },

    initializeIDs: function() {
        this.buttonIds = {
            exportPath: this.formId + ":csvExportButton",
            printPath: this.formId + ":printButton"
        };
    },
    
    handleReturnKey: function() {
    	var focusedButton = document.activeElement;
    	if(focusedButton.type == "submit" || focusedButton.type == "button" || focusedButton.type == "reset") {	
    		focusedButton.click();
		} else {
			this.determineFinishButton().click();
		}
    },
    
    handleDefaultButtonBorder: function() {

        jQuery(this.determineFinishButton()).addClass("defaultButton");
    },
    
    determineFinishButton: function() {
    	var finishButtonId = null;
	    if (document.getElementById(this.formId + ':exportType').value == 'CSV') {
	    	finishButtonId = this.buttonIds.exportPath;
		} else {
			finishButtonId = this.buttonIds.printPath;
		}
	    
		return document.getElementById(finishButtonId);
    }
});
