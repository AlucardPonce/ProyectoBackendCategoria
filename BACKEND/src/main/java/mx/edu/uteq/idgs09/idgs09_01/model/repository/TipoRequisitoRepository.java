package mx.edu.uteq.idgs09.idgs09_01.model.repository;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipoRequisitoRepository extends JpaRepository<TipoRequisito, Integer> {
    List<TipoRequisito> findByCategoriaId(Integer categoriaId);
}