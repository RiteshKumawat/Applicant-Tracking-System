package com.ats.pojo;

import java.io.Serializable;

public class ServiceResponse implements Serializable {
	public Boolean success=true;
	public Boolean isException=false;
	public Boolean isError=false;
	public Boolean hasResult=false;
	public String exception="";
	public String error="";
	public Object result=null;
}
