package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Suscripcion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	
	@Column(name="username")
	private Plan plan;
	
	@Column(name="nombreSuscriptor")
	private String nombreSuscriptor;
	
	@Column(name="emailSuscriptor")
	private String emailSuscriptor;
	
	@Column(name="telefonoSuscriptor")
	private String telefonoSuscriptor;
}
