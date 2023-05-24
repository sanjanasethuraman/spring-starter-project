package test.springFramework.SpringWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.springFramework.SpringWebApp.domain.Author;
import test.springFramework.SpringWebApp.domain.Book;
import test.springFramework.SpringWebApp.domain.Publisher;
import test.springFramework.SpringWebApp.repositories.AuthorRepository;
import test.springFramework.SpringWebApp.repositories.BookRepository;
import test.springFramework.SpringWebApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "14334324");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Publisher penguin = new Publisher("Penguin publisher", "123", "mum", "mh", "400071");
        publisherRepository.save(penguin);

        ddd.setPublisher(penguin);
        penguin.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3483713");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(penguin);
        penguin.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println(penguin.toString());
    }
}
