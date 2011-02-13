var MappingTypeController = Class.create(BaseController, {
    initialize: function($super, formId, panelId, dialogId, serviceMappingType) {
        $super(formId, panelId, dialogId);

		this.formId = formId;
		this.panelId = panelId;

        this.serviceMappingType = new Array();

        helperUtils.changeElementStateById(this.formId+':endpointMappingMenu1', helperUtils.spinnerState.disabled);
        helperUtils.changeElementStateById(this.formId+':endpointMappingMenu2', helperUtils.spinnerState.disabled);
        helperUtils.clearListOptions(serviceMappingType);
    },

    setupDialog: function(formSubmitted) {
        this.switchMappingTypeVisibility(false,this.panelId);
    },

    resetFormCallback: function() {
        var serviceMappingTypeSpinner1 = helperUtils.getJQueryElementById(formId+":endpointMappingVlanSpinner1Edit").data("spinner");
        var serviceMappingTypeSpinner2 = helperUtils.getJQueryElementById(formId+":endpointMappingVlanSpinner2Edit").data("spinner");

        helperUtils.changeElementStateById(this.formId+':endpointMappingMenu1', helperUtils.spinnerState.disabled);
        helperUtils.clearListOptions(formId+':endpointMappingMenu1');
        helperUtils.toggleVisibility(formId+':vlanIdLabel1', false);
        helperUtils.toggleVisibility(formId+':vlanIdSpinner1', false);
        serviceMappingTypeSpinner1.resetRanges();

        helperUtils.clearListOptions(formId+':endpointMappingMenu2');
        helperUtils.toggleVisibility(formId+':vlanIdLabel2', false);
        helperUtils.toggleVisibility(formId+':vlanIdSpinner2', false);
        serviceMappingTypeSpinner2.resetRanges();
    },

    deviceCapabilitiesCallback: function(serviceCapabilities) {
        this.updateServiceMappingTypeFromCapabilitites(serviceCapabilities.deviceCapabilities);
    },

    updateServiceMappingTypeFromCapabilitites : function(capabilities) {
    	if(capabilities !== "") {
            var listTypes = capabilities[natConstantsBundle.capabilities_mappingTypeName];
            if(helperUtils.isVariableDefined(listTypes)) {
                this.serviceMappingType = listTypes;
                
                if(this.panelId == 1) {
                	
	    			helperUtils.clearListOptions(this.formId+':endpointMappingMenu1');
		            var mappingField = document.getElementById(this.formId+':endpointMappingMenu1');
		            helperUtils.changeElementState(jQuery(mappingField), helperUtils.spinnerState.enabled);
		                        
		            helperUtils.changeSpinnerState(this.formId+':endpointMappingVlanSpinner1', helperUtils.spinnerState.enabled);
		            helperUtils.changeSpinnerState(this.formId+':endpointMappingVlanSpinner2', helperUtils.spinnerState.disabled);
	
		            for(var i=0; i<listTypes.length; ++i){
		            	helperUtils.addOptionToList(this.formId+':endpointMappingMenu1', this.formId+':endpointMapping'+listTypes[i]+'1', listTypes[i], listTypes[i]);
		            	helperUtils.addOptionToList(this.formId+':endpointMappingMenu2', this.formId+':endpointMapping'+listTypes[i]+'2', listTypes[i], listTypes[i]);
		            }
                    //To make sure the VLAN ID field is updated
                    this.switchMappingType(mappingField, this.panelId);
	        }
        }
        }
    },

    // Hide/Show the parent of the element to avoid extra vertical spacing
    switchMappingTypeVisibility : function(visible, id) { 
	    var vlanIdLabel = this.formId+':endpointMappingVlanLabel'+id;
	    
	    var parentTr = helperUtils.getJQueryElementById(vlanIdLabel).parent().parent();
	    helperUtils.toggleVisibilityElement(parentTr, visible);
	    
	    helperUtils.updateMandatoryFields();
    },

	switchMappingType : function(mappingType, id) {	
	    switch(mappingType.value) {
	        case 'Port':
	        	this.switchMappingTypeVisibility(false, id);
	            break;
	        case 'VLAN':
	        	this.switchMappingTypeVisibility(true, id);
	            break;
	    }
        
        //Change the value of the serviceMappingType2 using the value of the serviceMappingType1
        if (id == 1) {
        	helperUtils.clearListOptions(this.formId+':endpointMappingMenu2');
            helperUtils.addOptionToList(this.formId+':endpointMappingMenu2', this.formId+':endpointMapping'+mappingType.value+'2', mappingType.value,mappingType.value);  	
        	this.switchMappingType(mappingType, 2);
        	helperUtils.getJQueryElementById(this.formId+':endpointMappingMenu2').change();
        }
    },
    
    switchVlanId : function(id) {
       if (id == 1) {
    	   var endpointMappingVlanSpinner1 = helperUtils.getJQueryElementById(this.formId+":endpointMappingVlanSpinner"+id+"Edit");
           var endpointMappingVlanSpinner1TextField = endpointMappingVlanSpinner1.find("input[type=text]");
           var endpointMappingVlanSpinner1Value = endpointMappingVlanSpinner1TextField.val();
           
           var endpointMappingVlanSpinner2 = helperUtils.getJQueryElementById(this.formId+":endpointMappingVlanSpinner2Edit");
           var endpointMappingVlanSpinner2TextField = endpointMappingVlanSpinner2.find("input[type=text]");
           
           //Change value of endpoint2 spinner
           endpointMappingVlanSpinner2TextField.val( endpointMappingVlanSpinner1Value ).change();
       }
    }
});