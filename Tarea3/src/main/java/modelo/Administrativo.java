/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Administrativo extends Empleado {
    
    private String cargo;
    Scanner x = new Scanner(System.in);
    
    @Override
    public void registrar(){
        super.registrar();
        System.out.println("Ingrese el cargo Administrativo");
        this.cargo = x.nextLine();
        System.out.println("REGISTRADO");
    }
    
}
