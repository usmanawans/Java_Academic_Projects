package DVD;

import java.util.HashMap;
import java.util.Iterator;


public class Person {    
    
    private String name = null;
    private int eier = 0;
    private int laant = 0;
    private int utlaant = 0;
    private HashMap<Integer, DVD> dvdMap = new HashMap<Integer, DVD>();
    
    // GET methods
    ////////////////////////////////////////////////////////////////////////////
    public Person( String name ){
        this.name = name;
    }
    
    public String getName(){
        return name;    
    }
    
    public int getEierAntall(){
        return eier;    
    }
    
    public int getLaantAntall(){
        return laant;    
    }
    
    public int getUtlaantAntall(){
        return utlaant;    
    }
    
    public HashMap getdvdlist(){
        return this.dvdMap;
    }
    
    public String getdvdtittel( int index ){
        return dvdMap.get(index).tittel();
    }
    
    public String getdvdEier( int index ){
        return dvdMap.get(index).eier();
    }
    
    public String getdvdLaaner( int index ){
        return dvdMap.get(index).laaner();
    }
    
    public int getdvdAntall(){
        return dvdMap.size();
    }
    
    // Returns "key" of the DVD, by giving title
    public Integer getDVDkeybyTitle( String title ){
        Integer returNokkel = -1;
        
        Iterator<Integer> iterate = dvdMap.keySet().iterator();
        
        while( iterate.hasNext() ){
            Integer key = iterate.next();
            
            if( dvdMap.get(key).tittel().equals(title) )
                returNokkel = key;
        }        
        return returNokkel;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    // Increase and dcrease methods
    ////////////////////////////////////////////////////////////////////////////
    public void oekEierAntall(){
        eier++;    
    }
    
    public void oekLaantAntall(){
        laant++;    
    }
    
    public void oekUtlaantAntall(){
        utlaant++;    
    }    
    
    public void minskEierAntall(){
        eier--;    
    }
    
    public void minskLaantAntall(){
        laant--;    
    }
    
    public void misnkUtlaantAntall(){
        utlaant--;    
    }    
    ////////////////////////////////////////////////////////////////////////////
    
    
    // SET methods
    ////////////////////////////////////////////////////////////////////////////
    public void addDVD( DVD dvd ){
        this.dvdMap.put( dvdMap.size(), dvd);
    }
    
    public void setdvdTitle( int index, String tittel ){
        dvdMap.get(index).setTittel(tittel);
    }
    
    public void setdvdEier( int index, String eier ){
        dvdMap.get(index).setEier(eier);
    }
    
    public void setdvdLaaner( int index, String laaner ){
        dvdMap.get(index).setLaaner(laaner);
    }
}
