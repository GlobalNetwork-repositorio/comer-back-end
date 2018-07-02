package com.adicse.comercial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.comercial.model.Perfil;
import com.adicse.comercial.service.PerfilService;

@RestController
@RequestMapping("/res/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping("/pagination")
	@ResponseBody
	public  Map<String,Object>  pagination(
			@RequestParam("pagenumber") Integer pagenumber,
			@RequestParam("rows") Integer rows,
			@RequestParam("sortdireccion") String sortdireccion,
			@RequestParam("sortcolumn") String sortcolumn,
			@RequestParam("filters")  Object filter			
			){
		
		Map<String,Object> response = new HashMap<String, Object>();

		Page<Perfil> page = perfilService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filter);
		
		List<Perfil> lst = page.getContent() ;
		
		response.put("data", lst);
		response.put("totalCount", page.getTotalElements());
		response.put("success", true);				
		
		return response;
				
	}		
	
	@RequestMapping("/getall")
	public  Map<String,Object> getall(){
		
		
		Map<String,Object> response = new HashMap<>();
		
		List<Perfil> lst = perfilService.getall();
		
		response.put("data", lst);
		
		return response;
	}
	

}
