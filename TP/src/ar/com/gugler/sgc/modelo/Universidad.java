package ar.com.gugler.sgc.modelo;

import java.text.SimpleDateFormat;

public class Universidad {
	
	public static void mostrarDatos(Object obj) {
		Persona persona = (Persona) obj;

		SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
		String fecha = formato.format(persona.getFechaNacimiento());		
		
		StringBuilder sb = new StringBuilder();
			sb.append(persona.mostrarInformacion() + "\n");
			sb.append("Fecha nacimiento: " + fecha + "\n");
			sb.append("Domicilio: " + persona.getDomicilio() + "\n");
			sb.append("Teléfono: " + persona.getTelefono() + "\n");
			sb.append("E-Mail: " + persona.getCorreoElectronico() + "\n");
			System.out.println(sb.toString());
		}
}