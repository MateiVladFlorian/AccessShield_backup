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
@Table(name = "maintenance_logs")
@NamedQueries({
    @NamedQuery(name = "MaintenanceLogs.findAll", query = "SELECT m FROM MaintenanceLogs m"),
    @NamedQuery(name = "MaintenanceLogs.findByMaintenanceId", query = "SELECT m FROM MaintenanceLogs m WHERE m.maintenanceId = :maintenanceId"),
    @NamedQuery(name = "MaintenanceLogs.findByMaintenanceType", query = "SELECT m FROM MaintenanceLogs m WHERE m.maintenanceType = :maintenanceType"),
    @NamedQuery(name = "MaintenanceLogs.findByDescription", query = "SELECT m FROM MaintenanceLogs m WHERE m.description = :description"),
    @NamedQuery(name = "MaintenanceLogs.findByMaintenanceDate", query = "SELECT m FROM MaintenanceLogs m WHERE m.maintenanceDate = :maintenanceDate")})
public class MaintenanceLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maintenance_id")
    private Integer maintenanceId;
    @Basic(optional = false)
    @Column(name = "maintenance_type")
    private String maintenanceType;
    @Column(name = "description")
    private String description;
    @Column(name = "maintenance_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maintenanceDate;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public MaintenanceLogs() {
    }

    public MaintenanceLogs(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public MaintenanceLogs(Integer maintenanceId, String maintenanceType) {
        this.maintenanceId = maintenanceId;
        this.maintenanceType = maintenanceType;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
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
        hash += (maintenanceId != null ? maintenanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaintenanceLogs)) {
            return false;
        }
        MaintenanceLogs other = (MaintenanceLogs) object;
        if ((this.maintenanceId == null && other.maintenanceId != null) || (this.maintenanceId != null && !this.maintenanceId.equals(other.maintenanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MaintenanceLogs[ maintenanceId=" + maintenanceId + " ]";
    }
    
}
