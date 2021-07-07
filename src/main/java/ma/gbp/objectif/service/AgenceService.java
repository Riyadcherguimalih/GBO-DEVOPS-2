package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.model.Agence;
import ma.gbp.objectif.repository.AgenceRepository;

@Service
public class AgenceService {

	
	@Autowired
	private AgenceRepository agenceRepository;
	
	public AgenceService(AgenceRepository agenceRepository) {
		this.agenceRepository = agenceRepository;
	}
	
	public List<Agence> findAllAgenceBySuccursaleID(Integer id){
		return agenceRepository.findAllAgenceBySuccursale(id);
	}
	
	public Agence findAgenceById(Integer id) {
		return agenceRepository.findAgenceById(id);
	}
	
	public List<Agence> findAllAgences(){
		return agenceRepository.findAllAgences();
	}
	
	
}
