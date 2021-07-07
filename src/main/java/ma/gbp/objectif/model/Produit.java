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
@Table(name = "PRODUIT")
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "INTITULE_PRODUIT")
	private String intitule_produit;
	
	@Column(name = "DESCRIPTION_PRODUIT")
	private String description_produit;
	
	@OneToMany( 
			mappedBy = "produit")
			private List<Objectif> objectifs;
	
	@ManyToOne
	private Marche marche;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule_produit() {
		return intitule_produit;
	}

	public void setIntitule_produit(String intitule_produit) {
		this.intitule_produit = intitule_produit;
	}

	public String getDescription_produit() {
		return description_produit;
	}

	public void setDescription_produit(String description_produit) {
		this.description_produit = description_produit;
	}

	public List<Objectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

	public Marche getMarche() {
		return marche;
	}

	public void setMarche(Marche marche) {
		this.marche = marche;
	}
	
	
	
	
	
	

}
