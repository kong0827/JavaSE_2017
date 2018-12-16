package 生产者消费者模式;

/**
 * @author LHB
 *  TODO
 * 2018年9月28日  下午3:21:19
 */
public class Test {

	public static void main(String[] args) {

		Shelf shelf = new Shelf(5);

		Factory f1 = new Factory(shelf, 20);
		Customer c1 = new Customer(shelf, 30);
		f1.start();
		c1.start();

	}

}
