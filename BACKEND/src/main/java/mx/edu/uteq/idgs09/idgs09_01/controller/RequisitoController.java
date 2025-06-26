package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class RequisitoController {

    private final RequisitoService requisitoService;

    // Obtener todos los requisitos de un tipo
    @GetMapping("/requisitos/tipo/{tipoRequisitoId}")
    public List<Requisito> getByTipoRequisito(@PathVariable Integer tipoRequisitoId) {
        return requisitoService.findByTipoRequisitoId(tipoRequisitoId);
    }

    // Obtener un requisito por ID
    @GetMapping("/requisitos/{id}")
    public Requisito getById(@PathVariable Integer id) {
        return requisitoService.findById(id).orElse(null);
    }

    // Crear un requisito (requiere el id del tipo)
    @PostMapping("/requisitos/tipo/{tipoRequisitoId}")
    public Requisito create(@PathVariable Integer tipoRequisitoId, @RequestBody Requisito requisito) {
        return requisitoService.save(tipoRequisitoId, requisito);
    }

    // Eliminar un requisito
    @DeleteMapping("/requisitos/{id}")
    public void deleteRequisito(@PathVariable Integer id) {
        requisitoService.deleteById(id);
    }
}