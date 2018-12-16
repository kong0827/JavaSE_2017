
import java.util.Calendar;

public class Exe8 {

	public static void main(String[] args) {

		int year = 2018;
		int month = 10;
		
		Exe8 exe8=new Exe8();
		
		exe8.pucal(year, month);
	}

	public void pucal(int year, int month) {
		System.out.println("日\t一\t二\t三\t四\t五\t六");

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);

		int maxday = calendar.getActualMaximum(Calendar.DATE);
		//System.out.println(maxday);

		// 先判断1日是星期几
		int firstweek = calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println(firstweek);

		for (int i = 1; i < firstweek; i++) {
			System.out.print(" \t");
		}

		for (int i = 1; i <= maxday; i++) {

			System.out.print(i + "\t");
			// 星期六换行

			int week = calendar.get(Calendar.DAY_OF_WEEK);
			
			if (week == 7) {
				System.out.println();
			}
			calendar.add(Calendar.DATE, 1);
		}
	}

}
