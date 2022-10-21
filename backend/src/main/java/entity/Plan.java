package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PLAN")
@Getter
@Setter
public class Plan implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="monto")
	private int monto;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany(
        mappedBy = "plan",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<Suscripcion> suscripciones;
	
	public Plan() {
		
	}
	
	public Plan (int monto , List<Suscripcion> suscripciones ) {
		this.monto = monto;
		this.suscripciones = suscripciones;
	}
}
