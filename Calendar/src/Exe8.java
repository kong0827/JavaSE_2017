
import java.util.Calendar;

public class Exe8 {

	public static void main(String[] args) {

		int year = 2018;
		int month = 10;
		
		Exe8 exe8=new Exe8();
		
		exe8.pucal(year, month);
	}

	public void pucal(int year, int month) {
		System.out.println("��\tһ\t��\t��\t��\t��\t��");

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);

		int maxday = calendar.getActualMaximum(Calendar.DATE);
		//System.out.println(maxday);

		// ���ж�1�������ڼ�
		int firstweek = calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println(firstweek);

		for (int i = 1; i < firstweek; i++) {
			System.out.print(" \t");
		}

		for (int i = 1; i <= maxday; i++) {

			System.out.print(i + "\t");
			// ����������

			int week = calendar.get(Calendar.DAY_OF_WEEK);
			
			if (week == 7) {
				System.out.println();
			}
			calendar.add(Calendar.DATE, 1);
		}
	}

}