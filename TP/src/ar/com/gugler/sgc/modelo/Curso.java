package ar.com.gugler.sgc.modelo;

public class Curso extends Asignatura {
	public Integer cupo;

	// Constructors
	public Curso() {
		super();
	}
	public Curso(Integer cupo) {
		super();
		this.cupo = cupo;
	}
	
	// Getters and Setters
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
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

		Curso other = (Curso) obj;
		if (cupo == null) {
			if (other.cupo != null)
				return false;
		} else if (!cupo.equals(other.cupo))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "[Cupo:  " + getCupo() + "]"; 
	}
	
	
	public void agregarAlumno(Alumno alumno) {
		if (alumnos.size() < this.cupo) {
			if (!alumnos.contains(alumno)) {
				alumnos.add(alumno);
			}
		} else {
			System.out.println("No hay mas cupo en este curso");
		}
	}
	public void eliminarAlumno(Alumno alumno) {
		if (alumnos.contains(alumno)) {
			alumnos.remove(alumno);
		}
	}
	public void mostrarAlumnos() {
		System.out.println("*** Listado de alumnos ***");
		System.out.println("Cantidad de personas: " + alumnos.size());
		for (Alumno a: alumnos) {
			System.out.println(a);
		}
	}
}
