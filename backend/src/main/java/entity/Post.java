package entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "POST")
@Getter
@Setter
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="texto")
	private String texto;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Imagen imagen;
	
	@Column(name="fecha")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Emprendimiento autor;
	
	public Post () {
		
	}
	
	public Post (String texto , Imagen imagen , Date fecha , Emprendimiento autor) {
		this.texto = texto;
		this.imagen = imagen;
		this.fecha = fecha;
		this.autor = autor;
	}
}
