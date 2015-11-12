/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Domain.Reservation;
import java.util.List;

/**
 *
 * @author ppthgast
 */
public class ReservationDAO {

    public ReservationDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Tries to find the reservations for the given in the persistent data
     * store, in this case a MySQL database. The foreign keys relating to other
     * tables are not added, simply because they are not used 
     * in the application as of yet.
     *
     * @param Reservation indicates the moments during which the field is occupied
     * and cannot be used. 
     *
     */
    public List<Reservation> findReservations() {
        List<Reservation> reservations = new ArrayList<>();

        if (true) {
            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.
                 ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT * FROM reservation");

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the BookISBN in the row is ignored
                            // for this POC: no Book objects are loaded. Having the
                            // Reservation objects without the Book objects will do fine
                            // to determine whether the owning Member can be removed.
                            int StartTime = resultset.getInt("StartTime");
                            int EndTime = resultset.getInt("StopTime");
                            int Identity = resultset.getInt ("ReservationID");

                            Reservation newReservation = new Reservation(StartTime, EndTime, Identity);
                            reservations.add(newReservation);
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        reservations.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();
            }
        }

        return reservations;
    }
}
