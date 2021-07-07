/**package ma.gbp.objectif.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Affectation;

@Repository
public interface AffectationRepository extends CrudRepository<Affectation, Integer> {
	public final static String GET_AFFECTATION_D_UTILISATEUR = "SELECT affectation FROM Affectation affectation WHERE utilisateur.affectation.id = ?1";
	public final static String AJOUTER_AFFECTATION_DE_BPR = "INSERT INTO Affectation (ID, AFFECTATION_BPR_ID) VALUES (:id, :affectationbpr)";
	public final static String AJOUTER_AFFECTATION_DE_SUCCURSALE = "INSERT INTO Affectation (ID, AFFECTATION_SUCCURSALE_ID) VALUES (:id, :affectationsuccursale)";
	public final static String AJOUTER_AFFECTATION_DE_L_AGENCE = "INSERT INTO Affectation (ID, AFFECTATION_AGENCE_ID) VALUES (:id, :affectationagence)";
	
	
	@Query(GET_AFFECTATION_D_UTILISATEUR)
	Affectation getAffectationUtilisateur(Integer user_id);
	
	@Query(value = AJOUTER_AFFECTATION_DE_BPR, nativeQuery = true)
	@Transactional
	@Modifying
	void ajouterAffectationBPR(@Param(value = "id") String id, @Param(value = "affectationbpr") String affectation);

}
**/
