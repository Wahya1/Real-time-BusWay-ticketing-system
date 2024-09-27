package ma.fstm.ilisi.metier.bo;

import java.util.Collection;
import java.util.ArrayList; // Importez la classe ArrayList si vous utilisez celle-ci comme implémentation de votre Collection.

/**
 * Cette classe représente un catalogue de bus.
 * Elle contient une collection de bus.
 */
public class Catalogue {
    Collection<Bus> bus;

    // Constructeur par défaut
    public Catalogue() {
        // Initialisez la collection de bus lors de la création de l'objet Catalogue.
        bus = new ArrayList<>(); // Vous pouvez utiliser ArrayList comme implémentation de la Collection.
    }

    // Méthode pour ajouter un bus au catalogue
    public void ajouterBus(Bus B) {
        // Assurez-vous que la collection de bus n'est pas null avant d'ajouter le bus.
        if (bus != null) {
            bus.add(B);
        } else {
            // Si la collection est null, créez une nouvelle instance de collection et ajoutez le bus.
            bus = new ArrayList<>(); // ou toute autre implémentation de Collection que vous utilisez
            bus.add(B);
        }
    }

    // Méthode pour obtenir la collection de bus
    public Collection<Bus> getBus() {
        return bus;
    }

    // Redéfinition de la méthode toString pour afficher le contenu du catalogue
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Catalogue{");
        // Parcourir la collection de bus et ajouter chaque bus à la chaîne de caractères
        for (Bus b : bus) {
            stringBuilder.append(b.toString()); // Assurez-vous que la classe Bus a une méthode toString() appropriée
            stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
