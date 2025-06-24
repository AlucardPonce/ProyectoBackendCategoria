package mx.edu.uteq.idgs09.idgs09_01.service.impl;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.TipoRequisitoRepository;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.CategoriaRpository;
import mx.edu.uteq.idgs09.idgs09_01.service.TipoRequisitoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoRequisitoServiceImpl implements TipoRequisitoService {

    private final TipoRequisitoRepository tipoRequisitoRepository;
    private final CategoriaRpository categoriaRepository;

    public TipoRequisitoServiceImpl(TipoRequisitoRepository tipoRequisitoRepository, CategoriaRpository categoriaRepository) {
        this.tipoRequisitoRepository = tipoRequisitoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<TipoRequisito> findAll() {
        return tipoRequisitoRepository.findAll();
    }

    @Override
    public Optional<TipoRequisito> findById(Integer id) {
        return tipoRequisitoRepository.findById(id);
    }

    @Override
    public TipoRequisito save(TipoRequisito tipoRequisito) {
        // Si viene con categoria.id, buscar la entidad y asociarla
        if (tipoRequisito.getCategoria() != null && tipoRequisito.getCategoria().getId() != null) {
            Optional<Categoria> categoria = categoriaRepository.findById(tipoRequisito.getCategoria().getId());
            categoria.ifPresent(tipoRequisito::setCategoria);
        }
        return tipoRequisitoRepository.save(tipoRequisito);
    }

    @Override
    public void deleteById(Integer id) {
        tipoRequisitoRepository.deleteById(id);
    }

    @Override
    public List<TipoRequisito> findByCategoriaId(Integer categoriaId) {
        return tipoRequisitoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public TipoRequisito update(Integer id, TipoRequisito tipoRequisito) {
        return tipoRequisitoRepository.findById(id).map(existing -> {
            existing.setNombre(tipoRequisito.getNombre());
            if (tipoRequisito.getCategoria() != null && tipoRequisito.getCategoria().getId() != null) {
                Optional<Categoria> categoria = categoriaRepository.findById(tipoRequisito.getCategoria().getId());
                categoria.ifPresent(existing::setCategoria);
            }
            return tipoRequisitoRepository.save(existing);
        }).orElse(null);
    }
}