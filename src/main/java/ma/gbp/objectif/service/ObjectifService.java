package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.gbp.objectif.model.Objectif;
import ma.gbp.objectif.repository.ObjectifRepository;
import org.springframework.stereotype.Service;

@Service
public class ObjectifService {
	
	@Autowired
	private ObjectifRepository objectifRepository;
	
	public ObjectifService(ObjectifRepository objectifRepository) {
		this.objectifRepository = objectifRepository;
	}
	
	public List<Objectif> TrouverObjectifsBPRdepuisProduit(Integer id_produit, Integer id_bpr){
		return objectifRepository.FindObjectifFromBPRAndProduitID(id_produit, id_bpr);
		
	}
	
	public List<Objectif> TrouverObjectifsSuccursaleDepuisProduit(Integer id_produit, Integer id_succursale){
		return objectifRepository.FindObjectifFromSuccursaleAndProduitID(id_produit, id_succursale);
	}
	
	public List<Objectif> TrouverObjectifsAgenceDepuisProduit(Integer id_produit, Integer id_agence){
		return objectifRepository.FindObjectifFromAgenceAndProduitID(id_produit, id_agence);
	}
	
	
	

}
