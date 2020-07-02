/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class threadBackground extends Thread{
    gestoreImmobili gestore;
    public threadBackground(gestoreImmobili gestore){
        this.gestore = gestore;
    }
    
    public void run(){
        while(true){
            try{
                gestore.totaleImmobili();
                gestore.totalePrezziImmobili();
                
                Thread.sleep(5000);
            }catch(InterruptedException i){
                System.out.println("");
                System.exit(-1);
            }
    
    
    
    
    
    
    
    
    
    
    
    
        }
        
    }
    

    
}
