if(typeof(jQuery) !== "undefined"){
    if(typeof(Richfaces) !== "undefined" && typeof(Richfaces.Spinner) !== "undefined"){
        //While the rich faces component does not allow to disable on the client side, we need to do this "hack"
        Richfaces.Spinner.prototype.switchItems = Richfaces.Spinner.prototype.switchItems.wrap(
            function(originalFunction, event) {
                var element = jQuery(this.content.childElements()[0]);
                if(!element.attr("disabled") && !element.attr("readonly")){
                    originalFunction(event);
                }
            }
        );

        //to keep a reference to the javascript object of a spinner we need to attach it to the object
        Richfaces.Spinner.prototype.initialize = Richfaces.Spinner.prototype.initialize.wrap(
            function(originalFunction, containers, options, data ,events, images) {
                originalFunction(containers, options, data ,events, images);
                var spinner = jQuery("#"+helperUtils.escapeId(containers.edit));
                spinner.data("spinner", this);

                this.defaultMax = data.max;
                this.defaultMin = data.min;
                this.defaultDelta = data.delta;
                
                //because richfaces makes the text field readOnly when the disabled property is set in the XHTML we need to force it to be disabled
                if (options.disabled){
                	spinner.find("input").attr("disabled", true);
                }
            }
        );

        Richfaces.Spinner.prototype.resetRanges = function() {
            this.max = this.defaultMax;
            this.min = this.defaultMin;
            this.delta = this.defaultDelta;
            this.data.max = this.defaultMax;
            this.data.min = this.defaultMin;
            this.data.delta = this.defaultDelta;
        };

        Richfaces.Spinner.prototype.isCurrentValueValid = function() {
            var value = Number(this.controls.edit.value);

            if(this.controls.edit.value === ""
                    || isNaN(value)
                    || parseInt(value) != value
                    || this.controls.edit.value.indexOf(" ") != -1){

                return false;
            }

            return (value >= this.min && value <= this.max);
        };

        //Allows to change the range for the spinner
        Richfaces.Spinner.prototype.changeRange = function(min, max, delta) {
            this.max = max;
            this.min = min;
            this.delta = delta;
            this.data.max = max;
            this.data.min = min;
            this.data.delta = delta;

            var event = { keyCode: null };
            //TODO instead of updating the range it could mark the input as invalid
            this.controls.inputChange(event);
        };


        /*** Fix for comparisons between strings and numeric values  in spinner controls */
        Richfaces.Spinner.Controls.prototype.inputChange = function(e) {
        	var self = this;
        	if (jQuery.browser.msie && e.data != null && e.data.self != null) {
        		self = e.data.self;
        	}
            var value = Number(self.edit.value);

            if ( (self.edit.value == "" && self.spinner.required)
                    || isNaN(value)
                    || parseInt(value) != value
                    || self.edit.value.indexOf(" ") != -1) {

            	self.edit.value = self.prevEditValue;
            }
            else if ("" != self.edit.value) {
                if (value > self.spinner.max){
                	self.edit.value = self.spinner.max;
                }
                else if (value < self.spinner.min) {
                	self.edit.value = self.spinner.min;
                }
                self.prevEditValue = parseInt(Number(self.edit.value));
            }
            if (self.eventEditOnChange){
            	self.eventEditOnChange();
            }
        };

        Richfaces.Spinner.Controls.prototype.editChange = function(e) {
            var value = Number(this.edit.value);
            if ((value <= this.spinner.max) && (value >= this.spinner.min) && !isNaN(value) && this.edit.value != ""){
                this.prevEditValue = parseInt(value);
            }
            if (e.keyCode == 13){
                if (this.spinner.required || "" != this.edit.value){
                    this.edit.value = this.getValidValue(value);
                }
//                if (this.edit.form) {
//                    this.edit.form.submit();
//                }
            }
        };
        
        Richfaces.Spinner.Controls.prototype._attachBehaviors = function(){
            this.up.onmousedown		= this.upClick.bindAsEventListener(this);
            this.down.onmousedown	= this.downClick.bindAsEventListener(this);
            this.up.onmouseup		= this.mouseUp.bindAsEventListener(this);
            this.down.onmouseup		= this.mouseUp.bindAsEventListener(this);
            this.edit.onkeyup	= this.editChange.bindAsEventListener(this);
            this.eventInputChange= this.inputChange.bindAsEventListener(this);
            if (this.edit.onchange){
                this.eventEditOnChange = this.edit.onchange;
            }
            this.edit.onchange = this.eventInputChange.bindAsEventListener(this.edit);
	        if (jQuery.browser.msie) {
	        	jQuery(this.edit).bind('blur', {self: this}, this.inputChange);
            }
	    };
    }
}
