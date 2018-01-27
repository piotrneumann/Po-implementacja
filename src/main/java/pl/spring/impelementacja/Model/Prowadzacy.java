package pl.spring.impelementacja.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prowadzacy")
public class Prowadzacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;
    private String haslo;
    private String nazwisko;
    private String imie;
    private String kwalifikacje;
    @Column(name = "liczbapensum")
    private int liczbaPensum;

    @Override
    public String toString() {
        return "Prowadzacy{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", kwalifikacje='" + kwalifikacje + '\'' +
                ", liczbaPensum=" + liczbaPensum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getKwalifikacje() {
        return kwalifikacje;
    }

    public void setKwalifikacje(String kwalifikacje) {
        this.kwalifikacje = kwalifikacje;
    }

    public int getLiczbaPensum() {
        return liczbaPensum;
    }

    public void setLiczbaPensum(int liczbaPensum) {
        this.liczbaPensum = liczbaPensum;
    }
}
