package com.verizon.cabbooking;

public class ClsRoute {	
	public String[] sWayPoints;	
	public int iRouteID=0;
	public String sRouteName;
	
	public ClsRoute(String sRouteWayPoints)
	{
		sRouteWayPoints=sRouteWayPoints.replace("),", "@");
		sRouteWayPoints=sRouteWayPoints.replace("(", "");
		sRouteWayPoints=sRouteWayPoints.replace(")", "");
		sWayPoints=sRouteWayPoints.split("@");
	}
}
