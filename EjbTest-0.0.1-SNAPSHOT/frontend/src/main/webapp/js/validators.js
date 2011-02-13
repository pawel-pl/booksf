/**
 * Implementation of validations that can be performed on the
 * client-side. Although jsf implements some of these validators, it is best
 * to perform this dynamically in the client in order to avoid the server 
 * communication overhead.
 */
var validatorUtils = {
		
	validateMandatoryInput: function(inputId) {
		var input = helperUtils.getJQueryElementById(inputId)[0];
		return input.value != "";
	},
	
	validateNumberInput: function(inputId, minValue, maxValue, mandatory, messageId, isMessageTooltip) {
		var input = helperUtils.getJQueryElementById(inputId)[0];
		if (!messageId) messageId = inputId + "Message";
		return this.validateNumberInputElement(input, minValue, maxValue, mandatory, messageId, isMessageTooltip);
	},
	
	validateNumberInputInSet : function(inputId , set) {
        var input = helperUtils.getJQueryElementById(inputId)[0];
		var val = parseInt(input.value);
        return ! isNaN(val) && jQuery.inArray(val , set) != -1;
    } ,
	
	validateNumberInputSpinner: function(inputId, mandatory, messageId, isMessageTooltip) {
		var spinner = helperUtils.getJQueryElementById(inputId + "Edit").data("spinner");
		var input = jQuery(helperUtils.escapeId('#' + inputId + ' input'))[0];
		var minValue = spinner.min;
		var maxValue = spinner.max;
		if (!messageId) messageId = inputId + "Message";
		return this.validateNumberInputElement(input, minValue, maxValue, mandatory, messageId, isMessageTooltip);
	},
	
	_resetInputMessage: function(messageId, message,  isMessageTooltip) {
		if(isMessageTooltip === true){
			if (helperUtils.getInfoTipMessage(messageId) == message) {
				helperUtils.removeMessageInfoTip(messageId);
			} 
		} else {
			var messageElement = messageId ? helperUtils.getJQueryElementById(messageId) : false;
			if (messageElement && messageElement.text() == message) {
				messageElement.text("");
			}
		}
	},
	
	_setInputMessage: function(messageId, message, isMessageTooltip) {
		if(isMessageTooltip === true){
			helperUtils.addMessageInfoTip(messageId, helperUtils.infoTipSeverity.warn, message);
		} else {
			var message = messageId ? helperUtils.getJQueryElementById(messageId) : false;
			if (message) {
				message.text(message);
			}
		}
	},
	
	validateNumberInputElement: function(input, minValue, maxValue, mandatory, messageId, isMessageTooltip) {
		var value = input.value;
		var result = true;
		
		var msg = helperUtils.formatString(natMessagesBundle.error_FieldRangeViolation, [minValue, maxValue]);

		this._resetInputMessage(messageId, msg, isMessageTooltip);
		if (value == "" && mandatory) {
			result = false;
		}
		
		if (isNaN(value)) {
			input.value = minValue;
		} else {
			while (value[0] == "0" && value.length > 1) {
				// Remove left-side 0s to avoid parseInt to interpret value as octal
				value = value.substr(1);
			}
			var numValue = parseInt(value);
			if (numValue < minValue) {
				// Don't replace the value because of minimum values with more than one digit  
				this._setInputMessage(messageId, msg, isMessageTooltip);
				result = false;
			} else if (numValue > maxValue) {
				input.value = maxValue;
			} else if(input.value){
				// Avoid decimal numbers (e.g. 1.1 is transformed into 1)
				input.value = numValue;
			}
		}

		return result;
	} 
};