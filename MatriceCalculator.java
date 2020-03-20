 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package matricecalculator;

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
                
                minors ( matriceNumbers );
                //Permutated( matriceNumbers );
//                determinant = determinant( matriceNumbers, dimension );
//                if ( determinant == 0 ){
//                    System.out.println("Your matrix has no inverse. Its determinant = "+determinant);
//                }
//                System.out.println("Determinant = "+determinant);
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
                Transposed( matriceNumbers );
                System.out.println("your Transposed matrix is: \n");
                matricePrint( matriceNumbers );
                
                break;
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
    public static double[][] Transposed( double[][] matriceNumbers ){
        
        double temp;
        for ( int i = 0; i < matriceNumbers.length; i++ )
            for ( int j = 0; j < matriceNumbers[i].length; j++ )
            {
               temp =  matriceNumbers[i][j];
               matriceNumbers[i][j] = matriceNumbers[j][i];
               matriceNumbers[j][i] = temp;
            }
        return matriceNumbers;
    }
    public static double determinant( double[][] matriceNumbers,int dimension ){
    
        double determinant;
        //Putting matrice into a temporary mtrice and then adding the first two colums at the end
        if ( matriceNumbers.length == 2 )
        {
            //matricePrint( matriceNumbers );
            double productRight = matriceNumbers[0][0]*matriceNumbers[1][1];
            double productLeft =  matriceNumbers[0][1]*matriceNumbers[1][0];
            determinant = productRight - productLeft;
            return determinant;
        }
        else{
            double[][] tempMatriceNumbers = new double[dimension][dimension+2];
            String[][] stringTempMatriceNumbers = new String[dimension][dimension+2];

            for ( int x = 0; x < matriceNumbers.length; x++ )
                for ( int h = 0; h < matriceNumbers[x].length; h++ )
                    tempMatriceNumbers[x][h] = matriceNumbers[x][h];

            for ( int k = 0; k < tempMatriceNumbers.length; k++ )
                for ( int n = 0; n <(tempMatriceNumbers[k].length - dimension); n++ )
                    tempMatriceNumbers[k][dimension+n] = matriceNumbers[k][n];

            //matricePrint( tempMatriceNumbers );

            //Calculating the diagonal sums towards the right

            double productRight = 1;
            double sumRight = 0;

           boolean decider = true;
           int j = 0;
           int i = 0;
           int c = 1;
           while ( decider ){
               productRight = tempMatriceNumbers[i][j]*productRight;
               i++; 
               j++;
               if ( i == (tempMatriceNumbers.length ) ){
                   i = 0; j = i+c;
                   c++;
                   sumRight = productRight + sumRight;
                   productRight = 1;
                   if(j == 3){
                       break;
                   }
               }
           }
           // System.out.println("Sum from right: "+sumRight);

            //calculating the diagonal sums towards the left

            double productLeft = 1;
            double sumLeft = 0;

            int d = 0;
            int initial = tempMatriceNumbers[0].length - 1;
            int y = initial;
            int s = -1;

            while ( decider ){
               productLeft = tempMatriceNumbers[d][y]*productLeft;
               d++; 
               y--;
               if ( d == (tempMatriceNumbers.length ) ){
                   d = 0; y = initial+s;
                   s--;
                   sumLeft = productLeft + sumLeft;
                   productLeft = 1;
                   if(y == (initial - 3)){
                       break;
                   }
               }
           }
            //System.out.println("Sum from Left: "+sumLeft);

            determinant = sumRight - sumLeft;


            return determinant;
        }
    }
    public static double[][] Permutated( double[][] matriceNumbers ){
        
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
    public static void minors(double[][] matriceNumbers){
        
//        double[][] tempMatriceNumbers = new double[matriceNumbers.length][matriceNumbers.length];
//        for ( int i = 0; i<tempMatriceNumbers.length; i++ )
//            for ( int j = 0; j<tempMatriceNumbers[i].length; j++ ){
//                tempMatriceNumbers[i][j] = matriceNumbers[i][j];
//            }
//        double temp;
//        int dimension;
//        for ( int m = 0; m<tempMatriceNumbers.length; m++ )
//            for ( int z = 0; z<tempMatriceNumbers[m].length; z++ ){
//                
//                for ( int k = 1; k<tempMatriceNumbers.length; k++ ){
//                    double[][] inLoopMatrice = new double[tempMatriceNumbers.length - 1][tempMatriceNumbers.length - 1];
//                    dimension = inLoopMatrice.length;
//                    if ( ((tempMatriceNumbers.length - 1)> 3) ){
//                        minors( inLoopMatrice );
//                    }
//                    else
//                    {
//                        temp = determinant ( inLoopMatrice, dimension );
//                    }
//        }
//            
//        }

        matricePrint ( matriceNumbers );
        
        int dimension = matriceNumbers.length;
        int bigMatriceDimension = matriceNumbers.length + (matriceNumbers.length - 1);  
        double [][] bigMatriceNumbers = new double [bigMatriceDimension][bigMatriceDimension];
          
        //making matrice into a bigger matrice so I can easily find the minors' determinant easily.
        for ( int x = 0; x < matriceNumbers.length; x++ )
            for ( int h = 0; h < matriceNumbers[x].length; h++ )
                bigMatriceNumbers[x][h] = matriceNumbers[x][h];

        for ( int k = 0; k < bigMatriceNumbers.length - (bigMatriceNumbers.length - dimension); k++ )
            for ( int n = 0; n <(bigMatriceNumbers[k].length - dimension); n++ )
                bigMatriceNumbers[k][dimension+n] = matriceNumbers[k][n];
        
        for ( int f = 0; f < (bigMatriceNumbers.length - dimension); f++ )
            for ( int g = 0; g < bigMatriceNumbers[f].length; g++ )
                bigMatriceNumbers[dimension+f][g] = bigMatriceNumbers[f][g];
        
        matricePrint ( bigMatriceNumbers );
        
        //getting minors of the matrice
        
        double[][] determinantMatrice = new double[matriceNumbers.length][matriceNumbers.length];
        double[][] minorMatrice;
        int minorDimension = determinantMatrice.length - 1;
        double tempDeterminant;
        
        for ( int m = 0; m < determinantMatrice.length; m++ ){
            for ( int z = 0; z < determinantMatrice[m].length; z++ ){
                minorMatrice = new double[minorDimension][minorDimension];
                System.out.println("Minor Matrice at"+m+""+z+" = "+bigMatriceNumbers[m][z]);
                for ( int outside = 0; outside < minorMatrice.length; outside++ )
                    for ( int inside = 0; inside < minorMatrice[outside].length; inside++ ){
                        minorMatrice[outside][inside] = bigMatriceNumbers[m+1][z+1]; 
                        //find a way to make the outside loops work with the inside loops
                        
                        //System.out.println("Minor Matrice at"+outside+""+inside+" = "+minorMatrice[outside][inside]);
                    }
                matricePrint ( minorMatrice );
                System.out.println("");
                if ( minorMatrice.length > 3 ){
                    minors ( minorMatrice );
                }
                tempDeterminant = determinant ( minorMatrice, minorDimension );
                determinantMatrice[m][z] = tempDeterminant;
            }
        }
        
        //matricePrint ( determinantMatrice );
        
        
        
    }
}
