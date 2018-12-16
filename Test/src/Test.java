import java.util.Scanner;

public class Test {
	private static User[] user = new User[3];
	private static int num = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (true) {
			boolean flag = false;

			System.out.println("*****************");
			System.out.println("1、注册");
			System.out.println("2、登陆");
			System.out.println("1、退出");
			System.out.println("*****************");

			System.out.println("请输入你的选择");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				regite();
				break;

			case 2:
				login();
				break;

			case 3:
				flag = true;
				break;

			default:
				System.out.println("你的输入错误，请重新输入");
				break;
			}

			if (flag)
				break;
		}
	}

	private static void regite() {
		if (num < 3) {
			User u= new User();
			
			System.out.println("请输入你的用户名");
			String username = sc.next();
			System.out.println("请输入你的密码");
			String password = sc.next();
			System.out.println("请输入你的出生日期");
			String birthday = sc.next();
			System.out.println("请输入你的爱好");
			String hobby = sc.next();
			
			
			u.setUsername(username);
			u.setPassword(password);
			u.setBirthday(birthday);
			u.setHobby(hobby);
			
			user[num]  = u;
			
			num++;

		}else{
			System.out.println("注册人数已满，不允许注册");
		}

	}

	private static void login() {

	}

}
