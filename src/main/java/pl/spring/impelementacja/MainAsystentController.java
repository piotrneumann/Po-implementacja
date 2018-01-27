package pl.spring.impelementacja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.spring.impelementacja.Model.Course;
import pl.spring.impelementacja.Model.CourseList;
import pl.spring.impelementacja.Model.Group;
import pl.spring.impelementacja.Repo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainAsystentController {

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

    @RequestMapping ("/list_new_courses")
    public String listCoursese(Model model) {

        List<CourseList> kursy = new ArrayList<CourseList>();
        for (Course course : repoCourse.findAll()) {
            if(course.isOtwarty() == false && course.isOdrzucony() == false) {
                for (Group group : repoGroup.findAll()) {
                    if (course.getGrupa() == group.getId()) {
                        kursy.add(new CourseList(course.getId(), course.getNazwakursu(), group.getIloscStudentow(), course.getTypkursu(), "szczegoly"));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(kursy.toArray()));
        model.addAttribute("courses", kursy);
        return "list_new_courses";
    }

    @RequestMapping("/main_asystent")
    public String retAsys() {
        return "main_asystent";
    }
}
