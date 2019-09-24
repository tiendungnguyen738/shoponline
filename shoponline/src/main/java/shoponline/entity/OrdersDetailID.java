package shoponline.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrdersDetailID implements Serializable{

	@Column(name="orders_id")
	private Long orders_id;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders_id == null) ? 0 : orders_id.hashCode());
		result = prime * result + ((product_detail_id == null) ? 0 : product_detail_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersDetailID other = (OrdersDetailID) obj;
		if (orders_id == null) {
			if (other.orders_id != null)
				return false;
		} else if (!orders_id.equals(other.orders_id))
			return false;
		if (product_detail_id == null) {
			if (other.product_detail_id != null)
				return false;
		} else if (!product_detail_id.equals(other.product_detail_id))
			return false;
		return true;
	}
	@Column(name="product_detail_id")
	private Long product_detail_id;
	
	public Long getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Long orders_id) {
		this.orders_id = orders_id;
	}
	public Long getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(Long product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	
	
}
