package one.padroesprojetospring.service.impl;

import one.padroesprojetospring.model.Costumer;
import one.padroesprojetospring.model.CostumerRepository;
import one.padroesprojetospring.model.Endereco;
import one.padroesprojetospring.model.EnderecoRepository;
import one.padroesprojetospring.service.CostumerService;
import one.padroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Costumer> findAll() {
        return costumerRepository.findAll();
    }

    @Override
    public Costumer findById(Long id) {
        Optional<Costumer> costumer = costumerRepository.findById(id);
        return costumer.get();
    }

    @Override
    public void insert(Costumer costumer) {
        saveCep(costumer);
    }

    @Override
    public void update(Long id, Costumer costumer) {
        Optional<Costumer> costumerUpdate = costumerRepository.findById(id);
        if (costumerUpdate.isPresent()) {
            saveCep(costumer);
        }
    }

    @Override
    public void delete(Long id) {
        costumerRepository.deleteById(id);
    }

    private void saveCep(Costumer costumer) {
        String cep = costumer.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
           Endereco newAdress = viaCepService.consultCep(cep);
           enderecoRepository.save(newAdress);
           return newAdress;
        });
        costumer.setEndereco(endereco);
        costumerRepository.save(costumer);
    }
}
