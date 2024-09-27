/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author khawl
 */
public class Depart {
    private Voyage voyage;
    private Station station;
    private Date heure ;

    public Depart(Voyage voyage, Station station) {
        this.voyage = voyage;
        this.station = station;
    }
    public Depart( String station,Date d) {
       
       this.setStation(new Station(station));
       this.heure=d;
       //voyage=null;
    }
    public Voyage getVoyage() {
        return voyage;
    }

    public Station getStation() {
        return station;
    }

    public Date getHeure() {
        return heure;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

     @Override
    public String toString() {
        // Formater la date pour n'afficher que l'heure
         SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String heureFormatee = dateFormat.format(heure);
        return "(" + "" + this.getStation() + " à " + heureFormatee + ")";
    }
    
    
}
