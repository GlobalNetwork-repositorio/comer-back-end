package com.adicse.comercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.comercial.model.CatalogoProductoQaliwarma;
import com.adicse.comercial.model.ProductoPorNumeroEntrega;
import com.adicse.comercial.model.ProductoPresentacion;
import com.adicse.comercial.service.ProductoPorNumeroEntregaService;

@RestController
@RequestMapping(value="/res/productoPorNumeroEntrega")
public class ProductoPorNumeroEntregaController {
	
	@Autowired
	private ProductoPorNumeroEntregaService productoPorNumeroEntregaService;
	
	
	@RequestMapping("/getbyanno")
	public List<ProductoPorNumeroEntrega> getProductoPorNumeroEntregaAnno(@RequestParam("anno") Integer anno) {
	
		List<ProductoPorNumeroEntrega> lst = productoPorNumeroEntregaService.getProductoPorNumeroEntregaAnno(anno);
		
		for(ProductoPorNumeroEntrega row:lst) {
			
			CatalogoProductoQaliwarma catalogoProductoQaliwarma = row.getCatalogoProductoQaliwarma();
			
			for(ProductoPresentacion productoPresentacion: catalogoProductoQaliwarma.getProductoPresentacions()) {
				productoPresentacion.setCatalogoProductoQaliwarma(null);
			}
			
			
		}
		
		return lst;
	}
	
	
	@RequestMapping("/getProductoPorNumeroEntregaAndIdproducto")
	public List<ProductoPorNumeroEntrega> getProductoPorNumeroEntregaAndIdproducto(
			@RequestParam("anno") Integer anno,
			@RequestParam("numeroEntrega") Integer numeroEntrega,
			@RequestParam("idCatalogoProducto") String idCatalogoProducto
			) {
		
			List<ProductoPorNumeroEntrega> lst = productoPorNumeroEntregaService.getProductoPorNumeroEntregaPorNumeroEntregaAndAnno(numeroEntrega, anno, idCatalogoProducto);
		
		return lst;
		
	
	}
	
	@RequestMapping("/save")
	public ProductoPorNumeroEntrega save(@RequestBody ProductoPorNumeroEntrega productoPorNumeroEntrega) {
		
		String idProductoPorNumeroEntrega = productoPorNumeroEntrega.getIdProductoPorNumeroEntrega();
		
		ProductoPorNumeroEntrega productoPorNumeroEntregaAux = productoPorNumeroEntregaService.findbyid(idProductoPorNumeroEntrega).isPresent()?
				productoPorNumeroEntregaService.findbyid(idProductoPorNumeroEntrega).get():new ProductoPorNumeroEntrega();
				
		productoPorNumeroEntregaAux.setDscComplementoProducto(productoPorNumeroEntrega.getDscComplementoProducto());	
		
		productoPorNumeroEntregaAux = productoPorNumeroEntregaService.grabar(productoPorNumeroEntregaAux);
		
		return productoPorNumeroEntregaAux;
	}
	

}
