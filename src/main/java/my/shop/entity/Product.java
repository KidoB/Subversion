package my.shop.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class Product implements Serializable {

	private Integer id;
	private String nameProduct;
	private Integer availableProduct;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getAvailableProduct() {
		return availableProduct;
	}

	public void setAvailableProduct(Integer availableProduct) {
		this.availableProduct = availableProduct;
	}

}
