/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
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

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "rooms_amenities")
@NamedQueries({
    @NamedQuery(name = "RoomsAmenities.findAll", query = "SELECT r FROM RoomsAmenities r"),
    @NamedQuery(name = "RoomsAmenities.findByAmenityId", query = "SELECT r FROM RoomsAmenities r WHERE r.amenityId = :amenityId"),
    @NamedQuery(name = "RoomsAmenities.findByAmenityName", query = "SELECT r FROM RoomsAmenities r WHERE r.amenityName = :amenityName"),
    @NamedQuery(name = "RoomsAmenities.findByDescription", query = "SELECT r FROM RoomsAmenities r WHERE r.description = :description")})
public class RoomsAmenities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "amenity_id")
    private Integer amenityId;
    @Basic(optional = false)
    @Column(name = "amenity_name")
    private String amenityName;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public RoomsAmenities() {
    }

    public RoomsAmenities(Integer amenityId) {
        this.amenityId = amenityId;
    }

    public RoomsAmenities(Integer amenityId, String amenityName) {
        this.amenityId = amenityId;
        this.amenityName = amenityName;
    }

    public Integer getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Integer amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (amenityId != null ? amenityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomsAmenities)) {
            return false;
        }
        RoomsAmenities other = (RoomsAmenities) object;
        if ((this.amenityId == null && other.amenityId != null) || (this.amenityId != null && !this.amenityId.equals(other.amenityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoomsAmenities[ amenityId=" + amenityId + " ]";
    }
    
}
