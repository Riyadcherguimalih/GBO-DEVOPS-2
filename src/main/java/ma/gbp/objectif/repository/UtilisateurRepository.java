package ma.gbp.objectif.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import ma.gbp.objectif.model.Affectation;
import ma.gbp.objectif.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{
	public static final String TROUVER_TOUT_LES_UTILISATEURS = "SELECT utilisateurs FROM Utilisateur utilisateurs";
	public static final String ADD_UTILISATEUR = "INSERT INTO Utilisateur (ID, MATRICULE) VALUES (:id, :matricule) ";
	public static final String SUPPRIMER_UTILISATEUR = "DELETE FROM Utilisateur utilisateur WHERE utilisateur.id = ?1";
	public static final String FIND_UTILISATEUR_BY_ID = "SELECT utilisateur FROM Utilisateur utilisateur WHERE utilisateur.id = ?1";
	
	public static final String MODIFIER_AFFECTATION_BPR_UTILISATEUR = "UPDATE Utilisateur utilisateur SET utilisateur.affectation_bpr_id = :bpr, utilisateur.affectation_succursale_id = null, utilisateur.affectation_agence_id = null WHERE utilisateur.id = :id ";
	public static final String MODIFIER_AFFECTATION_SUCCURSALE_UTILISATEUR = "UPDATE Utilisateur utilisateur SET utilisateur.affectation_succursale_id = :succursale, utilisateur.affectation_bpr_id = null, utilisateur.affectation_agence = null WHERE utilisateur.id = :id";
	public static final String MODIFIER_AFFECTATION_AGENCE_UTILISATEUR = "UPDATE Utilisateur utilisateur SET utilisateur.affectation_agence_id = :agence, utilisateur.affectation_succursale_id = null, utilisateur.affectation_bpr_id = null WHERE utilisateur.id = :id";
	
	
	@Query(TROUVER_TOUT_LES_UTILISATEURS)
	List<Utilisateur> FindAllUsers();
	
	@Modifying
	@Transactional
	@Query(value = ADD_UTILISATEUR, nativeQuery = true)
	void AjouterUtilisateur(@Param(value = "id") String id, @Param(value = "matricule") String matricule);
	
	
	@Query(value = SUPPRIMER_UTILISATEUR)
	@Transactional
	@Modifying
	void supprimerUtilisateur(Integer id_user);
	
	
	@Query(FIND_UTILISATEUR_BY_ID)
	Utilisateur trouverUtilisateurById(Integer id);
	
	@Query(value = MODIFIER_AFFECTATION_BPR_UTILISATEUR, nativeQuery = true)
	@Modifying
	@Transactional
	void modifierAffectationBPRUtilisateur(@Param(value = "bpr") String bpr_id, @Param(value = "id") String utilisateur_id);
	
	
}
