
public class Target implements TargetInterface {

	@Override
	public void method1() {
		System.out.println("method1 running......");
		
	}

	@Override
	public String method2() {
		
		return "method2 running......";
	}

	@Override
	public int method3(int x) {
		
		return x;
	}
	

}
