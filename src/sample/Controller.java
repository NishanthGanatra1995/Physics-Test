package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import physics.World;
import physics.WorldOptions;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
	public Pane pane;
	public Label labelTemp;
	public TextField startSpeed;
	public TextField maxSize;
	public TextField frictionValue;
	public CheckBox sideCollisions;

	private World world;
	private Timer timer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void startPhysicsAnimation() {
		final int[] counter = {0};
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					counter[0] = counter[0] + 1;
					labelTemp.setText(String.valueOf(counter[0]));

					world.updatePositions();

					renderDots();
				});
			}
		}, 0, 25);
	}

	public void renderDots() {
		pane.getChildren().clear();
		for (int i = 0; i < world.getDots().size(); i++) {
			Circle circle = new Circle(world.getDots().get(i).size);
			circle.setCenterX(world.getDots().get(i).x);
			circle.setCenterY(world.getDots().get(i).y);
			pane.getChildren().add(circle);
		}
	}

	public void startSimulation(ActionEvent actionEvent) {

		if (timer != null) timer.cancel();

		WorldOptions worldOptions = new WorldOptions(800, 800, 50);
		worldOptions.setRandomXYSpeedVariation(Float.parseFloat(startSpeed.getText()));
		worldOptions.setMaxSize(Integer.parseInt(maxSize.getText()));
		worldOptions.setCollisionSides(sideCollisions.isSelected());
		worldOptions.setFriction(Float.parseFloat(frictionValue.getText()));
		world = new World(worldOptions);

		startPhysicsAnimation();
	}
}
