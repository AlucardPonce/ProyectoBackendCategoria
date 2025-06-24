package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import mx.edu.uteq.idgs09.idgs09_01.service.TipoRequisitoService;
import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipos-requisito")
public class TipoRequisitoController {

    private final TipoRequisitoService tipoRequisitoService;
    private final RequisitoService requisitoService;

    public TipoRequisitoController(TipoRequisitoService tipoRequisitoService, RequisitoService requisitoService) {
        this.tipoRequisitoService = tipoRequisitoService;
        this.requisitoService = requisitoService;
    }

    @GetMapping
    public List<TipoRequisito> getAll() {
        return tipoRequisitoService.findAll();
    }

    @GetMapping("/{id}")
    public TipoRequisito getById(@PathVariable Integer id) {
        return tipoRequisitoService.findById(id).orElse(null);
    }

    @PostMapping
    public TipoRequisito create(@RequestBody TipoRequisito tipoRequisito) {
        return tipoRequisitoService.save(tipoRequisito);
    }

    @PutMapping("/{id}")
    public TipoRequisito update(@PathVariable Integer id, @RequestBody TipoRequisito tipoRequisito) {
        return tipoRequisitoService.update(id, tipoRequisito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tipoRequisitoService.deleteById(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<TipoRequisito> getByCategoria(@PathVariable Integer categoriaId) {
        return tipoRequisitoService.findByCategoriaId(categoriaId);
    }

    @GetMapping("/{tipoId}/requisitos")
    public List<Requisito> getRequisitosByTipo(@PathVariable Integer tipoId) {
        return requisitoService.findByTipoRequisitoId(tipoId);
    }

    @PostMapping("/{tipoId}/requisitos")
    public Requisito addRequisito(@PathVariable Integer tipoId, @RequestBody Requisito requisito) {
        return requisitoService.save(tipoId, requisito);
    }
}