package Task8.matrix;

import java.io.File;
import java.util.List;

public class Main {
    private static final Validator matrixValidator = new Validator();

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new File("src/main/resources/matrix/matrix.txt"));
        Solver solver = new Solver(matrixValidator);
        List<Double> res = solver.solve(matrix);
        if(res!= null){
            System.out.println(res);
        }
    }
}
