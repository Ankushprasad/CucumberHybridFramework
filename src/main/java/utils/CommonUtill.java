package utils;

import java.util.Date;

public class CommonUtill {

	public static String getEmailWithTimeStamp() {
		
		Date date=new Date();
		return "ankush"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		
}
}
