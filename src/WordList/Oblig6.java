package WordList;

public class Oblig6 {
    
    public static void main( String args[] ) throws Exception{
        
        Ordliste ol = new Ordliste();
        ol.lesBok("scarlet.text");
        
        // a) Hvor mange ulike ord forekommer i boken?
        System.out.println("Ulike ord:");
        System.out.println( ol.antallOrd() );
        System.out.println("Alle ord:");
        System.out.println( ol.antallAlleOrd() );
        
        
        // b) Hvor mange ganger forekommer ordet Holmes?
        System.out.println("Ordet Holmes forekommer "+ol.forekommerEttOrd("Holmes")+" ganger");
        
        
        // c) Hvor mange ganger forekommer ordet elementary?
        System.out.println("Ordet elementary forekommer "+ol.forekommerEttOrd("elementary")+" ganger");
        
        
        // d) Hvilket ord forekommer flest ganger?
        System.out.println("Ordet "+ol.vanligste().toString()+" forekommer flest ganger");
    }
}
