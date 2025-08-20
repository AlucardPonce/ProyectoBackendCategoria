package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requisitos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class RequisitoController {

    private final RequisitoService requisitoService;

    // ✅ GET: Obtener todos los requisitos
    @GetMapping
    public List<Requisito> getAllRequisitos() {
        return requisitoService.findAll();
    }

    // ✅ GET: Obtener todos los requisitos de un tipo específico
    @GetMapping("/tipo/{tipoRequisitoId}")
    public List<Requisito> getByTipoRequisito(@PathVariable Integer tipoRequisitoId) {
        return requisitoService.findByTipoRequisitoId(tipoRequisitoId);
    }

    // ✅ GET: Obtener un requisito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Requisito> getById(@PathVariable Integer id) {
        Optional<Requisito> requisito = requisitoService.findById(id);
        return requisito.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ POST: Crear un requisito (requiere el id del tipo)
    @PostMapping("/tipo/{tipoRequisitoId}")
    public ResponseEntity<Requisito> create(@PathVariable Integer tipoRequisitoId, @RequestBody Requisito requisito) {
        Requisito nuevoRequisito = requisitoService.save(tipoRequisitoId, requisito);
        if (nuevoRequisito != null) {
            return ResponseEntity.ok(nuevoRequisito);
        }
        return ResponseEntity.badRequest().build();
    }

    // ✅ PUT: Actualizar un requisito existente
    @PutMapping("/{id}")
    public ResponseEntity<Requisito> update(@PathVariable Integer id, @RequestBody Requisito requisito) {
        Requisito requisitoActualizado = requisitoService.update(id, requisito);
        if (requisitoActualizado != null) {
            return ResponseEntity.ok(requisitoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ PUT: Actualizar un requisito y cambiar su tipo
    @PutMapping("/{id}/tipo/{tipoRequisitoId}")
    public ResponseEntity<Requisito> updateWithTipo(@PathVariable Integer id,
            @PathVariable Integer tipoRequisitoId,
            @RequestBody Requisito requisito) {
        Requisito requisitoActualizado = requisitoService.updateWithTipo(id, tipoRequisitoId, requisito);
        if (requisitoActualizado != null) {
            return ResponseEntity.ok(requisitoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ DELETE: Eliminar un requisito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequisito(@PathVariable Integer id) {
        Optional<Requisito> requisito = requisitoService.findById(id);
        if (requisito.isPresent()) {
            requisitoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}