/**
 * 
 */
package com.shaglama.shaggyrpg;

import java.util.ArrayList;

import com.shaglama.shaggyrpg.lists.CircularlyLinkedList;
import com.shaglama.shaggyrpg.location.bearings.CompassBearing;
import com.shaglama.shaggyrpg.location.position.Position;
import com.shaglama.shaggyrpg.location.position.positioner.Positioner;
import com.shaglama.shaggyrpg.location.vectors.Vector;
import com.shaglama.shaggyrpg.location.vectors.Vector3d;
import com.shaglama.shaggyrpg.location.vectors.heading.HeadingVector;
import com.shaglama.shaggyrpg.location.vectors.heading.InverseYHeadingVector;

/**
 * @author randy
 *
 */
public class Launcher {

	public Launcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("sun.java2d.opengl", "true");//needed for linux to do away with jerky movements except when moving mouse,should research more and see if there are other ways around the problerm
/*
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		CircularlyLinkedList<String>  testList = new CircularlyLinkedList<String>(list);
		System.out.println(testList.toString());		
		testList.append("first element");
		testList.append("second element");
		testList.append("third element");
		System.out.println(testList.next());
		System.out.println(testList.prev());
		System.out.println(testList.hasPrev());
		testList.next();
		testList.next();
		testList.next();
		testList.next();
		System.out.println(testList.hasNext());
		//testList.insert("inserted", true);
		System.out.println(testList.toString());
*/		
		//testList.remove("inserted");
		//System.out.println(testList.toString());
		//System.out.println(testList.getElement());
		////System.out.println(testList.findAll("first element").length);
		//System.out.println(testList.removeAll("first element"));
		//System.out.println(testList.getLength());
		//System.out.println(testList.removeAll("first element"));
		
		Game game = new Game("ShaggyRPG!",800,600);
		game.start();
		
		
		/*
		double[] angles;
		Vector3d vector = new Vector3d(1,2,3);
		//vector = Vector3d.getNormalizedVector(vector);
		System.out.println(vector.getX()+ "," + vector.getY()+","+ vector.getZ());
		
		angles = Vector3d.getAnglesFromVector(vector.getX(), vector.getY(),vector.getZ() );
		System.out.println(angles[0]+"," + angles[1]);
		Vector3d newVector = Vector3d.getVectorFromAngles(angles[0], angles[1]);
		System.out.println(newVector.getX() + "," + newVector.getY() + "," + newVector.getZ());
		angles = Vector3d.getAnglesFromVector(newVector.getX(), newVector.getY(),newVector.getZ() );
		System.out.println(angles[0]+"," + angles[1]);
		System.out.println(Vector3d.getMagnitude(newVector.getX(), newVector.getY(), newVector.getZ()));
	*/	
		
		//Positioner pos = new Positioner(new Position());
		//pos.move3d(pos.getPosition(), 1,179, 00);
		//System.out.println(pos.getPosition().getX() + "," + pos.getPosition().getY() + "," + pos.getPosition().getZ());
		
		
		
		//CompassBearing hb = new CompassBearing();
		//hb.setReferencePoint("North");
		//System.out.println("Starting degree: " + hb.getDegreesFromReference());
		//System.out.print(hb.getBearing());
		//System.out.println("");
		//System.out.println("rotating 90 degrees!");
		//hb.rotate(90);
		//System.out.println("Current degree: " + hb.getDegreesFromReference());
		//System.out.println(hb.getBearing());
		//System.out.println("Getting Opposite: ");
		//System.out.println(hb.getOppositeBearing());
		//System.out.println(hb.toString());		//System.out.print(CompassPoints.getNearest(264.5f));
		//System.out.println("");
		//System.out.print(CompassPoints.getFartherest(CompassPoints.NORTH));
		//System.out.println("");
		//System.out.print(CompassPoints.getFartherest(270f));
		/*Vector vec = Vector.getVectorFromAngle(180);
		InverseYHeadingVector hvec = InverseYHeadingVector.getVectorFromAngle(180);
		hvec.normalize();
		vec.normalize();
		System.out.println("(" + vec.getX() + "," + vec.getY() + ")");
		System.out.println(Vector.getAngleFromVector(vec));
		System.out.println("(" + hvec.getX() + "," + hvec.getY() + ")");
		System.out.println(InverseYHeadingVector.getAngleFromVector(hvec));
		//System.out.println(Math.atan2(vec.getX(), vec.getY()) * 180 / Math.PI);
double x = 0; double y = 0;
x += vec.getX(); y += vec.getY();
x += vec.getX(); y += vec.getY();
System.out.println(Math.round(x) + "," + Math.round(y));
		Position p = new Position();
		System.out.println("Checking Yaw:");
		System.out.println(p.getYaw());
		System.out.println(p.getYawBearing());
		System.out.println("rotating yaw 137.2 degrees:");
		System.out.println(p.rotateYaw(137.2f));
		System.out.println(p.getYawBearing());
		System.out.println("Checking Roll:");
		System.out.println(p.getRoll());
		System.out.println("rotating roll 90 degrees:");
		System.out.println(p.rotateRoll(90));
		System.out.println("rotating roll 90 degrees:");
		System.out.println(p.rotateRoll(90));
		System.out.println("Checking Pitch:");
		System.out.println(p.getPitch());
		System.out.println("rotating pitch 90 degrees:");
		System.out.println(p.rotatePitch(90));
		System.out.println("rotating pitch  -90 degrees:");
		System.out.println(p.rotatePitch(-90));
		System.out.println("Checking X: ");
		System.out.println(p.getX());
		System.out.println("moving X 10");
		System.out.println(p.moveX(10));
		System.out.println("moving X 10");
		System.out.println(p.moveX(10));
		System.out.println("moving X -10");
		System.out.println(p.moveX(-10));
		System.out.println(p);
		Positioner.moveEast(p, 10, 1);
		Positioner.moveSouth(p, 10, 1);
		System.out.println(p);
		Positioner positioner = new Positioner(p);
		positioner.teleport(200, 300, 10);
		System.out.println(p);
		positioner.rotate(20);
		positioner.spin(20);
		positioner.turn(20);
		System.out.println(p);*/
		
		
		
	}

}
