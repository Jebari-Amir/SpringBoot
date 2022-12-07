package tn.esprit.telecom.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idp;
    private String nomPrj;
    private String discription;
    @ManyToOne
    @JoinColumn(name="idetudiant")
    @JsonIgnore
    Etudiant etudiant;

}
