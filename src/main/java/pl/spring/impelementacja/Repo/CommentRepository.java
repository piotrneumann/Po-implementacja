package pl.spring.impelementacja.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.spring.impelementacja.Model.Comment;
import pl.spring.impelementacja.Model.Course;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
