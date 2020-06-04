package models;

public  class Angajati extends Persoane  {

    private Integer Salariu;
    private String Nume;
    private String CNP;
    private static int counter = 0;


    public Angajati(String Nume, Integer Salariu, String AdresaMail, String AdresaDomiciliu, String Telefon, String CNP){
        this.Nume=Nume;
        this.Salariu=Salariu;
        this.Telefon=Telefon;
        this.AdresaDomiciliu=AdresaDomiciliu;
        this.AdresaMail=AdresaMail;
        this.CNP = CNP;
        counter = counter + 1;
    }

    public Angajati(){

    }

    public int getCounter(){
        return this.counter;
    }
    public void setSalariu(Integer Salariu){
        this.Salariu = Salariu;
    }

    public Integer getSalariu(){
        return this.Salariu;
    }

    public void setNume(String Nume){
        this.Nume = Nume;
    }

    public void setAdresaMail(String AdresaMail){
        this.AdresaMail = AdresaMail;
    }

    public void setAdresaDomiciliu(String AdresaDomiciliu){
        this.AdresaDomiciliu=AdresaDomiciliu;
    }

    public void setCNP(String CNP){
        this.CNP = CNP;
    }

    public void setTelefon(String Telefon){
        this.Telefon=Telefon;
    }

    public String getCNP () { return this.CNP;}

    public String getNume(){
        return this.Nume;
    }

    public String toString() {
        return getNume() + " " +getSalariu().toString() + " " +getAdresaMail() + " " +
                " " + getAdresaDomiciliu() + " " + getTelefon() + " " +getCNP();
    }

}
