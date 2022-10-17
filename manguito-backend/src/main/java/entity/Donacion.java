package entity;

import java.sql.Date;

public class Donacion {
	private Long id;
	private int montoTotal;
	private String nombreDonante;
	private String email;
	private String telefono;
	private String mensaje;
	private int cantManguitos;
	private Emprendimiento beneficiario;
	private Date fecha;
}
