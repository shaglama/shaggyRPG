package com.shaglama.shaggyrpg.location.compassPoints;

import java.util.ArrayList;

public enum CompassPoints {
	NORTH(0),
	NORTH_BY_EAST(11.25),
	NORTH_NORTHEAST(22.5),
	NORTHEAST_BY_NORTH(33.75),
	NORTHEAST(45),
	NORTHEAST_BY_EAST(56.25),
	EAST_NORTHEAST(67.5),
	EAST_BY_NORTH(78.75),	
	EAST(90),
	EAST_BY_SOUTH(101.25),
	EAST_SOUTHEAST(112.5),
	SOUTHEAST_BY_EAST(123.75),
	SOUTHEAST(135),
	SOUTH_EAST_BY_SOUTH(146.25),
	SOUTH_SOUTHEAST(157.5),	
	SOUTH_BY_EAST(168.75),
	SOUTH(180),
	SOUTH_BY_WEST(191.25),
	SOUTH_SOUTHWEST(202.5),
	SOUTHWEST_BY_SOUTH(213.75),
	SOUTHWEST(225),
	SOUTHWEST_BY_WEST(236.25),
	WEST_SOUTHWEST(247.5),
	WEST_BY_SOUTH(258.75),
	WEST(270),	
	WEST_BY_NORTH(281.25),	
	WEST_NORTHWEST(292.5),
	NORTHWEST_BY_WEST(303.75),
	NORTHWEST(315),
	NORTHWEST_BY_NORTH(326.25),
	NORTH_NORTHWEST(337.5),
	NORTH_BY_WEST(348.75),
	N(0),NbE(11.25),NNE(22.5),NEbN(33.75),
	NE(45), NEbE(56.25),ENE(67.5),EbN(78.75),
	E(90),EbS(101.25),ESE(112.5),SEbE(123.75),
	SE(135),SEbS(146.25),SSE(157.5), SbE(168.75),
	S(180),SbW(191.25),SSW(202.5),SWbS(213.75),
	SW(225),SWbW(236.25),WSW(247.5),WbS(258.75),
	W(270),WbN(281.25),WNW(292.5), NWbW(303.75),
	NW(315),NWbN(326.25), NNW(337.5),NbW(348.75);
	
	
	private double degreesFromNorth;
	
	private CompassPoints(double degreesFromNorth){
		this.degreesFromNorth = degreesFromNorth;
	}
	public double getDegreesFromNorth(){
		return degreesFromNorth;
	}
	
	public static ArrayList<CompassPoints> getAll(){
		ArrayList<CompassPoints> points = new ArrayList<CompassPoints>();
		points.addAll(CompassPoints.getEasternHemisphere());
		points.addAll(CompassPoints.getWesternHemisphere());
		return points;
	}
	
	private static ArrayList<CompassPoints> getHemisphere(int hemisphere){
		ArrayList<CompassPoints> points = new ArrayList<CompassPoints>();
		switch (hemisphere){
			case 0://northern
				points.addAll(CompassPoints.getNorthEastQuadrant());
				points.addAll(CompassPoints.getNorthWestQuadrant());
				break;
			case 1://eastern
				points.addAll(CompassPoints.getNorthEastQuadrant());
				points.addAll(CompassPoints.getSouthEastQuadrant());
				break;
			case 2://southern
				points.addAll(CompassPoints.getSouthEastQuadrant());
				points.addAll(CompassPoints.getSouthWestQuadrant());
				break;
			case 3://western
				points.addAll(CompassPoints.getSouthWestQuadrant());
				points.addAll(CompassPoints.getNorthWestQuadrant());
				break;
			default:
				return null;
		}
		return points;
	}
	private static ArrayList<CompassPoints> getQuadrant(int quadrant)
	{
		ArrayList<CompassPoints> points = new ArrayList<CompassPoints>();
		switch (quadrant){
			case 0:
				points.add(CompassPoints.N);
				points.add(CompassPoints.NbE);
				points.add(CompassPoints.NNE);
				points.add(CompassPoints.NEbN);
				points.add(CompassPoints.NE);
				points.add(CompassPoints.NEbE);
				points.add(CompassPoints.ENE);
				points.add(CompassPoints.EbN);
				break;
			case 1:
				points.add(CompassPoints.E);
				points.add(CompassPoints.EbS);
				points.add(CompassPoints.ESE);
				points.add(CompassPoints.SEbE);
				points.add(CompassPoints.SE);
				points.add(CompassPoints.SEbS);
				points.add(CompassPoints.SSE);
				points.add(CompassPoints.SbE);
				break;
			case 2:
				points.add(CompassPoints.S);
				points.add(CompassPoints.SbW);
				points.add(CompassPoints.SSW);
				points.add(CompassPoints.SWbS);
				points.add(CompassPoints.SW);
				points.add(CompassPoints.SWbW);
				points.add(CompassPoints.WSW);
				points.add(CompassPoints.WbS);
				break;
			case 3:
				points.add(CompassPoints.W);
				points.add(CompassPoints.WbN);
				points.add(CompassPoints.WNW);
				points.add(CompassPoints.NWbW);
				points.add(CompassPoints.NW);
				points.add(CompassPoints.NWbN);
				points.add(CompassPoints.NNW);
				points.add(CompassPoints.NbW);
				break;
			default:
				return null;
		}
		return points;
	}
	public static ArrayList<CompassPoints> getNorthEastQuadrant(){
		return CompassPoints.getQuadrant(0);
	}
	public static ArrayList<CompassPoints> getSouthEastQuadrant(){
		return CompassPoints.getQuadrant(1);
	}
	public static ArrayList<CompassPoints> getSouthWestQuadrant(){
		return CompassPoints.getQuadrant(2);
	}
	public static ArrayList<CompassPoints> getNorthWestQuadrant(){
		return CompassPoints.getQuadrant(3);
	}	
	
