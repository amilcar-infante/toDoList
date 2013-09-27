package org.auraframework.models;

import java.util.ArrayList;
import java.util.List;

import org.auraframework.components.ui.InputOption;
import org.auraframework.controllers.ToDoListController;
import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.system.Annotations.Model;

@Model
public class TodoModel {
    
    private List<InputOption> items;
    
    public TodoModel(){
    	items = new ArrayList<InputOption>();
    	InputOption inputOption = null;    	
    	
    	for(ItemModel item: ToDoListController.loadItems()){
    		inputOption = new InputOption(item.getName(), item.getName(), item.getSelected(), item.getValue() , item.getDisabled());
            items.add(inputOption);
     	}
    }
    
    @AuraEnabled
    public List<InputOption> getItems() {
    //public List<ItemModel> getItems() {
        return items;
    }
}