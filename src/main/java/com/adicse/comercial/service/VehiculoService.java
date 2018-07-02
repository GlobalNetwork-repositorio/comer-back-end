package com.adicse.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.comercial.dao.IVehiculoDao;
import com.adicse.comercial.especification.VehiculoSpecification;
import com.adicse.comercial.model.Vehiculo;
import com.adicse.comercial.shared.CustomFilterSpec;

@Service
@Transactional
public class VehiculoService implements IAdicseService<Vehiculo, Integer> {
	
	@Autowired
	private IVehiculoDao iVehiculoDao;
	
	@Override
	public Page<?> paginationParmsExtra(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter, Object paramsExtra) {
		return null;
	}

	@Override
	public Page<Vehiculo> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);

		/*  
		 * instanciamos una entidad la cual servira de contenedor para realizar el filtro
		 * este evento sera llenado dentro de una funcion que esta en CustomFilterSpec
		 * se le debe pasar dos parametros, uno la entidad que queremos llenar con los datos 
		 * del segundo parametro que es un objecto json que se para en la variable filter  
		 */
		Vehiculo entidad = new Vehiculo();
		entidad.setIdVehiculo(null);
		entidad.setNumeroPlaca(null);
		
		

		CustomFilterSpec efs = new CustomFilterSpec();
		try {
			
			entidad = (Vehiculo) efs.CreateCustomFilter(entidad, filter);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Specification nos permite agregar implicitamente los where que se pasaran al evento findAll,
		 * Esto sucede en CrudRepository
		 */
		Specification<Vehiculo> spec = new VehiculoSpecification(entidad);
		
		Page<Vehiculo> lista = iVehiculoDao.findAll(spec,pageable);
 

		//
		return lista;
	}

	@Override
	public List<Vehiculo> getall() {
		// TODO Auto-generated method stub
		return (List<Vehiculo>) iVehiculoDao.findAll();
	}

	@Override
	public List<Vehiculo> getallbyid(List<?> lst) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo grabar(Vehiculo entidad) {
		// TODO Auto-generated method stub
		if(entidad.getIdVehiculo() == 0) {
			Integer id = iVehiculoDao.getMax()==null?1:iVehiculoDao.getMax()+1;
			entidad.setIdVehiculo(id);
		}
		return iVehiculoDao.save(entidad);
	}

	@Override
	public void delete(Vehiculo entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyid(Integer id) {
		// TODO Auto-generated method stub
		iVehiculoDao.deleteById(id);
	}

	@Override
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vehiculo> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iVehiculoDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vehiculo> EntityForSpecificatios(Vehiculo entidad, Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
