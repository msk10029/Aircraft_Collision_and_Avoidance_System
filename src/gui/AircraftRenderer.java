package gui;

//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
// import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//import javafx.util.Duration;
import models.Aircraft; 

public class AircraftRenderer {

    private Pane aircraftPane;  // Pane where aircraft will be displayed
    //private Timeline movementTimeline;  // Timeline for aircraft movement

    // Constructor to initialize the Pane
    public AircraftRenderer(Pane aircraftPane) {
        this.aircraftPane = aircraftPane;
    }

    // Method to add aircraft to the UI
    public Circle addAircraftToUI(Aircraft aircraft) {
        Circle aircraftIcon = new Circle(5);
        aircraftIcon.setFill(Color.BLUE);
        // Set the initial position of the aircraft based on the Aircraft object
        aircraftIcon.setLayoutX(aircraft.getPositionX());
        aircraftIcon.setLayoutY(aircraft.getPositionY());
        // aircraft.setIcon(aircraftIcon);
        // Add the icon to the Pane
        aircraftPane.getChildren().add(aircraftIcon);
        return aircraftIcon;
    }

    // Method to start aircraft movement
    // public void startAircraftMovement(Aircraft aircraft, ImageView aircraftIcon, double timeStep) {
    //     movementTimeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
    //         // Update the aircraft position
    //         aircraft.updatePosition(timeStep);
    //         // Update the UI icon position
    //         aircraftIcon.setLayoutX(aircraft.getPositionX());
    //         aircraftIcon.setLayoutY(aircraft.getPositionY());
    //     }));

    //     movementTimeline.setCycleCount(Timeline.INDEFINITE);  // Run indefinitely
    //     movementTimeline.play();  // Start the timeline
    //     System.out.println("It's running");
    // }

    // // Method to stop aircraft movement
    // public void stopAircraftMovement() {
    //     if (movementTimeline != null) {
    //         movementTimeline.stop();
    //     }
    }

