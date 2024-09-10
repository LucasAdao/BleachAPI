package dev.lucas.bleachapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "shinigamis")
public class Shinigami {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private ShinigamiTier tier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zanpakuto_id", referencedColumnName = "id")
    private Zanpakuto zanpakuto;
}
