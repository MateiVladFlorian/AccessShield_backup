/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

//import ApplicationManager.ManagerBuildings.BookingViewModel;
import Entities.Booking;
import Entities.Rooms;
import core.ManagerEntities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vlad
 */
public class BookingJpaController {
    private EntityManagerFactory f;
    private ManagerEntities em;
    
        
    public BookingJpaController() {
        em = new ManagerEntities();
        f = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
    }
    
    public boolean CreateBooking(Booking booking)
    {
        if (booking != null) {
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(booking);
            e.getTransaction().commit();
            return true;
        }
        
        return false;
    }
    
    public List<Object[]> getOwnerReservations(int accountId, String status) {
        try {
            return (List<Object[]>) (em.getManagerEntities()
                     .createNativeQuery("select Building.name, Booking.room_id, (extract(DAYS from age(check_out, check_in)) * Building.price) as totalPrice," +
                             "check_in, check_out, Booking.status from Booking inner join rooms  on Booking.room_id=rooms.room_id inner join Building on " + 
                             "rooms.build_id=Building.id where Booking.account_id=? and Booking.status=?;")
                    .setParameter(1, accountId)
                    .setParameter(2, status)
                    .getResultList());
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
    
    public boolean updateOwnerReservationByRoom(int accountId, int roomId, String status) {
        try {
            em.getManagerEntities()
            .createNativeQuery("UPDATE Booking SET status='" + status + "' WHERE room_id='" + roomId + "' and account_id = '" + accountId + "'", Rooms.class)
            .getResultList();  
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return true;
    }
}
