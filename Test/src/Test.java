import java.util.Scanner;

public class Test {
	private static User[] user = new User[3];
	private static int num = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (true) {
			boolean flag = false;

			System.out.println("*****************");
			System.out.println("1��ע��");
			System.out.println("2����½");
			System.out.println("1���˳�");
			System.out.println("*****************");

			System.out.println("���������ѡ��");
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
				System.out.println("��������������������");
				break;
			}

			if (flag)
				break;
		}
	}

	private static void regite() {
		if (num < 3) {
			User u= new User();
			
			System.out.println("����������û���");
			String username = sc.next();
			System.out.println("�������������");
			String password = sc.next();
			System.out.println("��������ĳ�������");
			String birthday = sc.next();
			System.out.println("��������İ���");
			String hobby = sc.next();
			
			
			u.setUsername(username);
			u.setPassword(password);
			u.setBirthday(birthday);
			u.setHobby(hobby);
			
			user[num]  = u;
			
			num++;

		}else{
			System.out.println("ע������������������ע��");
		}

	}

	private static void login() {

	}

}
