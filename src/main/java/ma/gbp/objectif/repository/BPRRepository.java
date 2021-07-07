package ma.gbp.objectif.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.gbp.objectif.model.BPR;

@Repository
public interface BPRRepository extends CrudRepository<BPR, Integer> {
	//public final static String FIND_ALL_BPR = "SELECT New BPR(bpr.id, bpr.code_bpr, bpr.libelle_bpr) FROM BPR bpr ";
	public final static String FIND_ALL_BPR = "SELECT bpr FROM BPR bpr";
	public final static String FIND_BPR_BY_ID = "SELECT bpr FROM BPR bpr WHERE bpr.id = ?1";
	public final static String DELETE_BPR_ID = "DELETE FROM BPR bpr WHERE bpr.id = ?1";
	public final static String ADD_BPR = "INSERT INTO BPR(ID, CODE_BPR, LIBELLE_BPR) VALUES (:id, :code_bpr, :libelle_bpr)";
	
	@Query(FIND_ALL_BPR)
	List<BPR> findAllBPR(); 

	@Query(FIND_BPR_BY_ID)
	BPR findBPRByID(Integer id);
	
	@Transactional
	@Modifying
	@Query(value = DELETE_BPR_ID, nativeQuery = true)
	void deleteBPR(Integer id);
	
	
	@Transactional
	@Modifying
	@Query(value = ADD_BPR, nativeQuery = true)
	void ajouterBPR(@Param(value = "id") Integer id, @Param(value = "code_bpr") Integer code_bpr, @Param(value = "libelle_bpr") String libelle_bpr);
	
	

}
