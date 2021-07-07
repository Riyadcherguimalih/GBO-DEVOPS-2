package ma.gbp.objectif.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = -5910992714197618960L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	//@Version
	@Column(name = "DATE_CREATION")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_creation;


	@Column(name = "MATRICULE")
	private String matricule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Agence affectation_agence;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Succursale affectation_succursale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private BPR affectation_bpr;

	public Utilisateur() {
		
	}

	public Integer getId() {
		return id;
	}
	
	public Date getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	


	public void setId(Integer id) {
		this.id = id;
	}



	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Agence getAffectation_agence() {
		return affectation_agence;
	}


	public void setAffectation_agence(Agence affectation_agence) {
		this.affectation_agence = affectation_agence;
	}


	public Succursale getAffectation_succursale() {
		return affectation_succursale;
	}


	public void setAffectation_succursale(Succursale affectation_succursale) {
		this.affectation_succursale = affectation_succursale;
	}


	public BPR getAffectation_bpr() {
		return affectation_bpr;
	}


	public void setAffectation_bpr(BPR affectation_bpr) {
		this.affectation_bpr = affectation_bpr;
	}



	

}
