/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

/**
 *
 * @author khawl
 */
public class Station {
    private String Local;

    public Station(String Local) {
        this.Local = Local;
    }

    public String getLocal() {
        return Local;
    }
    
     @Override
    public String toString() {
        return Local; // Vous pouvez simplement retourner le nom de la station pour l'affichage
    }
    
}
