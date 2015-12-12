package edu.harvard.agile.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.harvard.agile.model.StatusEnum;

/**
 * Utility class for Work package management
 * @author Incredibles Team
 *
 */
public class WorkPackageUtil 
{
	public static Date convertDate(String dateStr, String format) throws ParseException
	{
		if(dateStr != null && dateStr.trim().length() > 0)
		{
			DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
			Date date = dateFormat.parse(dateStr);
			return date;
		}
		else
		{
			return null;
		}
	}
	

	public static List<String> getValidStatus(){
		List<String> statuses = new ArrayList<String>();
		statuses.add(StatusEnum.OPEN.name());
		statuses.add(StatusEnum.INPROGRESS.name());
		statuses.add(StatusEnum.APPROVED.name());
		statuses.add(StatusEnum.COMPLETED.name());
		
		return statuses;
	}
}
