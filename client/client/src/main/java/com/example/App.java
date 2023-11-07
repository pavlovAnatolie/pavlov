package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);
            System.out.println("vi sieti connessi con successo");

            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            Scanner tastiera= new Scanner(System.in);
            Boolean presente = true;

            do{

                System.out.println("inserire la scelta desiderata: ");
                System.out.println("'D'- vedere quanti biglietti sono disponiblili");
                System.out.println("'A'- acquistare il biglietto");
                System.out.println("'Q'- uscire");

                String scelta = tastiera.nextLine();

                
                    out.writeBytes(scelta+"\n");
                switch (scelta) {
                    case "A":
                    case "a":
                    String result = in.readLine();
                    if(result.equals("N")){
                        System.out.println("biglietti esauriti");
                    }else{
                        System.out.println("acquistato con successo");
                    }

                    /*if(in.readLine().equals("fin")){
                        presente = false;
                    }*/

                        break;
                    case "D":
                    case "d":
                    
                        System.out.println("numero di biglietti disponibili è uguale a:"+ in.readLine());
                        break;

                    case "Q":
                    case "q":
                        
                        presente = false;
                        System.out.println("connessione chiusa");
                        break;
                
                    default:
                    System.out.println("riprovare");
                        break;
                }

            }while(presente);
            
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
