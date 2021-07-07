package ma.gbp.objectif.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "OBJECTIF")
public class Objectif implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	//@Version
	//@Column(name = "VERSION")
	//private Integer version;
	
	//private IdandYear id;
	
	/**@Column(name = "CODE_BPR")
	private Integer code_bpr;
	
	@Column(name = "CODE_SUCCURSALE")
	private Integer code_succursale;
	
	@Column(name = "CODE_AGENCE")
	private Integer code_agence;
	
	@Column(name = "CODE_BANQUE")
	private Integer code_banque;**/
	
	@Column(name = "ANNEE")
	private Integer annee;
	
	@Column(name = "VALUE_NUMBER")
	private Integer value_number;
	
	@Column(name = "VALUE_AMOUNT")
	private Integer value_amount;
	
	@Column(name = "REALISATION_NUMBER")
	private Integer realisation_number;
	
	@Column(name = "REALISATION_AMOUNT")
	private Integer realisation_amount;
	
	@Column(name = "CREATEUR")
	private String createur;
	
	@Column(name = "DATE_CREATION")
	private Date date_creation;
	
	@Column(name = "LAST_MODIFICATION")
	private String last_modification;
	
	@Column(name = "MODIFICATEUR")
	private String modificateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produit produit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private BPR bpr_objectif;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Succursale succursale_objectif;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Agence agence_objectif;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getValue_number() {
		return value_number;
	}

	public void setValue_number(Integer value_number) {
		this.value_number = value_number;
	}

	public Integer getValue_amount() {
		return value_amount;
	}

	public void setValue_amount(Integer value_amount) {
		this.value_amount = value_amount;
	}

	public Integer getRealisation_number() {
		return realisation_number;
	}

	public void setRealisation_number(Integer realisation_number) {
		this.realisation_number = realisation_number;
	}

	public Integer getRealisation_amount() {
		return realisation_amount;
	}

	public void setRealisation_amount(Integer realisation_amount) {
		this.realisation_amount = realisation_amount;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getLast_modification() {
		return last_modification;
	}

	public void setLast_modification(String last_modification) {
		this.last_modification = last_modification;
	}

	public String getModificateur() {
		return modificateur;
	}

	public void setModificateur(String modificateur) {
		this.modificateur = modificateur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public BPR getBpr_objectif() {
		return bpr_objectif;
	}

	public void setBpr_objectif(BPR bpr_objectif) {
		this.bpr_objectif = bpr_objectif;
	}

	public Succursale getSuccursale_objectif() {
		return succursale_objectif;
	}

	public void setSuccursale_objectif(Succursale succursale_objectif) {
		this.succursale_objectif = succursale_objectif;
	}

	public Agence getAgence_objectif() {
		return agence_objectif;
	}

	public void setAgence_objectif(Agence agence_objectif) {
		this.agence_objectif = agence_objectif;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
