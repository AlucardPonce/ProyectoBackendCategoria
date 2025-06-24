package mx.edu.uteq.idgs09.idgs09_01.service;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.RequisitoRepository;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.TipoRequisitoRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisitoService {

    private final RequisitoRepository requisitoRepository;
    private final TipoRequisitoRepository tipoRequisitoRepository;

    public List<Requisito> findByTipoRequisitoId(Integer tipoRequisitoId) {
        return requisitoRepository.findByTipoRequisitoId(tipoRequisitoId);
    }

    public Optional<Requisito> findById(Integer id) {
        return requisitoRepository.findById(id);
    }

    public Requisito save(Integer tipoRequisitoId, Requisito requisito) {
        return tipoRequisitoRepository.findById(tipoRequisitoId).map(tipo -> {
            requisito.setTipoRequisito(tipo);
            return requisitoRepository.save(requisito);
        }).orElse(null);
    }

    public void deleteById(Integer id) {
        requisitoRepository.deleteById(id);
    }
}