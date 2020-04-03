package utils;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(String lat, String lo, String alt) {
        double latAngle = Double.parseDouble(lat);
        double loAngle = Double.parseDouble(lo);
        double altDouble = Double.parseDouble(alt);

        Vector3 base = new Vector3(1,0,0);

        Matrix3x3 rotY = Matrix3x3.rotationY(latAngle);
        Matrix3x3 rotZ = Matrix3x3.rotationZ(loAngle);

        base = rotY.mult(base);
        base = rotZ.mult(base);

        altDouble += (6371 * 1000);

        base.mult(altDouble);

        this.x = base.x;
        this.y = base.y;
        this.z = base.z;
    }

    public void mult(double times) {
        this.x *= times;
        this.y *= times;
        this.y *= times;
    }

    public void rotate(double x, double y, double z) {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toLevel3Out() {
        return this.x + " " + this.y + " " + this.z;
    }
}
