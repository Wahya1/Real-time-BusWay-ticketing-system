/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author khawl
 */
public class Bus {
    private int numero ;
    private int nbrePlace;
    private String matricule;
    private Conducteur conducteur;
    private Collection<Voyage> voyages ; 
    private float price ;
    
    public float getPrice() {
		return price;
    }

   
    public Bus(int numero, String matricule ,int nb,float prix,Conducteur c) {
        this.numero = numero;
        this.matricule = matricule;
        this.nbrePlace=nb;
        this.price=prix;
        this.conducteur=c;
      //  voyages=new ArrayList<Voyage>();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public void setVoyages(Collection<Voyage> voyages) {
        this.voyages = voyages;
    }
    
    public void setNbrePlace(int nbre) {
        this.nbrePlace = nbre;
    }

    public int getNumero() {
        return numero;
    }

    public String getMatricule() {
        return matricule;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public Collection<Voyage> getVoyages() {
        return voyages;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }
     
   public String afficherListVoyage()
    {
        StringBuffer string = new StringBuffer();
        string.append(" [ ");
        if(voyages != null){
            for(Voyage v : voyages )
            {
                string.append(v);
                string.append("\n");
            }
        }
        string.append(" ] ");
        return string.toString();}
  @Override
    public String toString() {
        return "Bus{" + "numero=" + numero + ", matricule=" + matricule + ", conducteur=" + conducteur + ", voyages=" + afficherListVoyage()+'}';}

    public void ajoutervoyagebus(Voyage V )
    {
        
        if (voyages != null) {
            voyages.add(V);
        } else {
            // Si la collection est null, créez une nouvelle instance de collection et ajoutez le bus.
            voyages= new ArrayList<>(); // ou toute autre implémentation de Collection que vous utilisez
            voyages.add(V);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bus other = (Bus) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.nbrePlace != other.nbrePlace) {
            return false;
        }
        return Objects.equals(this.matricule, other.matricule);
    }
    
     public  Collection<Voyage> ChercherVoyageDispoo(String d,  String a , Date dt)
    {
        Collection<Voyage>  voyages_disponibles = new ArrayList<>();
        for(Voyage v : voyages)
        {
            if(v.verifierVoyage(d, a, dt)) 
                voyages_disponibles.add(v);
        }
        return voyages_disponibles;
    }
    
    
}
