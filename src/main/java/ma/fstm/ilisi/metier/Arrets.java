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
public class Arrets {
    private Station station;
    private Voyage voyage;
    private Date heur;

    public Arrets(Station station, Voyage voyage) {
        this.station = station;
        this.voyage = voyage;
    }
   public Arrets( String station,Date d) {
       this.setStation(new Station(station));
      this.heur=d;
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

    public void setHeur(Date heur) {
        this.heur = heur;
    }

    public Station getStation() {
        return station;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public Date getHeur() {
        return heur;
    }

    @Override
    public String toString() {
        //return "Arrets{" + "station=" + station + ", heur=" + heur + '}';
          SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String heureFormatee = dateFormat.format(heur);
        return "(" + "" + this.getStation() + " à " + heureFormatee + ")";
    }
    
    
}
