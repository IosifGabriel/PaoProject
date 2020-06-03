package models;

import java.util.HashSet;
import java.util.Set;

public class Sucursale {

    private String Adresa;
    private static int counter = 0 ;
    private Set<Angajati> AngajatiSucursala;
    private Set<Registre> Registre;


    public Sucursale(String Adresa, Set<Angajati> Angajati, Set<Registre> Registre){
        this.Adresa=Adresa;
        this.AngajatiSucursala=Angajati;
        this.Registre=Registre;
        counter = counter + 1;
    }

    public Sucursale(String Adresa){
        this.Adresa= Adresa;
        AngajatiSucursala = new HashSet<>();
        Registre = new HashSet<>();
        counter = counter  + 1;
    }

    public Sucursale(){
    }

    public int getCounter(){
        return this.counter;
    }
    public void setAdresa(String Adresa){
        this.Adresa=Adresa;
    }

    public void setAngajatiSucursala(Set<Angajati> Angajati){
        this.AngajatiSucursala=Angajati;
    }

    public void setRegistre(Set<Registre> Registre){
        this.Registre=Registre;
    }

    public void addRegistre(Registre Registru) { Registre.add(Registru);}

    public void adaugaAngajat(Angajati angajat) { this.AngajatiSucursala.add(angajat);}

    public int stergeAngajat(String CNP){
        for(Angajati a : AngajatiSucursala){
            if(a.getCNP().equals(CNP)){
                AngajatiSucursala.remove(a);
                return 1;
            }
        }
        return 0;
    }

    public int stergeRegistru(String NumeRegistru){
        for(Registre r : Registre){
            if(r.getNumeRegistru().equals(NumeRegistru))
            {
                Registre.remove(r);
                return 1;
            }
        }
        return 0;
    }

    public Registre searchRegistre(String nume){
        for(Registre r: Registre){
            if(r.getNumeRegistru().equals(nume))
                return r;
        }
        return null;
    }

    public String getAdresa(){
        return Adresa;
    }

    public Set<Angajati> getAngajatiSucursala(){
        return AngajatiSucursala;
    }

    public Set<Registre> GetRegistre(){
        return Registre;
    }


}
