package ma.gbp.objectif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Agence;

@Repository
public interface AgenceRepository extends CrudRepository<Agence, Integer> {
	public final static String FIND_AGENCES_FROM_SUCCURSALE = "SELECT agence FROM Agence agence WHERE agence.succursale.id = ?1";
	//public final static String FIND_ALL_AGENCE = "SELECT * FROM Agence agence";
	public final static String FIND_AGENCE_BY_ID = "SELECT agence FROM Agence agence WHERE agence.id = ?1 ";
	public final static String FIND_ALL_AGENCES = "SELECT agence FROM Agence agence";
	
	@Query(FIND_AGENCES_FROM_SUCCURSALE)
	List<Agence> findAllAgenceBySuccursale(Integer id);
	
	@Query(FIND_AGENCE_BY_ID)
	Agence findAgenceById(Integer id);
	
	@Query(FIND_ALL_AGENCES)
	List<Agence> findAllAgences();
	
	
	
}
