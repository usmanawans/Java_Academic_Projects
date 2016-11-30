// Deloppgave 6.2

package WordList;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Ordliste {
    
    ArrayList<String> heleboka = new ArrayList<String>();
    ArrayList<Ord> ordliste = new ArrayList<Ord>();
    Ord ord;
    

    public static void Ordliste(){ 
        // tom
    }
    
    // Leser heleboka forst
    public void lesBok( String filnavn )throws Exception {
        
        //Scanner tellerOrd = new Scanner( new File( filnavn ) );
        Scanner fil = new Scanner( new File( filnavn ) );
        
        // Leser hele boka forst så hvert ord kommer på hver linje uansett ganger
        while( fil.hasNextLine() ){
            heleboka.add( fil.nextLine() );
        }
        
        // skriver nytt ord i liste
        // ord-oeker antall forekommer i finnOrd metode
        for( int i=0; i<heleboka.size(); i++ ){
            leggTilOrd( heleboka.get(i).toLowerCase() );
        }
    }
    
    private void leggTilOrd( String ord ){
        
        if( finnOrd( ord ) == null ){
            this.ord = new Ord( ord );
            ordliste.add( this.ord );
        }
        else{
            for( int i=0; i<ordliste.size(); i++ ){
                if (ordliste.get(i).toString().equals( ord ) ){
                    ordliste.get(i).oekAntall();
                }
            }
        }
    }
    
    // finner ord i liste
    public Ord finnOrd( String tekst ){
                
        Ord lokalOrd = null;
        
        for ( int i=0; i<ordliste.size(); i++ ) {
            if (ordliste.get(i).toString().equals(tekst.toLowerCase())) {
                lokalOrd = new Ord( tekst );    // for returverdi Ord-type
            } 
        }
        
        return lokalOrd;
    }
    
    public int antallOrd(){
        return ordliste.size();
    }
    
    public int antallAlleOrd(){
        return heleboka.size();
    }
    
    public Ord vanligste(){
        
        int maks = 0, indeks = 0;
        ArrayList<Ord> listeKopi = ordliste;
        
        for( int i=0; i<listeKopi.size(); i++ ){
            if( listeKopi.get(i).hentAntall() >= maks ){
                maks = listeKopi.get(i).hentAntall();
                indeks = i;
            }
        } 
        
        return ordliste.get( indeks );
    }
    
    public int forekommerEttOrd( String sokOrd ){
        int forekommer = 0;
        
        for( int i=0; i<ordliste.size(); i++ ){
            
            if( ordliste.get(i).toString().equals( sokOrd.toLowerCase() ) )
                   forekommer = ordliste.get(i).hentAntall();
        }
        return forekommer;
    }
}
