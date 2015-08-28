package com.verizon.cabbooking;

public class RoutePicker {
	public ClsRoute[] oAvailableRoutes;
	public RoutePicker(ClsRoute[] oRoutes)
	{
		oAvailableRoutes=oRoutes;
	}
	public ClsRoute GetRouteName(UserBookInfo oUseBookInfo)
	{
		double LowestDistace=0;
		ClsRoute oRouteSel=null;
		for(int j=0;j<oAvailableRoutes.length;j++)
		{
			
			for(int i=0;i<oAvailableRoutes[j].sWayPoints.length;i++)
			{
				
				double dLat2=Double.parseDouble(oAvailableRoutes[j].sWayPoints[i].split(",")[0]);
				double dLon2=Double.parseDouble(oAvailableRoutes[j].sWayPoints[i].split(",")[1]);
				double iTmpDist=distance(oUseBookInfo.dLat,oUseBookInfo.dLon,dLat2,dLon2,'K');
				if(LowestDistace==0)
				{
					LowestDistace=iTmpDist;
				}
				else
				{
					if(LowestDistace>iTmpDist)
					{
						LowestDistace=iTmpDist;
						oRouteSel=oAvailableRoutes[j];
					}
				}
			}
		}
		return oRouteSel;
	}
	private  double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
	      double theta = lon1 - lon2;
	      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	      dist = Math.acos(dist);
	      dist = rad2deg(dist);
	      dist = dist * 60 * 1.1515;
	      if (unit == 'K') {
	        dist = dist * 1.609344;
	      } else if (unit == 'N') {
	        dist = dist * 0.8684;
	        }
	      return (dist);
	    }

	    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	    /*::  This function converts decimal degrees to radians             :*/
	    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	    private  double deg2rad(double deg) {
	      return (deg * Math.PI / 180.0);
	    }

	    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	    /*::  This function converts radians to decimal degrees             :*/
	    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	    private  double rad2deg(double rad) {
	      return (rad * 180.0 / Math.PI);
	    }
}
