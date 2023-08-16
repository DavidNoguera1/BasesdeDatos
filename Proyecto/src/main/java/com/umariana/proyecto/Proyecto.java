/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;
import Mundo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sistemas (David Noguera y Samuel Bolaños)
 */
public class Proyecto {
    
    
    public static void main(String[] args) {
        
        //Duncion que permite leer la opcion del usuario
        Scanner lector= new Scanner(System.in);
        //Bandera para terminar el programa
        boolean activo = true;
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        
        do{
        System.out.println("--------Menu de opeciones--------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Consultar alumno");
        System.out.println("5. Terminar Programa");
        System.out.println("----------------------------------");
        
        // Empleamos un switch para la seleccion de las opciones
        int opcion = lector.nextInt();
        
            switch (opcion) {
                case 1:
                    
                    System.out.println("Introduce la cedula del alumno");
                    int cedula = lector.nextInt();
                    
                    System.out.println("Introduce el nombre del alumno");
                    String nombre = lector.next(); 
                    
                    System.out.println("Introduce el apellido del alumno");
                    String apellido = lector.next(); 
                    
                    System.out.println("Introduce el semestre del alumno");
                    int semestre = lector.nextInt(); 
                    
                    System.out.println("Introduce el correo del alumno");
                    String correo = lector.next();
                    
                    System.out.println("Introduce el celular del alumno");
                    int celular = lector.nextInt();
                    
                    //Se crea un objeto para guardar la informacion de cada alumno
                    Alumno a = new Alumno();
                    
                    a.setCedula(cedula);
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setSemestre(semestre);
                    a.setCorreo(correo);
                    a.setCelular(celular);
                    // Se agrega el valor del objeto al list array
                    
                    misAlumnos.add(a);
                    
                    break;
                    
                case 2:
                    System.out.println("Opcion 2");
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    break;
                case 4:
                    System.out.println("Opcion 4");
                    break;
                case 5:
                    System.out.println("Opcion 5");
                    break;
                default:
                    System.out.println("Debe seleccionar una opcion del menu");
                    break;
            }
        
        
        } while (activo);
        
        
    }
}
        
