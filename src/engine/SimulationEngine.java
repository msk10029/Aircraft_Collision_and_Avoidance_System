package engine;
import java.util.Iterator;
import java.util.List;
import models.Aircraft;
import factory.AircraftGenerator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
// import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
// import javafx.scene.text.Text;

public class SimulationEngine {
    private List<Aircraft> aircraftList;
    private int aircraftcount = 60;
    private Pane aircraftPane;  // Pane where aircraft will be displayed
    private TextArea textArea;
    private Timeline movementTimeline;

    public SimulationEngine(Pane aircraftPane, TextArea textArea) {
        this.aircraftList = AircraftGenerator.generateRandomAircraft(aircraftcount);
        this.aircraftPane = aircraftPane;
        this.textArea = textArea;
    }

    public void startAircraftMovement() {
        movementTimeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            Iterator<Aircraft> iterator = aircraftList.iterator();
            
            while (iterator.hasNext()) {
                Aircraft aircraft = iterator.next();
    
                // Update the aircraft's position
                aircraft.updatePosition(0.1);
    
                // Get the aircraft icon (circle or ImageView)
                Circle aircraftIcon = aircraft.getIcon();  // Assuming the aircraft has a reference to its icon
    
                // Update the UI icon position
                aircraftIcon.setLayoutX(aircraft.getPositionX());
                aircraftIcon.setLayoutY(aircraft.getPositionY());

                CollisionDetector.checkForCollisions(aircraftList, textArea);
    
                // Check if the aircraft is out of bounds (off the Pane)
                if (aircraft.getPositionX() < 0 || aircraft.getPositionX() > aircraftPane.getWidth() ||
                    aircraft.getPositionY() < 0 || aircraft.getPositionY() > aircraftPane.getHeight()) {
                    
                    // Remove the aircraft icon from the pane
                    aircraftPane.getChildren().remove(aircraftIcon);
    
                    // Remove the aircraft from the list
                    iterator.remove();  // This removes it from the aircraftList safely
                }
            }
        }));
    
        movementTimeline.setCycleCount(Timeline.INDEFINITE);  // Run indefinitely
        movementTimeline.play();  // Start the timeline
    }
    

    // Method to stop aircraft movement
    public void stopAircraftMovement() {
        if (movementTimeline != null) {
            movementTimeline.stop();
        }
    }

    public void updateSimulation(double timeStep) {

        for (Aircraft aircraft : aircraftList) {
            aircraft.updatePosition(timeStep);
        }
        CollisionDetector.checkForCollisions(aircraftList, textArea);
    }

    public List<Aircraft> getAircraftList()
    {
        return this.aircraftList;
    }
}

