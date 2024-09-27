/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;

import java.util.List;

/**
 *
 * @author khawl
 */
public class Station {
    private String Local;
    private float x;
    private float y;
    private List<Arrets> arrets ;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public List<Arrets> getArrets() {
        return arrets;
    }

    public void setArrets(List<Arrets> arrets) {
        this.arrets = arrets;
    }

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
