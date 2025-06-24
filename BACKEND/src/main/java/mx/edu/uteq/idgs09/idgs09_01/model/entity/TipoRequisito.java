package mx.edu.uteq.idgs09.idgs09_01.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoRequisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Requisito> requisitos;
}