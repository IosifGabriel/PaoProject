package models;

public final class  PersoaneFizice extends Persoane {
    private String Nume;


    public PersoaneFizice(String Nume, String AdresaMail, String AdresaDomiciliu, String Telefon){
        this.Nume=Nume;
        this.Telefon=Telefon;
        this.AdresaDomiciliu=AdresaDomiciliu;
        this.AdresaMail=AdresaMail;
    }

    public String getNume(){
        return this.Nume;
    }

    public void setNume(String Nume){
        this.Nume = Nume;
    }
}
