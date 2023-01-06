package pl.codeCool1.appGuru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.codeCool1.appGuru.domain.Author;
import pl.codeCool1.appGuru.domain.Book;
import pl.codeCool1.appGuru.domain.Publisher;
import pl.codeCool1.appGuru.repositories.AuthorRepository;
import pl.codeCool1.appGuru.repositories.BookRepository;
import pl.codeCool1.appGuru.repositories.PublisherRepository;

import java.sql.SQLOutput;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric1 = new Author ("Eric", "Evans");
        Book ddd = new Book("Domain Driven Desing", "123123");
        eric1.getBooks().add(ddd);
        ddd.getAuthors().add(eric1);

        authorRepository.save(eric1);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book ("J2ee Development without EJB", "999999");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher agora = new Publisher("Agora", "Chmielna 116, Warszawa, 00-801");
        publisherRepository.save(agora);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers; " + publisherRepository.count());
    }
}
