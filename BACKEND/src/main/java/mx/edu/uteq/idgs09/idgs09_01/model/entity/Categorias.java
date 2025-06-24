package mx.edu.uteq.idgs09.idgs09_01.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
    private String nombreCategoria;
    private String categoriaAnterior;
    private String categoriaFederal;
    private String categoriaEstatal;
}
    
