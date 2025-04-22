package com.imset.tp;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.imset.tp.entities.Produit;
import com.imset.tp.repos.ProduitRepository;

@SpringBootTest
class TpApplicationTests {
//L'annotation @Autowired permet d'injecter automatiquement une instance de 
	//ProduitRepository dans la classe de test. Le ProduitRepository est un repository Spring Data JPA
	//qui permet d'effectuer des opérations CRUD (création, lecture, mise à jour, suppression) sur des entités Produit.
    // Injection du produitRepository par Spring, ce qui permet d'interagir avec la base de données.
    @Autowired
    private ProduitRepository produitRepository;

    // Test de la création d'un produit dans la base de données
    @Test
    void testCreateProduit() {
        // Création d'un objet Produit avec un nom, un prix et une date
        Produit prod = new Produit("PC Dell", 2200.500, new Date());
        
        // Sauvegarde du produit dans la base de données
        produitRepository.save(prod);
    }

    // Test de la recherche d'un produit par son ID
    @Test 
    public void testFindProduit() { 
        // Recherche du produit avec l'ID 1L dans la base de données
        Produit p = produitRepository.findById(1L).get(); 
        
        // Affichage des informations du produit trouvé
        System.out.println(p); 
    } 

    // Test de la mise à jour d'un produit existant
    @Test 
    public void testUpdateProduit() { 
        // Recherche du produit avec l'ID 1L dans la base de données
        Produit p = produitRepository.findById(1L).get(); 
        
        // Mise à jour du prix du produit à 1000.0
        p.setPrixProduit(1000.0); 
        
        // Sauvegarde des modifications dans la base de données
        produitRepository.save(p); 
    } 

    // Test de la suppression d'un produit par son ID
    public void testDeleteProduit() { 
        // Suppression du produit avec l'ID 1L de la base de données
        produitRepository.deleteById(1L);
    } 
}
