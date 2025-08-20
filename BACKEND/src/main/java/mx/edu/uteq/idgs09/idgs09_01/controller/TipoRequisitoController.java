package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import mx.edu.uteq.idgs09.idgs09_01.service.TipoRequisitoService;
import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tipos-requisito")
@RequiredArgsConstructor
public class TipoRequisitoController {

    private final TipoRequisitoService tipoRequisitoService;
    private final RequisitoService requisitoService;

    // ✅ GET: Obtener todos los tipos de requisito
    @GetMapping
    public List<TipoRequisito> getAll() {
        return tipoRequisitoService.findAll();
    }

    // ✅ GET: Obtener tipo de requisito por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoRequisito> getById(@PathVariable Integer id) {
        Optional<TipoRequisito> tipoRequisito = tipoRequisitoService.findById(id);
        return tipoRequisito.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ POST: Crear nuevo tipo de requisito
    @PostMapping
    public TipoRequisito create(@RequestBody TipoRequisito tipoRequisito) {
        return tipoRequisitoService.save(tipoRequisito);
    }

    // ✅ PUT: Actualizar tipo de requisito
    @PutMapping("/{id}")
    public ResponseEntity<TipoRequisito> update(@PathVariable Integer id, @RequestBody TipoRequisito tipoRequisito) {
        TipoRequisito actualizado = tipoRequisitoService.update(id, tipoRequisito);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ DELETE: Eliminar tipo de requisito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<TipoRequisito> tipoRequisito = tipoRequisitoService.findById(id);
        if (tipoRequisito.isPresent()) {
            tipoRequisitoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ GET: Obtener tipos de requisito por categoría
    @GetMapping("/categoria/{categoriaId}")
    public List<TipoRequisito> getByCategoria(@PathVariable Integer categoriaId) {
        return tipoRequisitoService.findByCategoriaId(categoriaId);
    }

    // ✅ GET: Obtener requisitos de un tipo específico
    @GetMapping("/{tipoId}/requisitos")
    public List<Requisito> getRequisitosByTipo(@PathVariable Integer tipoId) {
        return requisitoService.findByTipoRequisitoId(tipoId);
    }

    // ✅ POST: Crear requisito dentro de un tipo específico
    @PostMapping("/{tipoId}/requisitos")
    public ResponseEntity<Requisito> addRequisito(@PathVariable Integer tipoId, @RequestBody Requisito requisito) {
        Requisito nuevoRequisito = requisitoService.save(tipoId, requisito);
        if (nuevoRequisito != null) {
            return ResponseEntity.ok(nuevoRequisito);
        }
        return ResponseEntity.badRequest().build();
    }
}