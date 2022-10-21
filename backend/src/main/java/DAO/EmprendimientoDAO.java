package DAO;

import entity.Emprendimiento;

public interface EmprendimientoDAO extends GenericDAO<Emprendimiento>{
	
	Emprendimiento save (Emprendimiento entity);

}
