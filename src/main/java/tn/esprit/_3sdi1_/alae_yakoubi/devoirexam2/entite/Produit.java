package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(of = {"nomProduit"})
@ToString(exclude = {"utilisateur", "categorie"})

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;
    private String nomProduit;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JsonBackReference
    Utilisateur utilisateur;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference("prod-categorie")
    private Set<Categorie> categorie;

    public enum Etat {
        VERIF_EN_COURS, BOYCOTT
    }
}