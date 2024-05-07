package Task1;

public class Point {
    private double x;
    private double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void rotateAroundPoint(Point rotationCenter, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        double translatedX = getX() - rotationCenter.getX();
        double translatedY = getY() - rotationCenter.getY();

        double rotatedX = translatedX * cos - translatedY * sin;
        double rotatedY = translatedX * sin + translatedY * cos;

        this.x = rotatedX + rotationCenter.getX();
        this.y = rotatedY + rotationCenter.getY();
    }
}
