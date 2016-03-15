package de.jko.icoquet.service.data;

public class Attributes
{
	private String acting = null;
	private String beard = null;
	private String design = null;
	private String dinner = null;
	private String drink = null;
	private String fastfood = null;
	private String food = null;
	private String freetime = null;
	private String gender = null;
	private String goingout = null;
	private String hair = null;
	private String music = null;   
	private String pet = null;
	private String place = null;
	private String plant = null;
	private String season = null;
	private String sports = null;
	private String swimming = null;
	
	public Attributes()
	{
		super();
	}
	
	public String getActing()
	{
		return acting;
	}
	public void setActing(String acting)
	{
		this.acting = acting;
	}
	public String getBeard()
	{
		return beard;
	}
	public void setBeard(String beard)
	{
		this.beard = beard;
	}
	public String getDesign()
	{
		return design;
	}
	public void setDesign(String design)
	{
		this.design = design;
	}
	public String getDinner()
	{
		return dinner;
	}
	public void setDinner(String dinner)
	{
		this.dinner = dinner;
	}
	public String getDrink()
	{
		return drink;
	}
	public void setDrink(String drink)
	{
		this.drink = drink;
	}
	public String getFastfood()
	{
		return fastfood;
	}
	public void setFastfood(String fastfood)
	{
		this.fastfood = fastfood;
	}
	public String getFood()
	{
		return food;
	}
	public void setFood(String food)
	{
		this.food = food;
	}
	public String getFreetime()
	{
		return freetime;
	}
	public void setFreetime(String freetime)
	{
		this.freetime = freetime;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getGoingout()
	{
		return goingout;
	}
	public void setGoingout(String goingout)
	{
		this.goingout = goingout;
	}
	public String getHair()
	{
		return hair;
	}
	public void setHair(String hair)
	{
		this.hair = hair;
	}
	public String getMusic()
	{
		return music;
	}
	public void setMusic(String music)
	{
		this.music = music;
	}
	public String getPet()
	{
		return pet;
	}
	public void setPet(String pet)
	{
		this.pet = pet;
	}
	public String getPlace()
	{
		return place;
	}
	public void setPlace(String place)
	{
		this.place = place;
	}
	public String getPlant()
	{
		return plant;
	}
	public void setPlant(String plant)
	{
		this.plant = plant;
	}
	public String getSeason()
	{
		return season;
	}
	public void setSeason(String season)
	{
		this.season = season;
	}
	public String getSports()
	{
		return sports;
	}
	public void setSports(String sports)
	{
		this.sports = sports;
	}
	public String getSwimming()
	{
		return swimming;
	}
	public void setSwimming(String swimming)
	{
		this.swimming = swimming;
	}

	@Override
	public String toString()
	{
		return "Attributes [acting=" + acting + ", beard=" + beard + ", design=" + design + ", dinner=" + dinner + ", drink=" + drink + ", fastfood="
				+ fastfood + ", food=" + food + ", freetime=" + freetime + ", gender=" + gender + ", goingout=" + goingout + ", hair=" + hair
				+ ", music=" + music + ", pet=" + pet + ", place=" + place + ", plant=" + plant + ", season=" + season + ", sports=" + sports
				+ ", swimming=" + swimming + "]";
	}
}
