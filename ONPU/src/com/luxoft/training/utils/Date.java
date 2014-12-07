package com.luxoft.training.utils;

public class Date {

	private int day;
	private int month;
	private int year;
	
	// CONSTRUCTORS

	public Date() {
		this(1, 1, 1900);
	}

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public Date(Date d)
	{
		this(d.day, d.month, d.year);
	}
	
	// SUPERCLASS_METHODS
	
	public boolean equals(Object date) {
		if (date instanceof Date) {
			Date d = (Date)date;		
			if (d.day == getDay() && d.month == getMonth() && d.year == getYear())
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public String toString() {
		return (getDay() < 10 ? "0" : "") + getDay() + "." +
			   (getMonth() < 10 ? "0" : "") + getMonth() + "." +
			   (getYear() < 1000 ? "0" + (getYear() < 100 ? "0" + (getYear() < 10 ? "0" : "") : "") + getYear() : getYear());
	}

	// ACCESSORS
		
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		if (day > 0 && day <= daysInMonth(getMonth(), getYear()))
			this.day = day;
		else 
			System.out.println("Incorrect value of day: " + day);
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		if (month > 0 && month < 13) {
			this.month = month;
			int dim = daysInMonth(getMonth(), getYear());
			if (day > dim)
				day = dim;
		} else
			System.out.println("Incorrect value of month: " + month);
	}
	
	public int getYear() {
		return year;
	}
		
	public void setYear(int year) {
		this.year = year;
	}

	public Date getDate() {
		return new Date(this);
	}
	
	public void setDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// METHODS
	
	public void printDate() {
		System.out.println(this.toString());
	}
	
	private int daysInMonth(int m, int y) {
		switch (m) {
			case 1 : 
			case 3 :
			case 5 : 
			case 7 : 
			case 8 :
			case 10 : 
			case 12 : return 31;
			case 2 : return ((y % 4) == 0 && (y % 100) != 0 ? 29 : 28);
			case 4 : 
			case 6 : 
			case 9 :
			case 11 : return 30;
			
			default : return 0;
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 *  1 - this date more than arg date<br>
	 *  0 - date equals<br>
	 * -1 - this date less than arg date
	 */
	public int compare(Date date) {
		if (getYear() < date.year)
			return -1;
		else
			if (getYear() > date.year)
				return 1;
			else
				if (getMonth() < date.month)
					return -1;
				else
					if (getMonth() > date.month)
						return 1;
					else
						if (getDay() < date.day)
							return -1;
						else
							if (getDay() > date.day)
								return 1;
							else
								return 0;
	}
	
	public static int monthsCount(Date date1, Date date2) {
		// date1 always less or equals to date2
		switch (date1.compare(date2)) {
			case  1 : Date temp = new Date(date1);
					  date1 = date2;
					  date2 = temp; break;
			case  0 : return 0;
			case -1 : break;

			default : System.out.println("Error with comparing dates!"); return 0;
		}

		int mc = 0;
		if (date1.getYear() < date2.getYear()) {
			mc = date2.getMonth() - date1.getMonth();
			if (date1.getMonth() < date2.getMonth())
				if (date1.getDay() > date2.getDay()) // 25.03.2010 - 05.04.2011
					mc -= 1;
			if (date1.getMonth() > date2.getMonth())
				if (date1.getDay() > date2.getDay()) // 25.12.2010 - 05.01.2011
					mc -= 1;
			if (date1.getMonth() == date2.getMonth())
				mc = 0;
			mc += (date2.getYear() - date1.getYear()) * 12;
		}
		if (date1.getYear() == date2.getYear()) {
			if (date1.getMonth() < date2.getMonth()) {
				mc = date2.getMonth() - date1.getMonth();
				if (date1.getDay() > date2.getDay()) // 25.03.2011 - 05.04.2011
					mc -= 1;
			}
			if (date1.getMonth() == date2.getMonth())
				mc = 0;
		}
		return mc;
	}

	public String getMonthName() {
		switch (getMonth()) {
			case 1  : return "January";
			case 2  : return "February";
			case 3  : return "March";
			case 4  : return "April";
			case 5  : return "May";
			case 6  : return "June";
			case 7  : return "July";
			case 8  : return "August";
			case 9  : return "September";
			case 10 : return "October";
			case 11 : return "November";
			case 12 : return "December";

			default: return "Unknown month";
		}
	}

	public void incDay(int i) {
		int d = getDay();
		int days = daysInMonth(getMonth(), getYear());
		if ((d + i) > days)
		{	
			i += d - days;
			incMonth(1);
		}
		setDay(i);		
	}
	
	public void incMonth(int i) {
		int m = getMonth();
		if (m + i > 12)
		{
			i += m - 12;
			incYear(1);
			setMonth(i);
		}
		else
			setMonth(m + i);
	}
	
	public void incYear(int i) {
		int y = getYear();
		if (Integer.MAX_VALUE - i >= y)
			setYear(y + i);
		else
			System.out.println("The field \"year\" is overflowed!");
	}
	
	public void decDay(int i) {
		int d = getDay();
		if ((d - i) < 1)
		{
			i -= (d + 1);
			decMonth(1);
			setDay(daysInMonth(this.month, this.year) - i);
		}
		else
			setDay(d - i);
	}
	
	public void decMonth(int i) {
		int m = getMonth();
		if (m - i < 1)
		{
			i -= m;
			decYear(1);
			setMonth(12 - i);
		}
		else
			setMonth(m - i);
	}
	
	public void decYear(int i) {
		int y = getYear();
		if (Integer.MIN_VALUE + i <= y)
			setYear(getYear() - 1);
		else
			System.out.println("The field \"year\" is underflowed!");
	}
	
}
