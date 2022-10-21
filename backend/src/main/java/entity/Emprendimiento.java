package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPRENDIMIENTO")
@Getter
@Setter
public class Emprendimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "imagen_id")
	private Imagen imagen;
	
	@Column(name="mostrarDonadores")
	private boolean mostrarDonadores;
	
	@Column(name="mostrarDonaciones")
	private boolean mostrarDonaciones;
	
	@Column(name="precioManguito")
	private int precioManguito;
	
	@Column(name="categorias")
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Categoria> categorias;
	
	@Column(name="redes")
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<RedSocial> redes;
	
	@Column(name="posts")
	@OneToMany(
        mappedBy = "autor",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<Post> posts;
	
	@Column(name="donaciones")
	@OneToMany(
        mappedBy = "beneficiario",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<Donacion> donaciones;
	
	@Column(name="planes")
	@OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<Plan> planes;
	
	@OneToOne(mappedBy="emprendimiento")
	private Usuario usuario;
	
	public Emprendimiento() {
		
	}
	
	public Emprendimiento (
			String nombre , 
			String desc , 
			boolean mostrarDonadores , 
			boolean mostrarDonaciones , 
			int precioManguito
	) {
		this.nombre = nombre;
		this.descripcion = desc;
		this.mostrarDonadores = mostrarDonadores;
		this.mostrarDonaciones = mostrarDonaciones;
		this.precioManguito = precioManguito;
	}
	
	public Emprendimiento (
			String nombre , 
			String desc , 
			Imagen img , 
			boolean mostrarDonadores , 
			boolean mostrarDonaciones , 
			int precioManguito , 
			List<Categoria> categorias ,
			List<Post> posts ,
			List<Donacion> donaciones ,
			List<Plan> planes ,
			Usuario usuario
	) {
		this.nombre = nombre;
		this.descripcion = desc;
		this.imagen = img;
		this.mostrarDonadores = mostrarDonadores;
		this.mostrarDonaciones = mostrarDonaciones;
		this.precioManguito = precioManguito;
		this.categorias = categorias;
		this.posts = posts;
		this.donaciones = donaciones;
		this.planes = planes;
		this.usuario = usuario;
	}
}
