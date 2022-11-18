package security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product {
	@Id
	private int id;
	private String reviewer;
	private String description;
	private String starrating;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getStarrating() {
		return starrating;
	}

	public void setStarrating(String starrating) {
		this.starrating = starrating;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	

}
