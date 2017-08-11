package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String YYYYMMDD = "yyyyMMdd";

	public static String dataToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(date);
	}

}
