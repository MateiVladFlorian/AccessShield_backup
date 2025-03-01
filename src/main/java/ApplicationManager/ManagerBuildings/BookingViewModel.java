/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationManager.ManagerBuildings;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author vlad
 */
public class BookingViewModel {
    public String name;
    public int room_id;
    public BigDecimal totalPrice;
    public Timestamp check_in;
    public Timestamp check_out;
    public String status;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getRoomId() {
        return room_id;
    }
    
    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }
    
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public Timestamp getCheckIn() {
        return check_in;
    }
    
    public void setCheckIn(Timestamp check_in) {
        this.check_in = check_in;
    }
    
    public Timestamp getCheckOut() {
        return check_out;
    }
    
    public void setCheckOut(Timestamp check_out) {
        this.check_out = check_out;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
