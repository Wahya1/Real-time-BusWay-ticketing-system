/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

/**
 *
 * @author khawl
 */
public class Compte {
    private String login ;
    private String mdp;
    private Passager passager;

    public Compte() {
    }

    
    public Compte(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
        passager = new Passager();
    }
    
    
}
