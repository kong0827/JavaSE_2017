package 生产者消费者模式;

/**
 * @author LHB TODO 2018年9月28日 下午3:14:41
 */
public class Customer extends Thread {

	private Shelf shelf;
	private int amount;
	// 购买的次数

	public void run() {

		for (int i = 0; i <= amount; i++) {

			Product p = new Product();
			shelf.out();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

	/**
	 * @return the shelf
	 */
	public Shelf getShelf() {
		return shelf;
	}

	/**
	 * @param shelf
	 *            the shelf to set
	 */
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @param shelf
	 * @param amount
	 */
	public Customer(Shelf shelf, int amount) {
		super();
		this.shelf = shelf;
		this.amount = amount;
	}

	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param target
	 * @param name
	 */
	public Customer(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param target
	 */
	public Customer(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public Customer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 * @param name
	 * @param stackSize
	 */
	public Customer(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 * @param name
	 */
	public Customer(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param target
	 */
	public Customer(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param name
	 */
	public Customer(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

}
