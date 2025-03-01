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
@Table(name = "access_logs")
@NamedQueries({
    @NamedQuery(name = "AccessLogs.findAll", query = "SELECT a FROM AccessLogs a"),
    @NamedQuery(name = "AccessLogs.findByLogId", query = "SELECT a FROM AccessLogs a WHERE a.logId = :logId"),
    @NamedQuery(name = "AccessLogs.findByAccessId", query = "SELECT a FROM AccessLogs a WHERE a.accessId = :accessId"),
    @NamedQuery(name = "AccessLogs.findByAccessTime", query = "SELECT a FROM AccessLogs a WHERE a.accessTime = :accessTime"),
    @NamedQuery(name = "AccessLogs.findByExitTime", query = "SELECT a FROM AccessLogs a WHERE a.exitTime = :exitTime"),
    @NamedQuery(name = "AccessLogs.findByAccessGranted", query = "SELECT a FROM AccessLogs a WHERE a.accessGranted = :accessGranted"),
    @NamedQuery(name = "AccessLogs.findByStatus", query = "SELECT a FROM AccessLogs a WHERE a.status = :status")})
public class AccessLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "access_id")
    private int accessId;
    @Basic(optional = false)
    @Column(name = "access_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessTime;
    @Column(name = "exit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitTime;
    @Basic(optional = false)
    @Column(name = "access_granted")
    private boolean accessGranted;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public AccessLogs() {
    }

    public AccessLogs(Integer logId) {
        this.logId = logId;
    }

    public AccessLogs(Integer logId, int accessId, Date accessTime, boolean accessGranted) {
        this.logId = logId;
        this.accessId = accessId;
        this.accessTime = accessTime;
        this.accessGranted = accessGranted;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessLogs)) {
            return false;
        }
        AccessLogs other = (AccessLogs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AccessLogs[ logId=" + logId + " ]";
    }
    
}
