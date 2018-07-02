package com.adicse.comercial.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogo_producto_qaliwarma database table.
 * 
 */
@Entity
@Table(name="catalogo_producto_qaliwarma")
@NamedQuery(name="CatalogoProductoQaliwarma.findAll", query="SELECT c FROM CatalogoProductoQaliwarma c")
public class CatalogoProductoQaliwarma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_catalogo_producto_qaliwarma")
	private String idCatalogoProductoQaliwarma;

	private Integer anno;

	@Column(name="dsc_catalogo_producto_qaliwarma")
	private String dscCatalogoProductoQaliwarma;

	@Column(name="print_lote")
	private Integer printLote;

	//bi-directional many-to-one association to CatalogoMultiplicarNivelEducacion
	@OneToMany(mappedBy="catalogoProductoQaliwarma")
	private List<CatalogoMultiplicarNivelEducacion> catalogoMultiplicarNivelEducacions;

	//bi-directional many-to-one association to Envase
	@ManyToOne
	@JoinColumn(name="id_envase")
	private Envase envase;

	//bi-directional many-to-one association to UnidadMedidaTrabajo
	@ManyToOne
	@JoinColumn(name="id_unidad_medida_trabajo")
	private UnidadMedidaTrabajo unidadMedidaTrabajo;

	//bi-directional many-to-one association to Unidadmedida
	@ManyToOne
	@JoinColumn(name="idunidadmedida")
	private Unidadmedida unidadmedida;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="catalogoProductoQaliwarma")
	private List<Producto> productos;

	//bi-directional many-to-one association to ProductoPorNumeroEntrega
	@OneToMany(mappedBy="catalogoProductoQaliwarma")
	private List<ProductoPorNumeroEntrega> productoPorNumeroEntregas;

	//bi-directional many-to-one association to ProductoPresentacion
	@OneToMany(mappedBy="catalogoProductoQaliwarma", cascade={CascadeType.ALL})
	private List<ProductoPresentacion> productoPresentacions;

	public CatalogoProductoQaliwarma() {
	}

	public String getIdCatalogoProductoQaliwarma() {
		return this.idCatalogoProductoQaliwarma;
	}

	public void setIdCatalogoProductoQaliwarma(String idCatalogoProductoQaliwarma) {
		this.idCatalogoProductoQaliwarma = idCatalogoProductoQaliwarma;
	}

	public Integer getAnno() {
		return this.anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getDscCatalogoProductoQaliwarma() {
		return this.dscCatalogoProductoQaliwarma;
	}

	public void setDscCatalogoProductoQaliwarma(String dscCatalogoProductoQaliwarma) {
		this.dscCatalogoProductoQaliwarma = dscCatalogoProductoQaliwarma;
	}

	public Integer getPrintLote() {
		return this.printLote;
	}

	public void setPrintLote(Integer printLote) {
		this.printLote = printLote;
	}

	public List<CatalogoMultiplicarNivelEducacion> getCatalogoMultiplicarNivelEducacions() {
		return this.catalogoMultiplicarNivelEducacions;
	}

	public void setCatalogoMultiplicarNivelEducacions(List<CatalogoMultiplicarNivelEducacion> catalogoMultiplicarNivelEducacions) {
		this.catalogoMultiplicarNivelEducacions = catalogoMultiplicarNivelEducacions;
	}

	public CatalogoMultiplicarNivelEducacion addCatalogoMultiplicarNivelEducacion(CatalogoMultiplicarNivelEducacion catalogoMultiplicarNivelEducacion) {
		getCatalogoMultiplicarNivelEducacions().add(catalogoMultiplicarNivelEducacion);
		catalogoMultiplicarNivelEducacion.setCatalogoProductoQaliwarma(this);

		return catalogoMultiplicarNivelEducacion;
	}

	public CatalogoMultiplicarNivelEducacion removeCatalogoMultiplicarNivelEducacion(CatalogoMultiplicarNivelEducacion catalogoMultiplicarNivelEducacion) {
		getCatalogoMultiplicarNivelEducacions().remove(catalogoMultiplicarNivelEducacion);
		catalogoMultiplicarNivelEducacion.setCatalogoProductoQaliwarma(null);

		return catalogoMultiplicarNivelEducacion;
	}

	public Envase getEnvase() {
		return this.envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}

	public UnidadMedidaTrabajo getUnidadMedidaTrabajo() {
		return this.unidadMedidaTrabajo;
	}

	public void setUnidadMedidaTrabajo(UnidadMedidaTrabajo unidadMedidaTrabajo) {
		this.unidadMedidaTrabajo = unidadMedidaTrabajo;
	}

	public Unidadmedida getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(Unidadmedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCatalogoProductoQaliwarma(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCatalogoProductoQaliwarma(null);

		return producto;
	}

	public List<ProductoPorNumeroEntrega> getProductoPorNumeroEntregas() {
		return this.productoPorNumeroEntregas;
	}

	public void setProductoPorNumeroEntregas(List<ProductoPorNumeroEntrega> productoPorNumeroEntregas) {
		this.productoPorNumeroEntregas = productoPorNumeroEntregas;
	}

	public ProductoPorNumeroEntrega addProductoPorNumeroEntrega(ProductoPorNumeroEntrega productoPorNumeroEntrega) {
		getProductoPorNumeroEntregas().add(productoPorNumeroEntrega);
		productoPorNumeroEntrega.setCatalogoProductoQaliwarma(this);

		return productoPorNumeroEntrega;
	}

	public ProductoPorNumeroEntrega removeProductoPorNumeroEntrega(ProductoPorNumeroEntrega productoPorNumeroEntrega) {
		getProductoPorNumeroEntregas().remove(productoPorNumeroEntrega);
		productoPorNumeroEntrega.setCatalogoProductoQaliwarma(null);

		return productoPorNumeroEntrega;
	}

	public List<ProductoPresentacion> getProductoPresentacions() {
		return this.productoPresentacions;
	}

	public void setProductoPresentacions(List<ProductoPresentacion> productoPresentacions) {
		this.productoPresentacions = productoPresentacions;
	}

	public ProductoPresentacion addProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().add(productoPresentacion);
		productoPresentacion.setCatalogoProductoQaliwarma(this);

		return productoPresentacion;
	}

	public ProductoPresentacion removeProductoPresentacion(ProductoPresentacion productoPresentacion) {
		getProductoPresentacions().remove(productoPresentacion);
		productoPresentacion.setCatalogoProductoQaliwarma(null);

		return productoPresentacion;
	}

}
