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
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="address")
	String address;
	
	@Column(name="phone")
	String phone;
	
	@Column(name="orders_status")
	int ordersStatus;
	
	@Column(name="orders_date")
	String ordersDate;
	
	@Column(name="note")
	String note;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="orders_id",referencedColumnName = "id")
	
	Set<OrdersDetail> orders_detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(int ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public String getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<OrdersDetail> getOrders_detail() {
		return orders_detail;
	}

	public void setOrders_detail(Set<OrdersDetail> orders_detail) {
		this.orders_detail = orders_detail;
	}
	
	
	
}
