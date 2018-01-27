package Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.spring.impelementacja.IndexController;
import pl.spring.impelementacja.MainCourseListController;
import pl.spring.impelementacja.NewCourseController;
import pl.spring.impelementacja.Repo.StudentRepository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class DBTest {
    @Autowired
    StudentRepository repoStudent;

//    @Test
//    public void usetTest() {
//        IndexController controller = new IndexController();
//        assertEquals("index",controller.login());
//    }

    @Test
    public void testIndex() throws Exception {
        IndexController controller = new IndexController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

    @Test
    public void testCourse() throws Exception {
        NewCourseController controller = new NewCourseController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(post("/przekaz_dalej")).andExpect(view().name("main_student"));
    }

    @Test
    public void testFieldCorrect1() {
        NewCourseController controller = new NewCourseController();
        assertFalse(controller.validCourse("","",true));
    }

    @Test
    public void testFieldCorrect2() {
        NewCourseController controller = new NewCourseController();
        assertFalse(controller.validCourse("","",true));
    }
    @Test
    public void testFieldCorrect3() {
        NewCourseController controller = new NewCourseController();
        assertTrue(controller.validCourse("asd","asd",true));
    }
    @Test
    public void testFieldCorrect4() {
        NewCourseController controller = new NewCourseController();
        assertTrue(controller.validCourse("asd","ads",false));
    }
    @Test
    public void testFieldCorrect5() {
        NewCourseController controller = new NewCourseController();
        assertFalse(controller.validCourse("","asd",true));
    }
    @Test
    public void listCourses() {
        MainCourseListController controller = new MainCourseListController();
        //assertEquals(controller.getList(),3);
    }
}