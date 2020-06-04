package Repository;

import Audit.AuditService;
import DataBase.DbConnectivity;
import models.Angajati;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AngajatRepo {

    private static AngajatRepo instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO angajati(idAngajati,Nume,Salariu,AdresaMail,AdresaDomiciliu,Telefon,CNP) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM angajati WHERE idAngajati=?";
    private static final String UPDATE_STATEMENT = "UPDATE angajati SET Nume=?, Salariu=?, AdresaMail=?,AdresaDomiciliu=?,Telefon=?, CNP=? WHERE idAngajati = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM angajati WHERE idAngajati=?";

    private AngajatRepo(){

    }

    public static AngajatRepo getInstance(){
        if(instance == null)
            instance = new AngajatRepo();

        return instance;
    }

    public Angajati saveAngajati(Angajati angajati){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)){
            statement.setInt(1,angajati.getCounter());
            statement.setString(2,angajati.getNume());
            statement.setInt(3,angajati.getSalariu());
            statement.setString(4,angajati.getAdresaMail());
            statement.setString(5,angajati.getAdresaDomiciliu());
            statement.setString(6,angajati.getTelefon());
            statement.setString(7,angajati.getCNP());

            int rowsinserted = statement.executeUpdate();
            if(rowsinserted > 0 )
            {
                AuditService.getInstance().writeAudit("Un nou angajat a fost adaugat cu succes");
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare cand s-a incercat adaugarea in baza de date a angajatilor " + e.getMessage());
            return new Angajati();
        }

        return angajati;
    }

    public Angajati updateAngajati(Angajati angajati, int idAngajat){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)){
            statement.setInt(7, idAngajat);
            statement.setString(1,angajati.getNume());
            statement.setInt(2,angajati.getSalariu());
            statement.setString(3,angajati.getAdresaMail());
            statement.setString(4,angajati.getAdresaDomiciliu());
            statement.setString(5,angajati.getTelefon());
            statement.setString(6,angajati.getCNP());

            int rowUpdated = statement.executeUpdate();
            if( rowUpdated > 0){
                AuditService.getInstance().writeAudit("Angajat updatat cu success");
                return angajati;
            }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Eroare la updatarea unui angajat" + e.getMessage());
            return new Angajati();
        }

        AuditService.getInstance().writeAudit("Nu s-a putut updata angajatul deoarece nu s-a gasit");
        return new Angajati();
    }

    public boolean deleteAngajati(int idAngajati){
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)){
                statement.setInt(1,idAngajati);

                int rowsDeleted = statement.executeUpdate();
                if(rowsDeleted > 0){
                    AuditService.getInstance().writeAudit("Angajat sters cu succes");
                    return true;
                }
        }
        catch(SQLException e){
            AuditService.getInstance().writeAudit("Problema la stergerea angajatului" + e.getMessage());
            return false;
        }

        AuditService.getInstance().writeAudit("Nu s-a putut sterge angajatul deoarece nu a fost gasit");
        return false;
    }

    public Angajati findAngajati(int idAngajati){
        Angajati angajati = new Angajati();
        try(PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)){
            statement.setInt(1,idAngajati);
                try(ResultSet result = statement.executeQuery()){
                    if(!result.next()){
                        return angajati;
                    }
                    angajati.setNume(result.getString("Nume"));
                    angajati.setSalariu(result.getInt("Salariu"));
                    angajati.setAdresaMail(result.getString("AdresaMail"));
                    angajati.setAdresaDomiciliu(result.getString("AdresaDomiciliu"));
                    angajati.setTelefon(result.getString("Telefon"));
                    angajati.setCNP(result.getString("CNP"));
                }
                catch(SQLException e){
                    AuditService.getInstance().writeAudit("Nu s-a putut gasi angajatul" +e.getMessage());
                }

                return  angajati;
        }
        catch(SQLException e2){
            AuditService.getInstance().writeAudit("Ceva a mers gresit cand s-a cautat angajatul " + e2.getMessage());
        }
        return angajati;
    }
}
