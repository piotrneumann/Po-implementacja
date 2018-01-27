package pl.spring.impelementacja.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.spring.impelementacja.Model.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {


    @Query("SELECT s FROM Student s where login=:categoryName")
    public List<Student> findByCategory(String categoryName);
}
