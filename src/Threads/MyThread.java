import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by donald on 14.04.16.
 */
public class MyThread extends Thread{
    String[] arrStr;
    Monitor monitor;
    String[] finalArr;
    int wordCnt;
    String outputFile;

    public MyThread( String[] array, Monitor monitor ) throws Exception{
        this.monitor = monitor;
        arrStr = array;

    }

    public void run(){

        arrStr = bubbleSort(arrStr);

        String [] fraAnnetTrad = monitor.addArray(arrStr);

        while (fraAnnetTrad!=null) {
            arrStr = merge(arrStr, fraAnnetTrad);
            fraAnnetTrad = monitor.addArray(arrStr);
        }

        //print();
    }

    public String[] bubbleSort( String[] strArr ){

        for( String s: strArr ){
            for( int i=0; i<strArr.length-1; i++ ) {

                String current = strArr[i];
                String previous = strArr[i + 1];

                // Swap if
                if( current.compareToIgnoreCase( previous ) > 0 ){
                    String backup = strArr[i];
                    strArr[i] = strArr[i+1];
                    strArr[i+1] = backup;
                }
            }
        }
        return strArr;
    }

    // Merge two pre-sorted arrays
    public String[] merge(String[] a1, String[] a2) {
			/*
				Merging of two pre-sorted (required) arrays.
			*/

        // Result
        finalArr  = new String[(a1.length + a2.length)];

        for (int i = 0, j = 0, l = 0; i < a1.length || j < a2.length; l++){
            if (j == a2.length || (i != a1.length && a1[i].compareTo(a2[j]) <= 0)) {
                finalArr[l] = a1[i++];
            }
            else {
                finalArr[l] = a2[j++];
            }
        }

        // Return merged (pre-sorted) arrays, in one combined array
        return finalArr;
    }

    public void print(){

        for( String s: monitor.getArray() ){
            System.out.print( " "+ s +" " );
        }
        System.out.println();
    }

    // Write output file
    private void writeToFile(String[] result) {

        // Write result to output file
        System.out.println(" - Writing output file...");

        try {
            if ((result.length == this.wordCnt) && (result[(result.length - 1)] != null)) {
                PrintWriter file = new PrintWriter(new FileWriter(outputFile));

                for (String s : result)
                    file.println(s);

                file.close();

                System.out.println("  > Wrote " + result.length + " strings to file!");
            }
            else {
                System.out.println("- Word count mismatch in result!");
            }
        }
        catch (IOException e) {
            System.out.println("- Could not write to output file!");
        }

        System.out.println();
    }
}