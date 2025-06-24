package mx.edu.uteq.idgs09.idgs09_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import mx.edu.uteq.idgs09.idgs09_01.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return service.findAll();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return service.save(categoria);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable int id, @RequestBody Categoria categoria) {
        return service.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}