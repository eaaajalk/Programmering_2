package adaptor;

public class RectangleAdaptor implements Rectangle{
    LegacyRectangle legacyRectangle;

    public RectangleAdaptor(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }
    @Override
    public double calculatePerimeter() {
        return legacyRectangle.calculatePerimeter();
    }
    @Override
    public double calculateArea() {
        return legacyRectangle.calculateArea();
    }
}
