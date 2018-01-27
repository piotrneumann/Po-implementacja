package pl.spring.impelementacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spring.impelementacja.Model.Course;
import pl.spring.impelementacja.Model.Group;
import pl.spring.impelementacja.Model.Student;
import pl.spring.impelementacja.Repo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Controller
public class NewCourseController {

    @Autowired
    StudentRepository repoStudent;
    @Autowired
    CourseRepository repoCourse;
    @Autowired
    GroupRepository repoGroup;
    @Autowired
    AsystentDziekanaRepository repoAsystent;
    @Autowired
    ProwadzacyRepository repoProwadzacy;


    //@Value("${welcome.message:test}")
    private int iloscOsob;
    private Course course;
    private Group group;
    private Student student;


    /**
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/course")
    public String course(Model model, HttpServletRequest request ) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("nazwaKursu", course.getNazwakursu());
        model.addAttribute("typKursu", course.getTypkursu());
        model.addAttribute("iloscOsob", iloscOsob);
        return "course";
    }


    /**
     * @param kurs_zamiennikowy
     * @param kurs
     * @param typ
     * @param zam
     * @param model
     * @param request
     * @return
     */
    @PostMapping("/course")
    public String coursPost(@RequestParam("kurs_zamiennikowy") String kurs_zamiennikowy,
                            @RequestParam("kurs") String kurs,
                            @RequestParam("typ") String typ,
                            @RequestParam(value = "zam", required = false) boolean zam,
                            Model model,
                            HttpServletRequest request) {

        student = (Student) request.getSession().getAttribute("user");
        if(validCourse(kurs,kurs_zamiennikowy, zam)) {
           for (Course course: repoCourse.findAll()) {
               if(course.getNazwakursu().equals(kurs) && course.getTypkursu().equals(typ)) {
                   model.addAttribute("error", "Podany kurs juz istnieje");
                   return "newCourse";
               }
           }

            iloscOsob = 1;
            course = new Course();
            course.setNazwakursu(kurs);
            course.setTypkursu(typ);
            course.setLiczbaects(15);
            course.setIloscgodzin(15);
            course.setOdrzucony(false);
            course.setOtwarty(false);
            course.setStudentid(student.getId());
            group = new Group();
            group.setIloscStudentow(iloscOsob);
            repoGroup.save(group);
            student.setGrupa(group.getId());
            course.setGrupa(group.getId());

            model.addAttribute("nazwaKursu", course.getNazwakursu());
            model.addAttribute("typKursu", course.getTypkursu());
            model.addAttribute("iloscOsob", iloscOsob);
            model.addAttribute("user", request.getSession().getAttribute("user"));
            return "course";
        }
        model.addAttribute("error", "Nalezy wypelnic wszystkie pola");
        return "newCourse";
    }

    @PostMapping("/przekaz")
    public String coursPost(HttpServletRequest request, Model model) {
        model.addAttribute("info", "Kurs został dodany");
        addToDB();
        return "main_student";
    }

    @PostMapping("/przekaz_dalej")
    public String kurspost() {
        return "main_student";
    }

    /**
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/course_lista")
    public String courseList(Model model, HttpServletRequest request) {
        List<Student> listaS = new ArrayList<>();
        listaS.add(student);
        System.out.println(Arrays.toString(listaS.toArray()));
        model.addAttribute("students", listaS);
        return "course_lista";
    }

    /**
     * @return
     */
    @RequestMapping("/course_prowadzacy")
    public String courseProwadzacy() {
        return "course_prowadzacy";
    }


    public boolean validCourse(String nazwaKursu,String kurs_zamiennikowy, boolean zam) {
        if(zam==true){
            if(nazwaKursu.equals("") || kurs_zamiennikowy.equals(""))return false;
        } else {
            if(nazwaKursu.equals("")) return false;
        }
        return true;
    }

    void addToDB() {
        repoGroup.save(group);
        repoStudent.save(student);
        repoCourse.save(course);
    }
}
