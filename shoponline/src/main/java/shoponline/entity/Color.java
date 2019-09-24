package shoponline.entity;

import java.util.List;

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
@Table(name = "color")
public class Color {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "color_name")
	    private String colorName;

	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "color_id", referencedColumnName = "id")
	    private List<ProductDetail> productsDetail;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getColorName() {
	        return colorName;
	    }

	    public void setColorName(String colorName) {
	        this.colorName = colorName;
	    }

	    public List<ProductDetail> getProductsDetail() {
	        return productsDetail;
	    }

	    public void setProductsDetail(List<ProductDetail> productsDetail) {
	        this.productsDetail = productsDetail;
	    }
}
