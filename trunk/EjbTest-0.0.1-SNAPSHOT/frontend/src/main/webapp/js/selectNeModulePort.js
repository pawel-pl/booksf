var panelId;
var formId;
var nextButtonName;
var portSelectionEnabled = false;
var moduleSelectionEnabled = false;

function moduleChanged() {
    clearPhysicalPort(formId, panelId);
}

function clearPhysicalPort(fId, pId) {
    document.getElementById(fId + ':physicalPortId'+pId).value = '';
    document.getElementById(fId + ':physicalPortName'+pId).value = '';

    helperUtils.getJQueryElementById(fId + ':serviceCapabilities' + pId).data("serviceCapabilities").portCapabilities = '';
    helperUtils.getJQueryElementById(this.formId + ':serviceCapabilities' + this.panelId).data("supportsServiceType", '');

    enableSelectionButtons(pId, fId);
}

function physicalPortChanged(capabilityStr) {

    var serviceCapabilities = helperUtils.getJQueryElementById(formId + ':serviceCapabilities' + panelId).data("serviceCapabilities");
    if(capabilityStr !== "") {
        eval("serviceCapabilities.portCapabilities = " + capabilityStr);
    }

    var eventName = "portCapabilities.createService." + formId + "." + panelId;
    jQuery().trigger(eventName, serviceCapabilities );
}

function deviceChanged(fId, pId, capabilityStr) {
	if (fId !== undefined && pId !== undefined) {
		formId = fId;
		panelId = pId;
	}
	
    var serviceCapabilities = new ServiceCapabilities();
    if(capabilityStr !== "") {
        eval("serviceCapabilities.deviceCapabilities = " + capabilityStr);
    }
    helperUtils.getJQueryElementById(formId + ':serviceCapabilities' + panelId).data("serviceCapabilities", serviceCapabilities);

    clearModule(formId, panelId);

    var eventName = "deviceCapabilities.createService." + formId + "." + panelId;
    jQuery().trigger(eventName, serviceCapabilities);
}

function clearModule(fId, pId) {
    document.getElementById(fId + ':moduleId'+pId).value = '';
    document.getElementById(fId +':moduleName'+pId).value = '';
    clearPhysicalPort(fId, pId);
}

function enableSelectionButtons(panelId, formId) {
    moduleSelectionEnabled = document.getElementById(formId + ':deviceId'+panelId).value != '';
    document.getElementById(formId + ':moduleButton'+panelId).disabled = moduleSelectionEnabled ? '' : 'disabled';
    
    portSelectionEnabled = document.getElementById(formId + ':moduleId'+panelId).value != '';
    document.getElementById(formId + ':physicalPortButton'+panelId).disabled = portSelectionEnabled ? '' : 'disabled';

}

function disableInputBoxes(panelId, formId) {
	document.getElementById(formId + ':deviceName'+panelId).readOnly = 'readonly';
    document.getElementById(formId + ':moduleName'+panelId).readOnly = 'readonly';
    document.getElementById(formId + ':physicalPortName'+panelId).readOnly = 'readonly';
}
