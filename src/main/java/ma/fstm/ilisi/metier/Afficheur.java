/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

import java.util.Collection;

/**
 *
 * @author khawl
 */
public class Afficheur 
{
    public void AfficherVoyage(Collection<Voyage> v)
    {
        int i=1;
        //System.out.println("Voila les Voyages disponibles \n");  
        for(Voyage voyage : v)
          System.out.println(i+")"+voyage);
        i++;
         // System.out.println(voyage);   
    }
    
    public void AfficherListBus(Collection<Bus> busliste,int NB)
    {   
        int i=1;
        if(NB==0){
        for(Bus b : busliste )
              
            afficher(b);}
        else{
            for(Bus b : busliste )
           afficherinfo(b);
        }
    }
    
    public void afficher(Bus b)
    {
        System.out.println(b);
    }
    public void afficherinfo(Bus b)
    {
        System.out.println("Bus{" + "numero=" + b.getNumero() + ", matricule=" + b.getMatricule() + ", conducteur=" + b.getConducteur());
    }
 }   