	public static ArrayList<CompassPoints> getNorthernHemisphere(){
		return CompassPoints.getHemisphere(0);
	}
	public static ArrayList<CompassPoints> getSouthernHemisphere(){
		return CompassPoints.getHemisphere(2);
	}
	public static ArrayList<CompassPoints> getEasternHemisphere(){
		return CompassPoints.getHemisphere(1);
	}
	public static ArrayList<CompassPoints> getWesternHemisphere(){
		return CompassPoints.getHemisphere(3);
	}
	public static double getDistanceFromCompassPoint(double targetDegree, CompassPoints point){
		double pointDegree = point.getDegreesFromNorth();
		if(pointDegree > targetDegree){
			return pointDegree - targetDegree;
		} else {
			return targetDegree - pointDegree;
		}
	}
	public static int compareDistance(double start, CompassPoints point1, CompassPoints point2){
		double distance1; 
		double distance2;
		if(start < 0 || start >= 360){
			return -1;
		}
		distance1 = CompassPoints.getDistanceFromCompassPoint(start, point1);
		distance2 = CompassPoints.getDistanceFromCompassPoint(start, point2);
		if(distance1 == distance2){
			return 0;
		} else if(distance1 < distance2){
			return 1;
		} else {
			return 2;
		}
		
		
	}
	public static CompassPoints getOpposite(double degreesFromNorth){
		return CompassPoints.getFartherest(degreesFromNorth);
	}
	public static CompassPoints getOpposite(CompassPoints point){
		return CompassPoints.getFartherest(point);
	}
	public static CompassPoints getFartherest(CompassPoints point){
		return CompassPoints.getFartherest(point.getDegreesFromNorth());
	}
	public static CompassPoints getFartherest(double degreesFromNorth){
		if(degreesFromNorth < 0  || degreesFromNorth >= 360){
			return null;
		}
		double opposite = degreesFromNorth + 180;
		if(opposite >= 360){
			opposite = opposite - 360;
		}
		return CompassPoints.getNearest(opposite);
	}
	
	public static CompassPoints getNearest(double degreesFromNorth){
		int quadrant;
		ArrayList<CompassPoints> points;
		CompassPoints[] pointArray;
		int comparison;		
		
		if(degreesFromNorth < 0 || degreesFromNorth >= 360){
			return null;
		}
		quadrant = (int) Math.floor((double) degreesFromNorth / 90);
		points = CompassPoints.getQuadrant(quadrant);
		pointArray = points.toArray(new CompassPoints[points.size()]);
		for(int i = 0; i < pointArray.length; i++){
			if(pointArray[i].getDegreesFromNorth() == degreesFromNorth){
					return pointArray[i];
			} else {
				if(pointArray[i].getDegreesFromNorth() > degreesFromNorth){
					comparison = CompassPoints.compareDistance(degreesFromNorth, pointArray[i-1], pointArray[i]);
					switch(comparison){
					case 0://equal
						return pointArray[i-1];
					case 1://previous Point closer
						return pointArray[i-1];
					case 2://current point closer
						return pointArray[i];
						default://error
							return null;
					}
				} else {
					if(i+1 == pointArray.length){//may be in next quadrant
						switch (quadrant){
							case 0:
								comparison = CompassPoints.compareDistance(degreesFromNorth, pointArray[i], CompassPoints.EAST);
								switch(comparison){
									case 0://equal
										return pointArray[i];
									case 1://previous Point closer
										return pointArray[i];
									case 2://current point closer
										return CompassPoints.EAST;
									default://error
										return null;
								}
							case 1:
								comparison = CompassPoints.compareDistance(degreesFromNorth, pointArray[i], CompassPoints.SOUTH);
								switch(comparison){
									case 0://equal
										return pointArray[i];
									case 1://previous Point closer
										return pointArray[i];
									case 2://current point closer
										return CompassPoints.SOUTH;
									default://error
										return null;
								}							
							case 2:
								comparison = CompassPoints.compareDistance(degreesFromNorth, pointArray[i], CompassPoints.WEST);
								switch(comparison){
									case 0://equal
										return pointArray[i];
									case 1://previous Point closer
										return pointArray[i];
									case 2://current point closer
										return CompassPoints.WEST;
									default://error
										return null;
								}
							case 3:
								comparison = CompassPoints.compareDistance(degreesFromNorth, pointArray[i], CompassPoints.NORTH);
								switch(comparison){
									case 0://equal
										return pointArray[i];
									case 1://previous Point closer
										return pointArray[i];
									case 2://current point closer
										return CompassPoints.NORTH;
									default://error
										return null;
								}
							default:
								return null;
							
						}
					}
				}
			}
		}
		return null;		
	}
		
}
