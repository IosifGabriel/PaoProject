package Repository;

import Audit.AuditService;
import DataBase.DbConnectivity;
import models.Oras;
import models.Sucursale;
import models.Depozit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CladiriRepo {

    private static CladiriRepo instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO cladiri(idCladire,Oras,Tip,Adresa,Capacitate) VALUES(?,?,?,?,?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM cladiri WHERE idCladiri=?";
    private static final String UPDATE_STATEMENT = "UPDATE cladiri SET Oras=?, Tip=?, Adresa=?,Capacitate=? WHERE idCladiri = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM cladiri WHERE idCladiri=?";

    private CladiriRepo(){
    }


    public static CladiriRepo getInstance(){
        if(instance == null)
            instance = new CladiriRepo();

        return instance;
    }


    //DEPOZIT

    public Depozit saveDepozit(Depozit depozit, Oras oras){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)){
            statement.setInt(1,depozit.getCounter());
            statement.setString(2,oras.getNume());
            statement.setString(3,"Depozit");
            statement.setString(4,depozit.getAdresa());
            statement.setInt(5,depozit.getCapacitate());

            int rowsinserted = statement.executeUpdate();
            if(rowsinserted > 0 )
            {
                AuditService.getInstance().writeAudit("Un nou depozit a fost adaugata");
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare cand s-a incercat adaugarea in baza de date a unui deppzit " + e.getMessage());
            return new Depozit();
        }

        return depozit;
    }

    public Depozit updateDepozit(Depozit depozit, Oras oras){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)){
            statement.setInt(5,depozit.getCounter());
            statement.setString(1,oras.getNume());
            statement.setString(2,"Sucursala");
            statement.setString(3,depozit.getAdresa());
            statement.setInt(4,depozit.getCapacitate());

            int rowUpdated = statement.executeUpdate();
            if( rowUpdated > 0){
                AuditService.getInstance().writeAudit("Sucursala updatata cu success");
                return depozit;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare la updatarea unei sucursale" + e.getMessage());
            return new Depozit();
        }

        AuditService.getInstance().writeAudit("Nu s-a putut updata sucursala deoarece nu s-a gasit");
        return new Depozit();
    }

    public boolean deleteDepozit(int idDepozit){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)){
            statement.setInt(1,idDepozit);

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                AuditService.getInstance().writeAudit("Depozitul a fost sters cu succes");
                return true;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Problema la stergerea depozitului" + e.getMessage());
            return false;
        }

        AuditService.getInstance().writeAudit("Nu s-a putut sterge depozitul deoarece nu a fost gasit");
        return false;
    }

    public Depozit findDepozit(int idDepozit){
        Depozit depozit = new Depozit();
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)){
            statement.setInt(1,idDepozit);
            try(ResultSet result = statement.executeQuery()){
                if(!result.next()){
                    return depozit;
                }

                depozit.setAdresa(result.getString("Adresa"));
            }
            catch(SQLException e){
                AuditService.getInstance().writeAudit("Nu s-a putut gasi depozitul " +e.getMessage());
            }

            return  depozit;
        }
        catch(SQLException e2){
            AuditService.getInstance().writeAudit("Ceva a mers gresit cand s-a cautat depozitul " + e2.getMessage());
        }
        return depozit;
    }



    //SUCURSALE
    public Sucursale saveSucursale(Sucursale sucursala, Oras oras){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)){
            statement.setInt(1,sucursala.getCounter());
            statement.setString(2,oras.getNume());
            statement.setString(3,"Sucursala");
            statement.setString(4,sucursala.getAdresa());
            statement.setInt(5,0);

            int rowsinserted = statement.executeUpdate();
            if(rowsinserted > 0 )
            {
                AuditService.getInstance().writeAudit("O noua sucursala a fost adaugata");
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare cand s-a incercat adaugarea in baza de date a sucursale " + e.getMessage());
            return new Sucursale();
        }

        return sucursala;
    }

    public Sucursale updateSucursale(Sucursale sucursala, Oras oras){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)){
            statement.setInt(4,sucursala.getCounter());
            statement.setString(1,oras.getNume());
            statement.setString(2,"Sucursala");
            statement.setString(3,sucursala.getAdresa());

            int rowUpdated = statement.executeUpdate();
            if( rowUpdated > 0){
                AuditService.getInstance().writeAudit("Sucursala updatata cu success");
                return sucursala;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare la updatarea unei sucursale" + e.getMessage());
            return new Sucursale();
        }

        AuditService.getInstance().writeAudit("Nu s-a putut updata sucursala deoarece nu s-a gasit");
        return new Sucursale();
    }

    public boolean deleteSucursala(int idSucursala){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)){
            statement.setInt(1,idSucursala);

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                AuditService.getInstance().writeAudit("Sucursala sters cu succes");
                return true;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Problema la stergerea sucursalei" + e.getMessage());
            return false;
        }

        AuditService.getInstance().writeAudit("Nu s-a putut sterge sucursala deoarece nu a fost gasita");
        return false;
    }

    public Sucursale findSucursala(int idSucursala){
        Sucursale sucursala = new Sucursale();
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)){
            statement.setInt(1,idSucursala);
            try(ResultSet result = statement.executeQuery()){
                if(!result.next()){
                    return sucursala;
                }

                sucursala.setAdresa(result.getString("Adresa"));
            }
            catch(SQLException e){
                AuditService.getInstance().writeAudit("Nu s-a putut gasi sucursala" +e.getMessage());
            }

            return  sucursala;
        }
        catch(SQLException e2){
            AuditService.getInstance().writeAudit("Ceva a mers gresit cand s-a cautat sucursala " + e2.getMessage());
        }
        return sucursala;
    }
}
