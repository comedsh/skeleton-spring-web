/**
 * 
 */
package com.fenghua.auto.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fenghua.auto.finance.domain.OrderPayment;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderMasterResultDTO implements Serializable {

	private static final long serialVersionUID = 2263634449096339797L;

	private Long masterOrderId;

    private String masterOrderNo;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private BigDecimal transportAmount;

    private BigDecimal needPayAmount;

    private BigDecimal payedAmount;

    private Integer payMethod;

    private Integer payStatus;

	private List<String> orderNoList;
	
	private OrderPayment orderPayment;

	public OrderMasterResultDTO() {
		super();
	}

	public Long getMasterOrderId() {
		return masterOrderId;
	}

	public void setMasterOrderId(Long masterOrderId) {
		this.masterOrderId = masterOrderId;
	}

	public String getMasterOrderNo() {
		return masterOrderNo;
	}

	public void setMasterOrderNo(String masterOrderNo) {
		this.masterOrderNo = masterOrderNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getTransportAmount() {
		return transportAmount;
	}

	public void setTransportAmount(BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}

	public BigDecimal getNeedPayAmount() {
		return needPayAmount;
	}

	public void setNeedPayAmount(BigDecimal needPayAmount) {
		this.needPayAmount = needPayAmount;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public List<String> getOrderNoList() {
		return orderNoList;
	}

	public void setOrderNoList(List<String> orderNoList) {
		this.orderNoList = orderNoList;
	}

	public OrderPayment getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(OrderPayment orderPayment) {
		this.orderPayment = orderPayment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterOrderId == null) ? 0 : masterOrderId.hashCode());
		result = prime * result + ((masterOrderNo == null) ? 0 : masterOrderNo.hashCode());
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
		OrderMasterResultDTO other = (OrderMasterResultDTO) obj;
		if (masterOrderId == null) {
			if (other.masterOrderId != null)
				return false;
		} else if (!masterOrderId.equals(other.masterOrderId))
			return false;
		if (masterOrderNo == null) {
			if (other.masterOrderNo != null)
				return false;
		} else if (!masterOrderNo.equals(other.masterOrderNo))
			return false;
		return true;
	}
}
