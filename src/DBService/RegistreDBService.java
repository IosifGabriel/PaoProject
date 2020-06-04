package DBService;

import Repository.RegistreRepo;
import models.Registre;

public class RegistreDBService {

    private static RegistreDBService instance;

    private RegistreDBService(){}

    public static RegistreDBService getInstance(){
        if(instance == null)
            instance = new RegistreDBService();
        return instance;
    }


    public Registre saveRegistre(Registre registru, String numeoras, String TipCladire,  String adresa){
        return RegistreRepo.getInstance().saveRegistre(registru,numeoras, TipCladire,adresa);
    }

    public Registre updateRegistru(Registre registru, String numeoras,String  TipCladire,  String adresa, int idRegistru){
        return RegistreRepo.getInstance().updateRegistre(registru,numeoras,TipCladire, adresa,idRegistru);
    }

    public boolean deleteRegistru(int idRegistru){
        return RegistreRepo.getInstance().deleteRegistre(idRegistru);
    }

    public Registre findRegistru(int idRegistru){
        return RegistreRepo.getInstance().findRegistru(idRegistru);
    }

}
