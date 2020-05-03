package Helper;

import DataPersistence.AngajatService;
import DataPersistence.CladiriService;
import DataPersistence.OraseService;
import DataPersistence.RegistreService;
import models.*;

import java.util.*;

public class CompanieHelper extends InitializareCompanieHelper {

    @Override
    public Companie  CompanieInitializareInit(){

        // Angajati
        Set<Angajati> Angajati = new HashSet<>();
        Angajati angajat1 = new Angajati("Andreea Miron", 2100, "andreea.miron@mymail.com", "Strada Viilor, nr 1", "075555555",
        "2123456789");

        Angajati.add(angajat1);

        //Registre
        Set<Registre> Registre = new HashSet<>();
        Set<Registre> Registre2 = new HashSet<>();

        Registre registru1 = new Registre("Registrul Comertului"); // registru sucursala
        Registre registru2 = new Registre("Registrul Transportului");

        Registre.add(registru1);
        Registre2.add(registru2);

        //Sucursala
        Sucursale sucursala1 = new Sucursale("Strada Aviatiei, nr 12", Angajati, Registre);
        Set<Sucursale> Sucursale = new HashSet<>();
        Sucursale.add(sucursala1);

        //Depozite
        Depozit depozit1 = new Depozit(1500,"Strada Morii, nr 12", Registre2);

        Set<Depozit> Depozite = new HashSet<>();
        Depozite.add(depozit1);

        //Initializez orasele pentru companie;

        Oras oras1 = new Oras("Bucuresti","Romania", Sucursale, Depozite);
        List<Oras> Orase = new ArrayList<>();

        Orase.add(oras1);

        Companie MyCompany = new Companie(Orase);

        //initializare csv

        OraseService.getInstance().CitesteOrase(MyCompany);
        CladiriService.getInstance().CitesteCladiri(MyCompany);
        AngajatService.getInstance().citesteAngajati(MyCompany);
        RegistreService.getInstance().CitesteRegistre(MyCompany);

        return MyCompany;
    }

}
