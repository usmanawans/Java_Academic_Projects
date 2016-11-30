import java.io.File;

/**
 * Created on 14.04.16.
 */
public class Test {

    public static void main(String[] args) throws Exception {


        // Taking compand line inputs
        int threadCount = Integer.parseInt( args[0] );
        String inputFileName = args[1];
        String outputFileName = args[2];


        // Testing is command line inputs are fulling requirements
        try{
            testParameters( threadCount , inputFileName );
        }catch( MyExceptions e ){
            e.printStackTrace();
        }


        // This class reads file, and return Raw String Array
        FileStuff fileRawData = new FileStuff( inputFileName );
        String[] rawDataArray = fileRawData.getDataArray();
        int totalWords = fileRawData.getDataArray().length;

        Monitor monitor = new Monitor();
        MyThread[] threads = new MyThread[threadCount];

        

        for( int i=0; i<threadCount; i++ ){
            threads[i] = new MyThread( fileRawData.getDataArray(), monitor );
        }

        for( int i=0; i<threadCount; i++ ){
            threads[i].start();
        }

        

        for( int i=0; i<threadCount; i++ ){
            threads[i].join();
        }
        
        threads[threadCount-1].print();


    }
    public static void testParameters(int threadCount, String inputFileName) throws MyExceptions {

        File file = new File(inputFileName);

        if (threadCount <= 0)
            throw new MyExceptions("Number of threads are invalid");


        if (!file.exists())
            throw new MyExceptions("File does not exist");
    }
}