package pl.spring.impelementacja.Model;

import javax.persistence.*;

@Entity
@Table(name = "kurs")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="prowadzacyid")
    private int prowadzacy;
    private int studentid;
    @Column(name="grupaid")
    private int grupa;
    private String typkursu;
    private int iloscgodzin;
    private int liczbaects;
    private String nazwakursu;
    private boolean otwarty;
    private boolean odrzucony;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", prowadzacy=" + prowadzacy +
                ", studentid=" + studentid +
                ", grupa=" + grupa +
                ", typkursu='" + typkursu + '\'' +
                ", iloscgodzin=" + iloscgodzin +
                ", liczbaects=" + liczbaects +
                ", nazwakursu='" + nazwakursu + '\'' +
                ", otwarty=" + otwarty +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(int prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public String getTypkursu() {
        return typkursu;
    }

    public void setTypkursu(String typkursu) {
        this.typkursu = typkursu;
    }

    public int getIloscgodzin() {
        return iloscgodzin;
    }

    public void setIloscgodzin(int iloscgodzin) {
        this.iloscgodzin = iloscgodzin;
    }

    public int getLiczbaects() {
        return liczbaects;
    }

    public void setLiczbaects(int liczbaects) {
        this.liczbaects = liczbaects;
    }

    public String getNazwakursu() {
        return nazwakursu;
    }

    public void setNazwakursu(String nazwakursu) {
        this.nazwakursu = nazwakursu;
    }

    public boolean isOtwarty() {
        return otwarty;
    }

    public void setOtwarty(boolean otwarty) {
        this.otwarty = otwarty;
    }

    public boolean isOdrzucony() {
        return odrzucony;
    }

    public void setOdrzucony(boolean odrzucony) {
        this.odrzucony = odrzucony;
    }
}