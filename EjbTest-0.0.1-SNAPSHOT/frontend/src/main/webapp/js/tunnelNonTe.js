var TunnelNonTe = {
	hideOption : function() {
	    // enable/disable device 2 spinner according to symmetry
	    var symmetric = document.getElementById("services:symmetricCheckbox").checked;
	    var spinnerTable = document.getElementById("services:deviceCir2");
	    var inputs = spinnerTable.getElementsByTagName("input");
	        for (key in inputs) {
	            input = inputs[key];
	            input.disabled = symmetric;
	        }

        this.deviceCir1Changed();
	} ,
	
	deviceCir1Changed : function() {
	    // synchronize devices cir values if symmetric
	    var symmetric = document.getElementById("services:symmetricCheckbox").checked;
	    if (symmetric) {
	            var deviceCir1 = document.getElementsByName("services:deviceCir1")[0];
	            var deviceCir2 = document.getElementsByName("services:deviceCir2")[0];
	
	                deviceCir2.value = deviceCir1.value;
	    }
    }
};

var preEl ;
var orgBColor;
var orgTColor;

function HighLightTR(el, backColor,textColor){
  if(typeof(preEl)!='undefined') {
     preEl.bgColor=orgBColor;
     try{ChangeTextColor(preEl,orgTColor);}catch(e){;}
  }
  orgBColor = el.bgColor;
  orgTColor = el.style.color;
  el.bgColor=backColor;

  try{ChangeTextColor(el,textColor);}catch(e){;}
  preEl = el;
}

function ChangeTextColor(a_obj,a_color){ 
   for (i=0;i<a_obj.cells.length;i++)
    a_obj.cells(i).style.color=a_color;
}
