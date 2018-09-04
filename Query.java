package com.gmail.birchyboy.s;

public class Query {
	private String query;
	private boolean filter_dealers;
	private int given_condition;
	private int cylinders;
	private int transmission;
	private int fuel;
	private int title;
	private int drive;
	private int min_price;
	private int max_price;

	public void setQuery(String query) {
		this.query = query.replaceAll(" ", "+");
	}
	public void setFilter_dealers(boolean filter_dealers) {
		this.filter_dealers = filter_dealers;
	}
	public void setGiven_condition(int given_condition) {
		this.given_condition = given_condition;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public void setTransmission(int transmission) {
		this.transmission = transmission;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public void setDrive(int drive) {
		this.drive = drive;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}
	
	public String generate_query()
	{
		boolean first = true;
		String url_query = "/search/";
		if(filter_dealers)
		{
			url_query+="cto?";
		}
		else
		{
			url_query+="cta?";
		}
		if(!query.isEmpty()||filter_dealers)
		{
			url_query+="query=";
			if(!query.isEmpty())
			{
	
				url_query+=query;
			}
			if(filter_dealers)
			{
				if(!query.isEmpty())
				{
					query+="+";
				}	
				query+="-finance+-credit";
			}
			first=false;
		}
		if(min_price!=-1)
		{
			query+=sub_generate("min_price",min_price,first);
			first=false;
		}
		if(max_price!=-1)
		{
			query+=sub_generate("max_price",max_price,first);
			first=false;
		}
		if(given_condition!=-1)
		{
			query+=sub_generate("condition",given_condition,first);
			first=false;
		}
		if(cylinders!=-1)
		{
			query+=sub_generate("auto_cylinders",cylinders,first);
			first=false;
		}
		if(drive!=-1)
		{
			query+=sub_generate("auto_drivetrain",drive,first);
			first=false;
		}
		if(fuel!=-1)
		{
			query+=sub_generate("auto_fuel_type",fuel,first);
			first=false;
		}
		if(title!=-1)
		{
			query+=sub_generate("auto_title_status",title,first);
			first=false;
		}
		if(transmission!=-1)
		{
			query+=sub_generate("auto_transmission",transmission,first);
			first=false;
		}
		
		return url_query;
	}
	private String sub_generate(String term, int num, boolean first)
	{
		String add = "";
		if(!first)
		{
			add+="&";
		}
		
		add+=term+"="+num;
		
		return add;
	}
}
