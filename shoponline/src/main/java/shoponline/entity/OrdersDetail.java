package shoponline.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orders_detail")
public class OrdersDetail implements Serializable{

	@EmbeddedId
	private OrdersDetailID ordersDetail;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private String price;
	
	
	public OrdersDetailID getOrdersDetail() {
		return ordersDetail;
	}
	public void setOrdersDetail(OrdersDetailID ordersDetail) {
		this.ordersDetail = ordersDetail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
