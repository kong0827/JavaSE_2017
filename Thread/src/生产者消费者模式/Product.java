package ������������ģʽ;

/**
 * @author LHB
 *  TODO
 * 2018��9��28��  ����3:00:20
 */
public class Product {

	private String name;
	private String id;
	private int price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product(String name, String id, int price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
	
	public Product() {
		super();
	}
	
	
	
}
