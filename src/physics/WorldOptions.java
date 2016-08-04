package physics;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class WorldOptions {

	public int x;
	public int y;
	public int noOfEntities;
	public float variation;
	public float maxSize;
	public boolean collisionSides;
	public float friction;

	public WorldOptions (int x, int y, int noOfEntities) {
		this.x = x;
		this.y = y;
		this.noOfEntities = noOfEntities;
	}

	public void setRandomXYSpeedVariation(float variation) {
		this.variation = variation;
	}

	public void setMaxSize (int maxSize) {
		this.maxSize = maxSize;
	}

	public void setCollisionSides (boolean collisionSides) {
		this.collisionSides = collisionSides;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}
}
