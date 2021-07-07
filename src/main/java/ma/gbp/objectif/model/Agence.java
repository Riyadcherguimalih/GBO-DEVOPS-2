package ma.gbp.objectif.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCE")
public class Agence implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "CODE_AGENCE")
	private Integer code_agence;
	
	@Column(name = "CODE_BANQUE")
	private Integer code_banque;

	@Column(name = "LIBELLE_AGENCE")
	private String libelle_agence;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Succursale succursale;
	
	@OneToMany(
		mappedBy = "affectation_agence",
		cascade = CascadeType.ALL
			)
	private List<Utilisateur> affectation;

	@OneToMany(mappedBy = "agence_objectif")
	private List<Objectif> objectifs_agence;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode_agence() {
		return code_agence;
	}

	public void setCode_agence(Integer code_agence) {
		this.code_agence = code_agence;
	}

	public Integer getCode_banque() {
		return code_banque;
	}

	public void setCode_banque(Integer code_banque) {
		this.code_banque = code_banque;
	}

	public String getLibelle_agence() {
		return libelle_agence;
	}

	public void setLibelle_agence(String libelle_agence) {
		this.libelle_agence = libelle_agence;
	}

	public Succursale getSuccursale() {
		return succursale;
	}

	public void setSuccursale(Succursale succursale) {
		this.succursale = succursale;
	}

	public List<Utilisateur> getAffectation() {
		return affectation;
	}

	public void setAffectation(List<Utilisateur> affectation) {
		this.affectation = affectation;
	}

	public List<Objectif> getObjectifs_agence() {
		return objectifs_agence;
	}

	public void setObjectifs_agence(List<Objectif> objectifs_agence) {
		this.objectifs_agence = objectifs_agence;
	}


	
	
}
