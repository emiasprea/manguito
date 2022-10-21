package DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	
	public T save (T entity);
	public void delete (T entity);
	public T deleteById (Long id);
	public T getById (Long id);
	public List<T> getAll (String column);
	public T update (T entity);
	//public boolean exists (Long id);
}
