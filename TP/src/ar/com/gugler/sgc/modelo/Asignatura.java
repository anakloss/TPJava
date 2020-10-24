package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	public Integer codigo;
	public String nombre;
	public List<Alumno> alumnos;
	public Profesor profesor;
	
	// Constructors
	public Asignatura() {
		super();
		this.alumnos = new ArrayList<Alumno>();
	}
	public Asignatura(Integer codigo, String nombre, Profesor profesor) {  // List<Alumno> alumnos
		super();
		this.codigo = codigo;
		this.nombre = nombre;
//		this.alumnos = alumnos;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = profesor;
	}
	
	// Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public List<Alumno> getAlumnos() {
//		return alumnos;
//	}
//	public void setAlumnos(List<Alumno> alumnos) {
//		this.alumnos = alumnos;
//	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	// toStrings
	@Override
	public String toString() {
		if (codigo != null && nombre != null) 
			return "[" + codigo + "] " + nombre;
		else if (nombre != null)
			return nombre;
		return null;
	}
		
}
