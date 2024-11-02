package models;
// import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Aircraft {
    private String id;
    private double positionX;
    private double positionY;
    private double altitude; // Optional for basic simulation
    private double speed;
    private int heading; // In degrees (0-360)
    private double collisionRadius;
    private Color color; // For GUI representation
    private Circle icon;
    private double climbeRate;
    private boolean isWarningIssued;
    private boolean isInDangerZone;

    // Constructor
    public Aircraft(String id, double positionX, double positionY, double altitude, double speed, int heading, double collisionRadius, Color color) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.altitude = altitude;
        this.speed = speed;
        this.heading = heading;
        this.collisionRadius = collisionRadius;
        this.color = color;
        this.isWarningIssued = false;
        this.climbeRate = 0;
        this.isInDangerZone = false;
    }

    // Method to update the aircraft's position
    public void updatePosition(double timeStep) {
        double radianHeading = Math.toRadians(heading);
        this.positionX += speed * Math.cos(radianHeading) * timeStep;
        this.positionY += speed * Math.sin(radianHeading) * timeStep;
        if(this.isWarningIssued)
        this.altitude = this.altitude + climbeRate*timeStep;
    }

    public void setIcon(Circle icon) {
        this.icon = icon;
    }

    public Circle getIcon() {
        return icon;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public int getHeading() {
        return heading;
    }
    
    public void setHeading(int heading){
        this.heading = heading;
    }

    public double getCollisionRadius() {
        return collisionRadius;
    }

    public Color getColor() {
        return color;
    }

    public void setWarningIssued(boolean isWarningIssued) {
        this.isWarningIssued= isWarningIssued;
    }

    public boolean isWarningIssued() {
        return isWarningIssued;
    }

    public void setClimbRate(double rate){
        this.climbeRate = rate;
    }

    public double getClimbRate(){
        return climbeRate;
    }
    public void setInDangerZone(boolean isInDangerZone) {
        this.isInDangerZone = isInDangerZone;
    }

    public boolean isInDangerZone() {
        return isInDangerZone;
    }
}
