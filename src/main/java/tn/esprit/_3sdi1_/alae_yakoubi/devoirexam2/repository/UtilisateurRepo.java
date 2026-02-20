package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite.Utilisateur;

import java.util.Date;
import java.util.List;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByTypeUtilisateurAndDateInscriAfter(Utilisateur.TypeUtilisateur typeUtilisateur, Date dateInscri);
}