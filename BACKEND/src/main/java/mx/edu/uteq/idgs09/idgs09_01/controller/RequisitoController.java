package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RequisitoController {

    private final RequisitoService requisitoService;

    @DeleteMapping("/requisitos/{id}")
    public void deleteRequisito(@PathVariable Integer id) {
        requisitoService.deleteById(id);
    }
}