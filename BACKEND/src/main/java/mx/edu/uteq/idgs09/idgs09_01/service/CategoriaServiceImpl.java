package mx.edu.uteq.idgs09.idgs09_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import java.util.Optional;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.CategoriaRpository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRpository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> findById(int id) {
        return categoriaRepository.findById(id);
    }

    @Override
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

    @Override
    public void deleteById(int id) {
        categoriaRepository.deleteById(id);
    }
    
}