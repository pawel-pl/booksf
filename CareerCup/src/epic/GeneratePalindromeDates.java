package epic;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * http://www.careercup.com/question?id=3236729
 * http://www.livescience.com/33583-palindrome-dates-21st-century-weird.html
 * http://www.careercup.com/question?id=13115666
 */
public class GeneratePalindromeDates {

	public static void main(String[] args) {

		char[] date = new char[8];
		for (int i = 1; i <= 12; i++) {
			String month = String.valueOf(i);
			if (month.length() == 1) {
				month = "0" + month;
			}
			for (int j = 1; j <= 31; j++) {
				String day = String.valueOf(j);
				if (day.length() == 1) {
					day = "0" + day;
				}
				String monthDay = month + day;
				String year = new StringBuilder(monthDay).reverse().toString();
				if(Integer.parseInt(day) > checkMaxDays(year, monthDay)) {
					continue;
				}
				System.arraycopy(monthDay.toCharArray(), 0, date, 0, 4);
				System.arraycopy(year.toCharArray(), 0, date, 4, 4);
				System.out.println(Arrays.toString(date));
			}
			
		}
		
	}

	private static int checkMaxDays(String year, String month) {
		
		Calendar mycal = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, 1);
		System.out.println(mycal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

	}
	public static void generateDates(String start, String end) {

	}
}
