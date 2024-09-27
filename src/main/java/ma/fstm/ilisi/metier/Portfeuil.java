package ma.fstm.ilisi.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Portfeuil {
    private Collection<Voyage> voyages;

    public Collection<Voyage> getVoyages() {
        return voyages;
    }

    public Portfeuil() {
        voyages = new ArrayList<>(); // Initialisez la collection lors de la création de l'objet Portfeuil.
    }
    
    public Collection<Voyage> ChercherVoyageDispo(String d, String a, Date dt) {
        Collection<Voyage> voyages_disponibles = new ArrayList<>();
        for (Voyage v : voyages) {
            if (v.verifiervoyage2(d, a, dt)) 
                voyages_disponibles.add(v);
        }
        return voyages_disponibles;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Portfeuil{");
        // Vérifiez d'abord si la collection de voyages n'est pas null avant de la parcourir
        if (voyages != null) {
            for (Voyage v : voyages) {
                stringBuilder.append(v.toString()); // Assurez-vous que la classe Voyage a une méthode toString() appropriée
                stringBuilder.append(", ");
            }
        } else {
            stringBuilder.append("");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    
    public void ajoutervoyage(Voyage v) {
        // Assurez-vous que la collection de voyages est initialisée avant d'ajouter un voyage
        if (voyages == null) {
            voyages = new ArrayList<>();
        }
        voyages.add(v);
    }
}
