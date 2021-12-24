package Proceso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operation_person {

    Scanner s = new Scanner(System.in);

    List<Person> listaPersona;
    Person pers;
    automovil automovil = new automovil();
    Boleta_Infraccion boleta;

    public Operation_person() {
        listaPersona = new ArrayList<>();
    }

    public void Registro_Usuario() {
        pers = new Person();
        pers.Registrar_Persona();
        listaPersona.add(pers);
        System.out.println("Usuario Registrado en el Sistema...");
    }

    public void Mostrar_Usuario() {
        if (listaPersona != null && listaPersona.size() > 0) {
            System.out.println("---LISTADO DE USUARIOS EN EL SISTEMA---");
            for (Person pers : listaPersona) {
                pers.Mostrar_Persona();
                System.out.println("--------------------------");
            }
        }
    }

    public void Registrar_Automovil() {
        automovil.Registrar_Automovil();
    }

    public void Mostrar_Automovil() {
        if (automovil != null) {
            automovil.Motrar_Automovil();
        }
    }

    public void Asignar_automovil() {
        if (pers != null && automovil != null) {
            pers.setautomovil(automovil);
            System.out.println("Asignado con Exito");
        }
    }

    public void BoletaInfraccion() {
        if (pers.getautomovil() != null) {
            boleta = new Boleta_Infraccion();
            boleta.Llenar_Infraccion();
            //Adicionamos la boleta al automovil 
            pers.getautomovil().Adicionar_Boleta(boleta);
        } else {
            System.out.println("La persona no tiene Asociado un Vehiculo...");
        }
    }

    public void Pagar_Bol_Infrac(int nb) {

        if (pers.getautomovil().getListaBoletas().size() > 0) {
            System.out.println("---INFRACCIONES DEL VEHICULO (No canceladas)---");
            for (Boleta_Infraccion bol : pers.getautomovil().getListaBoletas()) {
                if (bol.getEstado().equalsIgnoreCase("EMITIDO")) {
                    bol.Mostrar_Boleta();
                }
            }
            //Preguntando cual infraccion cancelara
            String resp = "S";

            for (Boleta_Infraccion bol : pers.getautomovil().getListaBoletas()) {
                if (bol.getNroBoleta() == nb) {
                    System.out.println("Desea Cancelar la Infraccion de " + bol.getCosto() + "$ ? (S/N)");
                    resp = s.nextLine();
                    if (resp.equalsIgnoreCase("S")) {
                        bol.setEstado("CANCELADO");
                        System.out.println("Se cancelo la deuda de la Infraccion...");
                    } else {
                        System.out.println("Operacion de cancelacion no realizada...");
                    }
                }
            }
        }
    }
    
    public void AjustarBoleta() {
    	int boleta;
    	int confirmacion;
    	
    	System.out.println("Digite el Nro de boleta");
    	boleta = s.nextInt();
    	for(Boleta_Infraccion i: pers.getautomovil().getListaBoletas() ) {
    		if(i.getNroBoleta() == boleta) {
    			System.out.println("Ingrese el nuevo valor de " +i.getCosto()+ "Cordobas");
    			confirmacion = s.nextInt();
    			i.setCosto(confirmacion);
    			System.out.println("El nuevo valor de la boleta es: "+i.getCosto()+" Cordobas");
    		}
    	}
    }
}
