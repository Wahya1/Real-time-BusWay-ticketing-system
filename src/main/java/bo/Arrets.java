/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author khawl
 */
public class Arrets {
    private Station station;
    private Voyage voyage;
    private LocalTime heure;

    public Arrets(Station station, Voyage voyage) {
        this.station = station;
        this.voyage = voyage;
    }
    
    public Arrets( String station,LocalTime d) {
       this.setStation(new Station(station));
      this.heure=d;
       //voyage=null;
    }
   
    public void setStation(Station station) {
        this.station = station;
       // this.heur=new Date();
       //voyage=null;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Station getStation() {
        return station;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public LocalTime getHeure() {
        return heure;
    }

    @Override
    public String toString() {
        //return "Arrets{" + "station=" + station + ", heur=" + heur + '}';
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String heureFormatee = dateFormat.format(heure);
        return "(" + "" + this.getStation() + " à " + heureFormatee + ")";
    }
    
    
}
