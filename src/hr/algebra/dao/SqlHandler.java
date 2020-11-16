package hr.algebra.dao;

import hr.algebra.model.Grad;
import hr.algebra.model.Vozac;
import hr.algebra.model.Vozilo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author TomoNova
 */
public class SqlHandler {

    private static final String ADDDRZAVA = "{call AddDrzava(?)}";
    private static final String ADDGRAD = "{call AddGrad(?,?,?,?)}";
    private static final String GETGRADOVI = "{call GetGradovi}";
    private static final String ADDVOZAC = "{call AddVozac(?,?,?,?)}";
    private static final String GETVOZACI = "{call GetVozaci}";
    private static final String ADDVOZILO = "{call AddVozilo(?,?,?,?,?)}";
    private static final String GETVOZILA = "{call GetVozila}";

    public static void insertGradovi(List<Grad> gradovi, int drzavaID, int chunkSize) {
        if (drzavaID == 0) {
            drzavaID = 1;
        }
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stm = con.prepareCall(ADDGRAD)) {
            con.setAutoCommit(false);
            int counter = 0;
            for (Grad grad : gradovi) {
                stm.setString(1, grad.getIme());
                stm.setDouble(2, grad.getLatitude());
                stm.setDouble(3, grad.getLongitude());
                stm.setInt(4, drzavaID);
                stm.addBatch();
                if (++counter == chunkSize) {
                    stm.executeBatch();
                    counter = 0;
                }
            }
            if (counter > 0) {
                stm.executeBatch();
            }
            if (compareDBwithCSV(gradovi, gradoviDB(con))) {
                con.commit();
                System.out.println("Napravljen commit svih gradova");
            } else {
                con.rollback();
                System.out.println("Napravljen rollback jer podaci "
                        + "ubačeni iz CSV-a nisu identični podacima u bazi");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static List<Grad> gradoviDB(Connection con) {
        List<Grad> lista = new ArrayList<>();
        try (CallableStatement stm = con.prepareCall(GETGRADOVI);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                lista.add(
                        new Grad(rs.getString(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getInt(5)));

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }

    private static <T> boolean compareDBwithCSV(List<T> listCSV, List<T> listDB) {
        return listCSV.equals(listDB);
    }

    public static void insertDrzava(String Naziv) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stm = con.prepareCall(ADDDRZAVA)) {
            stm.setString(1, Naziv);
            stm.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static List<Grad> getGradovi() {
        DataSource dataSource = DataSourceSingleton.getInstance();
        List<Grad> lista = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                CallableStatement stm = con.prepareCall(GETGRADOVI);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
                lista.add(
                        new Grad(rs.getString(1),
                                rs.getDouble(2),
                                rs.getDouble(3),
                                rs.getInt(4)));

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }

    public static void insertVozaci(List<Vozac> vozaciLista, int chunkSize) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stm = con.prepareCall(ADDVOZAC)) {
            con.setAutoCommit(false);
            int counter = 0;
            for (Vozac vozac : vozaciLista) {
                stm.setString(1, vozac.getIme());
                stm.setString(2, vozac.getPrezime());
                stm.setString(3, vozac.getMobitel());
                stm.setString(4, vozac.getVozackDozvola());
                stm.addBatch();
                if (++counter == chunkSize) {
                    stm.executeBatch();
                    counter = 0;
                }
            }
            if (counter > 0) {
                stm.executeBatch();
            }
            if (compareDBwithCSV(vozaciLista, vozaciDB(con))) {
                con.commit();
                System.out.println("Napravljen commit svih vozaca");
            } else {
                con.rollback();
                System.out.println("Napravljen rollback jer podaci "
                        + "ubačeni iz CSV-a nisu identični podacima u bazi");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static List<Vozac> vozaciDB(Connection con) {
        List<Vozac> lista = new ArrayList<>();
        try (CallableStatement stm = con.prepareCall(GETVOZACI);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                lista.add(
                        new Vozac(rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }

    public static void insertVozila(List<Vozilo> vozilaLista, int chunkSize) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stm = con.prepareCall(ADDVOZILO)) {
            con.setAutoCommit(false);
            int counter = 0;
            for (Vozilo vozilo : vozilaLista) {
                stm.setString(1, vozilo.getMarka());
                stm.setString(2, vozilo.getModel());
                stm.setDate(3, Date.valueOf(vozilo.getGodinaProizvodnje()));
                stm.setDate(4, Date.valueOf(vozilo.getGodinaUnosa()));
                stm.setInt(5, vozilo.getInincijalniKM());
                stm.addBatch();
                if (++counter == chunkSize) {
                    stm.executeBatch();
                    counter = 0;
                }
            }
            if (counter > 0) {
                stm.executeBatch();
            }
            if (compareDBwithCSV(vozilaLista, vozilaDB(con))) {
                con.commit();
                System.out.println("Napravljen commit svih vozila");
            } else {
                con.rollback();
                System.out.println("Napravljen rollback jer podaci "
                        + "ubačeni iz CSV-a nisu identični podacima u bazi");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static List<Vozilo> vozilaDB(Connection con) {
        List<Vozilo> lista = new ArrayList<>();
        try (CallableStatement stm = con.prepareCall(GETVOZILA);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                lista.add(
                        new Vozilo(rs.getString(2),
                                rs.getString(3),
                                rs.getDate(4).toLocalDate(),
                                rs.getDate(5).toLocalDate(),
                                rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }
}
