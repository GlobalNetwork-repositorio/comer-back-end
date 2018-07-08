package com.adicse.comercial.specification;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ConvertObjectToFormatJson {

	//Este evento convierte el json generado por PRIMEGN en su componente tabla filter
	//aca convertimos para la busqueda y generacion del predicate devolviendo el objeto Filter
	//para specification.
	
	public Filter ConvertObjectToFormatSpecification(Object object) {
		
		
		String s = object.toString();
		JSONObject obj = new JSONObject();

		JSONObject json = null;
		JSONObject propiedadObj = new JSONObject();
		String value = null;
			
		json = new JSONObject(s);
		
		JSONArray ajson = new JSONArray();
		ajson.put(json);
	
			
		Filter filter = new Filter();
		
		List<Filter> lstFilter = new ArrayList<>();
		filter.setLogic("and");
		
		for (int i = 0; i < ajson.length(); i++) {
			obj = ajson.getJSONObject(i);
			
			for (Object key : obj.keySet()) {
				propiedadObj = (JSONObject) obj.get(key.toString());
				value = (String) propiedadObj.get("value");	
	
				
				Filter filterItem = new Filter();
				filterItem.setField(key.toString());
				filterItem.setOperator("contains");
				filterItem.setValue(value);
				
				lstFilter.add(filterItem);
	
				
			}
	
		}
		
		filter.setFilters(lstFilter);
		return filter;
	}

}
