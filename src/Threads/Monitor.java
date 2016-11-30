package Threads;

class Monitor {
    String [] array;
    boolean available = false;

    public synchronized String[] addArray(String[] array) {
        if (available) {
            available = !available;            
            return this.array;
        } else {
            available = !available;
            this.array = array;
            return null;
        }
    }

    public String[] getArray() {
        return array;
    }
    
    public void print( String[] arr ){

        for( String s: arr ){
            System.out.print( " "+ s +" " );
        }
        System.out.println();
    }
}