var helperUtils = {
	spinnerState: {
		enabled: 0,
		disabled: 1,
		readonly: 2
	},

	escapeId: function(string) {
		return string.replace(/:/ig,"\\:");
	},

    getJQueryElementById: function (elementId) {
        return jQuery("#" + helperUtils.escapeId(elementId));
    },

    getJQueryElementByName: function (type, elementName) {
        return jQuery(type + "[name=" + helperUtils.escapeId(elementName) + "]");
    },

    toggleVisibility: function(elementId, visible) {
        this.toggleVisibilityElement( jQuery("#" + helperUtils.escapeId(elementId)), visible );
    },
    
    toggleVisibilityElement: function(element, visible) {
        if(visible){
            element.removeClass("hidden");
        } else {
            element.addClass("hidden");
        }
    },
    
    infoTipSeverity: {
    	none: -1,
    	info: 0,
    	warn: 1,
    	error: 2,
    	fatal: 3
    },
    
    addMessageInfoTip: function(messageId, severity, message) {
    	var messageElement = helperUtils.getJQueryElementById(messageId);
    	var markerId = messageId + "-marker";
    	var markerElement = helperUtils.getJQueryElementById(markerId);
    	if (markerElement.length == 0 || messageElement.data("messageSeverity") != severity) {
    		// add InfoTip icon
	    	var imgId = "";
	    	var imgSrc = "";
	    	if (severity == helperUtils.infoTipSeverity.info) {
	    		imgId = messageId + "-info-icon";
	    		imgSrc = "/networkmap/images/m_info16.png";
	    	} else if (severity == helperUtils.infoTipSeverity.warn) {
	    		imgId = messageId + "-warn-icon";
	    		imgSrc = "/networkmap/images/m_warning16.png";
	    	} else if (severity == helperUtils.infoTipSeverity.error) {
	    		imgId = messageId + "-error-icon";
	    		imgSrc = "/networkmap/images/m_warning16.png";
	    	} else if (severity == helperUtils.infoTipSeverity.fatal) {
	    		imgId = messageId + "-fatal-icon";
	    		imgSrc = "/networkmap/images/m_error16.png";
	    	}
	    	if (markerElement.length != 0) {
	    		// there was already an icon, but of different severity: remove before adding the new one
	    		helperUtils.getJQueryElementById(markerId).remove();
	    	}
    		messageElement.prepend("<span id='" + markerId + "' class='rich-message-marker'><img id='" + imgId + "' src='" + imgSrc + "'" +
    				" onmouseover=\"helperUtils.showMessageInfoTip('" + messageId + "-tooltip', event);\"" +
    				" onmouseout=\"helperUtils.hideMessageInfoTip('" + messageId + "-tooltip', event);\" /></span>");
	    	messageElement.data("messageSeverity", severity);
    	}
    	var messageInfoTipElement = helperUtils.getJQueryElementById(messageId + "-tooltip-message");
    	messageInfoTipElement.text(message);
    },
    
    removeMessageInfoTip: function(messageId) {
    	var markerId = messageId + "-marker";
    	var messageMarker = helperUtils.getJQueryElementById(markerId);
    	if (messageMarker.length > 0) {
    		messageMarker.remove();
    	}
    	var messageInfoTipElement = helperUtils.getJQueryElementById(messageId + "-tooltip-message");
    	if (messageInfoTipElement.length > 0) {
    		messageInfoTipElement.text("");
    	}
    	var messageElement = helperUtils.getJQueryElementById(messageId);
    	messageElement.data("messageSeverity", helperUtils.infoTipSeverity.none);
    },
    
    getInfoTipMessage: function(messageId) {
    	var messageInfoTipElement = helperUtils.getJQueryElementById(messageId + "-tooltip-message");
    	return messageInfoTipElement.text();
    },
    
    getInfoTipSeverity: function(messageId) {
    	var messageElement = helperUtils.getJQueryElementById(messageId);
    	return messageElement.data("messageSeverity");
    },
    
    hasInfoTip: function(messageId) {
    	return helperUtils.getInfoTipSeverity(messageId) != helperUtils.infoTipSeverity.none;
    },
    
    hasInfoTipWarnOrHigher: function(messageId) {
    	return helperUtils.getInfoTipSeverity(messageId) >= helperUtils.infoTipSeverity.warn;
    },
    
    hasInfoTipErrorOrHigher: function(messageId) {
    	return helperUtils.getInfoTipSeverity(messageId) >= helperUtils.infoTipSeverity.error;
    },
    
    showMessageInfoTip: function(messageInfoTipId, event) {
    	var infotipJElement = helperUtils.getJQueryElementById(messageInfoTipId);
    	var infotip = infotipJElement[0];
    	var infotipParent = infotipJElement.parent()[0]; 
        if (infotipParent != document.body) {
        	/* move infotip to body element, to avoid possible 
        	parent elements with clipping overflow style settings. */ 
        	infotipParent.removeChild(infotip);
            document.body.appendChild(infotip);
        }
    	infotip.component.show(event);
    },

    hideMessageInfoTip: function(messageInfoTipId, event) {
    	helperUtils.getJQueryElementById(messageInfoTipId)[0].component.hide(event);
    },
    

	changeSpinnerState: function(spinnerId, state) {
		var spinner = helperUtils.getJQueryElementById(spinnerId);
		var spinnerText = spinner.find("input[type!=image]");
		var spinnerButtons = spinner.find("input[type=image]");

		this.changeElementState(spinnerText, state, spinnerId);

		/*Set spinnerButtons to disabled when state is 
		 * readonly (no click effect)*/
		if(state == this.spinnerState.readonly)
			state = this.spinnerState.disabled;
		this.changeElementState(spinnerButtons, state, spinnerId);
	},

	changeElementStateById: function(id, state) {
		var items = helperUtils.getJQueryElementById(id);

		this.changeElementState(items, state, id);
	},
    
    updateSpinnerRange: function(range, spinnerId) {
        var spinnerField = helperUtils.getJQueryElementById(spinnerId + "Edit");
        var spinnerTextField = spinnerField.find("input[type=text]");
        var spinnerRangeLabel = helperUtils.getJQueryElementById(spinnerId + "Range");
        var spinner = spinnerField.data("spinner");

        spinnerRangeLabel.text("[" + range.min + ".." + range.max + "]");
        spinner.changeRange(range.min, range.max, spinner.delta);

        spinnerTextField.change();
    },
    
    changeElementState: function(element, state, labelFor) {
		if(typeof(labelFor) === "undefined" || labelFor === "") {
			labelFor = element.attr("id");
		}
		
		switch(state) {
			case this.spinnerState.enabled:
				element.removeAttr("disabled");
				element.removeAttr("readonly");
				jQuery("label[for=" + labelFor + "]").removeClass("disabledLabel");
				break;
			case this.spinnerState.disabled:
				element.attr("disabled",true);
				element.removeAttr("readonly");
				jQuery("label[for=" + labelFor + "]").addClass("disabledLabel");
				break;
			case this.spinnerState.readonly:
			default:
				element.attr("readonly",true);
				element.removeAttr("disabled");
				jQuery("label[for=" + labelFor + "]").removeClass("disabledLabel");
				break;
		}
		
		element.trigger("stateChange");
	},
	
	changeTextState: function(id, state) {
		if (state == this.spinnerState.disabled) {
			helperUtils.getJQueryElementById(id).addClass("disabledLabel");
		} else {
			helperUtils.getJQueryElementById(id).removeClass("disabledLabel");
		}
	},

	hideDialog : function(dialogId) {
        jQuery(window).trigger("hideDialog." + dialogId);
		Richfaces.hideModalPanel(dialogId);
	},

	showDialog : function(dialogId) {
		Richfaces.showModalPanel(dialogId);
        jQuery(window).trigger("showDialog." + dialogId);
        
        helperUtils.updateMandatoryFields();
	},
	
    getButton: function(id){
        if(typeof(id) !== "undefined"){
            return document.getElementById(id);
        }
        return null;
    },
    
    handleButtonFocus: function(formId, event) {
		jQuery("#" + helperUtils.escapeId(formId) + " .defaultButton").removeClass("defaultButton");
		jQuery(event.currentTarget).addClass("defaultButton");
    },
    
    handleButtonBlur: function(formId, callback) {
    	jQuery("#" + helperUtils.escapeId(formId) + " .defaultButton").removeClass("defaultButton");
    	
    	callback();
    },

    paginationInputChange: function(elementId){
		var scroller = helperUtils.getJQueryElementById(elementId);
		var element = scroller.find("input[type=text]")[0];
		
		var value = element.value;

		if(element.defaultValue != value && value != ""){
			scroller[0].component.switchToPage(value);
		}
	},
	
	fixHotKeyHandlingWithNoSelection: function(dialogId) {
	    var escapedId = '#' + this.escapeId(dialogId);
	    jQuery(escapedId + 'Container [id$="ContentDiv"],' + escapedId + 'Container [id$="ShadowDiv"],'
	            + escapedId + 'Container [id$="CursorDiv"]').attr('tabindex', '-1').addClass('noDialogFocusOutline');
	},

    checkboxChangeStateFix: function (checkbox) {
        /** fix for IE behavior with the change event of check boxes */
        if (jQuery.browser.msie) {
            checkbox.click(function () {
                this.blur();
                this.focus();
            });
        }
    },

    checkboxChangeStateFixById: function (checkboxId) {
        helperUtils.checkboxChangeStateFix(helperUtils.getJQueryElementById(checkboxId));
    },

    registerValidator: function(elementId, callback) {
        this.registerValidatorElement(helperUtils.getJQueryElementById(elementId), callback);
    },

    registerValidatorElement: function(element, callback) {
        element.change(callback).keyup(callback).bind("paste", callback);
    },
    
    registerSpinnerValidator: function(elementId, callback) {
    	this.registerValidator(elementId, callback);
    	//Fix for IE -> buttons
    	if (jQuery.browser.msie) {
    		helperUtils.getJQueryElementById(elementId+" input[type=image]").click(callback);
    	}
    },

    registerValidatorOnChange: function(elementId, callback){
    	helperUtils.getJQueryElementById(elementId).change(callback);
    },

    change: function(elementId){
    	jQuery('#' + this.escapeId(elementId)).change();
    },

	setCaretToEnd : function(e) {
	    var control = $((e.target ? e.target : e.srcElement).id);
	    if (control.createTextRange) {
	        var range = control.createTextRange();
	        range.collapse(false);
	        range.select();
	    }
	    else if (control.setSelectionRange) {
	        control.focus();
	        var length = control.value.length;
	        control.setSelectionRange(length, length);
	    }
	    control.selectionStart = control.selectionEnd = control.value.length;
	},

    toggleTableSelection: function(tableId, checkboxClass, selectAll){
        // changes all checkboxes in the table that have the checkboxClass
        // to the value of the this checkbox
        var state = jQuery(selectAll).attr('checked');
        helperUtils.setTableSelection(tableId, checkboxClass, state);
    },

    setTableSelection: function(tableId, checkboxClass, state){
        // changes all checkboxes in the table that have the checkboxClass
        // to the value of state
        helperUtils.getJQueryElementById(tableId).find("." + checkboxClass).attr('checked', state);

    },

    getSelectedValueFromRadioButtonGroup : function(radioButtonGroupName){
    	var radioButtonGroup = document.getElementsByName(radioButtonGroupName);
    	for(i = 0; i < radioButtonGroup.length; i++){
    		if(radioButtonGroup[i].checked){
    			return radioButtonGroup[i].value;
    		}
    	}
    },

    addOptionToList : function(listId, optionId, optionText, optionValue) {
    	if(document.getElementById(listId) == null){
    		return;
    	}
    	var newOption = document.createElement('option');
    	
    	newOption.id = optionId;
    	newOption.value = optionValue;
    	newOption.text = optionText;

    	try {
    		document.getElementById(listId).add(newOption, null);
    	}//Workaround because of IE bug
    	catch(exception) {
    		document.getElementById(listId).add(newOption);
    	}
    },
    
    clearListOptions : function(listId) {
    	if(document.getElementById(listId) == null){
    		return;
    	}
    	document.getElementById(listId).innerHTML = "";
    },
    
    isVariableDefined: function(variable) {
        if(typeof(variable) === "undefined"){
            return false;
        }
        return true;
    },

    stopEvent: function(event) {
        if (!event) event = window.event;
        if (event.stopPropagation) {
        	event.stopPropagation();
        } else {
        	event.cancelBubble = true;
        }
    },
    
    cancelEvent: function(event) {
        if (!event) event = window.event;
        if (event.preventDefault) {
        	event.preventDefault();
        } else {
        	event.returnValue = false;
        }
    },
    
    addMandatoryIndicator: function(index, element) {
      var jElement = jQuery(element);
      
      if(jElement.is(":visible")){
        var mandatoryIcon = jQuery("<span class=\"mandatoryOn\"></span>");
        
        jElement.parent().prepend(mandatoryIcon);
        jElement.removeClass("mandatory");
        jElement.addClass("mandatoryInput");
        mandatoryIcon.height(jElement.outerHeight() - 2 ); //reduce mandatory border
        
        mandatoryIcon.css('marginTop', jElement.css('marginTop'));
        mandatoryIcon.css('marginBottom', jElement.css('marginBottom'));
        if(!jElement.is("table")){
          //for spinners we do not wish to reset the margin
          jElement.css('marginLeft', "0px");
        }
        
        var jElementInput = jElement;
        if(!jElement.is("input") && !jElement.is("select") && !jElement.is("textarea")){
          //then it must be a rich faces spinner
          var jElementInput = jElement.find("input.rich-spinner-input");
        }
        
        //In IE there are some cases where the offset for the input is 1px below the mandatory icon
        if(jQuery.browser.msie && jElement.offset().top != mandatoryIcon.offset().top){
          var marginTop = parseInt(jElement.css('marginTop'));
          //if the margin is not set it will be "auto" and the parse returns NaN
          if(isNaN(marginTop)) {
            marginTop = 1;
          }else{
            //TODO should be the difference between the offsets
            marginTop += 1;
           }
          mandatoryIcon.css('marginTop', marginTop + "px");
        }

        var callback = function(){ helperUtils.verifyMandatoryInput(jElementInput, mandatoryIcon);};

        jElementInput.bind("keyup change mouseup select stateChange", callback);
        /* when the paste/cut event is fired, the value of the textfield has not changed yet
           with a timeout of 0 it is executed after the event is processed */
        jElementInput.bind("paste cut", function(){ setTimeout ( callback, 0 );  });
        
        /* if the browsers fills in the fileds automatically, this will update the mandatory icon visibility */
        helperUtils.verifyMandatoryInput(jElementInput, mandatoryIcon);
      }
    },

    verifyMandatoryInput: function (jElement, mandatoryIcon) {
      if (!jElement.is(":disabled") && helperUtils.isEmptyOrNull(jElement.val())) {
          mandatoryIcon.css('visibility', 'visible');
      } else {
          mandatoryIcon.css('visibility', 'hidden');
      }
    },

    isEmptyOrNull: function(value){
      return (value==null || value=="");
    },
    
    isValueInList : function(list, value) {
        for(var i=0; i < list.length; i++) {
            if(list[i] === value) {
                return true;
            }
        }
        return false;
    },

    updateMandatoryFields: function() {
      jQuery(".mandatory").each( function(index, element) { helperUtils.addMandatoryIndicator(index, element); });
    },
    
    arrayUnion: function(array1, array2) {
    	var union = array1;
    	for (var i = 0; i < array2.length; i++) {
    		var value = array2[i];
    		if (union.indexOf(value) < 0) {
    			union = union.concat(value);
    		}
    	}
    	return union;
    },
    
    arrayIntersection: function(array1, array2) {
    	var intersection = array1.filter(function(n) {
    		return array2.indexOf(n) != -1;
        });
    	return intersection;
    },
    
    formatString: function(original, strings) {
    	var result = original;
    	for (var i = 0; i < strings.length; i++) {
    		result = result.replace(new RegExp("#" + i, 'g'), strings[i]);
    	}
    	return result;
    }
};

