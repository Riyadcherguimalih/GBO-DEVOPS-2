package ma.gbp.objectif.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUCCURSALE")
public class Succursale implements Serializable {


	private static final long serialVersionUID = -3550916156003023368L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "CODE_SUCCURSALE")
	private Integer code_succursale;
	
	@Column(name = "LIBELLE_SUCCURSALE")
	private String libelle_succursale;
	
	@OneToMany(
		mappedBy = "succursale",
		cascade = CascadeType.ALL
			)
	private List<Agence> agence = new ArrayList<>();
	
	@OneToMany(
		mappedBy = "affectation_succursale",
		cascade = CascadeType.ALL
			)
	private List<Utilisateur> affectation;
	
	@ManyToOne
	private BPR bpr;
	
	@OneToMany(mappedBy = "succursale_objectif")
	private List<Objectif> objectifs_succursale;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode_succursale() {
		return code_succursale;
	}

	public void setCode_succursale(Integer code_succursale) {
		this.code_succursale = code_succursale;
	}

	public String getLibelle_succursale() {
		return libelle_succursale;
	}

	public void setLibelle_succursale(String libelle_succursale) {
		this.libelle_succursale = libelle_succursale;
	}

	public List<Agence> getAgence() {
		return agence;
	}

	public void setAgence(List<Agence> agence) {
		this.agence = agence;
	}

	public List<Utilisateur> getAffectation() {
		return affectation;
	}

	public void setAffectation(List<Utilisateur> affectation) {
		this.affectation = affectation;
	}

	public List<Objectif> getObjectifs_succursale() {
		return objectifs_succursale;
	}

	public void setObjectifs_succursale(List<Objectif> objectifs_succursale) {
		this.objectifs_succursale = objectifs_succursale;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BPR getBpr() {
		return bpr;
	}

	public void setBpr(BPR bpr) {
		this.bpr = bpr;
	}
	
	
	
}
