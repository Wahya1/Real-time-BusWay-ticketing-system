/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

/**
 *
 * @author khawl
 */
public class ticket {
    private static int id=0;
    private int  id_ticket ;
    private Reservation reservation;
    public ticket(Reservation r) {
        super();
	id_ticket=++id;
	reservation = r;
    }
    public Reservation getRes() {
		return reservation;
	}

	public void setRes(Reservation res) {
		this.reservation = res;
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

    @Override
    public String toString() {
        return "ticket{" + "id_ticket=" + id_ticket + ", reservation=" + reservation + '}';
    }

    
}
