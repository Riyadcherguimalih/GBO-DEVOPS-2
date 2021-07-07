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
@Table(name = "MARCHE")
public class Marche implements Serializable {
	

	private static final long serialVersionUID = -6595351446020702619L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "INTITULE_MARCHE")
	private String intitule;
	
	@Column(name = "DESCRIPTION_MARCHE")
	private String description;
	
	@OneToMany(
		mappedBy = "marche",
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<Produit> produits;
	
	public Marche() {
		
	}
	public Marche(Integer id, String intitule, String description) {
		this.id = id;
		this.intitule = intitule;
		this.description = description;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Marche [id=" + id + ", intitule=" + intitule + ", description="
				+ description + ", produits=" + produits + "]";
	}
	
	
	
	

}
