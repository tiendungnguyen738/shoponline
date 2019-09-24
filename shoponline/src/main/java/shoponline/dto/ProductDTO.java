package shoponline.dto;

import java.util.Set;

import shoponline.entity.Category;
import shoponline.entity.ProductDetail;

public class ProductDTO {

	 private Long id;
	 private Category category;
	 private String productName;
	 private String price;
	 private String image;
	 private Long popular;
	 private Set<ProductDetail> productsDetail;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPopular() {
		return popular;
	}
	public void setPopular(Long popular) {
		this.popular = popular;
	}
	public Set<ProductDetail> getProductsDetail() {
		return productsDetail;
	}
	public void setProductsDetail(Set<ProductDetail> productsDetail) {
		this.productsDetail = productsDetail;
	}
	 
	 
}
