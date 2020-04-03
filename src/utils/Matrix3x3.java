package utils;

public class Matrix3x3 {
    private double[][] matrix;

    public Matrix3x3() {
        this.matrix = new double[3][3];
    }

    public static Matrix3x3 rotationX(double angle) {
        double rad = Math.toRadians(angle);
        Matrix3x3 m = new Matrix3x3();

        m.matrix[0][0] = 1;
        m.matrix[1][1] = Math.cos(rad);
        m.matrix[1][2] = -Math.sin(rad);
        m.matrix[2][1] = Math.sin(rad);
        m.matrix[2][2] = Math.cos(rad);

        return m;
    }

    public static Matrix3x3 rotationY(double angle) {
        double rad = Math.toRadians(angle);
        Matrix3x3 m = new Matrix3x3();

        m.matrix[0][0] = Math.cos(rad);
        m.matrix[0][2] = Math.sin(rad);
        m.matrix[1][1] = 1;
        m.matrix[2][0] = -Math.sin(rad);
        m.matrix[2][2] = Math.cos(rad);

        return m;
    }

    public static Matrix3x3 rotationZ(double angle) {
        double rad = Math.toRadians(angle);
        Matrix3x3 m = new Matrix3x3();

        m.matrix[0][0] = Math.cos(rad);
        m.matrix[0][1] = -Math.sin(rad);
        m.matrix[1][0] = Math.sin(rad);
        m.matrix[1][1] = Math.cos(rad);
        m.matrix[2][2] = 1;

        return m;
    }

    public Vector3 mult(Vector3 v) {
        Vector3 res = new Vector3(0,0,0);

        res.setX(v.getX() * this.matrix[0][0] + v.getY() * this.matrix[0][1] + v.getZ() * this.matrix[0][2]);
        res.setY(v.getX() * this.matrix[1][0] + v.getY() * this.matrix[1][1] + v.getZ() * this.matrix[1][2]);
        res.setZ(v.getX() * this.matrix[2][0] + v.getY() * this.matrix[2][1] + v.getZ() * this.matrix[2][2]);

        return res;
    }
}
