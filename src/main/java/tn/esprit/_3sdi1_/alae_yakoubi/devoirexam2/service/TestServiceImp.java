package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite.*;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class TestServiceImp implements iTestService {
    CategorieRepo categorieRepoRepo;
    ProduitRepo produitRepo;
    UtilisateurRepo utilisateurRepo;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    @Transactional
    public Produit ajouterProduitEtCategories(Produit p) {
        return produitRepo.save(p);
    }

    @Override
    public void affecterProdAUser(List<String> nomProduit, String email) {
        Utilisateur user = utilisateurRepo.findByEmail(email);

        List<Produit> produits = produitRepo.findByNomProduitIn(nomProduit);
        for (Produit p : produits) {
            p.setUtilisateur(user);
        }

        produitRepo.saveAll(produits);
    }

    @Override
    public boolean chercherProduit(String nomProduit) {
        Produit produit = produitRepo.findByNomProduit(nomProduit);
        if (produit.getEtat() == Produit.Etat.BOYCOTT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, Date d, Utilisateur.TypeUtilisateur tu) {
        List<Utilisateur> users = utilisateurRepo.findByTypeUtilisateurAndDateInscriAfter(tu, d);
        List<Utilisateur> result = new ArrayList<>();
        for (Utilisateur u : users) {
            for (Produit p : u.getProduits()) {
                for (Categorie c : p.getCategorie()) {
                    if (c.getNomCategorie().equalsIgnoreCase(nomCategorie)) {
                        result.add(u);
                        break;
                    }
                }
                if (result.contains(u)) break;
            }
        }
        return result;
    }

    @Override
    @Scheduled(fixedRate = 40000)
    public void afficherEtMettreAJourProduits() {
        List<Produit> produits = produitRepo.findAll();
        for (Produit p : produits) {
            if (p.getUtilisateur() != null &&
                    p.getUtilisateur().getTypeUtilisateur() == Utilisateur.TypeUtilisateur.ADMIN) {
                p.setEtat(Produit.Etat.BOYCOTT);
            }
        }
        produitRepo.saveAll(produits);

        System.out.println("Produits mis à jour : " + produits);
    }

    @Override
    public void desAffecterCatDeProd(List<String> nomCategories, String nomProduit) {
        Produit produit = produitRepo.findByNomProduit(nomProduit);

        if (produit != null && produit.getCategorie() != null) {
            produit.getCategorie().removeIf(c -> nomCategories.contains(c.getNomCategorie()));
            produitRepo.save(produit);
        }
    }
}