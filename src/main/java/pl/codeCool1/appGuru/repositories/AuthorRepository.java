package pl.codeCool1.appGuru.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.codeCool1.appGuru.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
