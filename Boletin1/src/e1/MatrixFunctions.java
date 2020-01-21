/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author carlos.tores
 * @author d.s.vega
 *
 */

public class MatrixFunctions {

    // Returns the maximun value of a matrix
    public static int max (int [][] a) {
        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        return max;
     }

    // Returns the sum of the values of a given row
    public static int rowSum (int [][] a , int row ) {
        int sum = 0;
        for (int i = 0; i < a[row].length; i++) {
            sum += a[row][i];
        }
        return sum;
    }

    // Returns the sum of the values of a given column
    public static int columnSum (int [][] a , int column ) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > column) {
                sum += a[i][column];
            }
        }
        return sum;
    }

    // Sums the value of each row and returns the results in an array .
    public static int [] allRowSums (int [][] a) {
        int resultado[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                resultado[i] += a[i][j];
            }
        }
        return resultado;
    }

    // Sums the value of each column and returns the results in an array .
    // If a position does not exist because the array is " ragged " that position
    // is considered a zero value .
    public static int [] allColumnSums(int [][] a) {
        int maxlength = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > maxlength)
                maxlength = a[i].length;
        }
        int [] sums = new int[maxlength];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sums[j] += a[i][j];
            }
        }
        return sums;
    }

    // Checks if an array is "row - magic ", that is , if all its rows have the same
    // sum of all its values .
    public static boolean isRowMagic (int [][] a) {
        int temporal[] = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temporal[1] += a[i][j];
            }
            if ((i > 1) && (temporal[0] != temporal[1])) {
                return false;
            }
            else {
                temporal[0] = temporal[1];
                temporal[1] = 0;
            }
        }
        return true;
    }

    // Checks if an array is " column - magic ", that is , if all its columns have
    // the same sum of all its values .
    public static boolean isColumnMagic (int [][] a) {
        int maxlength = 0;
        int sum = 0;
        boolean magic = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > maxlength){
                maxlength = a[i].length;
            }
        }

        sum = columnSum(a, 0);
        for (int j = 1; j < maxlength; j++) {
            magic = (columnSum(a, j) == sum);
            if (!magic){return magic;}
        }

        return magic;
    }

    // Checks that a matrix is square , that is , it has the same number of rows
    // as columns and all rows have the same length .
    public static boolean isSquare (int [][] a) {
        for (int i = 0; i < a.length; i++) {
            if( a.length != a[i].length)
                return false;
        }
        return true;
    }

    // Check if the matrix is a magic square . A matrix is magic square if it is
    // square , all the rows add up to the same , all the columns add up to the
    // same and the two main diagonals add up to the same . Also all these sums
    // are the same .
    public static boolean isMagic (int [][] a ) {
        //Versión mas eficiente
        int sumas[] = new int[4];
        int referencia = 0;
        if (isSquare(a)) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) { //Row and col sums
                    sumas[0] += a[i][j];
                    sumas[1] += a[j][i];
                }
                sumas[2] += a[i][i]; //Diagonals
                sumas[3] += a[a.length - 1 - i][i];
                if (i > 0) {
                    if (!((sumas[0] == referencia) && (sumas[1] == referencia))) //Checks if the sums of rows and cols are equal to the same value
                        return false;
                    else {
                        sumas[0] = 0;
                        sumas[1] = 0;
                    }
                } else //First row sum is the reference for the other sums
                    if (sumas[0] == sumas[1]) {
                        referencia = sumas[0];
                        sumas[0] = 0;
                        sumas[1] = 0;
                    } else
                        return false;
            }
        }
        else
            return false;
        if ((sumas[2] == sumas[3])&&(sumas[2] == referencia)) //Checks if the diagonals also add up to the same value
            return true;
        else
            return false;
    }

    /*
    public static boolean isMagicv2(int [][] a) {
        //Versión menos eficiente
        if (isSquare(a) && isColumnMagic(a) && isRowMagic(a)) {
            int sumas[] = new int[4];
            //Simultaneous sums:
            for (int i = 0; i < a.length; i++) {
                sumas[0] += a[0][i];   //Rows
                sumas[1] += a[i][0];   //Cols
                sumas[2] += a[i][i];   //Main diag Up/Down
                sumas[3] += a[a.length - 1 - i][i]; //Main diag Down/Up
            };
            if ((sumas[0] == sumas[1])&&(sumas[1] == sumas[2])&&(sumas[2]==sumas[3])) {
                return true;
            }
        }
        return false;
    } */

    // Checks if the given matrix forms a sequence , that is , it is square
    // (of order n) and contains all the digits from 1 to n * n, regardless of
    // their order .
    public static boolean isSequence (int [][] a) {
        //Versión más eficiente
            boolean checklist[] = new boolean[a.length*a.length];
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != a.length)
                    return false;
                for (int j = 0; j < a.length; j++) {
                    if ((a[i][j]-1 >= 0) && (checklist[a[i][j]-1] == false)) {
                        checklist[a[i][j]-1] = true;
                    }
                    else
                        return false;
                }
            }
        return true;
    }

    /*
    public static boolean isSequencev2 (int [][] a) {
        //Versión menos eficiente
        boolean tmp = true;
        int i = 0;
        int j = 0;
        if (!isSquare(a)){
            return false;
        }
        int nmax = a.length^2;
        for (int n = 1; n <= nmax; n++) {
            for (i = 0; i < a.length; i++) {
                for (j = 0; j < a[i].length; j++) {
                    if (a[i][j] == n){
                        break;
                    }
                }
                if (a[i][j] == n) {
                    break;
                }
            }
            tmp = tmp & (a[i][j] == n);
            if (!tmp) {
                return false;
            }
        }
        return true;
    } */
}
