package org.auraframework.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.auraframework.models.ItemModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileHelper {
		
	@SuppressWarnings("unchecked")
	public static List<Object> readJSONToObjectList(String jsonFilePath){		
		JSONParser parser = new JSONParser();
		List<Object> jsonArray = null;
		
		try {
			
			Object jsonFile = parser.parse(new FileReader(jsonFilePath));
			jsonArray = (List<Object>) jsonFile;						
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
 
		return jsonArray;
    }	

	public static JSONArray readJSONToJSONArray(String jsonFilePath){		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = null;
		
		try {
			
			Object jsonFile = parser.parse(new FileReader(jsonFilePath));
			jsonArray = (JSONArray) jsonFile;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
 
		return jsonArray;
    }
   		
	@SuppressWarnings("unchecked")
	public static Boolean writeJsonFromItemModel(String jsonFilePath, ItemModel item){
		Boolean result = false;
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", item.getName());
		jsonObject.put("label", item.getLabel());
		jsonObject.put("selected", item.getSelected());
		jsonObject.put("value", item.getValue());
		jsonObject.put("disabled", item.getDisabled());

		
		try {
			//Load the json to add a new item
			JSONArray jsonArray =  readJSONToJSONArray(jsonFilePath);
			
			jsonArray.add((JSONObject) jsonObject);
			
			FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
			jsonFileWriter.write(jsonArray.toJSONString());
		    jsonFileWriter.flush();
		    jsonFileWriter.close();
		    
		    result = true;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static Boolean writeJson(String jsonFilePath, JSONObject jsonObject){
		Boolean result = false;
		
		try {
			//Load the json to add a new item
			JSONArray jsonArray =  readJSONToJSONArray(jsonFilePath);
						
			jsonArray.add((JSONObject) jsonObject);
			
			FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
			jsonFileWriter.write(jsonArray.toJSONString());
		    jsonFileWriter.flush();
		    jsonFileWriter.close();
		    result = true;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static Boolean updateJson(String jsonFilePath, JSONArray jsonArray){
		Boolean result = false;
		
		try {
			FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
			jsonFileWriter.write(jsonArray.toJSONString());
		    jsonFileWriter.flush();
		    jsonFileWriter.close();
		    result = true;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static Boolean updateJSON(String jsonFilePath, ItemModel item){
		JSONArray jsonArray = null;
		Boolean result = false;		
			
		//Load the json to add a new item
		jsonArray =  readJSONToJSONArray(jsonFilePath);
		
		jsonArray = searchItem(item, jsonArray);
			
		if(jsonArray != null){
			result =  updateJson(jsonFilePath, jsonArray);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static JSONArray searchItem(ItemModel item, JSONArray jsonArray){
		JSONArray result = null;
		ItemModel tempItem = null;
		
		for(int i=0; i < jsonArray.size(); i++){
			tempItem = new ItemModel();
			
			tempItem.setName((String) ((JSONObject) jsonArray.get(i)).get("name"));
			tempItem.setLabel((String) ((JSONObject) jsonArray.get(i)).get("label"));
			tempItem.setSelected((Boolean) ((JSONObject) jsonArray.get(i)).get("selected"));
			tempItem.setValue((String) ((JSONObject) jsonArray.get(i)).get("valuee"));
			tempItem.setDisabled((Boolean) ((JSONObject) jsonArray.get(i)).get("disabled"));
			
			if(tempItem.getLabel().equalsIgnoreCase(item.getLabel())){
				jsonArray.remove(i);
				
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("name", item.getName());
				jsonObject.put("label", item.getName());
				jsonObject.put("selected", item.getSelected());
				jsonObject.put("value", item.getValue());
				jsonObject.put("disabled", item.getDisabled());
				
				jsonArray.add(i, jsonObject);
				result = jsonArray;
				break;
			}			
		}
		
		return result;
	}
}
