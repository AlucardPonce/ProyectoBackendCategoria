package mx.edu.uteq.idgs09.idgs09_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import mx.edu.uteq.idgs09.idgs09_01.model.entity.Categoria;
import mx.edu.uteq.idgs09.idgs09_01.model.repository.CategoriaRpository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRpository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}