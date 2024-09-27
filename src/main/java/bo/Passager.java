/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;

/**
 *
 * @author khawl
 */
public class Passager {
    private String fullName; 
    private Compte cmp;
    private Reservation reservation;

    public Passager() {
    }
    
    
    public Passager(String fullName, Reservation r) {
        reservation = r;
        fullName = fullName ;
    
    }
    
    
    public Passager(String fullName, Compte cmp, Reservation reservation) {
        this.fullName = fullName;
        this.cmp = cmp;
        this.reservation = reservation;
    }

    public String getFullName() {
        return fullName;
    }

    public Compte getCmp() {
        return cmp;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCmp(Compte cmp) {
        this.cmp = cmp;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Passager{" + "fullName=" + fullName + ", cmp=" + cmp +  '}';
    }
    
    public Compte creerCompte()
    {
        return new Compte();
    }
    
}
