package mx.edu.uteq.idgs09.idgs09_01.service;

import java.util.List;
import java.util.Optional;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    List<Categoria> findAll();
    Optional<Categoria> findById(int id);
    Categoria update(int id, Categoria categoria);
    void deleteById(int id);
}