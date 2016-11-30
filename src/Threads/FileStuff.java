package Threads;

import java.io.File;
import java.util.Scanner;

public class FileStuff{

    String[] finalArray;

    String[] strArr;
    int size;

    public FileStuff( String filename ) throws Exception{



        Scanner file = new Scanner( new File( filename ) );

        size = Integer.parseInt( file.nextLine() );
        strArr = new String[size];
        finalArray = new String[size];

        int count = 0;

        while( file.hasNext() ){
            strArr[count] = file.nextLine();
            count++;
        }
    }

    public String[] getDataArray(){
        return strArr;
    }

    public void setFinalArray( String[] finalArray ){
        this.finalArray = finalArray;
    }

    public void writeTFile( String outputfileName ){


        // finalarray is accessible here
    }

}