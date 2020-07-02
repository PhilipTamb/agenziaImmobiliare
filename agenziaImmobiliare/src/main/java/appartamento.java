/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Philip T
 */
public class appartamento extends unitaImmobiliare {
    private int piano;
    private int postoAuto;
    
    public appartamento(String id, String descrizione, String indirizzo, String codiceFiscale, float metriQuadri, int numVani, float p, int piano, int postoAuto  ){
        super(id, descrizione, indirizzo, codiceFiscale, metriQuadri,numVani,p );
        this.piano = piano;
        this.postoAuto = postoAuto;
        }
}
