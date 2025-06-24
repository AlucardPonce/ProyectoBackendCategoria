package mx.edu.uteq.idgs09.idgs09_01.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TipoRequisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Requisito> requisitos;

    // getters y setters
}