package mx.edu.uteq.idgs09.idgs09_01.repository;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequisitoRepository extends JpaRepository<Requisito, Integer> {
    List<Requisito> findByTipoRequisitoId(Integer tipoRequisitoId);
}