package shoponline.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
	
	@Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private String price;

    @Column(name = "image")
    private String image;
    
    @Column(name="popular")
    private Long popular;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "id")
    private Set<ProductDetail> productsDetail;
    
    public Long getPopular() {
		return popular;
	}

	public void setPopular(Long popular) {
		this.popular = popular;
	}

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

    public Set<ProductDetail> getProductsDetail() {
        return productsDetail;
    }

    public void setProductsDetail(Set<ProductDetail> productsDetail) {
        this.productsDetail = productsDetail;
    }
}
