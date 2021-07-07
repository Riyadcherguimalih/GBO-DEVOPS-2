package ma.gbp.objectif.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Marche;

@Repository
public interface MarcheRepository extends CrudRepository<Marche, Integer> {
	
	//public final static String FIND_ALL_MARCHE = "SELECT marche FROM Marche marche";
	public final static String FIND_ALL_MARCHE = "SELECT New Marche(marche.id, marche.intitule, marche.description) FROM Marche marche ";
	public final static String FIND_MARCHE_BY_ID = "SELECT marche FROM Marche marche WHERE marche.id = ?1";
	public final static String SUPPRIMER_MARCHE_BY_ID = "DELETE FROM Marche marche WHERE marche.id = ?1 CASCADE CONSTRAINTS";
	public final static String ADD_MARCHE = "INSERT INTO Marche (ID, INTITULE_MARCHE, DESCRIPTION_MARCHE) VALUES (:id, :intitule, :description)";
	
	@Query(FIND_ALL_MARCHE)
	List<Marche> findAllMarche();
	
	@Query(FIND_MARCHE_BY_ID)
	Marche  findMarcheById(Integer id);
	
	@Query(value = SUPPRIMER_MARCHE_BY_ID, nativeQuery = true)
	@Transactional
	@Modifying
	void supprimerMarcheDepuisID(Integer id);
	
	@Transactional
	@Modifying
	@Query(value = ADD_MARCHE, nativeQuery = true)
	void ajouterMarche(@Param(value = "id") String id, @Param(value = "intitule") String intitule, @Param(value = "description") String description);
	
}
