package ma.gbp.objectif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Objectif;

@Repository
public interface ObjectifRepository extends CrudRepository<Objectif, Integer> {
	public static final String TROUVER_OBJECTIFS_BPR_FROM_PRODUIT_ID = "SELECT objectifs FROM Objectif objectifs WHERE objectifs.produit.id = :idproduit AND objectifs.bpr_objectif.id = :idbpr ";
	public static final String TROUVER_OBJECTIFS_SUCCURSALE_FROM_PRODUIT_ID = "SELECT objectifs FROM Objectif objectifs WHERE objectifs.produit.id = :idproduit AND objectifs.succursale_objectif.id = :idsuccursale";
	public static final String TROUVER_OBJECTIFS_AGENCE_FROM_PRODUIT_ID = "SELECT objectifs FROM Objectif objectifs WHERE objectifs.produit.id = :idproduit AND objectifs.agence_objectif.id = :idagence";
	
	@Query(TROUVER_OBJECTIFS_BPR_FROM_PRODUIT_ID)
	List<Objectif> FindObjectifFromBPRAndProduitID(@Param("idproduit")Integer id_produit,@Param("idbpr") Integer id_bpr);
	
	@Query(TROUVER_OBJECTIFS_SUCCURSALE_FROM_PRODUIT_ID)
	List<Objectif> FindObjectifFromSuccursaleAndProduitID(@Param("idproduit") Integer id_produit ,@Param("idsuccursale") Integer id_succursale );

	@Query(TROUVER_OBJECTIFS_AGENCE_FROM_PRODUIT_ID)
	List<Objectif> FindObjectifFromAgenceAndProduitID(@Param("idproduit") Integer id_produit,@Param("idagence") Integer id_agence);
	
}
