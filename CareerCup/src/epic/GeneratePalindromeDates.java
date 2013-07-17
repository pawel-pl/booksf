package epic;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * http://www.careercup.com/question?id=3236729
 * http://www.livescience.com/33583-palindrome-dates-21st-century-weird.html
 * http://www.careercup.com/question?id=13115666
 */
public class GeneratePalindromeDates {

	public static void main(String[] args) {

		String startDate = "01012000";
		String endDate = "12122090";
		generateDates(startDate, endDate);
		printDates(1000, 3010);
	}

	public static void generateDates(String startDate, String endDate) {

		Calendar calStart = new GregorianCalendar(Integer.parseInt(startDate.substring(4)), Integer.parseInt(startDate
				.substring(2, 4)) - 1, Integer.parseInt(startDate.substring(0, 2)));
		Calendar calEnd = new GregorianCalendar(Integer.parseInt(endDate.substring(4)), Integer.parseInt(endDate
				.substring(2, 4)) - 1, Integer.parseInt(endDate.substring(0, 2)));

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
				Calendar currentDate = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
				if (Integer.parseInt(day) > checkMaxDays(currentDate)) {
					continue;
				}

				if (currentDate.getTimeInMillis() < calStart.getTimeInMillis()
						|| currentDate.getTimeInMillis() > calEnd.getTimeInMillis()) {
					continue;
				}
				System.out.println(monthDay + year);
			}

		}
	}

	private static int checkMaxDays(Calendar currentDate) {

		return currentDate.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static void printDates(int start, int end) {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int year = start; year <= end; year++) {
			String yyyy = Integer.toString(year);
			String mm = Integer.toString(year % 10) + Integer.toString((year / 10) % 10);
			String dd = Integer.toString((year / 100) % 10) + Integer.toString((year / 1000) % 10);
			int m = Integer.parseInt(mm);
			int d = Integer.parseInt(dd);

			if (m > 0 && m < 13) {
				if (d > 0 && d <= ((m - 1 != 2) ? daysInMonth[m - 1] : (year % 4 != 0) ? 28 : 29)) {
					System.out.println(mm + dd + yyyy);
				}
			}
		}
	}
}
