package pl.spring.impelementacja.Model;

public class CourseList {

    int id;
    String nazwaKursu;
    int iloscOsob;
    String typ;
    String szczegoly;

    public CourseList() {
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "id=" + id +
                ", nazwaKursu='" + nazwaKursu + '\'' +
                ", iloscOsob=" + iloscOsob +
                ", typ='" + typ + '\'' +
                ", szczegoly='" + szczegoly + '\'' +
                '}';
    }

    public CourseList(int id, String nazwaKursu, int iloscOsob, String typ, String szczegoly) {
        this.id = id;
        this.nazwaKursu = nazwaKursu;
        this.iloscOsob = iloscOsob;
        this.typ = typ;
        this.szczegoly = szczegoly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNazwaKursu() {

        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public int getIloscOsob() {
        return iloscOsob;
    }

    public void setIloscOsob(int iloscOsob) {
        this.iloscOsob = iloscOsob;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getSzczegoly() {
        return szczegoly;
    }

    public void setSzczegoly(String szczegoly) {
        this.szczegoly = szczegoly;
    }
}
