
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class gestoreImmobili {
    private LinkedList<unitaImmobiliare> listaImmobili;
    private int totaleImmobili;
    private float totalePrezzi;
    private BufferedReader tastiera;
    
    public gestoreImmobili(){
        listaImmobili = new LinkedList<unitaImmobiliare>();
        totaleImmobili = 0;
        totalePrezzi = 0.0f;
        tastiera = new BufferedReader ( new InputStreamReader (System.in));
    }
    
    public synchronized void  stampaReport(){
        System.out.println("Totale immobili in vendita: " + totaleImmobili + "\nTotale prezzi: " + totalePrezzi);
        
    }
    
    public synchronized void totalePrezziImmobili(){
        for(unitaImmobiliare u: listaImmobili){
            totalePrezzi += u.getPrezzo();
        }
    }
    
    public synchronized void totaleImmobili(){
        totaleImmobili = listaImmobili.size();
    }
    
        public synchronized void stampaCodici(){
        for(unitaImmobiliare u: listaImmobili){
            System.out.println(" Codice fiscale proprietario: " + u.getCodicefiscale());
        }
    }
    
    public synchronized void stampaProprietaPersona(){
        String codice;
        boolean control= false;
        try{
            stampaCodici();
            System.out.println("Inserisci il codice fiscale tra quelli esistenti: \n");
            codice = tastiera.readLine();
            for(unitaImmobiliare u: listaImmobili){
                if(u.getCodicefiscale().equalsIgnoreCase(codice)){
                    System.out.println("\nID: " + u.getId() + " descrizone: " + u.getDescrizione() + " indirizzo: " + u.getIndirizzo() + " metri quadri: " + u.getMetriQuadrati() + " numero vani: " + u.getNumVani() + " prezzo: " + u.getPrezzo() + " codice fiscale proprietario: " + u.getCodicefiscale());
                    control = true;
                }
            }
            if ( control == false ){
                System.out.println("Persona non trovata\n");
            }
            
        }catch(IOException e){
            System.out.println("Errrore di I/O");
            System.exit(-1);
        }
    }
    
    public synchronized void stampaImmobili(){
        for(unitaImmobiliare u: listaImmobili){
            System.out.println("\nID: " + u.getId() + " descrizone: " + u.getDescrizione() + " indirizzo: " + u.getIndirizzo() + " metri quadri: " + u.getMetriQuadrati() + " numero vani: " + u.getNumVani() + " prezzo: " + u.getPrezzo() + " codice fiscale proprietario: " + u.getCodicefiscale());
        }
    }
            
    public synchronized void inserisciNuovoImmobile(){
        BufferedReader fp;
       String id,descrizione,indirizzo, cf, tipoImmobili;
       int nVani,  piano, postoAuto, numLivelli;
       float mq, prezzo, mqGiardino;
       boolean piscina;
        try{
            System.out.println("Che tipo di immobile vuoi aggiungere?\n" + "  0  : Appartamento: \n" + "  1  : Villa a Schiera: \n" + "  2  : Villa Singola: \n");
            tipoImmobili = tastiera.readLine();
            System.out.println("\n ");
            stampaImmobili();
            System.out.println("Inserisci l'Id dell'immobile (controlla che l'id sia diverso da quelli stampati):");
            id = tastiera.readLine();
            System.out.println("Inserisci la descrizione dell' immobile");
            descrizione=tastiera.readLine();
            System.out.println("Inserisci l'indirizzo");
            indirizzo=tastiera.readLine();
            System.out.println("Inserisci i codice fiscale del proprietario");
            cf=tastiera.readLine();
            System.out.println("Inserisci i metri quadri");
            mq=Float.parseFloat(tastiera.readLine());
            System.out.println("Inserisci il numero dei vani");
            nVani=Integer.parseInt(tastiera.readLine());
            System.out.println("Inserisci il prezzo");
            prezzo=Float.parseFloat(tastiera.readLine());

               
               
               switch(Integer.parseInt(tipoImmobili)){
                   case 0: 
                       System.out.println("Appartamento");
                       System.out.println("Inserisci il piano");
                       piano = Integer.parseInt(tastiera.readLine());
                       System.out.println("Inserisci 1 se c'è il posto auto, 0 altrimenti");
                       postoAuto = Integer.parseInt(tastiera.readLine());
                       
                       appartamento appartamento = new appartamento(id, descrizione,  indirizzo, cf, mq, nVani, prezzo, piano, postoAuto  );
                       listaImmobili.add(appartamento);
                       break;
                   case 1: 
                       System.out.println("Villa a schiera");
                       System.out.println("Inserisci il numero di livelli della villa");
                       numLivelli = Integer.parseInt(tastiera.readLine());
                       System.out.println("Inserisci i metri quadrati del giardino");
                       mqGiardino = Float.parseFloat(tastiera.readLine());
                       villaSchiera villaSchiera = new villaSchiera(id, descrizione,  indirizzo, cf, mq, nVani, prezzo, numLivelli, mqGiardino );
                       listaImmobili.add(villaSchiera);
                       break;
                   case 2: 
                       System.out.println("Villa Singola");
                       System.out.println("Inserisci il numero di livelli della villa");
                       numLivelli = Integer.parseInt(tastiera.readLine());
                       System.out.println("Inserisci i metri quadrati del giardino");
                       mqGiardino = Float.parseFloat(tastiera.readLine());
                       System.out.println("Inserisci 1 se c'è la piscina, 0 altrimenti");
                       piscina = Boolean.parseBoolean(tastiera.readLine());
                       villaSingola villaSingola = new  villaSingola(id, descrizione, indirizzo, cf, mq, nVani, prezzo, numLivelli, mqGiardino, piscina );
                       listaImmobili.add(villaSingola);
                       break;
               }
               System.out.println("Immobile inserito correttamente");
            
            
        }catch(IOException e){
            System.out.println("Errrore di I/O");
            System.exit(-1);
        }
    }
    
    
    
    public synchronized void caricaImmobili(){
       BufferedReader fp;
       String id,descrizione,indirizzo, cf, tipoImmobili;
       int nVani,  piano, postoAuto, numLivelli;
       float mq, prezzo, mqGiardino;
       boolean piscina;
       try{
           fp = new BufferedReader ( new FileReader ("immobili.txt"));
           tipoImmobili = fp.readLine();
           while(tipoImmobili != null){
               id = fp.readLine();
               descrizione=fp.readLine();
               indirizzo=fp.readLine();
               cf=fp.readLine();
               mq=Float.parseFloat(fp.readLine());
               nVani=Integer.parseInt(fp.readLine());
               prezzo=Float.parseFloat(fp.readLine());
               switch(Integer.parseInt(tipoImmobili)){
                   case 0: 
                       piano = Integer.parseInt(fp.readLine());
                       postoAuto = Integer.parseInt(fp.readLine());
                       
                       appartamento appartamento = new appartamento(id, descrizione,  indirizzo, cf, mq, nVani, prezzo, piano, postoAuto  );
                       listaImmobili.add(appartamento);
                       break;
                   case 1: 
                       numLivelli = Integer.parseInt(fp.readLine());
                       mqGiardino = Float.parseFloat(fp.readLine());
                       villaSchiera villaSchiera = new villaSchiera(id, descrizione,  indirizzo, cf, mq, nVani, prezzo, numLivelli, mqGiardino );
                       listaImmobili.add(villaSchiera);
                       break;
                   case 2: 
                       numLivelli = Integer.parseInt(fp.readLine());
                       mqGiardino = Float.parseFloat(fp.readLine());
                       piscina = Boolean.parseBoolean(fp.readLine());
                       villaSingola villaSingola = new  villaSingola(id, descrizione, indirizzo, cf, mq, nVani, prezzo, numLivelli, mqGiardino, piscina );
                       listaImmobili.add(villaSingola);
                       break;
               }
               tipoImmobili = fp.readLine();
           }
           fp.close();
       }catch(FileNotFoundException f){
           System.out.println("Erroe file non trovato");
           System.exit(-1);
       }catch(IOException e){
            System.out.println("Errrore di I/O");
            System.exit(-1);
        }
    }
}
