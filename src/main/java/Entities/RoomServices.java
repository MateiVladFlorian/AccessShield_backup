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
@Table(name = "room_services")
@NamedQueries({
    @NamedQuery(name = "RoomServices.findAll", query = "SELECT r FROM RoomServices r"),
    @NamedQuery(name = "RoomServices.findByServiceId", query = "SELECT r FROM RoomServices r WHERE r.serviceId = :serviceId"),
    @NamedQuery(name = "RoomServices.findByServiceType", query = "SELECT r FROM RoomServices r WHERE r.serviceType = :serviceType"),
    @NamedQuery(name = "RoomServices.findByServiceDescription", query = "SELECT r FROM RoomServices r WHERE r.serviceDescription = :serviceDescription"),
    @NamedQuery(name = "RoomServices.findByServiceTime", query = "SELECT r FROM RoomServices r WHERE r.serviceTime = :serviceTime")})
public class RoomServices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "service_description")
    private String serviceDescription;
    @Column(name = "service_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceTime;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public RoomServices() {
    }

    public RoomServices(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public RoomServices(Integer serviceId, String serviceType) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomServices)) {
            return false;
        }
        RoomServices other = (RoomServices) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoomServices[ serviceId=" + serviceId + " ]";
    }
    
}
