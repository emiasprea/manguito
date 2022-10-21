package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private int role;
	
	@OneToOne
	private Emprendimiento emprendimiento;
	
	public Usuario() {
		
	}
	
	public Usuario (Long id , String username , String password , int role , Emprendimiento emprendimiento) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.emprendimiento = emprendimiento;
	}
}
