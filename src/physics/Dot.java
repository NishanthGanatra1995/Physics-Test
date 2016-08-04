package physics;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class Dot {
	public float size;
	public float x;
	public float y;
	public float velocityX;
	public float velocityY;

	public Dot(int x, int y, float velocityX, float velocityY, float size) {
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.size = size;
	}

}
