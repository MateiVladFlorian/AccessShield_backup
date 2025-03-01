/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "Booking.findByCheckIn", query = "SELECT b FROM Booking b WHERE b.checkIn = :checkIn"),
    @NamedQuery(name = "Booking.findByCheckOut", query = "SELECT b FROM Booking b WHERE b.checkOut = :checkOut"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @Column(name = "check_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Basic(optional = false)
    @Column(name = "check_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, Date checkIn, Date checkOut, String status) {
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Rooms getRoomId() {
        return roomId;
    }

    public void setRoomId(Rooms roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
