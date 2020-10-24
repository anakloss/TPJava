package ar.com.gugler.sgc.modelo;

import java.time.format.DateTimeFormatter;


/**
 * Clase Universidad
 * @author Ana Kloss
 *
 */
public class Universidad {
	
	/**
	 * Método utilizado para mostrar toda la información
	 * 
	 * @param persona
	 * 			muestra toda la información de la persona
	 */
	public static void mostrarDatos(Persona persona) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 	
		
		StringBuilder sb = new StringBuilder();
			sb.append(persona.mostrarInformacion() + "\n");
			sb.append("Fecha nacimiento: " + dtf.format(persona.getFechaNacimiento()) + "\n");
			sb.append("Domicilio: " + persona.getDomicilio() + "\n");
			sb.append("Teléfono: " + persona.getTelefono() + "\n");
			sb.append("E-Mail: " + persona.getCorreoElectronico() + "\n");
			System.out.println(sb.toString());
		}
}