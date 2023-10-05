package adaptor;
public class LegacyRectangle {
    private double sideA;
    private double sideB;

    public LegacyRectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double calculateArea(){
        return sideA * sideB;
    }
    public double calculatePerimeter(){
        return (sideA+sideB) * 2;
    }

}
