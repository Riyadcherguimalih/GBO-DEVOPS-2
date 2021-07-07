package ma.gbp.objectif.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
	
	public static final String TROUVER_PRODUITS_DEPUIS_MARCHE_ID = "SELECT produits FROM Produit produits WHERE produits.marche.id = ?1 ";
	public static final String TROUVER_PRODUIT_DEPUIS_SON_ID = "SELECT produit FROM Produit produit WHERE produit.id = ?1";
	public static final String TROUVER_TOUT_LES_PRODUITS = "SELECT produits FROM Produit produits";
	public static final String SUPPRIMER_PRODUIT_BY_ID = "DELETE FROM Produit produit WHERE produit.id = ?1";
	public static final String ADD_PRODUIT_AU_MARCHE = "INSERT INTO Produit (ID, INTITULE_PRODUIT, DESCRIPTION_PRODUIT, MARCHE_ID) VALUES (:id, :intitule, :description, :marche)";
	
	@Query(TROUVER_PRODUITS_DEPUIS_MARCHE_ID)
	List<Produit> findAllProduitFromMarche(Integer id);
	
	@Query(TROUVER_PRODUIT_DEPUIS_SON_ID)
	Produit FindProduitFromID(Integer id);
	
	@Query(TROUVER_TOUT_LES_PRODUITS)
	List<Produit> findAllProduits();
	
	@Transactional
	@Modifying
	@Query(value = SUPPRIMER_PRODUIT_BY_ID, nativeQuery = true)
	void SupprimerProduitById(Integer id);
	
	@Transactional
	@Modifying
	@Query(value = ADD_PRODUIT_AU_MARCHE, nativeQuery = true)
	void AjouterProduitAuMarche(@Param(value = "id" ) String id, @Param(value = "intitule") String intitule, @Param(value = "description") String description, @Param(value = "marche") String marche_id);
	
}
