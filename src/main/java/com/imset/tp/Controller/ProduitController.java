package com.imset.tp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imset.tp.entities.Produit;
import com.imset.tp.service.ProduitService;

@Controller 
public class ProduitController { 
	@Autowired 
	ProduitService produitService; 
	@RequestMapping("/ListeProduits") 
	public String listeProduits(ModelMap modelMap) 
	{ 
	List<Produit> prods = produitService.getAllProduits(); 
	modelMap.addAttribute("produits", prods); 
	return "listeProduits"; 
	} 
	@RequestMapping("/showCreate") 
	public String showCreate() 
	{ 
	return "createProduit"; 
	} 
}
