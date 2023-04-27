package one.padroesprojetospring.controller;

import one.padroesprojetospring.model.Costumer;
import one.padroesprojetospring.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("costumers")
public class CostumerRestController {

    @Autowired
    private CostumerService costumerService;
    @GetMapping
    public ResponseEntity<Iterable<Costumer>> findAll() {
        return ResponseEntity.ok(costumerService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(costumerService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Costumer> insert(@RequestBody Costumer costumer) {
        costumerService.insert(costumer);
        return ResponseEntity.ok(costumer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Costumer> update(@PathVariable Long id,@RequestBody Costumer costumer) {
        costumerService.update(id, costumer);
        return ResponseEntity.ok(costumer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costumerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
