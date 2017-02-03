package com.shaglama.shaggyrpg.location.bearings;

import com.shaglama.shaggyrpg.location.compassPoints.CompassPoints;

public class CompassBearing extends Bearing {

	public CompassBearing() {
		super("North");
	}
	public CompassBearing(double degreesFromNorth){
		super("North",degreesFromNorth);
	}
	
	public boolean setBearing(double degreesFromNorth){
		return this.setDegreesFromReference(degreesFromNorth);
	}
	@Override
	public String toString(){
		String base = super.toString();
		return base + " (" + getCompassBearing() + ")";
	}
	
	public CompassBearing getOppositeBearing(){
		return getBearingAt(180);
	}
	public CompassBearing getLeftBearing(){
		return getBearingAt(-90);
	}
	public CompassBearing getRightBearing(){
		return getBearingAt(90);
	}
	public CompassBearing getBearingAt(double degreesFromBearing){
		return new CompassBearing(getDegreeesFromNorth() + degreesFromBearing);
	}
	public double getDegreeesFromNorth(){
		return getDegreesFromReference();
	}
	public String getCompassBearing(){
		double degrees = getDegreesFromReference();
		double pointDegrees;
		double difference;
		String out;
		String modifier;
		String unit;
		CompassPoints point = CompassPoints.getNearest(degrees);
		pointDegrees = point.getDegreesFromNorth();
		if(degrees == pointDegrees){
			difference = 0f;
			modifier = "";
		} else if(degrees > pointDegrees ){
			difference = degrees - pointDegrees;
			modifier = "+";
		} else {
			difference = pointDegrees - degrees;
			modifier = "-";	
		}
		out = point.toString();
		if(difference == 0){
			return out;
		} else {
			if(difference == 1){
				unit = "degree";
			} else {
				unit = "degrees";
			}
			out += " ";
			out += modifier;
			out += " ";
			out += difference;
			out += " ";
			out += unit;
			return out;
		}
	}

}
