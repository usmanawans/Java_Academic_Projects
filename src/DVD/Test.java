package DVD;

public class Test {
    
    public static void main( String[] args ) throws Exception{
        
        DVDAdmin admin = new DVDAdmin();
        
        // Keeps printing menu until 7 pressed.
        while( admin.visMeny() ){}
    }
}
