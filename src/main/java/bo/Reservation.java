/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;

//import com.google.zxing.WriterException;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author khawl
 */
public class Reservation {
    private static int id=0;
    private int ID;
    private Passager passagers;
    private Voyage voyage;
    private Paiement paiement ;
    private ticket ticket;
    private Station From;
    private Station To;
    
    public void setTicket(ticket ticket) {
        this.ticket = ticket;
    }
    
    ///penser a ajouter un lien avec stations 
    public Reservation(Passager passagers, Voyage voyage,Paiement P,ticket t) {
        this.ID=++id;
        this.passagers = passagers;
        this.ticket=t;
        this.voyage = voyage;
        this.paiement=P;
    }

    public Reservation(Voyage V,String nom,String d,String a) {
	this.ID=++id;
        setPaiement(creerPaiement(V));
        setPassagers(creerPassager(nom));
        setVoyage(V);
        From = chercherDepart(d);       
        To = chercherArrive(a) ;
    }
    
    public int getID() {
        return ID;
    }

    public Passager getPassagers() {
        return passagers;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassagers(Passager passagers) {
        this.passagers = passagers;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public ticket getTicket() {
        return ticket;
    }
    
    private Station chercherDepart(String d)
    {
        if(voyage.getStationdepart().getLocal().equals(d)) return voyage.getStationdepart();
        for(Arrets a : getVoyage().getArrets())
            if(a.getStation().getLocal().equals(d))
               return  a.getStation();
         return null;
    }
    
    private Station chercherArrive(String arr)
    {
        if(voyage.getStationarrivee().getLocal().equals(arr)) return voyage.getStationarrivee();
        for(Arrets a : voyage.getArrets())
            if(a.getStation().getLocal().equals(arr))
               return a.getStation();
        return null;
    }
    
    public Paiement creerPaiement(Voyage v)
    {
        voyage = v;
        Paiement P  = new Paiement(this.voyage.getBus().getPrice());
        setPaiement(P);
        return P;
    }
    public Passager creerPassager(String fullname)
    {
        Passager P =  new Passager(fullname,this);
        setPassager(P);
        return P;
    }
    
//    public ticket creerTicket(Reservation R) throws IOException, WriterException 
//    {
//         ticket T= new ticket(R);
//         setTicket(T);
//         return T;
//    }

    public Station getFrom() {
        return From;
    }

    public Station getTo() {
        return To;
    }
    
    
    
    public void setPaiement(Paiement paiement)
    {
        this.paiement = paiement;
    }

    
    @Override
    public String toString() {
        return "Reservation{" + "ID=" + ID + ", passagers=" + passagers + '}';
    }

 
    public void setPassager(Passager P)
    {
    	this.passagers=P;
    }
}
