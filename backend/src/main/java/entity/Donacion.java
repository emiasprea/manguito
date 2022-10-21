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
@Table(name = "DONACION")
@Getter
@Setter
public class Donacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="montoTotal")
	private int montoTotal;
	
	@Column(name="nombreDonante")
	private String nombreDonante;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="mensaje")
	private String mensaje;
	
	@Column(name="cantManguitos")
	private int cantManguitos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Emprendimiento beneficiario;
	
	@Column(name="fecha")
	private Date fecha;
	
	public Donacion () {
		
	}
	
	public Donacion (
			int montoTotal ,
			String nombreDonante ,
			String email ,
			String telefono ,
			String mensaje ,
			int cantManguitos ,
			Emprendimiento beneficiario ,
			Date fecha
	) {
		this.montoTotal = montoTotal;
		this.nombreDonante = nombreDonante;
		this.email = email;
		this.telefono = telefono;
		this.mensaje = mensaje;
		this.cantManguitos = cantManguitos;
		this.beneficiario = beneficiario;
		this.fecha = fecha;
	}
}
