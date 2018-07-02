package com.adicse.comercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.comercial.model.CatalogoMarca;
import com.adicse.comercial.service.CatalogoMarcaService;

@RestController
@RequestMapping("/res/catalogoMarca")
public class CatalogoMarcaController {

	@Autowired
	private CatalogoMarcaService catalogoMarcaService;
	
	
	@RequestMapping("/getCatalogoMarcaByIdProductoPorNumeroEntrega")
	@ResponseBody
	public List<CatalogoMarca> getCatalogoMarcaByIdProductoPorNumeroEntrega( 
			@RequestParam ("idProductoPorNumeroEntrega") String idProductoPorNumeroEntrega,
			@RequestParam ("anno") Integer anno,
			@RequestParam ("numeroEntrega") Integer numeroEntrega
			) {
		
		return catalogoMarcaService.getCatalogoMarcaByIdProductoPorNumeroEntrega(idProductoPorNumeroEntrega,anno,numeroEntrega);
		
	}
	
	@RequestMapping("/save")
	public CatalogoMarca save(@RequestBody CatalogoMarca catalogoMarca) {
		
		String idCatalogoMarca = catalogoMarca.getIdCatalogoMarca();
		
		CatalogoMarca catalogoMarcaAux = catalogoMarcaService.findbyid(idCatalogoMarca).isPresent()?catalogoMarcaService.findbyid(idCatalogoMarca).get():new CatalogoMarca();
		
		catalogoMarcaAux.setMarca(catalogoMarca.getMarca());
		catalogoMarcaAux.setDscCatalogoMarca(catalogoMarca.getDscCatalogoMarca());
		
		catalogoMarcaAux = catalogoMarcaService.grabar(catalogoMarcaAux);
		
		return catalogoMarcaAux;
	}
}
