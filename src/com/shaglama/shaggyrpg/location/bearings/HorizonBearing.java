package com.shaglama.shaggyrpg.location.bearings;

public class HorizonBearing extends Bearing {
	private static Axes DEFAULT_AXIS = Axes.LATERAL;
	private static double DEFAULT_DEVIATION = 0;
	protected Axes axis;
	
//Constructors-----------------------------------------------------------------	
	public HorizonBearing() {
		this(DEFAULT_DEVIATION,DEFAULT_AXIS);
	}

	public HorizonBearing(double degreesFromHorizontal) {
		this(degreesFromHorizontal,DEFAULT_AXIS);		
	}
	public HorizonBearing(Axes axis){
		this(DEFAULT_DEVIATION,axis);
	}
	public HorizonBearing(double degreesFromHorizontal, Axes axis){
		super("Horizontal");
		if(!setDegreesFromHorizontal(degreesFromHorizontal)){
			throw new IllegalArgumentException("Invalid value for 'degreesFromHorizontal'");
		}
		if(!setAxis(axis)){
			throw new IllegalArgumentException("Invalid value for 'axis'");
		}
	}
	//Public Methods-----------------------------------------------------------
	public double getDegreesFromHorizontal(){
		return this.getDegreesFromReference();
	}
	public boolean setDegreesFromHorizontal(double degreesFromHorizontal){
		return this.setDegreesFromReference(degreesFromHorizontal);
	}
	public Axes getAxis(){
		return axis;
	}
	public HorizonBearing getBearingAt(double degreesFromBearing){
		return new HorizonBearing(getDegreesFromHorizontal() + degreesFromBearing);
	}
	public HorizonBearing getOppositeBearing(){
		return getBearingAt(180);
	}
	//Protected Methods--------------------------------------------------------
	protected boolean setAxis(Axes axis){
		switch(axis){
			case LATERAL:
				this.axis = axis;
				return true;
			case LONGITUDINAL:				
				this.axis = axis;
				return true;
			default:
				return false;
				
		}
		
	}

}
