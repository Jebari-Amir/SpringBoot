package tn.esprit.telecom.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idetudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    @JoinColumn(name="dep_id")
    Departement departement;
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrats;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="etudiant_equipe",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private Set<Equipe>equipes;
    @OneToMany(mappedBy = "etudiant")
    private Set<Information> information;

    @OneToMany(mappedBy = "etudiant")
    private Set<Projet> projets;


}
