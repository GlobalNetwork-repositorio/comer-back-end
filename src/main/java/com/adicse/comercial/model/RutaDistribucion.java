package com.adicse.comercial.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ruta_distribucion database table.
 * 
 */
@Entity
@Table(name="ruta_distribucion")
@NamedQuery(name="RutaDistribucion.findAll", query="SELECT r FROM RutaDistribucion r")
public class RutaDistribucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruta_distribucion")
	private String idRutaDistribucion;

	private Integer anno;

	@Column(name="dsc_ruta_distribucion")
	private String dscRutaDistribucion;

	@Column(name="numero_entrega")
	private Integer numeroEntrega;

	//bi-directional many-to-one association to Chofer
	@ManyToOne
	@JoinColumn(name="id_chofer")
	private Chofer chofer;

	//bi-directional many-to-one association to EmpleadoDistribuidor
	@ManyToOne
	@JoinColumn(name="id_empleado_distribuidor")
	private EmpleadoDistribuidor empleadoDistribuidor;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="id_vehiculo")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to RutaDistribucionDetalle
	
	@OneToMany(mappedBy="rutaDistribucion", cascade={CascadeType.ALL})
	private List<RutaDistribucionDetalle> rutaDistribucionDetalles;

	public RutaDistribucion() {
	}

	public String getIdRutaDistribucion() {
		return this.idRutaDistribucion;
	}

	public void setIdRutaDistribucion(String idRutaDistribucion) {
		this.idRutaDistribucion = idRutaDistribucion;
	}

	public Integer getAnno() {
		return this.anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getDscRutaDistribucion() {
		return this.dscRutaDistribucion;
	}

	public void setDscRutaDistribucion(String dscRutaDistribucion) {
		this.dscRutaDistribucion = dscRutaDistribucion;
	}

	public Integer getNumeroEntrega() {
		return this.numeroEntrega;
	}

	public void setNumeroEntrega(Integer numeroEntrega) {
		this.numeroEntrega = numeroEntrega;
	}

	public Chofer getChofer() {
		return this.chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public EmpleadoDistribuidor getEmpleadoDistribuidor() {
		return this.empleadoDistribuidor;
	}

	public void setEmpleadoDistribuidor(EmpleadoDistribuidor empleadoDistribuidor) {
		this.empleadoDistribuidor = empleadoDistribuidor;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<RutaDistribucionDetalle> getRutaDistribucionDetalles() {
		return this.rutaDistribucionDetalles;
	}

	public void setRutaDistribucionDetalles(List<RutaDistribucionDetalle> rutaDistribucionDetalles) {
		this.rutaDistribucionDetalles = rutaDistribucionDetalles;
	}

	public RutaDistribucionDetalle addRutaDistribucionDetalle(RutaDistribucionDetalle rutaDistribucionDetalle) {
		getRutaDistribucionDetalles().add(rutaDistribucionDetalle);
		rutaDistribucionDetalle.setRutaDistribucion(this);

		return rutaDistribucionDetalle;
	}

	public RutaDistribucionDetalle removeRutaDistribucionDetalle(RutaDistribucionDetalle rutaDistribucionDetalle) {
		getRutaDistribucionDetalles().remove(rutaDistribucionDetalle);
		rutaDistribucionDetalle.setRutaDistribucion(null);

		return rutaDistribucionDetalle;
	}

}
