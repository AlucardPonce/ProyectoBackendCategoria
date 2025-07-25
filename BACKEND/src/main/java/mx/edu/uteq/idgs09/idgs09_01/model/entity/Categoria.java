package mx.edu.uteq.idgs09.idgs09_01.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // <-- Cambia de int a Integer
    private String nombreCategoria;
    private String categoriaFederal;
    private String categoriaEstatal;
}