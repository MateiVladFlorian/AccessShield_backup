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
@Table(name = "users_sessions")
@NamedQueries({
    @NamedQuery(name = "UsersSessions.findAll", query = "SELECT u FROM UsersSessions u"),
    @NamedQuery(name = "UsersSessions.findBySessionId", query = "SELECT u FROM UsersSessions u WHERE u.sessionId = :sessionId"),
    @NamedQuery(name = "UsersSessions.findByDeviceId", query = "SELECT u FROM UsersSessions u WHERE u.deviceId = :deviceId"),
    @NamedQuery(name = "UsersSessions.findByLastActivity", query = "SELECT u FROM UsersSessions u WHERE u.lastActivity = :lastActivity"),
    @NamedQuery(name = "UsersSessions.findByCreatedAt", query = "SELECT u FROM UsersSessions u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "UsersSessions.findByIsActive", query = "SELECT u FROM UsersSessions u WHERE u.isActive = :isActive")})
public class UsersSessions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "session_id")
    private Integer sessionId;
    @Basic(optional = false)
    @Column(name = "device_id")
    private String deviceId;
    @Basic(optional = false)
    @Column(name = "last_activity")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivity;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "is_active")
    private Boolean isActive;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public UsersSessions() {
    }

    public UsersSessions(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public UsersSessions(Integer sessionId, String deviceId, Date lastActivity) {
        this.sessionId = sessionId;
        this.deviceId = deviceId;
        this.lastActivity = lastActivity;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersSessions)) {
            return false;
        }
        UsersSessions other = (UsersSessions) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UsersSessions[ sessionId=" + sessionId + " ]";
    }
    
}
