package test.springFramework.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.springFramework.SpringWebApp.domain.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
