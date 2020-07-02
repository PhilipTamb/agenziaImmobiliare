/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class villaSchiera extends unitaImmobiliare{
    private int numLivelli;
    private float mqGiardino;
    
    public villaSchiera(String id, String descrizione, String indirizzo, String codiceFiscale, float metriQuadri, int numVani, float p,int numLivelli, float mqGiardino  ){
    super( id, descrizione, indirizzo, codiceFiscale, metriQuadri,numVani,p );
    this.numLivelli = numLivelli;
    this.mqGiardino = mqGiardino;
}

    
}
