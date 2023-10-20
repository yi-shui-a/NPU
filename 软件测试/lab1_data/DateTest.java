
import org.junit.Assert;
import org.junit.Test;

public class DateTest {
	@Test
	public void test() {
		Date date1 = new Date(12, 5, 2029);
		Date date2 = new Date(12, 5, 2029);
		Date date3 = new Date(12, 31, 2019);
		Date date4 = new Date(2, 28, 2020);
		Date date5 = new Date(3, 31, 2020);
		Year year1 = new Year(2019);
		Month month = new Month(1, year1);

		Day day = new Day(1, month);
//test date
		Assert.assertTrue(date1.equals(date2));
		Assert.assertFalse(date1.equals(date3));
		Assert.assertFalse(date1.equals(year1));
		Assert.assertFalse(date1.equals(date4));
		System.out.println(Nextday.nextDay(date1));
		Nextday.nextDay(date3);
		Nextday.nextDay(date4);
		Nextday.nextDay(date5);
		date1.printDate();
		Assert.assertFalse(month.equals(1));
		Assert.assertFalse(day.equals(1));
		try {
			Date date6 = new Date(1, 1, 0);
//			Assert.assertArrayEquals(null, null);
		} catch (IllegalArgumentException e) {
			e.getMessage();
		}
		try {
			Date date7 = new Date(1, 1, -1);
			Assert.assertTrue(date7.getYear().increment());
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			Month month1 = new Month(0, year1);
			Month month2 = new Month(1, year1);
			Assert.assertFalse(month2.equals(date1));
			Assert.assertFalse(month2.equals(month1));
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			Month month1 = new Month(1, year1);

			Day day1 = new Day(-1, month1);
			Assert.assertTrue(day1.equals(1));
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			Nextday nextDay = new Nextday();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		}
		
	}
}