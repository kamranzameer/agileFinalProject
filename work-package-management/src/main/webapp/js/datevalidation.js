function validate_dates(form)
{
	Date contractStartDate = new Date(form.contractFromYear);
	Date contractToDate = new Date(form.contractToYear);
	Date startDate = new Date(form.startDate);
	Date endDate = new Date(form.endDate);

	if(contractToDate.getTime() < contractStartDate.getTime())
	{
		alert("Contract to year cannot be less than\n Contract start year");
		return false
	}
	
	if(endDate.getTime() < startDate.getTime())
	{
		alert("End date cannot be less than\n Start date");
		return false
	}
	
	return true;

}
