package test.springFramework.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.springFramework.SpringWebApp.domain.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
