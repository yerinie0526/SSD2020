package dongduk.cs.ssd.summerpetstore.controller;

import dongduk.cs.ssd.summerpetstore.model.CartModel;

public class Order {
	private CartModel cartmodel;
	private OrderForm orderForm;
	private int orderId;
	
	public Order() {
		
	}

	public Order(CartModel cartmodel) {
		super();
		this.cartmodel = cartmodel;
	}
	
	public Order(CartModel cartmodel, OrderForm orderForm) {
		super();
		this.cartmodel = cartmodel;
		this.orderForm = orderForm;
	}
	

	public Order(CartModel cartmodel, OrderForm orderForm, int orderId) {
		super();
		this.cartmodel = cartmodel;
		this.orderForm = orderForm;
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public CartModel getCartmodel() {
		return cartmodel;
	}

	public void setCartmodel(CartModel cartmodel) {
		this.cartmodel = cartmodel;
	}
	
	
}
