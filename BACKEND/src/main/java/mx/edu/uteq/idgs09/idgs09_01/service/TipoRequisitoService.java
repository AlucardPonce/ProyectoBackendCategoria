package mx.edu.uteq.idgs09.idgs09_01.service;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import java.util.List;
import java.util.Optional;

public interface TipoRequisitoService {
    List<TipoRequisito> findAll();

    Optional<TipoRequisito> findById(Integer id);

    TipoRequisito save(TipoRequisito tipoRequisito);

    void deleteById(Integer id);

    List<TipoRequisito> findByCategoriaId(Integer categoriaId);

    TipoRequisito update(Integer id, TipoRequisito tipoRequisito);
}