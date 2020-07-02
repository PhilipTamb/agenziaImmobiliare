/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class unitaImmobiliare {
    private String identificativo;
    private String descrizione;
    private String indirizzo;
    private String codiceFiscale;
    private float metriQuadri;
    private int numVani;
    private float prezzo;
    
    public unitaImmobiliare(String id, String descrizione, String indirizzo, String codiceFiscale, float metriQuadri, int numVani, float p  ){
        this.identificativo = id;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.codiceFiscale = codiceFiscale;
        this.identificativo = identificativo;
        this.metriQuadri = metriQuadri;
        this.numVani = numVani;
        this.prezzo = p;
    }
    
    public String getId (){
        return identificativo;
    }
    
    public String getDescrizione (){
        return descrizione;
        
    }
    
    public String getIndirizzo (){
        return indirizzo;
        
    }
    
    public String getCodicefiscale (){
        return codiceFiscale;
        
    }
    
    public float  getMetriQuadrati (){  
     return   metriQuadri;
    }
    
    public int getNumVani(){  
     return   numVani;
    }
    
    public float getPrezzo (){  
     return   prezzo;
    }
        
     
    
    
}
