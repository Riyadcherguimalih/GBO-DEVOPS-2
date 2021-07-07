package ma.gbp.objectif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.Succursale;

@Repository
public interface SuccursaleRepository extends CrudRepository<Succursale, Integer> {
	public final static String FIND_SUCCURSALES_FROM_BPR = "Select succursale FROM Succursale succursale WHERE succursale.bpr.id = ?1 ";
	public final static String FIND_SUCCURSALE_BY_ID = "SELECT succursale FROM Succursale succursale WHERE succursale.id = ?1";
	public final static String FIND_ALL_SUCCURSALES = "SELECT succursales FROM Succursale succursales";
	
	@Query(FIND_SUCCURSALES_FROM_BPR)
	List<Succursale> findAllSuccursaleByBPR(Integer id);
	
	@Query(FIND_SUCCURSALE_BY_ID)
	Succursale findSuccursaleByID(Integer id);
	
	@Query(FIND_ALL_SUCCURSALES)
	List<Succursale> trouverToutesSuccursales();


}
