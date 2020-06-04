package DBService;

import Repository.OrasRepo;
import models.Oras;

public class OrasDBService {
    private static OrasDBService instance;

    private OrasDBService(){

    }

    public static OrasDBService getInstance(){
        if(instance == null)
            instance = new OrasDBService();
        return instance;
    }

    public Oras saveOras(Oras oras){
        return OrasRepo.getInstance().saveOras(oras);
    }

    public Oras updateOras(Oras oras, int idOras){
        return OrasRepo.getInstance().updateOras(oras, idOras);
    }

    public boolean deleteOras(int idOras){
        return OrasRepo.getInstance().deleteOras(idOras);
    }

    public Oras findOras(int idOras){
        return OrasRepo.getInstance().findOras(idOras);
    }
}
