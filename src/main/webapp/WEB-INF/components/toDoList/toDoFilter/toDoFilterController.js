{
	clearCompleted : function(cmp){
		var items = cmp.getValue("v.items");
		for(var i = items.getLength()-1; i >= 0; i--){
			if(items.get(i).selected===true){
				items.remove(i);
				/*var output = cmp.get("labelOutput");
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
			    $A.enqueueAction(action);*/
			};
		};
	},
	getItemsLengthByFilter : function(cmp, event, helper){
		helper.getItemsLengthByFilter(cmp, 'Active');
	},
	updateItemsLength : function(cmp,event,helper) {
		helper.getItemsLengthByFilter(cmp, 'Active');
	}
}