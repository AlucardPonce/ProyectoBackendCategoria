package mx.edu.uteq.idgs09.idgs09_01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;

public interface CategoriaRpository extends JpaRepository<Categoria, Integer> {
    
}
