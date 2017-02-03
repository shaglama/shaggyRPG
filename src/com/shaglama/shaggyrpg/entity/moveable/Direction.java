package com.shaglama.shaggyrpg.entity.moveable;

public enum Direction {
	NORTH,EAST,SOUTH,WEST,NORTH_EAST,SOUTH_EAST,NORTH_WEST,SOUTH_WEST,UP,DOWN,LEFT,RIGHT,BACKWARD,FORWARD;
	
	public static Direction mapDirection(Direction currentDirection,Direction moveDirection){
		Direction result;
		switch (currentDirection){
			case EAST:
				switch (moveDirection){
					case LEFT:
						result = Direction.NORTH;
						break;
					case RIGHT:
						result = Direction.SOUTH;
						break;
					case FORWARD:
						result = Direction.EAST;
						break;
					case BACKWARD:
						result = Direction.WEST;
						break;
					default:
						result = null;
						break;
				}
				break;
			case NORTH:
				switch (moveDirection){
					case LEFT:
						result = Direction.WEST;
						break;
					case RIGHT:
						result = Direction.EAST;
						break;
					case FORWARD:
						result = Direction.NORTH;
						break;
					case BACKWARD:
						result = Direction.SOUTH;
						break;
					default:
						result = null;
						break;
				}
				break;
			case NORTH_EAST:
				switch (moveDirection){
					case LEFT:
						result = Direction.NORTH_WEST;
						break;
					case RIGHT:
						result = Direction.SOUTH_EAST;
						break;
					case FORWARD:
						result = Direction.NORTH_EAST;
						break;
					case BACKWARD:
						result = Direction.SOUTH_WEST;
						break;
					default:
						result = null;
						break;
				}
				break;
			case NORTH_WEST:
				switch (moveDirection){
					case LEFT:
						result = Direction.SOUTH_WEST;
						break;
					case RIGHT:
						result = Direction.NORTH_EAST;
						break;
					case FORWARD:
						result = Direction.NORTH_WEST;
						break;
					case BACKWARD:
						result = Direction.SOUTH_EAST;
						break;
					default:
						result = null;
						break;
				}
				break;
			case SOUTH:
				switch (moveDirection){
					case LEFT:
						result = Direction.EAST;
						break;
					case RIGHT:
						result = Direction.WEST;
						break;
					case FORWARD:
						result = Direction.SOUTH;
						break;
					case BACKWARD:
						result = Direction.NORTH;
						break;
					default:
						result = null;
						break;
				}
				break;
			case SOUTH_EAST:
				switch (moveDirection){
					case LEFT:
						result = Direction.NORTH_EAST;
						break;
					case RIGHT:
						result = Direction.SOUTH_WEST;
						break;
					case FORWARD:
						result = Direction.SOUTH_EAST;
						break;
					case BACKWARD:
						result = Direction.NORTH_WEST;;
						break;
					default:
						result = null;
						break;
				}
				break;
			case SOUTH_WEST:
				switch (moveDirection){
					case LEFT:
						result = Direction.SOUTH_EAST;
						break;
					case RIGHT:
						result = Direction.NORTH_WEST;
						break;
					case FORWARD:
						result = Direction.SOUTH_WEST;
						break;
					case BACKWARD:
						result = Direction.NORTH_EAST;;
						break;
					default:
						result = null;
						break;
				}
				break;
			case WEST:
				switch (moveDirection){
					case LEFT:
						result = Direction.SOUTH;
						break;
					case RIGHT:
						result = Direction.NORTH;
						break;
					case FORWARD:
						result = Direction.WEST;
						break;
					case BACKWARD:
						result = Direction.EAST;
						break;
					default:
						result = null;
						break;
				}
				break;
			default:
				result = null;
				break;			
		}
		return result;
	}
}
