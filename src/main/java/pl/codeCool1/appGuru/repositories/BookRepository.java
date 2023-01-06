package pl.codeCool1.appGuru.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.codeCool1.appGuru.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
