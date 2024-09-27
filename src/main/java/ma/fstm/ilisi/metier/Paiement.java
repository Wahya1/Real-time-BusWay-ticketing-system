/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ma.fstm.ilisi.metier;
/**
 *
 * @author khawl
 */
public class Paiement {
    private static int  id=0;
    private int id_paiement;
    private float somme;
    
    public Paiement(float s) {
    	 id_paiement=++id;
    	 somme = s ;}

    
}
