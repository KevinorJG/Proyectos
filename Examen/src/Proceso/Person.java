package Proceso;

import java.util.Scanner;

public class Person {

	Scanner s = new Scanner(System.in);

	private String Ced;
	private String NomComp;
	private String Exped;
	protected boolean ps = false;

	// Definir relacion de asociacion 1 a 1
	private automovil automovil = new automovil();
	// Relacion de 1 a n

	public void Registrar_Persona() {
		System.out.println("Nro. de cedula: ");
		this.Ced = s.nextLine();
		// Limpiando el buffer
		s.nextLine();
		System.out.println("Nombre completo: ");
		this.NomComp = s.nextLine();
		System.out.println("Lugar de expedido de la cedula: ");
		this.Exped = s.nextLine();
		// Llamar al metodo para registro de los datos de automovil
		// Instanciando onj automovil

		automovil.Registrar_Automovil();
	}

	public void Mostrar_Persona() {
		System.out.println("Cedula: " + this.Ced);
		System.out.println("Expedido: " + this.Exped);
		System.out.println("Nombre Completo: " + this.NomComp);
		if (automovil != null) {
			automovil.Motrar_Automovil();
		}
	}
	// Getters y Setters

	public String getCed() {
		return Ced;
	}

	public String getNomComp() {
		return NomComp;
	}

	public String getExped() {
		return Exped;
	}

	public automovil getautomovil() {
		return automovil;
	}

	public void setCed(String Ced) {
		this.Ced = Ced;
	}

	public void setNomComp(String NomComp) {
		this.NomComp = NomComp;
	}

	public void setExped(String Exped) {
		this.Exped = Exped;
	}

	public void setautomovil(automovil automovil) {
		this.automovil = automovil;
	}

}
