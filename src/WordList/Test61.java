package WordList;

public class Test61{
    
    public static void main( String args[] ){
        
        Ord forstOrd = new Ord("have");        
        Ord andreOrd = new Ord("has");
        
        System.out.println("Forste ord: "+forstOrd.toString()+" har antall " +forstOrd.hentAntall());
        System.out.println("Andre ord: "+andreOrd.toString()+" har antall " +andreOrd.hentAntall());
        
        // oeker antall for andre ord
        andreOrd.oekAntall();
        System.out.println("Tester: oeker Antall");        
        System.out.println("Ordet: "+andreOrd.toString()+" har naa antall " +andreOrd.hentAntall());
    
    }
    
}