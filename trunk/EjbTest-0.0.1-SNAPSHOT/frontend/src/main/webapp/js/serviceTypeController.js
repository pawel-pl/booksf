/*
 * This js file handles the serviceType capability
 */
var ServiceTypeController = Class.create(BaseController, {
    initialize: function($super, formId, panelId, dialogId, serviceType) {
        $super(formId, panelId, dialogId);

        this.panelId = panelId;
        this.formId = formId;
        this.serviceType = serviceType;
    },

    setupDialog: function(formSubmitted) {
        helperUtils.getJQueryElementById(this.formId + ':serviceCapabilities' + this.panelId).data("supportsServiceType", '');
    },

    portCapabilitiesCallback: function(serviceCapabilities) {
        var supportsServiceType = this.checkSupportedTypeFromCapabilities(serviceCapabilities.portCapabilities);
        helperUtils.getJQueryElementById(this.formId + ':serviceCapabilities' + this.panelId).data("supportsServiceType", supportsServiceType);
    },

    checkSupportedTypeFromCapabilities: function(capabilities){
        if(capabilities !== "") {
            var serviceTypes = capabilities[natConstantsBundle.capabilities_serviceTypeName];
            if(helperUtils.isVariableDefined(serviceTypes)){
                return helperUtils.isValueInList(serviceTypes, this.serviceType);
            }
        }
        return true;
    }

 });
