package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	
	public static String formateDate(String pattern, String date) {
		SimpleDateFormat d=new SimpleDateFormat(pattern);
		@SuppressWarnings("deprecation")
		Date dat=new Date(date);
		String formattedDate=d.format(dat);
		System.out.println("formattedDate "+formattedDate);

		
		return formattedDate;
	}

}
