import java.util.Arrays;

public class matrix {

    public static int maxMatrix(int[][] matrix) {
        int max = matrix[0][0];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                if (matrix[j][i] > max) {

                    max = matrix[j][i];
                }
            }
        }
        return max;
    }

    public static void fill (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

    }


    public static void main(String[] args) {

        int[][] matrix = new int[10][10];
        fill(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(maxMatrix(matrix));

    }
}



