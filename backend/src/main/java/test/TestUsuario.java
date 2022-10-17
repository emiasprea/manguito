package test;

import java.util.List;

import entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestUsuario {
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("manguito");
		manager = emf.createEntityManager();
		
		List<Usuario> usuarios = manager.createQuery("FROM Usuario").getResultList();

		System.out.println("En DB hay "+usuarios.size()+" usuarios.");
	}

}
