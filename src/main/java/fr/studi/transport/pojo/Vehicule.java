package fr.studi.transport.pojo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "immatriculation")
)
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculeId;

    private String marque;
    private String modele;
    private Integer annee;
    @Column(unique=true, nullable=false)
    @
    private String immatriculation;

}
