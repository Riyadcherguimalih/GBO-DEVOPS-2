package ma.gbp.objectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.gbp.objectif.model.Agence;
import ma.gbp.objectif.model.BPR;
import ma.gbp.objectif.model.Objectif;
import ma.gbp.objectif.model.Produit;
import ma.gbp.objectif.model.Succursale;
import ma.gbp.objectif.service.AgenceService;
import ma.gbp.objectif.service.BPRService;
import ma.gbp.objectif.service.ObjectifService;
import ma.gbp.objectif.service.ProduitService;
import ma.gbp.objectif.service.SuccursaleService;

@Controller
public class ObjectifController {
	
	
	@Autowired
	private BPRService bprService;
	
	@Autowired
	private SuccursaleService succursaleService;
	
	@Autowired
	private AgenceService agenceService;
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private ObjectifService objectifService;
	
	@GetMapping("/bpr/{id_bpr}/produit/{id_produit}")
	public String voirLesObjectifsDuProduitBPR(Model model, @PathVariable(value = "id_bpr") Integer id_bpr, @PathVariable(value = "id_produit") Integer id_produit) {
		BPR bpr = bprService.findBPRByID(id_bpr);
		List<Objectif> listeObjectifs = objectifService.TrouverObjectifsBPRdepuisProduit(id_produit, id_bpr);
		
		Produit produit = produitService.TrouverProduitFromID(id_produit);
		System.out.println(objectifService.TrouverObjectifsBPRdepuisProduit(144, 1));
		model.addAttribute("produit",produit);
		model.addAttribute("bpr", bpr);
		model.addAttribute("listeObjectifs", listeObjectifs);
		
		return "bpr/objectif";
		
	}
	
	@GetMapping("/succursale/{id_succursale}/produit/{id_produit}")
	public String voirLesObjectifsDuProduitSuccursale(Model model, @PathVariable(value = "id_succursale") Integer id_succursale, @PathVariable(value = "id_produit") Integer id_produit) {
		Succursale succursale = succursaleService.findSuccursaleByID(id_succursale);
		List<Objectif> listeObjectifs = objectifService.TrouverObjectifsSuccursaleDepuisProduit(id_produit, id_succursale);
		Produit produit = produitService.TrouverProduitFromID(id_produit);
		
		model.addAttribute("produit", produit);
		model.addAttribute("listeObjectifs", listeObjectifs);
		model.addAttribute("succursale", succursale);
		
		
		return "succursale/objectif";
	}
	
	@GetMapping("/agence/{id_agence}/produit/{id_produit}")
	public String voirLesObjectifsDuProduitAgence(Model model, @PathVariable(value = "id_agence") Integer id_agence, @PathVariable(value = "id_produit") Integer id_produit) {
		Agence agence = agenceService.findAgenceById(id_agence);
		List<Objectif> listeObjectifs = objectifService.TrouverObjectifsAgenceDepuisProduit(id_produit, id_agence);
		Produit produit = produitService.TrouverProduitFromID(id_produit);
		
		model.addAttribute("produit", produit);
		model.addAttribute("listeObjectifs", listeObjectifs);
		model.addAttribute("agence", agence);
		
		return "agence/objectif";
	}
	
	
	
	
	
}
