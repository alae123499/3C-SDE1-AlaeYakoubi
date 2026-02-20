package tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.entite.*;
import tn.esprit._3sdi1_.alae_yakoubi.devoirexam2.service.iTestService;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/server")
public class controller {
    @Autowired
    iTestService testService;

    @GetMapping("/hello")
    public String hello(){
        return "DevOps Projet";
    }

    @PostMapping("/add-utilisateur")
    public Utilisateur addUser(@RequestBody Utilisateur u) {
        return testService.ajouterUtilisateur(u);
    }

    @PostMapping("/add-produit-categorie")
    public Produit addProduitEtCategorie(@RequestBody Produit p) {
        return testService.ajouterProduitEtCategories(p);
    }

    @GetMapping("/affecter-produit-user")
    public void affecterProdAUser(@RequestParam List<String> nomProduit, @RequestParam String email) {
        testService.affecterProdAUser(nomProduit, email);
    }

    @GetMapping("/chercher-produit")
    public boolean chercherProduit(@RequestParam String nomProduit) {
        return testService.chercherProduit(nomProduit);
    }

    @GetMapping("/get-users-criteres/{nomCategorie}/{d}/{tu}")
    public List<Utilisateur> recupererUtilisateursParCriteres(@PathVariable("nomCategorie") String nomCategorie, @PathVariable("d") Date d
    ,@PathVariable Utilisateur.TypeUtilisateur tu) {
        return testService.recupererUtilisateursParCriteres(nomCategorie,d,tu);
    }

    @PostMapping("/desaffecter-categories-produit")
    public void desAffecterCatDeProd(@RequestParam List<String> nomCategories, @RequestParam String nomProduit) {
        testService.desAffecterCatDeProd(nomCategories, nomProduit);
    }
}