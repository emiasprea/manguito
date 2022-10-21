package entity;

import java.io.Serializable;

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
@Table(name = "SUSCRIPCION")
@Getter
@Setter
public class Suscripcion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Plan plan;
	
	@Column(name="nombreSuscriptor")
	private String nombreSuscriptor;
	
	@Column(name="emailSuscriptor")
	private String emailSuscriptor;
	
	@Column(name="telefonoSuscriptor")
	private String telefonoSuscriptor;
	
	public Suscripcion () {
		
	}
	
	public Suscripcion (Plan plan , String nombreSuscriptor , String emailSuscriptor , String telefonoSuscriptor) {
		this.plan = plan;
		this.nombreSuscriptor = nombreSuscriptor;
		this.emailSuscriptor = emailSuscriptor;
		this.telefonoSuscriptor = telefonoSuscriptor;
	}
}
