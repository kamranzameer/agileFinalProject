package edu.harvard.agile.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for Work package management
 * @author Incredibles Team
 *
 */
public class WorkPackageUtil 
{
	public static Date convertDate(String dateStr, String format) throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		Date date = dateFormat.parse(dateStr);
		return date;
	}
}
