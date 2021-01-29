package edu.ib;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.ArrayList;

public class ConsoleStepper implements ODEUpdate {
    private ArrayList<Double> tList;
    private ArrayList<Double> xList;
    private ArrayList<Double> vList;
    private MoveTo startX;
    private LineTo lineX;
    private Path pathX = new Path();

    public ConsoleStepper() {
        tList = new ArrayList<>();
        xList = new ArrayList<>();
        vList = new ArrayList<>();
    }

    public Path getPathX() {
        return pathX;
    }

    @Override
    public void update(double t, double x, double v) {
        tList.add(t);
        xList.add(x);
        vList.add(v);
    }

    public void getT_X(int n) {
        startX = new MoveTo(tList.get(0), xList.get(tList.size() - 1)); // dodawanie położenia startowego
        pathX.getElements().add(startX);

        for (int i = 0; i < tList.size(); i = i + n) {
            if (i != 0) {
                lineX = new LineTo(tList.get(i), xList.get(tList.size() - 1 - i)); // dodanie kolejnych położeń
                pathX.getElements().add(lineX);
            }
        }
    }

    public void getT_V(int n) {
        for (int i = 0; i < tList.size(); i = i + n) {
            if (i != 0) {
                System.out.println(tList.get(i) + "\t" + vList.get(i));
            }
        }
    }
}
