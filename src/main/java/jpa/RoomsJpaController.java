/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import Entities.*;
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
public class RoomsJpaController {
    private EntityManagerFactory f;
    private ManagerEntities em;
    
    public RoomsJpaController() {
        em = new ManagerEntities();
        f = Persistence.createEntityManagerFactory("org_AccessShield_backup_jar_1.0-SNAPSHOTPU");
    }
    
    public Rooms GetRoomById(int roomId) {
        try {
                return (Rooms)(em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM rooms WHERE room_id = '" + roomId + "'", Rooms.class)
                     .getSingleResult());
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public boolean UpdateRoomStatus(int roomId, String roomStatus) {
        try {
                em.getManagerEntities()
                     .createNativeQuery("UPDATE rooms SET status='" + roomStatus + "' WHERE room_id='" + roomId + "' and status <> 'occupied'", Rooms.class)
                     .getResultList();  
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return true;
    }
    
    public boolean ForceUpdateRoomStatus(int roomId, String roomStatus) {
        try {
                em.getManagerEntities()
                     .createNativeQuery("UPDATE rooms SET status='" + roomStatus + "' WHERE room_id='" + roomId + "'", Rooms.class)
                     .getResultList();  
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return true;
    }
    
    public List<Integer> GetAllAvailableRooms(int buildingId) {
        try {
                List<Integer> list = new ArrayList<>(); 
                
                List<Rooms> rooms = em.getManagerEntities()
                     .createNativeQuery("SELECT * FROM rooms WHERE build_id = '" + buildingId + "' and status <> 'occupied' order by room_id asc", Rooms.class)
                     .getResultList();
                
                for(int i = 0; i < rooms.size(); i++)
                    list.add(rooms.get(i).getRoomId());
                
                return list;
            }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return new ArrayList<>();
    }
}
