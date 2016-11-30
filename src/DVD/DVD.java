package DVD;

public class DVD {
    
    private String tittel = "";
    private String eier;
    private String laaner ;
    
    
    // SET methods
    ////////////////////////////////////////////////////////////////////////////
    public void setTittel( String tittel ){
        this.tittel = tittel;
    }
    
    public void setEier( String eier ){
        this.eier = eier;
    }
    
    public void setLaaner( String laaner ){
        this.laaner = laaner;
    }    
    
    
    // GET methods
    ////////////////////////////////////////////////////////////////////////////
    public String tittel(){
        return tittel;
    }
    
    public String eier(){
        return eier;
    }
    
    public String laaner(){
        return laaner;
    }
}
