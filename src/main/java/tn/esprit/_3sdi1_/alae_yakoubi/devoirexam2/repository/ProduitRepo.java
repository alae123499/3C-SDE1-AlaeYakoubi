package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite.Produit;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit, Integer> {
    List<Produit> findByNomProduitIn(List<String> noms);
    Produit findByNomProduit(String nomProduit);
}