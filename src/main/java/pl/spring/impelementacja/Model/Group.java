package pl.spring.impelementacja.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grupa")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="ilosc_studentow")
    private int iloscStudentow;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", iloscStudentow=" + iloscStudentow +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIloscStudentow() {
        return iloscStudentow;
    }

    public void setIloscStudentow(int iloscStudentow) {
        this.iloscStudentow = iloscStudentow;
    }
}
