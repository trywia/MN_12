package edu.ib;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Animation extends Application {
    @Override
    public void start(Stage stage) {
        // tworzenie danych do ruchu cząstki
        ConsoleStepper stepperT3 = new ConsoleStepper();
        VerletIntegrator verletIntegrator = new VerletIntegrator((x) -> 24 * ((2 / Math.pow(x, 13)) - (1 / Math.pow(x, 7))), stepperT3);

        verletIntegrator.integrate(0, 5, 2, 0, 0.01, 120, 200);
        stepperT3.getT_X(10);
        stepperT3.getT_V(10);

        // cząsteczki
        Circle particleSmall = new Circle();
        Circle particleBig = new Circle();

        // pozycje cząsteczek
        particleBig.setCenterX(300);
        particleBig.setCenterY(600);

        // rozmiar cząsteczek
        particleSmall.setRadius(25.0);
        particleBig.setRadius(200);

        // kolor cząsteczek
        particleSmall.setFill(Color.BROWN);
        particleBig.setFill(Color.GRAY);

        // trasa mniejszej cząsteczki
        PathTransition pathTransition = new PathTransition();

        // czas trwania animacji 5 sekund
        pathTransition.setDuration(Duration.millis(5000));

        pathTransition.setNode(particleSmall);

        // wyznaczenie trasy
        pathTransition.setPath(stepperT3.getPathX());

        // orientacja trasy
        pathTransition.setOrientation(
                PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        // ilość powtarzania animacji
        pathTransition.setCycleCount(10);

        // powtórzenie animacji
        pathTransition.setAutoReverse(false);

        // start animacji
        pathTransition.play();

        // wyświetlenie obu obiektów i wyświetlenie
        Pane pane = new Pane();
        pane.getChildren().add(particleSmall);
        pane.getChildren().add(particleBig);
        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Movement of a particle - Van der Waals force");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}