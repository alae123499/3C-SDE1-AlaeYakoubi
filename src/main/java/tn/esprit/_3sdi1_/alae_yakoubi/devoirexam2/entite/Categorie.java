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
@EqualsAndHashCode(of = {"nomCategorie"})
@ToString(exclude = {"produits"})

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;
    private String nomCategorie;

    @ManyToMany(mappedBy="categorie", cascade = CascadeType.ALL) // mappedBy so JsonBackReference
    @JsonBackReference("prod-categorie")
    private Set<Produit> produits;
}