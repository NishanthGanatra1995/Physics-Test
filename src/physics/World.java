package physics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class World {

	private WorldOptions worldOptions;
	private ArrayList<Dot> dots;

	public World(WorldOptions worldOptions) {
		this.worldOptions = worldOptions;
		Random random = new Random();
		dots = new ArrayList<>();
		for (int i = 0; i < worldOptions.noOfEntities; i++) {
			dots.add(
					new Dot(
							random.nextInt(worldOptions.x), random.nextInt(worldOptions.y),
							(random.nextFloat() * worldOptions.variation * 2) - worldOptions.variation,
							(random.nextFloat() * worldOptions.variation * 2) - worldOptions.variation,
							random.nextFloat() * worldOptions.maxSize)
			);
		}
	}

	public ArrayList<Dot> getDots() {
		return dots;
	}

	public void updatePositions() {
		for (int i = 0; i < worldOptions.noOfEntities; i++) {
			Dot dot = dots.get(i);
			dot.x = dot.x + dot.velocityX;
			dot.y = dot.y + dot.velocityY;

			if (worldOptions.collisionSides) {
				if (dot.y < 0 || dot.y > worldOptions.y) dot.velocityY = - dot.velocityY;
				if (dot.x < 0 || dot.x > worldOptions.x) dot.velocityX = - dot.velocityX;
			}

			if (worldOptions.friction > 0) {
				if (dot.velocityX > 0) {
					if (dot.velocityX - worldOptions.friction < 0)
						dot.velocityX = 0;
					else
						dot.velocityX = dot.velocityX - worldOptions.friction;
				} else {
					if (dot.velocityX + worldOptions.friction > 0)
						dot.velocityX = 0;
					else
						dot.velocityX = dot.velocityX + worldOptions.friction;
				}

				if (dot.velocityY > 0) {
					if (dot.velocityY - worldOptions.friction < 0)
						dot.velocityY = 0;
					else
						dot.velocityY = dot.velocityY - worldOptions.friction;
				} else {
					if (dot.velocityY + worldOptions.friction > 0)
						dot.velocityY = 0;
					else
						dot.velocityY = dot.velocityY + worldOptions.friction;
				}
			}
		}
	}
}
