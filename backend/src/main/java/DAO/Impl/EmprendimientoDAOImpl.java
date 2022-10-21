package DAO.Impl;

import DAO.EmprendimientoDAO;
import entity.Emprendimiento;

public class EmprendimientoDAOImpl extends GenericDAOImpl<Emprendimiento> implements EmprendimientoDAO{

	public EmprendimientoDAOImpl() {
		super(Emprendimiento.class);
	}
	
	public Emprendimiento save (Emprendimiento emp) {
		return super.save(emp);
	}

}
