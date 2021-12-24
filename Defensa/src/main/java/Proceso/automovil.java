package Proceso;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class automovil {

    Scanner s = new Scanner(System.in);
    private String placa;
    private String marca;
    private int modelo;
    private String color;
    protected boolean pas = false;

//Difiniendo relacion de agregacion con boleta
    private List<Boleta_Infraccion> listaBoletas;

    //Constructor
    public automovil() {
        listaBoletas = new ArrayList<>();
    }

    //Metodos
    public void Registrar_Automovil() {
        System.out.println("Digite la placa del automovil: ");
        this.placa = s.nextLine();
        System.out.println("Digite la marca del automovil: ");
        this.marca = s.nextLine();
        System.out.println("Digite el color del automovil: ");
        this.color = s.nextLine();
        
        do {
        	try {
        		pas = false;
        		 System.out.println("Digite el modelo del automovil: ");
                 this.modelo = s.nextInt();
    		} catch (InputMismatchException e) {
    			System.err.println("Dato erroneo");
    			s.next();
    			pas = true;
    		}
           
        }while(pas);
        
    }

    /**
     * Adiciona dentro de la lista listaBoletas el objeto boleta
     *
     * @param boleta Boleta de innfraccion creada por el funcionario de transito
     */
    public void Adicionar_Boleta(Boleta_Infraccion boleta) {
        if (listaBoletas != null) {
            listaBoletas.add(boleta);
            System.out.println("---BOLETA DE INFRACCION ADICIONADA AL AUTOMOVIL " + this.placa);
        }
    }

    public void Motrar_Automovil() {
        System.out.println("Placa: " + this.placa);
        System.out.println("Marca: " + this.marca);
        System.out.println("Color: " + this.color);
        System.out.println("Modelo: " + this.modelo);
        if (listaBoletas != null && listaBoletas.size() > 0) {
            System.out.println("---BOLETAS DE INFRACCION REGISTRADAS PARA EL AUTOMOVIL---");
            for (Boleta_Infraccion boleta : listaBoletas) {
                boleta.Mostrar_Boleta();
            }
        } else {
            System.out.println("No tiene infracciones registradas...");
        }
    }

    //Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public List<Boleta_Infraccion> getListaBoletas() {
        return listaBoletas;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setListaBoletas(List<Boleta_Infraccion> listaBoletas) {
        this.listaBoletas = listaBoletas;
    }

}
