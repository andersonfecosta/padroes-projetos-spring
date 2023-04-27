package one.padroesprojetospring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends CrudRepository<Costumer, Long> {
}
