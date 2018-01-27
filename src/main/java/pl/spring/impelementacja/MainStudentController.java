package pl.spring.impelementacja;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.servlet.http.HttpServletRequest;

@Controller
public class MainStudentController {

//    @PostMapping
//    public String newCourse(HttpServletRequest request) {
//
//        System.out.println(makeUrl(request));
//        System.out.println("DEBUG");
//        return "newcourse";
//    }

    @PostMapping("/newCourse")
    public String goToNewCourse(Model model, HttpServletRequest request) {
        model.addAttribute("info", "");
        return "newCourse";
    }

    @PostMapping("/main_student")
    public String done(Model model, HttpServletRequest request) {
        model.addAttribute("info", "Kurs został dodany");
        return "main_student";
    }

    public static String makeUrl(HttpServletRequest request)
    {
        return request.getRequestURL().toString() + "?" + request.getQueryString();
    }
}
