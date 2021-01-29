package edu.ib;

// badamy zachowanie się cząstki
public class VerletIntegrator {
    private CalculateAcceleration calc;
    private ODEUpdate stepper;

    // jakie równanie różniczkowe, jaki stepper
    public VerletIntegrator(CalculateAcceleration calc, ODEUpdate stepper) {
        this.calc = calc;
        this.stepper = stepper;
    }

    // zastosowanie skali w celu poprawnego wyświetlenia na ekranie
    public void integrate(double t0, double tEnd, double x0, double v0, double dt, int scaleT, int scaleX) {
        int n = (int) ((tEnd - t0) / dt);
        double x = x0;
        double v = v0;
        double t = t0;
        double vHalf;
        double aOld = calc.a(x);

        for (int i = 0; i < n; i++) {
            // zastosowanie przesunięcia wartości w celu poprawnego wyświetlenia na ekranie
            stepper.update(t * scaleT, -x * scaleX + 500, v);

            // algorytm Verleta
            vHalf = v + dt * aOld / 2;
            x = x + dt * vHalf;
            double aNew = calc.a(x);
            // v = vHalf + dt * calc.a(x) / 2;
            v += dt * (aOld + aNew) / 2;
            t += dt;
            aOld = aNew;
        }
    }
}
