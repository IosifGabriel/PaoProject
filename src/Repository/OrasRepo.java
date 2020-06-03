package Repository;

import Audit.AuditService;
import DataBase.DbConnectivity;
import models.Oras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class OrasRepo {

    private static OrasRepo instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO orase(id,Oras, Nume, Tara) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM customer WHERE idOras = ?";
    private static final String UPDATE_STATEMENT = "UPDATE orase SET nume = ?, tara = ? WHERE idOras = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM orase WHERE idOras=?";

    private OrasRepo() {
    }

    public static OrasRepo getInstance() {
        if (instance == null) {
            instance = new OrasRepo();
        }

        return instance;
    }

    public Oras saveOras(Oras oras) {
        try (PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, oras.getCounter());
            statement.setString(2, oras.getNume());
            statement.setString(3,oras.getTara());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                AuditService.getInstance().writeAudit("Oras nou adaugat");
            }
        } catch (SQLException e) {
            AuditService.getInstance().writeAudit("Nu s-a putut adauga orasul" + e.getMessage());
            return new Oras();
        }
        return oras;
    }


    public Oras updateOras(Oras oras) {
        try (PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(3,oras.getCounter());
            statement.setString(1, oras.getNume());
            statement.setString(2, oras.getTara());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                AuditService.getInstance().writeAudit("Oras updatat cu succes!");
                return oras;
            }
        } catch (SQLException e) {
            AuditService.getInstance().writeAudit("Nu s-a putut updata orasul " + e.getMessage());
            return new Oras();
        }

        AuditService.getInstance().writeAudit("Nu s-a putut gasi orasul pentru update");
        return new Oras();
    }

    public boolean deleteOras(int idOras) {
        try (PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, idOras);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                AuditService.getInstance().writeAudit("Oras sters cu succes");
                return true;
            }
        } catch (SQLException e) {
            AuditService.getInstance().writeAudit("Nu s-a putut sterge orasul" + e.getMessage());
            return false;
        }

        AuditService.getInstance().writeAudit("Nu s-a putut gasi orasul");
        return false;
    }

    public Oras findOras(int idOras) {
        Oras oras = new Oras();
        try (PreparedStatement statement = DbConnectivity.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, idOras);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return oras;
                }
                oras.setNume(result.getString("Nume"));
                oras.setTara(result.getString("Tara"));
            }
        } catch (SQLException e) {
            AuditService.getInstance().writeAudit("Nu s-a putut gasi orasul" + e.getMessage());
        }
        return oras;
    }


}