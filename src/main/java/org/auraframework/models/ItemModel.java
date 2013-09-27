package org.auraframework.models;

import java.io.IOException;

import org.auraframework.system.Annotations.Model;
import org.auraframework.util.json.Json;
import org.auraframework.util.json.JsonSerializable;

@Model
public class ItemModel implements JsonSerializable{
	
	//Item Name
	private String name;
	//Item Label (Optional)
	private String label;
	//Mark if the item is marked as complete
	private Boolean selected;
	//Unused field
	private String value;
	//Mark if the item is logically deleted
	private Boolean disabled;
	
	public ItemModel(){
	}
	
	public ItemModel(String name){
		this.name     = name;
		this.label    = name;
		this.selected = false;
		this.value	  = "";
		this.disabled = false;		
	}
	
	public ItemModel(String name, Boolean selected){
		this.name     = name;
		this.label    = name;
		this.selected = selected;
		this.value	  = "";
		this.disabled = false;	
	}
	
	public ItemModel(String name, Boolean selected, Boolean disabled){
		this.name     = name;
		this.label    = name;
		this.selected = selected;
		this.value	  = "";
		this.disabled = disabled;
	}
	
	public ItemModel(String name, String label, Boolean selected, Boolean disabled){
		this.name     = name;
		this.label    = name;
		this.selected = selected;
		this.value	  = "";
		this.disabled = disabled;
	}
	
	public ItemModel(String name, String label, Boolean selected, String value, Boolean disabled){
		this.name     = name;
		this.label    = name;
		this.selected = selected;
		this.value	  = value;
		this.disabled = disabled;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

		
	@Override
	public String toString() {
		return "{name=" + name + ", label=" + label + ", selected="
				+ selected + ", value=" + value + ", disabled=" + disabled + "}";
	}

	@Override
	public void serialize(Json json) throws IOException {
		json.writeMapBegin();
		json.writeMapEntry("name", getName());
		json.writeMapEntry("label", getLabel());
		json.writeMapEntry("selected", getSelected());
		json.writeMapEntry("value", getValue());
		json.writeMapEntry("disabled", getDisabled());
		json.writeMapEnd();
	}
	
	
}