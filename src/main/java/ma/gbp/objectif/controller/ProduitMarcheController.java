package ma.gbp.objectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.gbp.objectif.model.Agence;
import ma.gbp.objectif.model.BPR;
import ma.gbp.objectif.model.Marche;
import ma.gbp.objectif.model.Produit;
import ma.gbp.objectif.model.Succursale;
import ma.gbp.objectif.service.AgenceService;
import ma.gbp.objectif.service.BPRService;
import ma.gbp.objectif.service.MarcheService;
import ma.gbp.objectif.service.ProduitService;
import ma.gbp.objectif.service.SuccursaleService;

@Controller
public class ProduitMarcheController {

	@Autowired
	private BPRService bprService;
	
	@Autowired
	private SuccursaleService succursaleService;
	
	@Autowired
	private AgenceService agenceService;
	
	@Autowired
	private MarcheService marcheService;
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/bpr/{id_bpr}/marches")
	public String voirLesMarchesDeLaBPR(Model model, @PathVariable(value = "id_bpr") Integer id_bpr) {
		
		BPR bpr = bprService.findBPRByID(id_bpr);
		List<Marche> listeDesMarches = marcheService.TrouverToutLesMarches();
		//Marche market = marcheService.findMarcheById(10);
		//System.out.println(market);
		model.addAttribute("bpr", bpr);
		model.addAttribute("listeDesMarches", listeDesMarches);
		return "bpr/marches";
	}
	
	@GetMapping("/bpr/{id_bpr}/produits")
	public String voirLesProduitsDeLaBPR(Model model, @PathVariable(value = "id_bpr") Integer id_bpr) {
		BPR bpr = bprService.findBPRByID(id_bpr);
		List<Produit> listeDesProduits = produitService.TrouverToutLesProduits();
		
		model.addAttribute("bpr", bpr);
		model.addAttribute("listeDesProduits", listeDesProduits);
		return "bpr/produits";
	}
	
	
	@GetMapping("/bpr/{id_bpr}/marche/{id_marche}")
	public String voirLesProduitsDuMarcheBPR(Model model, @PathVariable(value = "id_bpr") Integer id_bpr, @PathVariable(value = "id_marche") Integer id_marche) {
		BPR bpr = bprService.findBPRByID(id_bpr);
		List<Produit> listeDesProduits = produitService.TrouverLesProduitsFromMarche(id_marche);
		
		model.addAttribute("bpr", bpr);
		model.addAttribute("listeDesProduits", listeDesProduits);
		return "bpr/produitslies";
	}
	
	@GetMapping("/succursale/{id_succursale}/marches")
	public String voirLesMarchesDeLaSuccursale(Model model, @PathVariable(value = "id_succursale") Integer id_succursale ) {
		Succursale succursale = succursaleService.findSuccursaleByID(id_succursale);
		List<Marche> listeDesMarches = marcheService.TrouverToutLesMarches();
		
		model.addAttribute("listeDesMarches", listeDesMarches);
		model.addAttribute("succursale", succursale);
		return "succursale/marches";
	}
	
	@GetMapping("/succursale/{id_succursale}/produits")
	public String voirToutLesProduitsDeSuccursale(@PathVariable(value = "id_succursale") Integer id_succursale, Model model) {
		Succursale succursale = succursaleService.findSuccursaleByID(id_succursale);
		List<Produit> listeDesProduits = produitService.TrouverToutLesProduits();
		
		model.addAttribute("succursale",succursale);
		model.addAttribute("listeDesProduits", listeDesProduits);
		return "succursale/produits";
	}
	
	@GetMapping("/succursale/{id_succursale}/marche/{id_marche}")
	public String voirLesProduitsDuMarcheSuccursale(Model model, @PathVariable(value = "id_succursale") Integer id_succursale, @PathVariable(value = "id_marche") Integer id_marche) {
		Succursale succursale = succursaleService.findSuccursaleByID(id_succursale);
		List<Produit> listeDesProduits = produitService.TrouverLesProduitsFromMarche(id_marche);
		
		model.addAttribute("listeDesProduits", listeDesProduits);
		model.addAttribute("succursale", succursale);
		
		return "succursale/produitslies";
	}
	
	
	
	@GetMapping("/agence/{id_agence}/marches")
	public String voirLesMarchesDeLAgence(Model model, @PathVariable(value = "id_agence") Integer id_agence) {
		Agence agence = agenceService.findAgenceById(id_agence);
		List<Marche> listeDesMarches = marcheService.TrouverToutLesMarches();
		
		model.addAttribute("agence", agence);
		model.addAttribute("listeDesMarches",listeDesMarches);
		return "agence/marches";
	}
	
	@GetMapping("/agence/{id_agence}/produits")
	public String voirToutLesProduitsDeLAgence(Model model, @PathVariable(value = "id_agence") Integer id_agence) {
		Agence agence = agenceService.findAgenceById(id_agence);
		List<Produit> listeDesProduits = produitService.TrouverToutLesProduits();
		
		model.addAttribute("listeDesProduits", listeDesProduits);
		model.addAttribute("agence", agence);
		return "agence/produits";
	}
	
	
	@GetMapping("/agence/{id_agence}/marche/{id_marche}")
	public String voirLesProduitsDuMarcheAgence(Model model, @PathVariable(value = "id_agence") Integer id_agence, @PathVariable(value = "id_marche") Integer id_marche) {
		Agence agence = agenceService.findAgenceById(id_agence);
		List<Produit> listeDesProduits = produitService.TrouverLesProduitsFromMarche(id_marche);
		
		model.addAttribute("listeDesProduits", listeDesProduits);
		model.addAttribute("agence", agence);
		
		return "agence/produitslies";
	}
	
	
	
		
	
}
	

