package pl.spring.impelementacja.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.spring.impelementacja.Model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
