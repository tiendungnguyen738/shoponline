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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "so_luong")
    private int soLuong;

    @OneToOne
    @JoinColumn(name="color_id",referencedColumnName = "id")
    private Color color;

    @OneToOne
    @JoinColumn(name="size_id",referencedColumnName = "id")
    private Size size;

    @OneToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_detail_id",referencedColumnName = "id")
	Set<OrdersDetail> orders_detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
