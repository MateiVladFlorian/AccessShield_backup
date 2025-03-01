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
@Table(name = "audit_logs")
@NamedQueries({
    @NamedQuery(name = "AuditLogs.findAll", query = "SELECT a FROM AuditLogs a"),
    @NamedQuery(name = "AuditLogs.findByLogId", query = "SELECT a FROM AuditLogs a WHERE a.logId = :logId"),
    @NamedQuery(name = "AuditLogs.findByReservationId", query = "SELECT a FROM AuditLogs a WHERE a.reservationId = :reservationId"),
    @NamedQuery(name = "AuditLogs.findByAction", query = "SELECT a FROM AuditLogs a WHERE a.action = :action"),
    @NamedQuery(name = "AuditLogs.findByActionTime", query = "SELECT a FROM AuditLogs a WHERE a.actionTime = :actionTime"),
    @NamedQuery(name = "AuditLogs.findByIpAddress", query = "SELECT a FROM AuditLogs a WHERE a.ipAddress = :ipAddress"),
    @NamedQuery(name = "AuditLogs.findByUserAgent", query = "SELECT a FROM AuditLogs a WHERE a.userAgent = :userAgent")})
public class AuditLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "reservation_id")
    private int reservationId;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @Column(name = "action_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionTime;
    @Basic(optional = false)
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "user_agent")
    private String userAgent;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public AuditLogs() {
    }

    public AuditLogs(Integer logId) {
        this.logId = logId;
    }

    public AuditLogs(Integer logId, int reservationId, String action, String ipAddress) {
        this.logId = logId;
        this.reservationId = reservationId;
        this.action = action;
        this.ipAddress = ipAddress;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditLogs)) {
            return false;
        }
        AuditLogs other = (AuditLogs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AuditLogs[ logId=" + logId + " ]";
    }
    
}
