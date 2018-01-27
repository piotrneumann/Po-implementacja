package pl.spring.impelementacja.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asystent_dziekana_ds_dydaktyki")
public class AsystentDziekanaDsDydaktyki {

    @Id
    private int id;
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;
    private int dziekanatID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    public int getDziekanatID() {
        return dziekanatID;
    }

    public void setDziekanatID(int dziekanatID) {
        this.dziekanatID = dziekanatID;
    }

    public String toString() {
        return this.getClass().getName() + ": " + imie + " " + nazwisko + " " + dziekanatID;
    }

}
