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

    public boolean deleteAngajati(int idAngajat){
        return AngajatRepo.getInstance().deleteAngajati(idAngajat);
    }

    public Angajati findAngajati(int idAngajat){
        return AngajatRepo.getInstance().findAngajati(idAngajat);
    }

    public Angajati updateAngajati(Angajati angajat, int idAngajat){ return AngajatRepo.getInstance().updateAngajati(angajat, idAngajat);}
}
