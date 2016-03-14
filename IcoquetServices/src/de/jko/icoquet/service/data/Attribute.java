package de.jko.icoquet.service.data;

public class Attribute
{
	String name = null;
	String value = null;
	boolean weighted = false;
	
	public Attribute()
	{
		super();
	}

	public Attribute(String name, String value)
	{
		super();
		this.name = name;
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public boolean isWeighted()
	{
		return weighted;
	}

	public void setWeighted(boolean weighted)
	{
		this.weighted = weighted;
	}

	@Override
	public String toString()
	{
		return "Attribute [name=" + name + ", value=" + value + ", weighted=" + weighted + "]";
	}
}
