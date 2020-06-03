package models;

import java.util.HashSet;
import java.util.Set;

public class Depozit {

    private Integer Capacitate;
    private String Adresa;
    private Set<Registre> RegistreStocate;
    private static int counter =1500;

    @SuppressWarnings("unused")
    public Depozit(Integer Capacitate, String Adresa, Set<Registre> RegistreStocate){
        this.Adresa = Adresa;
        this.Capacitate=Capacitate;
        this.RegistreStocate = RegistreStocate;
        counter = counter +1;
    }

    public Depozit(Integer Capacitate, String Adresa){
        this.Adresa = Adresa;
        this.Capacitate=Capacitate;
        RegistreStocate = new HashSet<>();
        counter = counter + 1;
    }

    public Depozit(){

    }

    public int getCounter(){
        return this.counter;
    }
    public String getAdresa(){
        return this.Adresa;
    }

    public Integer getCapacitate(){
        return this.Capacitate;
    }

    public void setAdresa(String Adresa){
        this.Adresa= Adresa;
    }

    public void setCapacitate(Integer Capacitate){
        this.Capacitate = Capacitate;
    }

    public void addRegistre(Registre Registru) {
        if(RegistreStocate.size() < Capacitate)
            RegistreStocate.add(Registru);
        else
            System.out.println("Capacitatea este maxima, nu se mai pot adauga registre");
    }

    public int stergeRegistru(String NumeRegistru){
        for(Registre r : RegistreStocate){
            if(r.getNumeRegistru().equals(NumeRegistru))
            {
                RegistreStocate.remove(r);
                return 1;
            }
        }
        return 0;
    }


    public Set<Registre>  getRegistreStocate(){
        return RegistreStocate;
    }

    public void setRegistreStocate(Set<Registre> RegistreStocate){
        this.RegistreStocate = RegistreStocate;
    }
}
