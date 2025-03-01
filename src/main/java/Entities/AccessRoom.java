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
@Table(name = "access_room")
@NamedQueries({
    @NamedQuery(name = "AccessRoom.findAll", query = "SELECT a FROM AccessRoom a"),
    @NamedQuery(name = "AccessRoom.findByAccessId", query = "SELECT a FROM AccessRoom a WHERE a.accessId = :accessId"),
    @NamedQuery(name = "AccessRoom.findByAccessTime", query = "SELECT a FROM AccessRoom a WHERE a.accessTime = :accessTime"),
    @NamedQuery(name = "AccessRoom.findByExitTime", query = "SELECT a FROM AccessRoom a WHERE a.exitTime = :exitTime"),
    @NamedQuery(name = "AccessRoom.findByAccessGranted", query = "SELECT a FROM AccessRoom a WHERE a.accessGranted = :accessGranted"),
    @NamedQuery(name = "AccessRoom.findByAccessReason", query = "SELECT a FROM AccessRoom a WHERE a.accessReason = :accessReason"),
    @NamedQuery(name = "AccessRoom.findByStatus", query = "SELECT a FROM AccessRoom a WHERE a.status = :status")})
public class AccessRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "access_id")
    private Integer accessId;
    @Column(name = "access_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessTime;
    @Column(name = "exit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitTime;
    @Basic(optional = false)
    @Column(name = "access_granted")
    private boolean accessGranted;
    @Column(name = "access_reason")
    private String accessReason;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public AccessRoom() {
    }

    public AccessRoom(Integer accessId) {
        this.accessId = accessId;
    }

    public AccessRoom(Integer accessId, boolean accessGranted) {
        this.accessId = accessId;
        this.accessGranted = accessGranted;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public boolean getAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public String getAccessReason() {
        return accessReason;
    }

    public void setAccessReason(String accessReason) {
        this.accessReason = accessReason;
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
        hash += (accessId != null ? accessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessRoom)) {
            return false;
        }
        AccessRoom other = (AccessRoom) object;
        if ((this.accessId == null && other.accessId != null) || (this.accessId != null && !this.accessId.equals(other.accessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AccessRoom[ accessId=" + accessId + " ]";
    }
    
}
