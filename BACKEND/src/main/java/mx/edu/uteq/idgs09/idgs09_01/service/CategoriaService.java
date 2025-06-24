package mx.edu.uteq.idgs09.idgs09_01.service;

import java.util.List;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;

public interface CategoriaService {
    List<Categoria> findAll();
}