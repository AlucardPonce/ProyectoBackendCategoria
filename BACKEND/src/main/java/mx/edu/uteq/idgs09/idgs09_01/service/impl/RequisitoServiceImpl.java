package mx.edu.uteq.idgs09.idgs09_01.service.impl;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.Requisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.RequisitoRepository;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.TipoRequisitoRepository;
import mx.edu.uteq.idgs09.idgs09_01.service.RequisitoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitoServiceImpl implements RequisitoService {

    private final RequisitoRepository requisitoRepository;
    private final TipoRequisitoRepository tipoRequisitoRepository;

    public RequisitoServiceImpl(RequisitoRepository requisitoRepository, TipoRequisitoRepository tipoRequisitoRepository) {
        this.requisitoRepository = requisitoRepository;
        this.tipoRequisitoRepository = tipoRequisitoRepository;
    }

    @Override
    public List<Requisito> findByTipoRequisitoId(Integer tipoRequisitoId) {
        return requisitoRepository.findByTipoRequisitoId(tipoRequisitoId);
    }

    @Override
    public Optional<Requisito> findById(Integer id) {
        return requisitoRepository.findById(id);
    }

    @Override
    public Requisito save(Integer tipoRequisitoId, Requisito requisito) {
        Optional<TipoRequisito> tipo = tipoRequisitoRepository.findById(tipoRequisitoId);
        if (tipo.isPresent()) {
            requisito.setTipoRequisito(tipo.get());
            return requisitoRepository.save(requisito);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        requisitoRepository.deleteById(id);
    }
}