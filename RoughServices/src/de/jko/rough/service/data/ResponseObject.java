package de.jko.rough.service.data;

public class ResponseObject
{
	private int code = 0;
	private String message = null;
	
	public ResponseObject(int code, String message)
	{
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode()
	{
		return code;
	}
	public void setCode(int code)
	{
		this.code = code;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
			
	
}
