/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.examenmario;

import java.util.Scanner;

/**
 *
 * @author mssyo
 */
public class main {

    static int pinA = 4455, saldo = 1500, codigo = 11222345, recibo;
    static String ubicacion = "Cuautla centro";
    static Scanner leer = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //solo se valida una tarjeta (codigo)
        //pin 4 digitos (pin)
        //saldo se le pondran $1500
        int pin, codi;
        int intentos = 0;
        int validar = 0;
        
        do {
            System.out.println("ingrese un codigo:");
            codi = leer.nextInt();

            System.out.println("ingrese pin:");
            pin = leer.nextInt();

            //validar datos
            if (codi == codigo && pinA == pin) {

                System.out.println("bienvenido");
                pago pa = new pago();
                validar = 1;

            } else {
                System.out.println("pin o codigo no valido");
                intentos++;

                if (intentos == 3) {
                    System.out.println("demasiados intentos");
                    validar = 1;
                }
            }

        } while (validar == 0);

        
        System.out.println("-Retire su tarjeta-");
        System.out.println("vuelva pronto");
        System.out.println("Examen_Cervantes Segundo Mario");

    }

    private static class pago {

        public pago() {
            int opc = 0;

            int adeudo;
            String nombre;
            int salir=0;
            String a;
            do{
            System.out.println("PAGO DE SERVICIO");
            System.out.println("1. telefono ");
            System.out.println("2. CFE");
            System.out.println("3. Pago TV");

            opc = leer.nextInt();
            
            switch (opc) {
                case 1:
                    a="telefono";
                    recibo reci =new recibo(a);
            
                    break;
                case 2:
                    a="CFE";
                     reci =new recibo(a);
            
                    break;
                case 3:
                    a="Pago TV";
                    reci =new recibo(a);
            
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
                
                System.out.println("desea realizar otro pago");
                System.out.println("1. si");
                System.out.println("0. no");
                salir= leer.nextInt();
            
            }while (salir==1);
                
            }

        }

    //recibo
    private static class recibo {

        public recibo(String a) {
            int adeudo;
            String nombre;
            System.out.println("Nombre: ");
                    nombre = leer.next();
                    System.out.println("Cantidad a pagar: ");
                    adeudo = leer.nextInt();
                    if (adeudo<saldo) {
                        
                        System.out.println("adeudo pagado");
                        
                        //nuevo saldo
                        saldo=saldo-adeudo;
                        
                        recibo++;
                        
                        //ticket
                        System.out.println("Recibo de "+a);
                        System.out.println("folio: "+recibo);
                        System.out.println("Ubicacion: "+ubicacion);
                        System.out.println("cantidad depositada: "+adeudo );
                        System.out.println("Nuevo saldo: "+saldo);
                        System.out.println("gracias "+nombre);
                    }else{
                        System.out.println("saldo insuficiente");
                    }
        }
    }
    }


