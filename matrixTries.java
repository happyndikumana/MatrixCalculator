import java.util.Scanner;
import java.util.Arrays;
/**
 * Happy Ndikumana
 * @author happyndikumana
 */
public class matrixTries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int[][] trying = {{3,2,3},{4,5,6}};
        int[] temp = new int[3];

        temp = trying[0];


        System.out.println("Column size = "+trying[0].length+"\n");
        System.out.println("Row size = "+trying.length+"\n");


    }
    
    public static double determinant( double[][] matriceNumbers ){
        double factor = 1;
        double[] temp = new double[matriceNumbers.length];
        double detB = 1;
        double determinant;
        int columns = matriceNumbers[0].length, rows = matriceNumbers.length;

        for ( int j = 0; j < columns; j++ ){
            for ( int k = 0; k < rows;k++ ){
                boolean decider = true;
                if ( j == k ){
                    while ( decider ){
                        if ( matriceNumbers[k][j] != 1 && matriceNumbers[k][j] != 0 ){
                            //then divide the whole row by matriceNumbers[k][j]
                            for ( int g = j; j < columns; g++ ){
                                matriceNumbers[k][g] = matriceNumbers[k][g] / matriceNumbers[k][j];
                            }
                            detB = detB * matriceNumbers[k][j];
                            factor = factor * (1/matriceNumbers[k][j]);
                            decider = false;
                        }
                        else if ( matriceNumbers[k][j] == 0 && k < rows ){
                            //then switch the whole row by the row under it.
                            temp = matriceNumbers[k];
                            matriceNumbers[k] = matriceNumbers[k+1];
                            matriceNumbers[k+1] = temp;
                            factor = (-1) * factor;
                        }
                    }
                }
                else if (k > j){
                    if ( matriceNumbers[k][j] != 0 ){
                        //then divide the whole row by matriceNumbers[k][j].
                        for ( int d = j; d < columns; d++ ){
                            matriceNumbers[k][d] = matriceNumbers[k][d]/matriceNumbers[k][j];
                            factor = factor * (1/matriceNumbers[k][j]);
                        }
                        for ( int h = j; h < columns; h++ ){
                            matriceNumbers[k][h] = - matriceNumbers[k][h] + matriceNumbers[k-1][h];
                        }

                    }
                }
            }
        }
        determinant = detB * factor;
        return determinant;
    }
}