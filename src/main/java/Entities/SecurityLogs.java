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
@Table(name = "security_logs")
@NamedQueries({
    @NamedQuery(name = "SecurityLogs.findAll", query = "SELECT s FROM SecurityLogs s"),
    @NamedQuery(name = "SecurityLogs.findByLogId", query = "SELECT s FROM SecurityLogs s WHERE s.logId = :logId"),
    @NamedQuery(name = "SecurityLogs.findByEventType", query = "SELECT s FROM SecurityLogs s WHERE s.eventType = :eventType"),
    @NamedQuery(name = "SecurityLogs.findByEventDetails", query = "SELECT s FROM SecurityLogs s WHERE s.eventDetails = :eventDetails"),
    @NamedQuery(name = "SecurityLogs.findByEventTime", query = "SELECT s FROM SecurityLogs s WHERE s.eventTime = :eventTime")})
public class SecurityLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "event_details")
    private String eventDetails;
    @Column(name = "event_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTime;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public SecurityLogs() {
    }

    public SecurityLogs(Integer logId) {
        this.logId = logId;
    }

    public SecurityLogs(Integer logId, String eventType) {
        this.logId = logId;
        this.eventType = eventType;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
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
        if (!(object instanceof SecurityLogs)) {
            return false;
        }
        SecurityLogs other = (SecurityLogs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SecurityLogs[ logId=" + logId + " ]";
    }
    
}
