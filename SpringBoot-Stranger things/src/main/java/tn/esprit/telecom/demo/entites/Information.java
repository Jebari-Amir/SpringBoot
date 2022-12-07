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
public class Information implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInf;
    private String photoperso;
    private String moyen;
    @ManyToOne
    @JoinColumn(name="idetudiant")
    @JsonIgnore
    Etudiant etudiant;


}
