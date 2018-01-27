package pl.spring.impelementacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.spring.impelementacja.Model.*;
import pl.spring.impelementacja.Repo.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class IndexController {

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

    @GetMapping("/")
    public String login(Model model) {
        System.out.println("INDEX - loginGet");
        return "index";
    }


    @PostMapping("/index")
    public String checkLogin(String login, String haslo, HttpServletRequest request, Model model) {


        System.out.println("INDEX - checkloginPost");
        System.out.println(login + " " + haslo);
        if (studentExist(login, haslo)) {
            request.getSession().setAttribute("user", getLoggedStudent(login,haslo));
            model.addAttribute("info", "");
            return "main_student";
        }

        if (asystenExist(login, haslo)) {
            return "main_asystent";
        }

        return "index";
    }

    boolean studentExist(String login, String haslo) {
        for (Student student : repoStudent.findAll()) {
            System.out.println(student.toString());
            if (student.getLogin().equals(login) && student.getHaslo().equals(haslo)) {
                return true;
            }
        }
        return false;
    }

    boolean asystenExist(String login, String haslo) {
        for (AsystentDziekanaDsDydaktyki asystent : repoAsystent.findAll()) {
            if (asystent.getLogin().equals(login) && asystent.getHaslo().equals(haslo)) {

                return true;
            }
        }
        return false;
    }
    public Student getLoggedStudent(String login, String haslo) {
        for (Student student : repoStudent.findAll()) {
            if (student.getLogin().equals(login) && student.getHaslo().equals(haslo)) {
                return student;
            }
        }
        return null;
    }
    public AsystentDziekanaDsDydaktyki getLoggedAssystent(String login, String haslo) {
        for (AsystentDziekanaDsDydaktyki asystent : repoAsystent.findAll()) {
            if (asystent.getLogin().equals(login) && asystent.getHaslo().equals(haslo)) {
                return asystent;
            }
        }
        return null;
    }

}
