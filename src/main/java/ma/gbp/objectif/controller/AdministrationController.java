package ma.gbp.objectif.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import ma.gbp.objectif.model.Affectation;
import ma.gbp.objectif.model.Agence;
import ma.gbp.objectif.model.BPR;
import ma.gbp.objectif.model.Marche;
import ma.gbp.objectif.model.Produit;
import ma.gbp.objectif.model.Succursale;
import ma.gbp.objectif.model.Utilisateur;
//import ma.gbp.objectif.service.AffectationService;
import ma.gbp.objectif.service.AgenceService;
import ma.gbp.objectif.service.BPRService;
import ma.gbp.objectif.service.MarcheService;
import ma.gbp.objectif.service.ProduitService;
import ma.gbp.objectif.service.SuccursaleService;
import ma.gbp.objectif.service.UtilisateurService;

@Controller
@RequestMapping("/administration/")
public class AdministrationController {

	
	@Autowired 
	private UtilisateurService utilisateurService;
	
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
	
	//@Autowired
	//private AffectationService affectationService;
	
	@GetMapping("/users")
	public String voirToutLesUtilisateurs(Model model) {
		List<Utilisateur> allusers = utilisateurService.TrouverToutLesUtilisateurs();
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("allusers", allusers);
		return "administration/users";
	}
	@PostMapping("/users/add")
	public String addUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur, Model model) {
		System.out.println(utilisateur);
		utilisateurService.ajouterUnUtilisateur(utilisateur.getMatricule());
		
		//List<Utilisateur> allusers = utilisateurService.TrouverToutLesUtilisateurs();
		//model.addAttribute("allusers", allusers);
		return "redirect:/administration/users";
	}
	@GetMapping("/users/delete/{id_user}")
	public String supprimerUtilisateur(@PathVariable(value = "id_user")Integer id_user) {
		utilisateurService.supprimerUtilisateur(id_user);
		
		return "redirect:/administration/users";
	}
	
	//@DeleteMapping("/users/delete/{id_users}")
	//public String deleteUser(@)
	
	
	@GetMapping("/regionales")
	public String voirToutesLesRegionales(Model model) {
		List<BPR> allBPR = bprService.findAllBPR();
		
		model.addAttribute("regionale", new BPR());
		model.addAttribute("allBPR", allBPR);
				
				return "administration/bprs";
	}
	@PostMapping("/regionales/add")
	public String ajouterUneBPR(@ModelAttribute("regionale") BPR regionale, Model model) {
		bprService.ajouterBPR(regionale.getCode_bpr(), regionale.getCode_bpr(), regionale.getLibelle_bpr());
		return "redirect:/administration/regionales";
	}
	
	@GetMapping("/regionales/delete/{id_regionale}")
	public String supprimerRegionale(@PathVariable(value = "id_regionale")Integer id_bpr) {
		bprService.deleteBPRParID(id_bpr);
		
		return "redirect:/administration/regionales";
	}
	
	@GetMapping("/succursales")
	public String voirToutesLesSuccursales(Model model) {
		List<Succursale> allSuccursales = succursaleService.trouverToutesLesSuccursales();
		
		model.addAttribute("allSuccursales", allSuccursales);
		return "administration/succursales";
	}
	
	@GetMapping("/agences")
	public String voirToutesLesAgences(Model model) {
		List<Agence> allAgences = agenceService.findAllAgences();
		
		model.addAttribute("allAgences", allAgences);
		return "administration/agences";
	}
	
	@GetMapping("/marches")
	public String voirToutLesMarches(Model model) {
		List<Marche> allMarches = marcheService.TrouverToutLesMarches();
		model.addAttribute("marche", new Marche());
		model.addAttribute("allMarches", allMarches);
		return "administration/marches";
	}
	
	@PostMapping("/marches/add")
	public String addMarche(@ModelAttribute("marche") Marche marche) {
		//System.out.println(utilisateur);
		//utilisateurService.ajouterUnUtilisateur(utilisateur.getMatricule());
		marcheService.ajouterMarche(marche.getIntitule(), marche.getDescription());
		//List<Utilisateur> allusers = utilisateurService.TrouverToutLesUtilisateurs();
		//model.addAttribute("allusers", allusers);
		return "redirect:/administration/marches";
	}
	
	@GetMapping("/marches/delete/{id_marche}")
	public String supprimerMarcheDepuisId(@PathVariable(value = "id_marche") Integer id_marche) {
		
		marcheService.supprimerMarcheById(id_marche);
		return "redirect:/administration/marches";
	}
	
	@GetMapping("/produits")
	public String voirToutLesProduits(Model model) {
		List<Produit> allProduits = produitService.TrouverToutLesProduits();
		List<Marche> marches = marcheService.TrouverToutLesMarches();
		Produit nouveauProduit = new Produit();
		model.addAttribute("marches", marches);
		model.addAttribute("produit", nouveauProduit);
		model.addAttribute("allProduits", allProduits);
		return "administration/produits";
	}
	
	@PostMapping("/produits/add")
	public String addProduit(@ModelAttribute("produit") Produit produit) {
		//System.out.println(utilisateur);
		//utilisateurService.ajouterUnUtilisateur(utilisateur.getMatricule());
		//marcheService.ajouterMarche(marche.getIntitule(), marche.getDescription());
		produitService.ajouterProduitAuMarche(produit.getIntitule_produit(), produit.getDescription_produit(), produit.getMarche().getId().toString());
		//List<Utilisateur> allusers = utilisateurService.TrouverToutLesUtilisateurs();
		//model.addAttribute("allusers", allusers);
		return "redirect:/administration/marches/"+produit.getMarche().getId();
	}
	
	@GetMapping("/produits/delete/{id_produit}")
	public String supprimerProduitById(@PathVariable(value = "id_produit") Integer id_produit) {
		
		produitService.SupprimerProduitDepuisID(id_produit);
		
		return "redirect:/administration/produits";
	}
	
	@GetMapping("/marches/{id_marche}")
	public String voirLesProduitsLieAUnMarche(@PathVariable(value = "id_marche") Integer id_marche, Model model) {
		Marche marche = marcheService.findMarcheById(id_marche);
		Produit produit = new Produit();
		produit.setMarche(marche);
		//System.out.println("l'id du marché : "+produit.getMarche().getId());
		model.addAttribute("marche", marche);
		model.addAttribute("produit", produit);
		return "administration/produitslies";
	}
	@GetMapping("/marches/produits/delete/{id_produit}")
	public String supprimerProduitDepuisMarcheById(@PathVariable(value = "id_produit") Integer id_produit) {
		Produit produit = produitService.TrouverProduitFromID(id_produit);
		Integer idMarchePrecedent = produit.getMarche().getId();
		produitService.SupprimerProduitDepuisID(id_produit);
		
		return "redirect:/administration/marches/"+idMarchePrecedent;
	}
		//theese two may have a modification
	@GetMapping("/users/{user_id}/affectation")
	public String modifierAffectationUtilisateur(@PathVariable(value = "user_id") Integer user_id, Model model) {
		Utilisateur user = utilisateurService.getUtilisateur(user_id);
		List<BPR> bprs = bprService.findAllBPR();
		//Affectation affectation = new Affectation();
		//model.addAttribute("affectation", affectation);
		model.addAttribute("bprs", bprs);
		model.addAttribute("utilisateur", user);
		return "administration/affectation";
	}
	
	
	@PostMapping("/users/{id_user}/affectation/bpr/add")
	public String ajouterAffectationBPRUtilisateur(@PathVariable(value = "id_user") Integer id_user, @ModelAttribute("utilisateur") Utilisateur utilisateur	) {
		//Double id = Math.random()*10000;
		utilisateurService.ModifierAffectationBPRUtilisateur(utilisateur.getAffectation_bpr().getId().toString(), id_user.toString());
		//affectationService.ajouterAffectationBPR(String.valueOf(id.intValue()), affectation.getAffectation_bpr().getId().toString() );
		//utilisateurService.modifierAffectationUtilisateur(affectation,String.valueOf(id.intValue()));
		return "redirect:/administration/users/";
	}
}
