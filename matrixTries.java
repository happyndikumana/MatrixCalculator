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
    /*
    public static void nothing(double[][] matriceNumbers){
        
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
        for ( int x = 0; x < matriceNumbers.length; x++ ) // copying matrice only in big matrice
            for ( int h = 0; h < matriceNumbers[x].length; h++ )
                bigMatriceNumbers[x][h] = matriceNumbers[x][h];
        // populating the remaining space on the right in big matrice by the starting columns of original matrice
        for ( int k = 0; k < bigMatriceNumbers.length - (bigMatriceNumbers.length - dimension); k++ )// populating the remaining space in
            for ( int n = 0; n <(bigMatriceNumbers[k].length - dimension); n++ )
                bigMatriceNumbers[k][dimension+n] = matriceNumbers[k][n];
        // populating the remaining space on the bottom of big matrice by the starting rows of bigmatrice.
        for ( int f = 0; f < (bigMatriceNumbers.length - dimension); f++ )
            for ( int g = 0; g < bigMatriceNumbers[f].length; g++ )
                bigMatriceNumbers[dimension+f][g] = bigMatriceNumbers[f][g];
        
        matricePrint ( bigMatriceNumbers );
        
        //getting minors of the matrice
        
        double[][] determinantMatrice = new double[matriceNumbers.length][matriceNumbers.length]; // filled with determinants of minors
        double[][] minorMatrice;
        int minorDimension = determinantMatrice.length - 1;
        double tempDeterminant;
        
        for ( int m = 0; m < determinantMatrice.length; m++ ){
            for ( int z = 0; z < determinantMatrice[m].length; z++ ){
                minorMatrice = new double[minorDimension][minorDimension];
                //System.out.println("Minor Matrice at"+m+""+z+" = "+bigMatriceNumbers[m][z]);
               
                //System.out.println("temp M = "+tempM+" temp Z = "+tempZ);
                String[][] minorMatriceString = new String[determinantMatrice.length+1][determinantMatrice.length+1];
            for ( int outside = 0; outside < minorMatrice.length; outside++ ){
                for ( int inside = 0; inside < minorMatrice[outside].length; inside++ ){
                        minorMatrice[outside][inside] = bigMatriceNumbers[outside+m+1][inside+z+1];
                        //minorMatriceString[outside][inside] = Double.toString( minorMatrice[outside][inside] );
                        //System.out.println("this the string array: "+minorMatriceString[outside][inside]+" at itireation a"+outside+""+inside);
                        //System.out.println("String Matrice at a"+outside+""+inside);
                        //System.out.println(minorMatriceString[outside+1][inside]+"");
                    }
                    //System.out.println("Before If statement");
                    //matricePrint( minorMatrice );

                        if ( (determinantMatrice.length == 3) && (( minorMatriceString[1][1] != null)|| (minorMatriceString[2][1] != null) || (minorMatriceString[3][1] != null) ) )
                        {
                            //System.out.println("m + 1 = "+(m+1));
                            //System.out.println("before any changes: ");
                            matricePrint (minorMatrice);
                            //System.out.println("this the string array: "+minorMatriceString[m][z]);
                                    if ( ((m+1)%2==0) && ((z+1)%2==0) )
                                    {
                                        minorMatrice = rowSwitch ( minorMatrice );
                                        minorMatrice = columnSwitch ( minorMatrice );
                                        System.out.println("i and j right minor: ");
                                        matricePrint (minorMatrice);
                                        //break;
                                    }
                                    else if ( (m+1)%2==0 ){
                                        minorMatrice = rowSwitch ( minorMatrice );
                                        System.out.println("i right minor: ");
                                        matricePrint (minorMatrice);
                                        // loop1;
                                    }
                                    else if ( (z+1)%2==0 ){
                                        minorMatrice = columnSwitch ( minorMatrice );
                                        System.out.println("j right minor: ");
                                        matricePrint (minorMatrice);
                                        //break loop1;
                                    }
                                
                        }
                }
                //matricePrint ( minorMatrice );
                //int size = minorMatrice.length;
                //double det = determinant ( minorMatrice );
                //System.out.println("determinant = "+det);
                //System.out.println("");
                if ( minorMatrice.length > 3 ){
                    minors ( minorMatrice );
                }
                tempDeterminant = determinant ( minorMatrice);
                //System.out.println("determinant = "+tempDeterminant);
                determinantMatrice[m][z] = tempDeterminant;
            }
        }
        
        System.out.println("Normal:");
        matricePrint ( determinantMatrice );
        
        
        determinantMatrice = permutated ( determinantMatrice );
        
        System.out.println("permutated");
        matricePrint ( determinantMatrice );
        
        determinantMatrice = transposed ( determinantMatrice );
        
        System.out.println("transposed");
        matricePrint ( determinantMatrice );
        
        determinantMatrice = transposed ( determinantMatrice );
        
        //System.out.println("permutated");
        //matricePrint ( determinantMatrice );
        
        
        
    }
    */
    /*
    public static double[][] rowSwitch(double[][] matrice){
        for ( int i = 0; i<matrice.length-1;i++ )
            for ( int j = 0; j<matrice[i].length;j++ ){
                double temp = matrice[i][j];
                matrice[i][j] = matrice[i+1][j];
                matrice[i+1][j] = temp;
            }
        //matricePrint ( matrice );
        return matrice;
    }//works fine
    public static double[][] columnSwitch(double[][] matrice){
        
        for ( int i = 0; i<matrice.length;i++ )
            for ( int j = 0; j<matrice[i].length-1;j++ ){
                double temp = matrice[i][j];
                matrice[i][j] = matrice[i][j+1];
                matrice[i][j+1] = temp;
            }
        //matricePrint ( matrice );
        return matrice;
    }//works fine
    */
    /*
    public static double determinant( double[][] matriceNumbers ){
        
        double factor = 1;
        double[] temp = new double[matriceNumbers.length];
        double[] tempWithOne = new double[matriceNumbers.length];
        //double detB = 1;
        double firstEntry;
        double determinant;
        int columns = matriceNumbers[0].length, rows = matriceNumbers.length;
        //int m = 1;

        for ( int j = 0; j < columns; j++ ){
            for ( int k = 0; k < rows;k++ ){
                if ( j == k ){
                    boolean decider = true;
                    while (decider){
                        if ( matriceNumbers[k][j] == 0 && (k < rows - 1) ){
                            //then bubble sort and bring the 0 to the bottom of the matrix
                            for (int m = k; m < rows - 1;m++){
                                for (int n = k; n < rows - 1 - m; n++ ){
                                    System.out.println("m = "+m+" n = "+n);
                                    int comp = compare ( matriceNumbers[n],matriceNumbers[n+1] );
                                    if ( comp == 1 ){ // n < n+1
                                        temp = matriceNumbers[n];
                                        matriceNumbers[n] = matriceNumbers[n+1];
                                        matriceNumbers[n+1] = temp;
                                        factor = factor*(-1); //after switching, multiply a variable by -1 and save it.
                                        System.out.println("After iteration m = "+m+" n = "+n);
                                        matricePrint(matriceNumbers);

                                    }
                                }
                            }
                        }
                        else {
                            firstEntry = matriceNumbers[k][j];
                            for ( int g = 0; g < columns; g++ ){
                                matriceNumbers[k][g] = matriceNumbers[k][g] / firstEntry; //dividing the whole row by number
                            }
                            tempWithOne = matriceNumbers[k];
                            //detB = detB * matriceNumbers[k][j];
                            factor = factor * (firstEntry);
                            decider = false;
                        }
                    }
                }
                        
                else if (k > j){
                    if ( matriceNumbers[k][j] != 0 ){
                        firstEntry = (-1) * matriceNumbers[k][j];
                        for ( int d = 0; d < columns; d++ ){
                            matriceNumbers[k][d] = (firstEntry * tempWithOne[d]) + matriceNumbers[k][d];
                        }
                    }
                }
            }
        }
        determinant = factor;
        return determinant;
    }
    public static int compare(double [] k, double[] kPlusOne){

        int decision = 0; // 0 = equal; 1 = k is bigger than k+1;
        int h = 0;

        while ( h < k.length ) {
                if ( k[h] == kPlusOne[h] ){
                        h++;
                        decision = 0;
                }
                else if (k[h] < kPlusOne[h]){
                        decision  = 1;
                        break;
                }
                else {
                        decision = 0;
                        break;
                }
                //System.out.println("Decisions = "+decision);
        }
        return decision;
}
    */
    /*
    public static double[][] inverse(double[][] matrice){
        double[][] inverseMatrice = new double[matrice.length][matrice.length];
        double determinantOfMatrice = determinant (matrice);
        double[][] adjointOfMatrice = adjoint(matrice);
        
        for ( int i = 0;i < matrice.length;i++ ){
            for ( int j = 0; j < matrice.length;j++ ){
                inverseMatrice[i][j] = (1/determinantOfMatrice) * adjointOfMatrice[i][j];
            }
        }
        return inverseMatrice;
    }*/
/*
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
        else
        {
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
    */

