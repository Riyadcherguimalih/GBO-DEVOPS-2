package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.model.Marche;
import ma.gbp.objectif.repository.MarcheRepository;

@Service
public class MarcheService {

	@Autowired
	private MarcheRepository marcheRepository;
	
	public MarcheService(MarcheRepository marcheRepository) {
		this.marcheRepository = marcheRepository;
	}
	
	public List<Marche> TrouverToutLesMarches(){
		return marcheRepository.findAllMarche();
	}
	
	public Marche findMarcheById(Integer id) {
		return marcheRepository.findMarcheById(id);
	}
	
	public void supprimerMarcheById(Integer id) {
		marcheRepository.supprimerMarcheDepuisID(id);
	}
	
	public void ajouterMarche(String intitule, String description) {
		Double id = Math.random()*10000;
		marcheRepository.ajouterMarche(String.valueOf(id.intValue()), intitule, description);
	}



}
