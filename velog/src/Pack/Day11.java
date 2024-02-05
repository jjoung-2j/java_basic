package Pack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Day11 {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		
		String currentTime = String.format("%tZ",now);
		// currentTime : 2024-02-03
		System.out.println(currentTime);
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
		sdformat.setLenient(false);
		
		try {
			Date d = sdformat.parse("19990520");
			System.out.println(d);
		} catch(ParseException e) {
			System.out.println("달력에 존재하지 않습니다.");
		}
		
		Calendar currentDate = Calendar.getInstance();
		System.out.println(currentDate.getActualMaximum(Calendar.DATE));
		System.out.println(currentDate.get(Calendar.ZONE_OFFSET));
	}

}
