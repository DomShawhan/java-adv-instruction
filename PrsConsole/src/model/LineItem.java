package model;

public class LineItem {
	private int id;
	private Request request;
	private Product product;
	private int quantity;
	
	public LineItem(int id, Request request, Product product, int quantity) {
		this.id = id;
		this.request = request;
		this.product = product;
		this.quantity = quantity;
	}
	
	public LineItem() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", request=" + request + ", product=" + product + ", quantity=" + quantity
				+ "]";
	}
	
	
}
