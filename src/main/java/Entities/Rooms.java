/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "rooms")
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByRoomId", query = "SELECT r FROM Rooms r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "Rooms.findByRoomNumber", query = "SELECT r FROM Rooms r WHERE r.roomNumber = :roomNumber"),
    @NamedQuery(name = "Rooms.findByRoomType", query = "SELECT r FROM Rooms r WHERE r.roomType = :roomType"),
    @NamedQuery(name = "Rooms.findByCapacity", query = "SELECT r FROM Rooms r WHERE r.capacity = :capacity"),
    @NamedQuery(name = "Rooms.findByStatus", query = "SELECT r FROM Rooms r WHERE r.status = :status")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "room_id")
    private Integer roomId;
    @Basic(optional = false)
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "build_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Building buildId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<MaintenanceLogs> maintenanceLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<AccessRoom> accessRoomCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<RoomAccessCards> roomAccessCardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<RoomServices> roomServicesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<Reservations> reservationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<RoomsAmenities> roomsAmenitiesCollection;

    public Rooms() {
    }

    public Rooms(Integer roomId) {
        this.roomId = roomId;
    }

    public Rooms(Integer roomId, String roomNumber) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Building getBuildId() {
        return buildId;
    }

    public void setBuildId(Building buildId) {
        this.buildId = buildId;
    }

    public Collection<MaintenanceLogs> getMaintenanceLogsCollection() {
        return maintenanceLogsCollection;
    }

    public void setMaintenanceLogsCollection(Collection<MaintenanceLogs> maintenanceLogsCollection) {
        this.maintenanceLogsCollection = maintenanceLogsCollection;
    }

    public Collection<AccessRoom> getAccessRoomCollection() {
        return accessRoomCollection;
    }

    public void setAccessRoomCollection(Collection<AccessRoom> accessRoomCollection) {
        this.accessRoomCollection = accessRoomCollection;
    }

    public Collection<RoomAccessCards> getRoomAccessCardsCollection() {
        return roomAccessCardsCollection;
    }

    public void setRoomAccessCardsCollection(Collection<RoomAccessCards> roomAccessCardsCollection) {
        this.roomAccessCardsCollection = roomAccessCardsCollection;
    }

    public Collection<RoomServices> getRoomServicesCollection() {
        return roomServicesCollection;
    }

    public void setRoomServicesCollection(Collection<RoomServices> roomServicesCollection) {
        this.roomServicesCollection = roomServicesCollection;
    }

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    public Collection<RoomsAmenities> getRoomsAmenitiesCollection() {
        return roomsAmenitiesCollection;
    }

    public void setRoomsAmenitiesCollection(Collection<RoomsAmenities> roomsAmenitiesCollection) {
        this.roomsAmenitiesCollection = roomsAmenitiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Rooms[ roomId=" + roomId + " ]";
    }
    
}
