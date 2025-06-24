package mx.edu.uteq.idgs09.idgs09_01.service;

import mx.edu.uteq.idgs09.idgs09_01.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.TipoRequisitoRepository;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoRequisitoService {

    private final TipoRequisitoRepository tipoRequisitoRepository;
    private final CategoriaRepository categoriaRepository;

    public List<TipoRequisito> findAll() {
        return tipoRequisitoRepository.findAll();
    }

    public Optional<TipoRequisito> findById(Integer id) {
        return tipoRequisitoRepository.findById(id);
    }

    public TipoRequisito save(TipoRequisito tipoRequisito) {
        if (tipoRequisito.getCategoria() != null && tipoRequisito.getCategoria().getId() != null) {
            categoriaRepository.findById(tipoRequisito.getCategoria().getId())
                .ifPresent(tipoRequisito::setCategoria);
        }
        return tipoRequisitoRepository.save(tipoRequisito);
    }

    public void deleteById(Integer id) {
        tipoRequisitoRepository.deleteById(id);
    }

    public List<TipoRequisito> findByCategoriaId(Integer categoriaId) {
        return tipoRequisitoRepository.findByCategoriaId(categoriaId);
    }

    public TipoRequisito update(Integer id, TipoRequisito tipoRequisito) {
        return tipoRequisitoRepository.findById(id).map(existing -> {
            existing.setNombre(tipoRequisito.getNombre());
            if (tipoRequisito.getCategoria() != null && tipoRequisito.getCategoria().getId() != null) {
                categoriaRepository.findById(tipoRequisito.getCategoria().getId())
                    .ifPresent(existing::setCategoria);
            }
            return tipoRequisitoRepository.save(existing);
        }).orElse(null);
    }
}