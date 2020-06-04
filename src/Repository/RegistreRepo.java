package Repository;

import Audit.AuditService;
import DataBase.DbConnectivity;
import models.Oras;
import models.Registre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class RegistreRepo {

    private static RegistreRepo instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO registre(idRegistru,Nume,Oras,Cladire,Adresa) VALUES(?,?,?,?,?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM registre WHERE idRegistru=?";
    private static final String UPDATE_STATEMENT = "UPDATE registre SET Nume=?, Oras=?, Cladire=?,Adresa=? WHERE idRegistru = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM registre WHERE idRegistru=?";

    private RegistreRepo(){

    }

    public static RegistreRepo getInstance(){
        if(instance == null)
            instance = new RegistreRepo();

        return instance;
    }

    public Registre saveRegistre(Registre registru, String NumeOras, String Tipcladire, String AdresaCladire ){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)){
            statement.setInt(1,registru.getCounter());
            statement.setString(2,registru.getNumeRegistru());
            statement.setString(3,NumeOras);
            statement.setString(4,Tipcladire);
            statement.setString(5,AdresaCladire);


            int rowsinserted = statement.executeUpdate();
            if(rowsinserted > 0 )
            {
                AuditService.getInstance().writeAudit("Un nou registru a fost adaugat cu succes");
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare cand s-a incercat adaugarea in baza de date a unui registru " + e.getMessage());
            return new Registre();
        }

        return registru;
    }

    public Registre updateRegistre(Registre registru, String NumeOras, String TipCladire, String AdresaCladire, int idRegistru ){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)){
            statement.setInt(5, idRegistru);
            statement.setString(1,registru.getNumeRegistru());
            statement.setString(2,NumeOras);
            statement.setString(3, TipCladire);
            statement.setString(4,AdresaCladire);

            int rowUpdated = statement.executeUpdate();
            if( rowUpdated > 0){
                AuditService.getInstance().writeAudit("Registru updatat cu success");
                return registru;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare la updatarea unui registru" + e.getMessage());
            return new Registre();
        }

        AuditService.getInstance().writeAudit("Nu s-a putut updata registrul deoarece nu s-a gasit");
        return new Registre();
    }

    public boolean deleteRegistre(int idRegistru){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)){
            statement.setInt(1,idRegistru);

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                AuditService.getInstance().writeAudit("Registru sters cu succes");
                return true;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Problema la stergerea registrului" + e.getMessage());
            return false;
        }

        AuditService.getInstance().writeAudit("Nu s-a putut sterge registrul deoarece nu a fost gasit");
        return false;
    }

    public Registre findRegistru(int idRegistru){
        Registre registru = new Registre();
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)){
            statement.setInt(1,idRegistru);
            try(ResultSet result = statement.executeQuery()){
                if(!result.next()){
                    return registru;
                }
                registru.setNumeRegistru(result.getString("Nume"));

            }
            catch(SQLException e){
                AuditService.getInstance().writeAudit("Nu s-a putut gasi angajatul" +e.getMessage());
            }

            return  registru;
        }
        catch(SQLException e2){
            AuditService.getInstance().writeAudit("Ceva a mers gresit cand s-a cautat angajatul " + e2.getMessage());
        }
        return registru;
    }
}
