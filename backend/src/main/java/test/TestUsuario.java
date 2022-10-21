package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.service.spi.InjectService;

import DAO.GenericDAO;
import DAO.Impl.EmprendimientoDAOImpl;
import entity.Categoria;
import entity.Emprendimiento;
import entity.Imagen;
import entity.Post;
import entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestUsuario {
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	private static GenericDAO<Emprendimiento> emprendimientoDAO;

	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("manguito");
		manager = emf.createEntityManager();
		
		Date fecha = new Date(2022,5,23);
		Long id = Long.valueOf(12);
		Imagen img = new Imagen ("abc123","desc imagen");
		
		//Categoria cat1 = new Categoria("cat 1");
		//Categoria cat2 = new Categoria("cat 2");
		//Categoria cat3 = new Categoria("cat 3");
		
		//Post post1 = new Post("texto post 1",img,fecha,)
		
		Emprendimiento emp1 = new Emprendimiento("emprendimiento 1","descripcion del emprendimiento",true,true,50);
		Emprendimiento emp2 = new Emprendimiento("emprendimiento 2","descripcion del emprendimiento",true,true,50);
		Emprendimiento emp3 = new Emprendimiento("emprendimiento 3","descripcion del emprendimiento",true,true,50);
		emprendimientoDAO = new EmprendimientoDAOImpl();
		emprendimientoDAO.save(emp1);
		emprendimientoDAO.save(emp2);
		emprendimientoDAO.save(emp3);
		List<Emprendimiento> emprendimientos = manager.createQuery("FROM Emprendimiento").getResultList();

		System.out.println("En DB hay "+emprendimientos.size()+" emprendimientos.");
	}

}
