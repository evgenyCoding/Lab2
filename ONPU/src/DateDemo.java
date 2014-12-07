import com.luxoft.training.utils.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date date1 = new Date(),
			 date2 = new Date(9, 9, 2011),
			 date3 = new Date(new Date());

		System.out.println(date1.getDay() + "." + date1.getMonth() + "." + date1.getYear());
		date2.printDate();
		date3.printDate();
		date3.setDate(9, 9, 2012);
		date3.printDate();
		
		date1.printDate();
	// 1
		date1.incDay(40);
		date1.printDate();
		
	// 2	
		date1.incMonth(15);
		date1.printDate();

	// 3	
		date1.decDay(40);
		date1.printDate();

	// 4	
		date1.decMonth(15);
		date1.printDate();
		
	// 5	
		System.out.println(date1.getMonthName());
	
		System.out.println(Date.monthsCount(date2, new Date(8, 4, 2012)));
	}

}
