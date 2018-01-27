package pl.spring.impelementacja.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.spring.impelementacja.Model.Prowadzacy;
import pl.spring.impelementacja.Model.Student;

public interface ProwadzacyRepository extends CrudRepository<Prowadzacy, Long> {
}
