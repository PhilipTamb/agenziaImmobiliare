/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class villaSingola extends unitaImmobiliare{
    private int numLivelli;
    private float mqGiardino;
    private boolean piscina;
    
    public villaSingola(String id, String descrizione, String indirizzo, String codiceFiscale, float metriQuadri, int numVani, float p, int numLivelli, float mqGiardino, boolean piscina ){
    super(id, descrizione, indirizzo, codiceFiscale, metriQuadri,numVani,p );
    this.numLivelli  = numLivelli;
    this.mqGiardino = mqGiardino;
    this.piscina = piscina;
    }
    
}
