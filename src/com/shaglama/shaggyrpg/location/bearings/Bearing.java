package com.shaglama.shaggyrpg.location.bearings;

public class Bearing {
//Members----------------------------------------------------------------------
	//Constants----------------------------------------------------------------
	public static final String DEFAULT_REFERENCE_POINT = "reference";
	public static final double DEFAULT_DEGREES_FROM_REFERENCE = 0;
	
	//private------------------------------------------------------------------ 
	
	//protected----------------------------------------------------------------
	protected double degreesFromReference;
	protected String referencePoint;
	
	//public-------------------------------------------------------------------
	
//Methods----------------------------------------------------------------------
	//Constructors-------------------------------------------------------------
	public Bearing() {
		this(DEFAULT_REFERENCE_POINT,DEFAULT_DEGREES_FROM_REFERENCE);
	}
	public Bearing(String referencePoint){
		this(referencePoint,DEFAULT_DEGREES_FROM_REFERENCE);
	}
	public Bearing(float degreesFromReference){
		this(DEFAULT_REFERENCE_POINT,degreesFromReference);
	}
	public Bearing(String referencePoint, double degreesFromReference){
		setDegreesFromReference(degreesFromReference);
		setReferencePoint(referencePoint);
	}
	
	//public-------------------------------------------------------------------	
	public String getReferencePoint(){
		return referencePoint;
	}
	
	public double getDegreesFromReference(){
		return degreesFromReference;
	}
	
	public boolean rotate(double degrees){
		return setDegreesFromReference(Bearing.rotate(getDegreesFromReference(), degrees));
		
	}
	public static double rotate(double start, double amount){
		double result = start + amount;
		if(result < 0){
					
			do {				
				result = 360 + result;
				
			} while(result < 0);
			
		} else {
			if(result >= 360) {
				do {			
					result = result - 360;
				} while (result >= 360);
			}
		}
		return result;
	}
	public static Bearing getOppositeBearing(Bearing bearing){
		return Bearing.getBearingAt(bearing, 180);
	}
	public static Bearing getBearingAt(Bearing referenceBearing, float degreesFromReference){
		return new Bearing(referenceBearing.getReferencePoint(),
				referenceBearing.getDegreesFromReference() + degreesFromReference);
	}
	@Override
	public String toString(){
		return "Bearing: " + getDegreesFromReference() + " degrees from " + getReferencePoint();
	}
	
	//protected----------------------------------------------------------------
	protected boolean setReferencePoint(String referencePoint){
		if(referencePoint.trim().isEmpty()){
			return false;
		} else {
			this.referencePoint = referencePoint;
			return true;
		}
	}
	protected boolean setDegreesFromReference(double degrees){
		if(degrees >=0 && degrees < 360){
			this.degreesFromReference = degrees;
			return true;
		} else {
			return false;
		}
	}

	//private------------------------------------------------------------------
	
}
