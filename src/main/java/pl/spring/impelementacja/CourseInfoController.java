package pl.spring.impelementacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.impelementacja.Model.Comment;
import pl.spring.impelementacja.Model.Course;
import pl.spring.impelementacja.Model.Group;
import pl.spring.impelementacja.Model.Student;
import pl.spring.impelementacja.Repo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CourseInfoController {

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
    @Autowired
    CommentRepository repoComment;

    private int id;
    private String nazwaKursu;
    private String typKursu;
    private int iloscOsob;

    @PostMapping("/asystent_course_info")
    public String toCoursInfo(String kursid, Model model) {

        this.id = Integer.parseInt(kursid);
        Course course = repoCourse.findOne(new Integer(id));
        nazwaKursu = course.getNazwakursu();
        typKursu = course.getTypkursu();
        iloscOsob = 1;
        model.addAttribute("nazwaKursu", nazwaKursu);
        model.addAttribute("typKursu", typKursu);
        model.addAttribute("iloscOsob", iloscOsob);
        return "course_asystent";
    }

    @RequestMapping("/course_asystent")
    public String toCoursInfo1(Model model) {
        model.addAttribute("nazwaKursu", nazwaKursu);
        model.addAttribute("typKursu", typKursu);
        model.addAttribute("iloscOsob", iloscOsob);

        return "course_asystent";
    }

    @RequestMapping("/course_asystent_lista")
    public String toCourseList(Model model) {

        List<Student> listaS = new ArrayList<>();
        List<Group> grupy = new ArrayList<>();
        Course course = repoCourse.findOne(new Integer(id));

        for (Group group : repoGroup.findAll()) {
            if(group.getId() == course.getGrupa()) {
                grupy.add(group);
            }
        }

        for (Student student : repoStudent.findAll()) {
            for (Group group : grupy) {
                if(student.getGrupa() == group.getId()) {
                    listaS.add(student);
                }
            }
        }

        System.out.println(Arrays.toString(listaS.toArray()));
        model.addAttribute("students", listaS);
        return "course_asystent_lista";
    }

    @RequestMapping("/course_asystent_prowadzacy")
    public String toCourseProwadzacy() {

        return "course_asystent_prowadzacy";
    }

    @PostMapping(value = "/zgoda_na_kurs", params = "Zgoda")
    public String zgoda(Model model) {
        Course course = repoCourse.findOne(new Integer(id));
        course.setOtwarty(true);
        repoCourse.save(course);
        model.addAttribute("info", "Kurs zostal dodany");
        return "main_asystent";
    }

    @PostMapping(value = "/zgoda_na_kurs", params = "Brak zgody")
    public String nieZgoda(Model model) {

        model.addAttribute("info", "Kurs nie został dodany");
        return "reason";
    }


    @PostMapping(value = "/main_student_reason", params = "Brak zgody")
    public String reason(Model model, String reason) {
        System.out.println(reason);
        Comment comment = new Comment();
        comment.setTresc(reason);
        Course course = repoCourse.findOne(new Integer(id));
        course.setOdrzucony(true);
        comment.setKursid(course.getId());
        repoCourse.save(course);
        repoComment.save(comment);
        model.addAttribute("info", "Kurs nie został dodany");
        return "main_asystent";
    }

}

