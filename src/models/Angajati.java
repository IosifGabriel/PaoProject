package models;

public  class Angajati extends Persoane  {

    private Integer Salariu;
    private String Nume;
    private String CNP;


    public Angajati(String Nume, Integer Salariu, String AdresaMail, String AdresaDomiciliu, String Telefon, String CNP){
        this.Nume=Nume;
        this.Salariu=Salariu;
        this.Telefon=Telefon;
        this.AdresaDomiciliu=AdresaDomiciliu;
        this.AdresaMail=AdresaMail;
        this.CNP = CNP;
    }

    public void setSalariu(Integer Salariu){
        this.Salariu = Salariu;
    }

    public Integer getSalariu(){
        return this.Salariu;
    }

    public void setNume(String Nume){
        this.Nume=Nume;
    }

    public String getCNP () { return this.CNP;}

    public String getNume(){
        return this.Nume;
    }

}
