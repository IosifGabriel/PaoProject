package models;

abstract class Persoane {
    protected String AdresaMail;
    protected String AdresaDomiciliu;
    protected String Telefon;
    protected String CNP;

    public String getAdresaMail(){
        return this.AdresaMail;
    }

    public String getAdresaDomiciliu(){
        return this.AdresaDomiciliu;
    }

    public String getTelefon(){
        return this.Telefon;
    }

    public void setAdresaMail(String AdresaMail){
        this.AdresaMail = AdresaMail;
    }

    public void setAdresaDomiciliu(String AdresaDomiciliu){
        this.AdresaDomiciliu = AdresaDomiciliu;
    }

    public void setTelefon(String Telefon){
        this.Telefon = Telefon;
    }
}
