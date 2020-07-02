
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class threadForeground extends Thread{
    gestoreImmobili gestore;
    BufferedReader tastiera;
    
    public threadForeground (gestoreImmobili gestore){
       this.gestore = gestore;
       this.tastiera = new BufferedReader ( new InputStreamReader ( System.in));
    }
    
    public void run(){
        gestore.caricaImmobili();
        
        while(true){

                switch(menu()){
                    default:
                        System.out.println("Opzione non valida");
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        gestore.inserisciNuovoImmobile();
                        break;
                    case 2:
                        gestore.stampaProprietaPersona();
                        break;
                    case 3:
                        gestore.stampaReport();
                        break;
                    case 4:
                        gestore.stampaImmobili();
                        break;
                }
        }


    }
    
    public int menu(){
    int scelta = -1;
        do{
            try{
                System.out.println(
                "  _________________________________________________________________________ \n" +
                "  1  : Inserisci un nuovo immobile\n" + 
                "  2  : Stampa immobili di una persona\n" +
                "  3  : Stampa Report\n" + 
                "  4  : Stampa tutti gli immobili\n" +
                "  0  : Esci\n"
                );
                scelta = Integer.parseInt(tastiera.readLine());

            }catch(IOException e){
                    System.out.println("Errrore di I/O");
                    System.exit(-1);
                }

        }while(scelta<0 || scelta>5);
        return scelta;
    }  
}
    
    
    
    
