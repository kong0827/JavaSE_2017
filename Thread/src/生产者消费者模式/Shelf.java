package 生产者消费者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LHB TODO 2018年9月28日 下午3:02:16
 */
public class Shelf {

	private int max;
	private List<Product> products = new ArrayList<>();

	public synchronized void in(Product p) {
		while (products.size() >= max) {

			try {
				wait();
			} catch (Exception e) {
			}
		}
		// 表示没货
		products.add(p);
		System.out.println("有货");
		notifyAll();
	}

	public synchronized void out() {
		System.out.println(products.size());
		while (products.size() == 0) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		// 表示有货
		products.remove(0);
		System.out.println("有货");
		notifyAll();

	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	
	public void setMax(int max) {
		this.max = max;
	}

	
	public List<Product> getProduct() {
		return products;
	}

	public void setProduct(List<Product> products) {
		this.products = products;
	}

	
	public Shelf(int max) {
		super();
		this.max = max;
		this.products = products;
	}

	
	public Shelf() {
		super();
	}

}
