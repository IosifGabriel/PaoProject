package models;

import java.util.HashSet;
import java.util.Set;

public class Oras {

    private String Nume;
    private String Tara;
    private int counter = 0;

    private Set<Sucursale> Sedii;
    private Set<Depozit> Depozite;

    public Oras(String Nume, String Tara, Set<Sucursale> Sedii, Set<Depozit> Depozite){
        this.Nume = Nume;
        this.Tara= Tara;
        this.Sedii=Sedii;
        this.Depozite=Depozite;
        counter = counter+1;
    }

    public Oras(String Nume){
        this.Nume = Nume;
        Sedii = new HashSet<>();
        Depozite = new HashSet<>();
        counter = counter+1;
    }

    public Oras(String Name, String Tara){
        this.Nume=Name;
        this.Tara=Tara;
        counter = counter + 1;
        Sedii = new HashSet<>();
        Depozite = new HashSet<>();
    }

    public Oras(){

    }

    public int getCounter(){
        return this.counter;
    }

    public void setNume(String Nume){
        this.Nume = Nume;
    }

    public String getNume(){
        return this.Nume;
    }

    public Set<Sucursale> getSedii(){
        return this.Sedii;
    }

    public void AdaugaDepozit(Depozit d){
        Depozite.add(d);
    }

    public void StergeDepozit(Depozit d){
        Depozite.remove(d);
    }

    public void setTara(String Tara){
        this.Tara= Tara;
    }

    public String getTara(){ return this.Tara;}

    public void AdaugaSucursala(Sucursale Sucursala){
        this.Sedii.add(Sucursala);
    }

    public void setSedii(Set<Sucursale> Sedii){
        this.Sedii = Sedii;
    }

    public void setDepozite(Set<Depozit> Depozite)
    {
        this.Depozite=Depozite;
    }

    public Set<Depozit> getDepozite(){
        return this.Depozite;
    }

    public Sucursale SearchSucursale(String adresa){
        for (Sucursale s : Sedii){
            if (s.getAdresa().equals(adresa)) {
                return s;
            }
        }
        return null;
    }

    public Depozit SearchDepozit(String adresa){
        for (Depozit d : Depozite){
            if (d.getAdresa().equals(adresa)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getNume()+" din "+getTara();
    }

}
