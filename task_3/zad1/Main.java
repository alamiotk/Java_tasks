package zad1;

public class Main {

    public static void main(String[] args){
        int rows=3, columns=3;

        Matrix<Integer> matrix_I1 = new Matrix<Integer>(rows,columns);
        Matrix<Integer> matrix_I2 = new Matrix<Integer>(rows,columns);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix_I1.setNode(i, j, i*j);
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix_I2.setNode(i, j, 2*i+j);
            }
        }
        matrix_I1.print();
        matrix_I2.print();

        matrix_I1.addMatrix(matrix_I2);
        matrix_I1.print();

        Matrix<String> matrix_S1 = new Matrix<String>(rows,columns);
        Matrix<String> matrix_S2 = new Matrix<String>(rows,columns);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix_S1.setNode(i, j, String.format("java%d", i*j));
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix_S2.setNode(i, j, String.format("java%d", i+j));
            }
        }

        matrix_S1.print();
        matrix_S2.print();

        matrix_S1.addMatrix(matrix_S2);
        matrix_S1.print();


    }


}
