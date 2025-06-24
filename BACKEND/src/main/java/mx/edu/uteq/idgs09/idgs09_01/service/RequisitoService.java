package mx.edu.uteq.idgs09.idgs09_01.service;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import java.util.List;
import java.util.Optional;

public interface RequisitoService {
    List<Requisito> findByTipoRequisitoId(Integer tipoRequisitoId);
    Optional<Requisito> findById(Integer id);
    Requisito save(Integer tipoRequisitoId, Requisito requisito);
    void deleteById(Integer id);
}