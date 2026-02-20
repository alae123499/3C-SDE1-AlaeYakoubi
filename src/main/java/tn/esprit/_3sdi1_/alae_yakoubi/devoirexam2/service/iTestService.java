package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.service;

import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite.*;

import java.util.Date;
import java.util.List;

public interface iTestService {
    public Utilisateur ajouterUtilisateur(Utilisateur u);
    public Produit ajouterProduitEtCategories (Produit p);
    public void affecterProdAUser(List<String> nomProduit, String email);
    public boolean chercherProduit(String nomProduit);
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, Date d, Utilisateur.TypeUtilisateur typeUtilisateur);
    public void afficherEtMettreAJourProduits();
    public void desAffecterCatDeProd(List<String> nomCategories, String nomProduit);
}