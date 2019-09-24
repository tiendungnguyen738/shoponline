package shoponline.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "size")
public class Size {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "size_name")
	    private String sizeName;

	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="size_id",referencedColumnName = "id")
	    private Set<ProductDetail> productsDetail;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getSizeName() {
	        return sizeName;
	    }

	    public void setSizeName(String sizeName) {
	        this.sizeName = sizeName;
	    }

	    public Set<ProductDetail> getProductsDetail() {
	        return productsDetail;
	    }

	    public void setProductsDetail(Set<ProductDetail> productsDetail) {
	        this.productsDetail = productsDetail;
	    }

}
