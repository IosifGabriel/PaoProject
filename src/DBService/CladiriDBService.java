package DBService;

import Repository.CladiriRepo;
import models.Depozit;
import models.Sucursale;
import models.Oras;

public class CladiriDBService {

    private static CladiriDBService instance;

    private CladiriDBService(){

    }

    public static CladiriDBService getInstance(){
        if(instance == null)
            instance = new CladiriDBService();
        return instance;
    }

    public Sucursale saveSucursala(Sucursale sucursala, Oras oras){
        return CladiriRepo.getInstance().saveSucursale(sucursala,oras);
    }

    public Sucursale updateSucursala(Sucursale sucursala, Oras oras, int idSucursala){
        return CladiriRepo.getInstance().updateSucursale(sucursala, oras, idSucursala);
    }

    public boolean deleteSucursala(int idSucursala){
        return CladiriRepo.getInstance().deleteSucursala(idSucursala);
    }

    public Sucursale findSucursala(int idSucursala){
        return CladiriRepo.getInstance().findSucursala(idSucursala);
    }

    public Depozit saveDepozit(Depozit depozit, Oras oras){
        return CladiriRepo.getInstance().saveDepozit(depozit,oras);
    }

    public Depozit updateDepozit(Depozit depozit, Oras oras, int idDepozit){
        return CladiriRepo.getInstance().updateDepozit(depozit, oras, idDepozit);
    }

    public boolean deleteDepozit(int idDepozit){
        return CladiriRepo.getInstance().deleteDepozit(idDepozit);
    }

    public Depozit findDepozit(int idDepozit){
        return CladiriRepo.getInstance().findDepozit(idDepozit);
    }


}
