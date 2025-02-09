
# Aircraft Collision Detection System (ACAS)

## Description
The Aircraft Collision Detection System (ACAS) is a JavaFX-based application designed to simulate real-time detection and avoidance of aircraft collisions. This system uses graphical visualization to display aircraft movement and provides collision alerts when aircraft come too close. ACAS can be used for educational purposes and as a foundation for more advanced simulation systems.

## Features
- Real-time simulation of aircraft movement.
- Collision detection based on horizontal distance and altitude.
- Visual representation of aircraft in a graphical pane.
- Dynamic collision warning system with visual and textual alerts.
- Configurable number of aircraft and collision parameters.

## Installation

### Prerequisites
- Java JDK 11 or later.
- JavaFX SDK (version matching your JDK).

### Steps
1. Clone this repository:
   ```sh
   git clone https://github.com/msk10029/Aircraft_Collision_and_Avoidance_System.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Aircraft_Collision_and_Avoidance_System
   ```
3. Set up JavaFX SDK:
   - Download the JavaFX SDK and add it to your project dependencies in your IDE (IntelliJ, Eclipse, or VSCode).

4. Run the application:
   - Open `App.java` in your IDE and run it to start the simulation.

## Usage
- **Start** the simulation by clicking the Start button.
- **Stop** the simulation by clicking the Stop button.
- **Collision Warnings**: When two aircraft are in danger of colliding, the system changes the color of the aircraft to red and displays a warning message in the message box.

## Configuration
You can adjust certain parameters in `Controller.java` or other configuration files:
- **Number of Aircraft**: Modify the number of aircraft generated in the simulation.
- **Collision Radius**: Adjust the collision radius for each aircraft.
- **Simulation Speed**: Modify the update interval for smoother or faster animations.

## Building and Packaging
To package the application as a standalone executable, you can use `jpackage`:

```sh
jpackage --type exe     --input path/to/libs     --name AircraftCollisionDetection     --main-jar YourApp.jar     --main-class com.example.MainApp     --icon path/to/icon.ico     --module-path path/to/javafx-sdk/lib     --add-modules javafx.controls,javafx.fxml     --output path/to/output
```

Replace the paths with the actual paths for your project files and JavaFX SDK.

## Contributing
Contributions are welcome! If you’d like to contribute to ACAS, please:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Submit a pull request.

Please make sure to document any changes you make and test thoroughly.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or suggestions, please reach out to [msk10029@gmail.com].
