/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Arrays;
/**
 * Happy Ndikumana
 * @author happyndikumana
 */
public class MatriceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);
        int userOption, dimension, numberColumns, numberRows, numberOfMatrices;
        double[][] matriceNumbers;
        double[][] tempMatriceNumbers;
        double determinant;
        
        
        System.out.println("Calculation options");
        System.out.println("1: Addition \n2: Substraction\n3: Multiplication\n4: Dot Product\n"
                + "5: Inverse\n6: Transpose");
        System.out.println("Enter one of the options here. (enter an integer):");
        
        userOption = inputUser.nextInt();
        
        switch ( userOption )
        {
            case 1: //Addition. Use loop and only one temp 2D array and save in all the matrices entered depending on how many there are.
            {
                System.out.println("How many matrices are you adding together? Enter and integer: ");
                numberOfMatrices = inputUser.nextInt();
                System.out.println("What are the dimensions of your matrices?: (enter an integer)");
                dimension = inputUser.nextInt();

                matriceNumbers = new double[dimension][dimension];
                System.out.println("Enter your 1st Matrice: ");
                matriceNumbers = numberInsertion( matriceNumbers, inputUser ); //called method for entering numbers
                
                System.out.println("this is the first matrice you entered");
                matricePrint( matriceNumbers ); //called method for printing matrices
                
                System.out.println("");
                tempMatriceNumbers = new double[dimension][dimension];
                for( int i = 2; i <= numberOfMatrices; i++ ){
                    System.out.println("");
                    System.out.println("Enter matrix "+i+": ");
                    tempMatriceNumbers = numberInsertion( tempMatriceNumbers, inputUser );
                    matricePrint( tempMatriceNumbers );
                    addition( matriceNumbers, tempMatriceNumbers );
                }
                System.out.println("");
                System.out.println("The sum is: \n");
                matricePrint( matriceNumbers );
                
                break;
            }
            case 2 : //Substraction
            {
                System.out.println("How many matrices are you Substracting together? Enter and integer: ");
                numberOfMatrices = inputUser.nextInt();
                System.out.println("What are the dimensions of your matrices?: (enter an integer)");
                dimension = inputUser.nextInt();

                matriceNumbers = new double[dimension][dimension];
                matriceNumbers = numberInsertion( matriceNumbers, inputUser ); //called method for entering numbers
                
                System.out.println("this is the first matrice you entered");
                matricePrint( matriceNumbers ); //called method for printing matrices
                
                System.out.println("");
                tempMatriceNumbers = new double[dimension][dimension];
                for( int i = 2; i <= numberOfMatrices; i++ ){
                    System.out.println("");
                    System.out.println("Enter matrix "+i+": ");
                    tempMatriceNumbers = numberInsertion( tempMatriceNumbers, inputUser );
                    matricePrint( tempMatriceNumbers );
                    Substraction( matriceNumbers, tempMatriceNumbers );
                }
                System.out.println("");
                System.out.println("The difference is: \n");
                matricePrint( matriceNumbers );
                
                break;   
            }
            case 3: //multiplication
            {
                System.out.println("Number of Colums: (enter an integer)");
                numberColumns = inputUser.nextInt();
                System.out.println("Number of rows: (enter an integer)");
                numberRows = inputUser.nextInt();

                matriceNumbers = new double[numberRows][numberColumns];
                break;
            }
            case 4: //dot product
            {
                System.out.println("Number of Colums: (enter an integer)");
                numberColumns = inputUser.nextInt();
                System.out.println("Number of rows: (enter an integer)");
                numberRows = inputUser.nextInt();

                matriceNumbers = new double[numberRows][numberColumns];
                break;
            }
            case 5: //Inverse
            {
                System.out.println("What are the dimensions of your matrice?: (enter an integer)");
                dimension = inputUser.nextInt();

                matriceNumbers = new double[dimension][dimension];
                matriceNumbers = numberInsertion( matriceNumbers, inputUser ); //called method for entering numbers
                
                System.out.println("You entered");
                matricePrint ( matriceNumbers );
                double[][] inverseMatrice = inverse ( matriceNumbers );
                boolean choice = true;
                loop1:
                for ( int i = 0; i < inverseMatrice.length;i++ ){
                    for ( int j = 0; j < inverseMatrice.length;j++ ){
                        if ( inverseMatrice[i][j] == 0 ){
                            choice = false;
                        }
                        else {
                            choice = true;
                            break loop1;
                        }
                    }
                        
                }
                if ( choice ){
                System.out.println("\nThe inverse is: ");
                matricePrint( inverseMatrice );
                }
                else{
                    System.out.println("The matrice has no inverse");
                }
                break;
            }
            case 6: //Transpose
            {
                System.out.println("What are the dimensions of your matrice?: (enter an integer)");
                dimension = inputUser.nextInt();

                matriceNumbers = new double[dimension][dimension];
                matriceNumbers = numberInsertion( matriceNumbers, inputUser ); //called method for entering numbers
                
                System.out.println("this is the matrice you entered");
                matricePrint( matriceNumbers ); //called method for printing matrices
                
                System.out.println("");
                transposed( matriceNumbers );
                System.out.println("your Transposed matrix is: \n");
                matricePrint( matriceNumbers );
                
                break;
            }
            case 7:
            {
                System.out.println("What are the dimensions of your matrice?: (enter an integer)");
                dimension = inputUser.nextInt();

                matriceNumbers = new double[dimension][dimension];
                matriceNumbers = numberInsertion( matriceNumbers, inputUser );
                
                System.out.println("this is the matrice you entered");
                matricePrint( matriceNumbers ); //called method for printing matrices
                
                double temp = determinant ( matriceNumbers );
                System.out.println("Determinant = "+temp);
                
//                matriceNumbers = rowSwitch ( matriceNumbers );
//                System.out.println("Row is switched: ");
//                matricePrint ( matriceNumbers );
//                
//                matriceNumbers = columnSwitch ( matriceNumbers );
//                System.out.println("Column is switched: ");
//                matricePrint ( matriceNumbers );
            }
        }
       
    }
    public static double[][] numberInsertion( double[][] matriceNumber, Scanner inputUser ){
        
        for( int i=0; i<matriceNumber.length ; i++ )
            for( int j =0; j<matriceNumber[i].length ; j++ ){
                System.out.println("Enter entry for a"+(i+1)+""+(j+1));
                matriceNumber[i][j] = inputUser.nextDouble();
            }
        return matriceNumber;
    }
    public static void matricePrint( double[][] matriceNumbers ){
        
        for (double[] matriceNumber : matriceNumbers) {
            for (double j : matriceNumber) {
                System.out.print(j + " ");
            }
            System.out.println();
        }    
           
    }
    public static double[][] addition( double[][] matriceNumbers, double [][] tempMatriceNumbers ){
     
        for ( int i = 0; i < matriceNumbers.length; i++ )
            for ( int j = 0; j < matriceNumbers[i].length; j++ )
            {
                matriceNumbers[i][j] = matriceNumbers[i][j] + tempMatriceNumbers[i][j];
            }
        return matriceNumbers;
    }
    public static double[][] Substraction( double[][] matriceNumbers, double [][] tempMatriceNumbers ){
     
        for ( int i = 0; i < matriceNumbers.length; i++ )
            for ( int j = 0; j < matriceNumbers[i].length; j++ )
            {
                matriceNumbers[i][j] = matriceNumbers[i][j] - tempMatriceNumbers[i][j];
            }
        return matriceNumbers;
    }
    public static double[][] transposed( double[][] matriceNumbers ){
        
        int rows = matriceNumbers[0].length;
        int columns = matriceNumbers.length;
        double[][] tempMatrice = new double[matriceNumbers.length][matriceNumbers[0].length];
        
        for ( int f = 0; f<tempMatrice.length;f++ )
            for ( int h = 0;h<tempMatrice[f].length;h++ )
                tempMatrice[f][h] = matriceNumbers[f][h];
        
        for ( int i = 0; i < rows; i++ )
            for ( int j = 0; j < columns; j++ )
            {
               //temp =  matriceNumbers[i][j];
               matriceNumbers[i][j] = tempMatrice[j][i];
               //matriceNumbers[j][i] = temp;
            }
        return matriceNumbers;
    }
    public static double[][] permutated( double[][] matriceNumbers ){
        
        for ( int i = 0; i < matriceNumbers.length; i++  )
            for ( int j = 0; j < matriceNumbers[i].length; j++ )
            {
                if ( ((j+1)% 2 == 0)||((i+1)% 2 == 0) )
                {
                    matriceNumbers[i][j] = matriceNumbers[i][j] *(-1);
                    if ( ((j+1)% 2 == 0)&&((i+1)% 2 == 0) ){
                        matriceNumbers[i][j] = matriceNumbers[i][j] *(-1);
                    }
                }
            };
        return matriceNumbers;
    } 
    public static double[][] cofactors(double[][] matrice){
        int dimension = matrice.length;
        double[][] cofactorMatrice = new double[dimension][dimension];
        double[][] minorMatrice = new double[dimension - 1][dimension - 1];
        
        for ( int i = 0; i < dimension;i++ ){
            for ( int j = 0; j < dimension;j++ ){
                minorMatrice = minor( matrice,i,j );
                cofactorMatrice[i][j] = determinant(minorMatrice);
            }
        }
        //System.out.println("cofactor matrice = ");
        //matricePrint(cofactorMatrice);
        return cofactorMatrice;
    }
    public static double determinant(double[][] matrice){
        double det = 0;
        int permutation = 1;
        if ( matrice.length == 1 ){
            return matrice[0][0];
        }
        double[][] minorMatrice = new double[matrice.length - 1][matrice.length - 1];
        for ( int j = 0; j < matrice.length; j++ ){
            minorMatrice = minor( matrice, 0, j );
            det = det + (permutation * matrice[0][j] * determinant( minorMatrice ));
            permutation = - permutation;
        }
        
        return det;
    }
    public static double[][] minor(double[][] matrice, int row, int column){
        double[][] minorMatrice = new double[matrice.length - 1][matrice.length - 1];
        int d = 0, s = 0;
        for ( int k = 0; k < matrice.length;k++ ){
            for ( int h = 0; h < matrice.length;h++ ){
                if (k != row && h != column){
                    minorMatrice[d][s] = matrice[k][h];
                    s++;
                    if ( s == minorMatrice.length ){
                        s = 0;
                        d++;
                    }
                }
            }
        }
        return minorMatrice;
    }
    public static double[][] adjoint(double[][] matrice){
        double[][] adjointMatrice = new double[matrice.length][matrice.length];
        double[][] cofactorMatrice = new double[matrice.length][matrice.length];
        
        cofactorMatrice = cofactors(matrice);
        adjointMatrice = permutated (cofactorMatrice);
        adjointMatrice = transposed (adjointMatrice);
        
        return adjointMatrice;
    }
    public static double[][] inverse(double[][] matrice){
        double[][] inverseMatrice = new double[matrice.length][matrice.length];
        double determinantOfMatrice = determinant (matrice);
        double[][] adjointOfMatrice = adjoint(matrice);

        if ( determinantOfMatrice  == 0 ){
            //System.out.println("Your matrice has no inverse");
            return inverseMatrice;
        }
        else {
            for ( int i = 0;i < matrice.length;i++ ){
                for ( int j = 0; j < matrice.length;j++ ){
                    inverseMatrice[i][j] = (1/determinantOfMatrice) * adjointOfMatrice[i][j];
                    if ( inverseMatrice[i][j] == - 0 ){
                        inverseMatrice[i][j] = - inverseMatrice[i][j];
                    }
                }
            }
            //System.out.println("The inverse is :");
            //matricePrint ( inverseMatrice );
            return inverseMatrice;
        }    
    }
}