package one.padroesprojetospring.service;

import one.padroesprojetospring.model.Costumer;

public interface CostumerService {

    Iterable<Costumer> findAll();
    Costumer findById(Long id);
    void insert(Costumer costumer);
    void update(Long id, Costumer costumer);
    void delete(Long id);
}
