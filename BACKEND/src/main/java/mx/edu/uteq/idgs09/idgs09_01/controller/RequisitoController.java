package mx.edu.uteq.idgs09.idgs09_01.controller;

import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequisitoController {

    private final RequisitoService requisitoService;

    public RequisitoController(RequisitoService requisitoService) {
        this.requisitoService = requisitoService;
    }

    @DeleteMapping("/requisitos/{id}")
    public void deleteRequisito(@PathVariable Integer id) {
        requisitoService.deleteById(id);
    }
}