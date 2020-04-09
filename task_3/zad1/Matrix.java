package zad1;

import javax.lang.model.util.Elements;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Matrix<T> implements Iterable<T> {
    public
    int columns, rows;
    List<ArrayList<T>> content;


    Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.content = new ArrayList<ArrayList<T>>();

        Integer inside = 0;
        for(int i=0; i<rows; i++){
            ArrayList<T> list = new ArrayList<>();
            for(int j=0; j<columns; j++){
                list.add((T)inside);
            }
            content.add(list);
        }
    }


    public void addMatrix(Matrix<T> matrix2) {
        try {
            calculate(matrix2);
            System.out.println("Added: ");
        }
        catch(MyException ex){
            System.out.print("The matrix cannot be added");
        }

    }


    public void calculate (Matrix<T> matrix2) throws MyException {
        if (sizeOk(matrix2) && typeOk(matrix2)) {

            for (int i = 0; i < this.rows; i++) {
                ArrayList<T> var_matrix1 = this.content.get(i);
                ArrayList<T> var_matrix2 = matrix2.content.get(i);
                for (int j = 0; j < this.columns; j++) {
                    if (var_matrix1.get(0) instanceof Integer) {
                        Integer int_data = (Integer) var_matrix1.get(j) + (Integer) var_matrix2.get(j);
                        var_matrix1.set(j, (T) int_data);
                    } else if (var_matrix2.get(0) instanceof String) {
                        String string_data = (String) var_matrix1.get(j) + (String) var_matrix2.get(j);
                        var_matrix1.set(j, (T) string_data);
                    }
                    else {
                        throw new MyException();
                    }
                }
            }
        }

        else {
            throw new MyException();
        }
    }



    boolean sizeOk(Matrix<T> matrix2){
        if(this.rows == matrix2.rows && this.columns == matrix2.columns) {
            return true;
        }
        else {
            return false;
        }
    }

   boolean typeOk(Matrix<T> matrix2){
        if(this.content.get(0).get(0).getClass() == matrix2.content.get(0).get(0).getClass()) {
            return true;
        }
        else {
            return false;
        }
   }



    public void setNode(int row, int columns, T content){                                                // wstawia do macierzy dane odpowiedniego typu
        ArrayList<T> content_list = new ArrayList<>();
        content_list = this.content.get(row);
        content_list.set(columns, content);
    }


    public void print(){
        Iterator<T> iterator = this.iterator();
        int i = 0;
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
            i++;
            if(i == columns) {
                System.out.print("\n");
                i = 0;
            }
        }
        System.out.print("\n");
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            public int pos_x = 0, pos_y = 0;

            @Override
            public boolean hasNext(){
                if(pos_x == -1 && pos_y == -1){
                    return false;
                }
                else{
                    return true;
                }
            }

            @Override
            public T next() {
                T ret_val = null;
                if(pos_x == rows-1 && pos_y == columns-1) {
                    ret_val = content.get(pos_x).get(pos_y);
                    pos_x=-1;
                    pos_y=-1;
                }
                else if(pos_x == rows-1 && pos_y != columns-1){
                    ret_val = content.get(pos_x).get(pos_y);
                    pos_x=0;
                    pos_y++;
                }
                else{
                    ret_val = content.get(pos_x).get(pos_y);
                    pos_x++;
                }
                return ret_val;
            }

            public T getNext(){
                return content.get(pos_x).get(pos_y);
            }
        };
        return iterator;
    }
}
