package mx.edu.uteq.idgs09.idgs09_01.dto;

import lombok.*;

@Data
public class CategoriasDTO {
    private int id;
    private String nombreCategoria;
    private String categoriaAnterior;
    private String categoriaFederal;
    private String categoriaEstatal;
    
}
