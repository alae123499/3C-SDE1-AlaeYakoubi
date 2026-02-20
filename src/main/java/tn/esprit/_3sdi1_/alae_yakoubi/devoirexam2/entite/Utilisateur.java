package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = {"email"})
@ToString(exclude = {"Produits"})

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    private String email;
    private Date dateInscri;
    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="utilisateur")
    @JsonManagedReference
    private Set<Produit> Produits;

    public enum TypeUtilisateur {
        VISITEUR, ADMIN, VOLONTAIRE
    }
}
