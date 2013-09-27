package org.auraframework.controllers;

import java.util.ArrayList;
import java.util.List;

import org.auraframework.helpers.FileHelper;
import org.auraframework.models.ItemModel;
import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.system.Annotations.Controller;
import org.auraframework.system.Annotations.Key;
import org.json.simple.JSONObject;

@Controller
public class ToDoListController {
	
	private static String JSON_FILE_PATH = ".\\src\\main\\java\\org\\auraframework\\items.json";

    @AuraEnabled
    public static Boolean saveItem(@Key("name") String name,
            					   @Key("label") String label,
						           @Key("selected") Boolean selected,
						           @Key("value") String value,
						           @Key("disabled") Boolean disabled) throws Exception {
    	Boolean result = false;
    	
    	if (selected == null) {
    		selected = false;
        }

        if (disabled == null) {
        	disabled = false;
        }
    	
    	ItemModel item = new ItemModel(name, selected, disabled);
    	
    	result = FileHelper.writeJsonFromItemModel(JSON_FILE_PATH, item);
    	
    	return result;    	
    }
    
    @AuraEnabled
    public static List<ItemModel> loadItems(){
    	List<ItemModel> itemModelList = new ArrayList<ItemModel>();
    	ItemModel item = null;

    	for(Object object:FileHelper.readJSONToJSONArray(JSON_FILE_PATH)){
    		item = new ItemModel();
    		item.setName((String) ((JSONObject) object).get("name"));
			item.setLabel((String) ((JSONObject) object).get("name"));
			item.setSelected((Boolean) ((JSONObject) object).get("selected"));
			item.setValue("");
			item.setDisabled((Boolean) ((JSONObject) object).get("disabled"));
			
    		itemModelList.add(item);
    	}
    	
    	return itemModelList;    	
    }    
    
    @AuraEnabled
    public static Boolean updateItem(@Key("name") String name,
			   						 @Key("label") String label,
			   						 @Key("selected") Boolean selected,
			   						 @Key("value") String value,
			   						 @Key("disabled") Boolean disabled){
    	Boolean result = false;
    	
    	ItemModel item = new ItemModel();
    	
    	item.setName(name);
    	item.setLabel(label);
    	
    	if (value == null){
    		value = "";
    	}
    	item.setValue(value);
    	
    	if (selected == null) {
    		selected = false;
        }
    	item.setSelected(selected);

        if (disabled == null) {
        	disabled = false;
        }
        item.setDisabled(disabled);
    	
    	result = FileHelper.updateJSON(JSON_FILE_PATH, item);
    	
    	return result;    	
    }
}
