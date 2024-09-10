package dev.lucas.bleachapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zanpakutos")
public class Zanpakuto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    private String shikai;
    private String bankai;
    private String descricao;

}
