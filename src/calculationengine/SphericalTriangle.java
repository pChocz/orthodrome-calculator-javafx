package calculationengine;

import gui.Controller;

import static util.Converter.toDegrees;
import static util.Converter.toRadians;

public class SphericalTriangle extends Controller {

    //input
    private Point aPoint;
    private Point bPoint;
    private CASE caseType;

    //output
    public double a;
    public double b;
    public double d;
    public double A;
    public double B;
    public double C;
    private double aRadians;
    private double bRadians;
    private double CRadians;

    public SphericalTriangle(Point startPoint, Point endPoint, CASE caseType) {
        this.aPoint = startPoint;
        this.bPoint = endPoint;
        this.caseType = caseType;

        calculateSphericalTriangle();
    }

    private void calculateSphericalTriangle() {
        this.a = 90 - bPoint.phi;
        this.aRadians = toRadians(a);

        this.b = 90 - aPoint.phi;
        this.bRadians = toRadians(b);

        this.C = calculateC();
        this.CRadians = toRadians(C);

        this.A = calculateA();

        this.B = calculateB();

        this.d = calculateOrthodrome();

        if (!caseType.equals(Controller.CASE.GENERAL)) {
            verifySpecialCasesSphericalTriangle();
        }
    }

    private double calculateC() {
        double C = Math.abs(bPoint.lambda - aPoint.lambda);
        return (C <= 180) ? (C) : (360 - C);
    }

    private double calculateA() {
        double orthodromeRadians = Math.acos(Math.cos(aRadians) * Math.cos(bRadians) + Math.sin(aRadians) * Math.sin(bRadians) * Math.cos(CRadians));
        return (toDegrees(Math.acos((Math.cos(aRadians) - Math.cos(bRadians) * Math.cos(orthodromeRadians)) / (Math.sin(bRadians) * Math.sin(orthodromeRadians)))));
    }

    private double calculateB() {
        double orthodromeRadians = Math.acos(Math.cos(aRadians) * Math.cos(bRadians) + Math.sin(aRadians) * Math.sin(bRadians) * Math.cos(CRadians));
        return toDegrees(Math.acos((Math.cos(bRadians) - Math.cos(aRadians) * Math.cos(orthodromeRadians)) / (Math.sin(aRadians) * Math.sin(orthodromeRadians))));
    }

    private double calculateOrthodrome() {
        return toDegrees(Math.acos(Math.cos(aRadians) * Math.cos(bRadians) + Math.sin(aRadians) * Math.sin(bRadians) * Math.cos(CRadians)));
    }


    private void verifySpecialCasesSphericalTriangle() {
        if (caseType == Controller.CASE.MERIDIAN_SAIL || caseType == Controller.CASE.OPPOSITE_POINTS) {
            this.A = 999;
            this.B = 999;
        }
    }

}
