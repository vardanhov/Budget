package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BudgetFormat {

	public String getDate(DateFormat dateFormat, String dateString) {
    	try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
			return dateFormat.format(date);
		} catch (ParseException e) {
			return dateString;
		}
	}
	
	public String getDecimal(String value) {
		return value.replaceAll(" ", "");
	}
	
	public String getCost(String value) {
		value = getDecimal(value);
		value = value.replaceAll("rub.", "");
		value = value.replaceAll(",", ".");
		return value;
	}
}
