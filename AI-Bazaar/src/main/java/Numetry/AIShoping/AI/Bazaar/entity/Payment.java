package Numetry.AIShoping.AI.Bazaar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    private java.sql.Timestamp paymentDate;
    private Double paymentAmount;
    private String paymentMethod;
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public CustomerOrder getOrder() {
		return customerOrder;
	}
	public void setOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public java.sql.Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(java.sql.Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

    
}
