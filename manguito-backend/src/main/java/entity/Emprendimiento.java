package entity;

import java.util.List;

public class Emprendimiento {
	private Long id;
	private String nombre;
	private String descripcion;
	private Imagen imagen;
	private boolean mostrarDonadores;
	private boolean mostrarDonaciones;
	private int precioManguito;
	private List<Categoria> categorias;
	private List<RedSocial> redes;
	private List<Post> posts;
	private List<Donacion> donaciones;
	private List<Plan> planes;
}
