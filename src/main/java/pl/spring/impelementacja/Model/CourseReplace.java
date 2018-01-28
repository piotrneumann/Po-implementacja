package pl.spring.impelementacja.Model;

import javax.persistence.*;

@Entity
@Table(name = "kurs")
public class CourseReplace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int kursid;
    private String nazwaKursuPoprzedniego;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKursid() {
        return kursid;
    }

    public void setKursid(int kursid) {
        this.kursid = kursid;
    }

    public String getNazwaKursuPoprzedniego() {
        return nazwaKursuPoprzedniego;
    }

    public void setNazwaKursuPoprzedniego(String nazwaKursuPoprzedniego) {
        this.nazwaKursuPoprzedniego = nazwaKursuPoprzedniego;
    }

    @Override
    public String toString() {
        return "CourseReplace{" +
                "id=" + id +
                ", kursid=" + kursid +
                ", nazwaKursuPoprzedniego='" + nazwaKursuPoprzedniego + '\'' +
                '}';
    }
}
