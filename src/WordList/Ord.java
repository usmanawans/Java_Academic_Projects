// Deloppgave 6.1
package WordList;

public class Ord {
    
    private String ordet;
    private int antall = 1;  // Fordi alle objekterr starter med en constructor
    
    public Ord( String tekst ){
        ordet = tekst;
    }
    
    public String toString(){
        return ordet;
    }
    
    public int hentAntall(){    
        return antall;
    }
    
    public void oekAntall(){
        antall++;
    }
}
