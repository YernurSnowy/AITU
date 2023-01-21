public class Matrix {
    private double[][] array;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns, double[][] array) {
        this.rows = rows;
        this.columns = columns;
        this.array = array;
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Cannot add matrices of different sizes.");
        }

        double[][] result = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result[i][j] = this.array[i][j] + other.array[i][j];
            }
        }

        return new Matrix(this.rows, this.columns, result);
    }

    public Matrix multiply(double scalar) {
        double[][] result = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result[i][j] = this.array[i][j] * scalar;
            }
        }

        return new Matrix(this.rows, this.columns, result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.append(this.array[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Incompatible matrices for multiplication.");
        }

        double[][] result = new double[this.rows][other.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result[i][j] += this.array[i][k] * other.array[k][j];
                }
            }
        }
        return new Matrix(this.rows, this.columns, result);
    }
}
