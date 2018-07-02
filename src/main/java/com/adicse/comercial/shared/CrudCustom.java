package com.adicse.comercial.shared;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.adicse.comercial.service.IAdicseService;

public class CrudCustom<T,ID>  implements IAdicseService<T, ID> {
	
	@Override
	public Page<?> paginationParmsExtra(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter, Object paramsExtra) {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public Page<?> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		return null;
	}

	@Override
	public List<T> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getallbyid(List<?> lst) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(T entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyid(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean exists(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> findbyid(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T grabar(T entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<T> EntityForSpecificatios(T entidad,Object filter) {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		Class _class = (Class) entidad.getClass();
		Object newEntity = null;
		try {
			newEntity = _class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    
		
		return (Optional<T>) newEntity;
	}
	


}
