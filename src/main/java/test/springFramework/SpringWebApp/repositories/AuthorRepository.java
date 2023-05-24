package test.springFramework.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.springFramework.SpringWebApp.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
