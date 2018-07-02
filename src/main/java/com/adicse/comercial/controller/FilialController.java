package com.adicse.comercial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.comercial.model.Filial;
import com.adicse.comercial.service.FilialService;

@RestController
@RequestMapping("/res/filial")
public class FilialController {
	
	
	@Autowired
	private FilialService filialService;
	
	
	@RequestMapping("/getall")
	public Map<String,Object> findall(){
		
		
		Map<String,Object> response = new HashMap<>();
		
		List<Filial> lst = filialService.getall();
		
		response.put("data", lst);
		
		return response;
		
	}

}
