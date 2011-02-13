var BaseController = Class.create({

    initialize: function(formId, panelsIds, dialogId) {
        this.formId = formId;
        this.panelsIds = panelsIds;
        if (!(panelsIds instanceof Array)) {
        	this.panelsIds = [panelsIds];
        }

        this.formSubmitted = true;

        var context = this;
        jQuery(window).bind("showDialog." + dialogId, function() {
            context.setupBinds();
            context.setupDialog(context.formSubmitted);

            this.formSubmitted = false;
        });

        jQuery(window).bind("formSubmitted." + this.formId, function() {
            context.formSubmitted = true;
        });

        this.bindPortCapabilities();
        this.bindDeviceCapabilities();
    },

    setupBinds: function() {
        if(this.formSubmitted) {
            this.bindResetForm();
        }
    },

    setupDialog: function(formSubmitted) {
        //do nothing, to be overridden if necessary
    },

    bindResetForm: function() {
        var context = this;
        helperUtils.getJQueryElementById(this.formId).bind("reset", function() {
            context.resetFormCallback();
        });
    },

    resetFormCallback: function() {
        //do nothing, to be overridden if necessary
    },

    bindPortCapabilities: function() {
        var context = this;
    	for (var i = 0; i < this.panelsIds.length; i++) {
    		var panelId = this.panelsIds[i];
    		var eventName = "portCapabilities.createService." + this.formId + "." + panelId;
    		jQuery().bind(eventName, {panelId: panelId}, function(event, params){
    			context.portCapabilitiesCallback(params, event.data.panelId);
    		});
    	}
    },

    portCapabilitiesCallback: function(params, panelId) {
        //do nothing, to be overridden if necessary
    },

    bindDeviceCapabilities: function() {
        var context = this;
        for (var i = 0; i < this.panelsIds.length; i++) {
    		var panelId = this.panelsIds[i];
    		var eventName = "deviceCapabilities.createService." + this.formId + "." + panelId;
            jQuery().bind(eventName, {panelId: panelId}, function(event, params){
                context.deviceCapabilitiesCallback(params, event.data.panelId);
            });
    	}
    },

    deviceCapabilitiesCallback: function(params, panelId) {
        //do nothing, to be overridden if necessary
    },
    
    updateRangeFromCapability: function(capability, panelId, ranges, range, spinnerId) {
    	if(helperUtils.isVariableDefined(capability)
                && helperUtils.isVariableDefined(capability.min)
                && helperUtils.isVariableDefined(capability.max) ) {
    		
    		ranges[panelId - 1].min = parseInt(Number(capability.min));
    		ranges[panelId - 1].max = parseInt(Number(capability.max));
    		
    		var otherPanelId = (panelId == 1 ? 2 : 1);
    		if (ranges[otherPanelId - 1].max > 0) {
	    		range.min = Math.max(ranges[0].min, ranges[1].min);
	    		range.max = Math.min(ranges[0].max, ranges[1].max);
    		} else {
    			range.min = ranges[panelId - 1].min;
	    		range.max = ranges[panelId - 1].max;
    		}
        }
    	helperUtils.updateSpinnerRange(range, spinnerId);
    }
});
