/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;
import java.util.Collection;

/**
 *
 * @author khawl
 */
public class Conducteur {
    private String name;
    private String famillyName;
    private String CIN;
  //  private Bus bus;
    
    public Conducteur(String name, String famillyName, String CIN) {
        this.name = name;
        this.famillyName = famillyName;
        this.CIN = CIN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamillyName(String famillyName) {
        this.famillyName = famillyName;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    /*public void setBus(Bus bus) {
        this.bus = bus;
    }
*/
    public String getName() {
        return name;
    }

    public String getFamillyName() {
        return famillyName;
    }

    public String getCIN() {
        return CIN;
    }
/*
    public Bus getBus() {
        return bus;
    }
*/
    @Override
    public String toString() {
        return "Conducteur{" + "name=" + name + ", famillyName=" + famillyName + ", CIN=" + CIN +  '}';
    }
    
    
}
