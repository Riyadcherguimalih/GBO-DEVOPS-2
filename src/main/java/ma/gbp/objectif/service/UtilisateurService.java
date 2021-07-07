package ma.gbp.objectif.service;

//import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ma.gbp.objectif.model.Affectation;
import ma.gbp.objectif.model.Utilisateur;
import ma.gbp.objectif.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public List<Utilisateur> TrouverToutLesUtilisateurs(){
		return utilisateurRepository.FindAllUsers();
	}
	
	public void ajouterUnUtilisateur(String matricule) {
		Double id = Math.random()*10000;
		System.out.println("le nombre de l'id" + id);
		System.out.println("le nombre de l'id en int" + id.intValue());
		System.out.println(String.valueOf(id.intValue()));
		utilisateurRepository.AjouterUtilisateur(String.valueOf(id.intValue()), matricule);
	}
	
	public void supprimerUtilisateur(Integer id) {
		utilisateurRepository.supprimerUtilisateur(id);
	}
	
	public Utilisateur getUtilisateur(Integer id) {
		return utilisateurRepository.trouverUtilisateurById(id);
	}
	
	public void ModifierAffectationBPRUtilisateur(String bpr_id, String utilisateur_id) {
		utilisateurRepository.modifierAffectationBPRUtilisateur(bpr_id, utilisateur_id);
	}
	
	/**public void modifierAffectationUtilisateur(Affectation affectation, String id) {
		utilisateurRepository.modifierAffectationUtilisateur(affectation, id);
	}
	**/

}
