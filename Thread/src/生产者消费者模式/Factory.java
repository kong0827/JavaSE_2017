package 生产者消费者模式;

/**
 * @author LHB
 *  TODO
 * 2018年9月28日  下午3:13:59
 */
public class Factory  extends Thread{
	private String name;
	private Shelf shelf;
	private int amount;
	//生产的产品数量
	
	
	@Override
	public void run() {
		
		for(int i=0;i<=amount; i++) {
			
			Product p = new Product();
			
			shelf.in(p);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			
		}
	}
	
	
	public Shelf getShelf() {
		return shelf;
	}
	
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Factory(Shelf shelf, int amount) {
		super();
		this.shelf = shelf;
		this.amount = amount;
	}
	
	public Factory() {
		super();
		
	}
	
	public Factory(Runnable target, String name) {
		super(target, name); 
	}
	
	public Factory(Runnable target) {
		super(target);
		
	}
	
	public Factory(String name) {
		super(name);
		
	}
	
	public Factory(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		
	}
	
	public Factory(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		
	}
	
	public Factory(ThreadGroup group, Runnable target) {
		super(group, target);
		
	}
	
	public Factory(ThreadGroup group, String name) {
		super(group, name);
		
	}
	
	
	
	
	
}
