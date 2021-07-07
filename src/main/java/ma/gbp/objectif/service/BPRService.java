package ma.gbp.objectif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.gbp.objectif.model.BPR;
import ma.gbp.objectif.repository.BPRRepository;
import org.springframework.stereotype.Service;

@Service
public class BPRService {

	@Autowired
	private BPRRepository bprRepository;
	
	public BPRService(BPRRepository bprRepository) {
		this.bprRepository = bprRepository;
	}
	
	public List<BPR> findAllBPR(){
		return bprRepository.findAllBPR();
	}
	
	public BPR findBPRByID(Integer id) {
		return bprRepository.findBPRByID(id);
	}
	
	public void deleteBPRParID(Integer id) {
		bprRepository.deleteBPR(id);
	}
	
	public void ajouterBPR(Integer id, Integer code_bpr, String libelle_bpr) {
		bprRepository.ajouterBPR(id, code_bpr, libelle_bpr);
	}
	
}
