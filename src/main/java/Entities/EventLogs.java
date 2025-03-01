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
@Table(name = "event_logs")
@NamedQueries({
    @NamedQuery(name = "EventLogs.findAll", query = "SELECT e FROM EventLogs e"),
    @NamedQuery(name = "EventLogs.findByEventId", query = "SELECT e FROM EventLogs e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "EventLogs.findByEventType", query = "SELECT e FROM EventLogs e WHERE e.eventType = :eventType"),
    @NamedQuery(name = "EventLogs.findByEventDetails", query = "SELECT e FROM EventLogs e WHERE e.eventDetails = :eventDetails"),
    @NamedQuery(name = "EventLogs.findByCreatedAt", query = "SELECT e FROM EventLogs e WHERE e.createdAt = :createdAt")})
public class EventLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "event_details")
    private String eventDetails;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public EventLogs() {
    }

    public EventLogs(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventLogs)) {
            return false;
        }
        EventLogs other = (EventLogs) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EventLogs[ eventId=" + eventId + " ]";
    }
    
}
