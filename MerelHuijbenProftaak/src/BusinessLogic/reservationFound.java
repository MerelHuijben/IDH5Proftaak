
package BusinessLogic;

import Domain.Reservation;
import java.util.Date;
import java.util.List;
/* 
* The int ShortenedTime has been added to align the automatically inserted hours
* and minutes with the data as implemented in the database.

*/
public class reservationFound {

    public static boolean reservationFound (List<Reservation> reservations) {
        boolean occupied = false;            
        Date currentTime = new Date();
        int hours = currentTime.getHours();
        int minutes = currentTime.getMinutes();
        int ShortenedTime = hours * 100 + minutes;
            
        for (Reservation res : reservations) {

//          To calculate whether or not the field is currently occupied: 
            if ((ShortenedTime >= res.GetStartTime()) && (ShortenedTime <= res.GetEndTime())) {
                occupied = true;
           }
        }
        return occupied;
    }    

 }
