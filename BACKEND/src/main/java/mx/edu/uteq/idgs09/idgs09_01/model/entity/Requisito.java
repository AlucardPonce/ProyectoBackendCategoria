package mx.edu.uteq.idgs09.idgs09_01.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_requisito_id")
    private TipoRequisito tipoRequisito;
}