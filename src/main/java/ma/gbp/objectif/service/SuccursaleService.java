package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.gbp.objectif.model.Succursale;
import ma.gbp.objectif.repository.SuccursaleRepository;

@Service
public class SuccursaleService {

	
	@Autowired
	private SuccursaleRepository succursaleRepository;
	
	public SuccursaleService(SuccursaleRepository succursaleRepository) {
		this.succursaleRepository = succursaleRepository;
	}
	
	public List<Succursale> findAllSuccursaleByIdBPR(Integer id){
		return succursaleRepository.findAllSuccursaleByBPR(id);
	}
	
	public Succursale findSuccursaleByID(Integer id) {
		return succursaleRepository.findSuccursaleByID(id);
	}
	
	public List<Succursale> trouverToutesLesSuccursales(){
		return succursaleRepository.trouverToutesSuccursales();
	}
	
	
	
	
	
	
}
