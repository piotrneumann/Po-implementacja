package pl.spring.impelementacja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.impelementacja.Model.Course;
import pl.spring.impelementacja.Model.CourseList;
import pl.spring.impelementacja.Model.Group;
import pl.spring.impelementacja.Model.Student;
import pl.spring.impelementacja.Repo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainCourseListController {

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

    @RequestMapping("/main_course_list")
    public String getCourseList(Model model) {


        //System.out.println(Arrays.toString(kursy.toArray()));
        model.addAttribute("courses", getList());

        return "main_course_list";
    }

    public List<CourseList> getList() {
        List<CourseList> kursy = new ArrayList<CourseList>();
        for (Course course : repoCourse.findAll()) {
            for (Group group : repoGroup.findAll()) {
                if (course.getGrupa() == group.getId()) {
                    kursy.add(new CourseList(course.getId(), course.getNazwakursu(), group.getIloscStudentow(), course.getTypkursu(), "szczegoly"));
                }
            }
        }
        return kursy;
    }
}
