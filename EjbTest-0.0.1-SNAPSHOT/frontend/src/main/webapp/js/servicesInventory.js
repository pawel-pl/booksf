var servicesInventory = {
    deleteButtonId: "",
    selectAllId: "",
    tableId: "",

    registerSelectAll: function () {
        var selectAllElement = helperUtils.getJQueryElementById(servicesInventory.selectAllId);

        var callback = function(){
            helperUtils.toggleTableSelection(servicesInventory.tableId, "tableSelection", selectAllElement);
            servicesInventory.toggleDeleteButton();
        };
        selectAllElement.change(callback);
        helperUtils.checkboxChangeStateFix(selectAllElement);
    },

    registerSelectionBoxes: function () {
        var callback = servicesInventory.toggleDeleteButton;

        helperUtils.getJQueryElementById(servicesInventory.tableId).find(".tableSelection").change(callback).each(
                function(index, element){
                    helperUtils.checkboxChangeStateFix(jQuery(element));
                });
    },

    registerEvents: function() {
        servicesInventory.registerSelectAll();
        servicesInventory.registerSelectionBoxes();
    },

    toggleDeleteButton: function () {
        var selected = false;
        helperUtils.getJQueryElementById(servicesInventory.tableId).find(".tableSelection").each(function() {
            if (jQuery(this).attr('checked')) {
                selected = true;
                return false;
            }
        });

        //enable or disable the delete button
        var button = helperUtils.getJQueryElementById(servicesInventory.deleteButtonId);
        if(!selected) {
            button.attr("disabled",true);
        } else {
            button.removeAttr("disabled");
        }
    },
 

    disableDeleteButton: function() {
        var button = helperUtils.getJQueryElementById(servicesInventory.deleteButtonId);
        button.attr("disabled",true);
    } ,
	onSearchComplete : function () {
		this.registerEvents();
		this.disableDeleteButton(); 
		
		// hacks
	//	this.onWindowResize();
	} ,
	
	// hacks
	onWindowResize : function () {
		jQuery('#connections\\:servicesTableDiv').width(jQuery(window).width());

        var element = jQuery('#connections\\:servicesTableDiv');
        //get the form padding and reduce it from width
        var form = element.closest("form");
        var paddingLeft = this.getNumericValue(form.css("padding-left"));
        var paddingRight = this.getNumericValue(form.css("padding-right"));

        element.width(jQuery(window).width() - paddingLeft - paddingRight);
	},
    
    getNumericValue: function(value) {
        var number = parseInt(value);
        if(isNaN(number)){
            number = 0;
        }
        return number;
    }
};
