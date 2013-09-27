{  
	deleteItem : function(cmp, event){
		var output = cmp.get("labelOutput");
		var input = cmp.get("inputCheckbox");
		var text = output.getValue("v.value").value;
		var selected = input.getValue("v.value").value;
		var action = cmp.get("c.updateItem");
	    action.setParams({
	        label : text,
	        name : text,
	        selected : selected,
	        value : '',
	        disabled : true
	    });
	    
	    action.setCallback(this, function(a){
	    	if (a){
	    		cmp.getValue("v.item").getValue("disabled").setValue(true);
	    		var event = $A.get("e.toDoList:checkItemEvent");
	            event.fire();
		    }else{
		    	alert('error deleting');
		   	}
	    });
	    $A.enqueueAction(action);
	},
	editItem : function(cmp, event){
		cmp.getValue("v.viewMode").setValue(false);
	},
	updateItemName : function(cmp, event){
		 var keyCodeValue =  event.getParam("keyCode");
		 if(keyCodeValue===13){
			 var input = cmp.get("labelInput");
			 var checkbox = cmp.get("inputCheckbox");
			 var text = input.getValue("v.value").value;
			 var label = input.getValue("v.placeholder").value;
			 var selected = checkbox.getValue("v.value").value;
			 var action = cmp.get("c.updateItem");
			 action.setParams({
			     label : label,
			     name : text,
			     selected : selected,
			     value : '',
			     disabled : false
			 });
			    
			 action.setCallback(this, function(a){
			    if (a){
			       cmp.getValue("v.viewMode").setValue(true);
				}else{
				   alert('error updating');
				}
			 });
			 $A.enqueueAction(action);
		 }
	},
	checkItem : function(cmp, event, helper){
		var event = $A.get("e.toDoList:checkItemEvent");
        event.fire();
	}
}