package ma.gbp.objectif.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BPR")
public class BPR implements Serializable{
	

	private static final long serialVersionUID = -3903937678436395592L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "CODE_BPR")
	private Integer code_bpr;
	
	@Column(name = "LIBELLE_BPR")
	private String libelle_bpr;
	
	@OneToMany(
		mappedBy = "affectation_bpr",
		cascade = CascadeType.ALL, orphanRemoval = true
			)
	private List<Utilisateur> affectation;
	
	@OneToMany(
			cascade = CascadeType.ALL, orphanRemoval = true,
		mappedBy = "bpr"	
			)
	private List<Succursale> succursales;

	@OneToMany(
			cascade = CascadeType.ALL, orphanRemoval = true,
		mappedBy = "bpr_objectif"
		)
	private List<Objectif> objectifs_bpr;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode_bpr() {
		return code_bpr;
	}

	public void setCode_bpr(Integer code_bpr) {
		this.code_bpr = code_bpr;
	}

	public String getLibelle_bpr() {
		return libelle_bpr;
	}

	public void setLibelle_bpr(String libelle_bpr) {
		this.libelle_bpr = libelle_bpr;
	}


	public List<Utilisateur> getAffectation() {
		return affectation;
	}

	public void setAffectation(List<Utilisateur> affectation) {
		this.affectation = affectation;
	}

	public List<Objectif> getObjectifs_bpr() {
		return objectifs_bpr;
	}

	public void setObjectifs_bpr(List<Objectif> objectifs_bpr) {
		this.objectifs_bpr = objectifs_bpr;
	}

	public List<Succursale> getSuccursales() {
		return succursales;
	}

	public void setSuccursales(List<Succursale> succursales) {
		this.succursales = succursales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**public BPR() {
		
	}
	public BPR(Integer id, Integer code_bpr, String libelle_bpr) {
		this.id = id;
		this.code_bpr = code_bpr;
		this.libelle_bpr = libelle_bpr;
	}**/
	
	
	
}
