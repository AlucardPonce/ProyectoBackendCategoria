package mx.edu.uteq.idgs09.idgs09_01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import java.util.Optional;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.CategoriaRpository;

@Service
public class CategoriaServiceImpl {

    @Autowired
    private CategoriaRpository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> findById(int id) {
        return categoriaRepository.findById(id);
    }

    public Categoria update(int id, Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria existente = optionalCategoria.get();
            existente.setNombreCategoria(categoria.getNombreCategoria());
            existente.setCategoriaFederal(categoria.getCategoriaFederal());
            existente.setCategoriaEstatal(categoria.getCategoriaEstatal());
            return categoriaRepository.save(existente);
        } else {
            throw new RuntimeException("Categoría no encontrada");
        }
    }

    public void deleteById(int id) {
        categoriaRepository.deleteById(id);
    }
}