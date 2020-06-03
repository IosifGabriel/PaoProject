package DBService;

import Repository.AngajatRepo;
import models.Angajati;

public class AngajatDBService {

    private static AngajatDBService instance;
    private final AngajatRepo angajatRepo = AngajatRepo.getInstance();

    private AngajatDBService(){

    }

    public static AngajatDBService getInstance(){
        if(instance == null)
            instance = new AngajatDBService();
        return instance;
    }

    public Angajati saveAngajat(Angajati angajati){
        return AngajatRepo.getInstance().saveAngajati(angajati);
    }
}
