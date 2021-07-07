package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.model.Produit;
import ma.gbp.objectif.repository.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	public ProduitService(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}
	
	public List<Produit> TrouverLesProduitsFromMarche(Integer id){
		return produitRepository.findAllProduitFromMarche(id);
	}
	
	public Produit TrouverProduitFromID(Integer id) {
		return produitRepository.FindProduitFromID(id);
	}
	
	public List<Produit> TrouverToutLesProduits(){
		return produitRepository.findAllProduits();
	}
	
	public void SupprimerProduitDepuisID(Integer id) {
		produitRepository.SupprimerProduitById(id);
	}
	
	public void ajouterProduitAuMarche(String intitule, String description, String marche_id) {
		Double id = Math.random()*10000;
		produitRepository.AjouterProduitAuMarche(String.valueOf(id.intValue()), intitule, description, marche_id);
	}
	
	
}
