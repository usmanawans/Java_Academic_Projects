package DVD;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.io.PrintWriter;

public class DVDAdmin {
    
    Scanner inn = new Scanner( System.in );
    HashMap <Integer, Person> folk = new HashMap<Integer, Person>();
    Person person;
    
    ////////////////////////////////////////////////////////////////////////////
    public void nyPerson() throws Exception{
        Scanner inn = new Scanner( System.in );
        System.out.println("Hva heter den nye personen?");
        String navn = inn.nextLine().toLowerCase();
        
        if( finnPerson( navn ).equals(-1) )
        {
            person = new Person( navn );
            folk.put( folk.size() + 1, person );
        }
        else
            System.err.println( navn +" er allerde registert");
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////////
    public void kjop()throws Exception{
        //Scanner inn = new Scanner( System.in );
        Integer key;
        System.out.println("Hvem har kjopt DVDen?");
        String kunde = inn.nextLine();
        DVD lokalDVD = new DVD();
        
        // person finnes
        if( !finnPerson( kunde ).equals(-1) ){
            key = finnPerson( kunde );
            
            System.out.println("Hva er tittelen paa DVDen?");
            String tittel = inn.nextLine();
            if( !dvdFinnesAllerede( folk.get(key), tittel ) ){
                lokalDVD.setEier( folk.get(key).getName() );
                lokalDVD.setTittel(tittel);
                
                // DVDen skal oppdateres etter testing
                folk.get(key).oekEierAntall();
                folk.get(key).addDVD(lokalDVD);
            }
            else{
                System.err.println( kunde + " har allerede kjopt " +tittel );
                System.err.println( "Prove paa nytt" ); 
            }
        }        
        else{
            System.err.println("Det finnes ikke noen med navn: " +kunde );
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////////    
    public void laan(){
        
        System.out.println("Hvem vil laane DVDen?");
        String laaner = inn.nextLine();
        Integer nokkel;
        
        if( finnPerson( laaner ) != null )
        {
            System.out.println("Hvem skal DVDen laanes fra?");
            String laanfra = inn.nextLine();
            
            if( !finnPerson( laanfra ).equals(-1) )
            {
                    System.out.println("Hva er tittelen paa DVDen?");
                    String tittelen = inn.nextLine();
                    
                    if( dvdFinnesAllerede( folk.get( finnPerson(laanfra) ), tittelen ) ){
                        nokkel = folk.get( finnPerson(laanfra)).getDVDkeybyTitle(tittelen);
                        
                        // oppdaterer objekt
                        folk.get( finnPerson(laanfra) ).setdvdLaaner(nokkel, laaner);
                        
                        // teller antall
                        folk.get( finnPerson(laanfra) ).oekUtlaantAntall();
                        folk.get( finnPerson(laaner) ).oekLaantAntall();
                        
                        System.out.println( "[Success]: " +laanfra+"s DVD " +tittelen+ " er naa utlaant til " +laaner+ "" );
                    }
                    else
                        System.err.println( "[Feil]: DVD " +tittelen+ " er ikke registert");            }
            else
                System.err.println( "[Feil]: Person " +laanfra + " er ikke registert");
        }
        else
            System.err.println( "[Feil]: Person " +laaner + " er ikke registert");        
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////////
    public void vis(){
        
        System.out.println("Hvilken person vil du se?(* for alle)");
        String navn = inn.nextLine();
        
        if( !navn.equals("*") )
            visDennePersonen( navn );
        else{
            Iterator<Integer> iterate = folk.keySet().iterator();
            while( iterate.hasNext() ){
                Integer key = iterate.next();
                visDennePersonen( folk.get(key).getName() );
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // Method prints indiviudal person details upon giving just name
    ////////////////////////////////////////////////////////////////////////////    
    public void visDennePersonen( String navn ){
        
        if( !finnPerson( navn ).equals(-1) ){
            
            Person person = folk.get( finnPerson(navn) );
            
            // Person eier folgende
            Iterator<Integer> iterate = person.getdvdlist().keySet().iterator();
            if( person.getEierAntall() > 0 ){
                System.out.println( navn+ " eier folgende:");
                while( iterate.hasNext() ){
                    Integer key = iterate.next();
                    System.out.println( (key+1)+". " +person.getdvdtittel(key)+ "");                    
                }
            }
            else
                System.out.println( navn+ " eier ikke noe");
            
            
            // Person laaner bort folgende
            Iterator<Integer> iterate2 = person.getdvdlist().keySet().iterator();
            if( person.getUtlaantAntall() > 0 ){
                System.out.println( navn+ " laaner bort folgende:");
                while( iterate2.hasNext() ){
                    Integer key = iterate2.next();
                    if( person.getdvdLaaner(key) != null ){
                        System.out.println( (key+1)+". " +person.getdvdtittel(key)+ " til " +person.getdvdLaaner(key)); 
                    }                   
                }
            }
            else
                System.out.println( navn+ " laaner ikke bort noe");
            
            
            // Person laaner folgende
            Iterator<Integer> iterate3 = folk.keySet().iterator();
            if( person.getLaantAntall() > 0 ){
                System.out.println( navn+ " laaner folgende:");
                while( iterate3.hasNext() ){
                    Integer key = iterate3.next();
                    Person lokalperson = folk.get(key);
                    
                    Iterator<Integer> innerIterator = lokalperson.getdvdlist().keySet().iterator();
                    while( innerIterator.hasNext() ){
                        Integer innerKey = innerIterator.next();
                        if( lokalperson.getdvdLaaner(innerKey).equals(navn) ){
                        System.out.println( (innerKey+1)+". " +lokalperson.getdvdtittel(innerKey)+ " fra " +lokalperson.getdvdEier(innerKey)); 
                        }  
                    }
                }
            }
            else
                System.out.println( navn+ " laaner ikke noe");
            
        }
        else
            System.err.println("[Feil]: Person "+navn+" er ikke registert.");        
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // Method gives oversikt of all people
    ////////////////////////////////////////////////////////////////////////////
    public void oversikt(){
        
         Iterator<Integer> iterate = folk.keySet().iterator();
         while( iterate.hasNext() ){
                    Integer key = iterate.next();
                    System.out.println( "Person " +folk.get(key).getName()  );
                    System.out.println( "Eier " +folk.get(key).getEierAntall()  );
                    System.out.println( "Laant " +folk.get(key).getLaantAntall()  );
                    System.out.println( "Utlaant " +folk.get(key).getUtlaantAntall()  );
                    System.out.println( "");
                }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // if someone returns DVD back
    ////////////////////////////////////////////////////////////////////////////
    public void retur(){
        
        System.out.println("Hvem skal reture DVDen?");
        String laaner = inn.nextLine();
        String laanfra = "";
        
        if( !finnPerson( laaner ).equals(-1) )
        {
            System.out.println("Hva er tittelen paa DVDen?");
            String tittelen = inn.nextLine();
            
            Iterator<Integer> iterate = folk.keySet().iterator();
            while( iterate.hasNext() ){
            
                Integer key = iterate.next();
                Iterator<Integer> innerIterator = folk.get(key).getdvdlist().keySet().iterator();
                while( innerIterator.hasNext() ){
                    
                    Integer innerKey = innerIterator.next();
                    
                    // fjerning
                     if( folk.get(key).getdvdtittel(innerKey).equals(tittelen) ){
                         laanfra = folk.get(key).getName();
                            
                        // oppdaterer objekt
                        folk.get( finnPerson(laanfra) ).setdvdLaaner(innerKey, null);
                            
                        // teller antall
                        folk.get( finnPerson(laanfra) ).misnkUtlaantAntall();
                        folk.get( finnPerson(laaner) ).minskLaantAntall();
                        }
                    }
                System.out.println( "[Success]: " +laanfra+"s DVD " +tittelen+ " er naa returt" );
            }
        }
        else
            System.err.println( "[Feil]: Person " +laaner + " er ikke registert");        
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // This method will show menu repeatedly
    ////////////////////////////////////////////////////////////////////////////
    public boolean visMeny() throws Exception{
        
        int valg;
        boolean paagaar = true;
        Scanner inn = new Scanner( System.in );
        
        System.out.println("Meny for DVD-ADMINITRASJON");
        System.out.println("1: Ny person");
        System.out.println("2: kjop");
        System.out.println("3: Laan");
        System.out.println("4: Vis");
        System.out.println("5: Oversikt");
        System.out.println("6: Retur");
        System.out.println("7: Avsluttes");
        
        valg = inn.nextInt();
        
        switch( valg ){
            case 1:
                nyPerson();
                break;
                
            case 2:
                kjop();
                break;
                
            case 3:
                laan();
                break;
                
            case 4:
                vis();
                break;
                
            case 5:
                oversikt();
                break;
                
            case 6:
                retur();
                break;
                
            case 7:{
                oppdaterFil( folk, "folk.txt" );
                System.out.println( "[Success]: Filen folk.txt er skrevet ned" );
                paagaar = false;
            }break;
                
            default:
                System.out.println("Prove paa nytt med int type input");
        }
        return paagaar;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // This method will find person's key by giving name
    ////////////////////////////////////////////////////////////////////////////
    public Integer finnPerson( String navn ){
        Integer lokalKey = -1;
        
        Iterator<Integer> iterate = folk.keySet().iterator();
        
        while( iterate.hasNext() ){
            Integer key = iterate.next();
            
            if( folk.get(key).getName().equals( navn ) )
                lokalKey = key;
        }
        
        return lokalKey;
        
    }
    ////////////////////////////////////////////////////////////////////////////    
    
    
    // Finds if DVD already bought by this person
    ////////////////////////////////////////////////////////////////////////////
    public boolean dvdFinnesAllerede( Person person, String tittel ){
        boolean finnesVerdi = false;
        Iterator<Integer> iterate = person.getdvdlist().keySet().iterator();
        
        while( iterate.hasNext() ){
            Integer key = iterate.next();
            if( person.getdvdtittel(key).equals(tittel) )
                finnesVerdi = true;
        }
        
        return finnesVerdi;
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    // Updates the fil by using single object "folk"
    ////////////////////////////////////////////////////////////////////////////
    public void oppdaterFil( HashMap<Integer, Person> folk, String filNavn ) throws Exception{
        
        
        PrintWriter skriv = new PrintWriter( filNavn );
        
        Iterator<Integer> iterate = folk.keySet().iterator();
        while( iterate.hasNext() ){
            Integer key = iterate.next();
            skriv.println( folk.get(key).getName() );
        }        
        // Skriver en "-"
        skriv.println("-" );
        
        
        // Denne while lokke skal finna hvert person som innholder DVDer
        iterate = folk.keySet().iterator();
        while( iterate.hasNext() ){
            Integer key = iterate.next();
            skriv.println( folk.get(key).getName() );
            
            // Denne while-lokken skal finne hver DVD detaljer
            Iterator<Integer> dvdAntall = folk.get(key).getdvdlist().keySet().iterator();
            while( dvdAntall.hasNext() ){
                Integer nextDVD = dvdAntall.next();
                
                // DVD detaljer
                //System.out.println( folk.get(key).getdvdEier(nextDVD) );
                if( folk.get(key).getdvdLaaner(nextDVD) != null ){
                    skriv.println( "*" + folk.get(key).getdvdtittel(nextDVD) );
                    skriv.println( folk.get(key).getdvdLaaner(nextDVD) );
                }
                else
                    skriv.println( folk.get(key).getdvdtittel(nextDVD) );
            }
            skriv.println("-");
        }        
        skriv.close();
    }
    ////////////////////////////////////////////////////////////////////////////
}
////////////////////////////////////////////////////////////////////////////////