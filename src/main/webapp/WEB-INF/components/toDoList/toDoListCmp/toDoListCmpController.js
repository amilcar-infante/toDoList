{
  createNewTodo : function(cmp, event){
	var input = cmp.get("newTodo");
  	var text = input.getValue("v.value").value;  
    var keyCodeValue =  event.getParam("keyCode");
    if(keyCodeValue===13 && text){
      var items = cmp.getValue("m.items");
      var action = cmp.get("c.saveItem");      
      action.setParams({
          label : text,
          name : text
      });
      action.setCallback(this, function(a){
    	    if (a){
	  			var newTodo = {
	    			label: text, 
	          		name: text,
	          		selected: false,
	          		disabled: false
	  			};
	          
	    		items.push(newTodo);
	    		input.getValue("v.value").setValue("");
	   		}else{
	    		input.getValue("v.value").setValue("Error Saving");
	   		}
      });
      $A.enqueueAction(action);
    };
  }
}