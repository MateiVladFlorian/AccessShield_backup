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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "notification_events")
@NamedQueries({
    @NamedQuery(name = "NotificationEvents.findAll", query = "SELECT n FROM NotificationEvents n"),
    @NamedQuery(name = "NotificationEvents.findByEventId", query = "SELECT n FROM NotificationEvents n WHERE n.eventId = :eventId"),
    @NamedQuery(name = "NotificationEvents.findByEventType", query = "SELECT n FROM NotificationEvents n WHERE n.eventType = :eventType"),
    @NamedQuery(name = "NotificationEvents.findByEventDescription", query = "SELECT n FROM NotificationEvents n WHERE n.eventDescription = :eventDescription"),
    @NamedQuery(name = "NotificationEvents.findByPriority", query = "SELECT n FROM NotificationEvents n WHERE n.priority = :priority"),
    @NamedQuery(name = "NotificationEvents.findByDefaultNotificationMessage", query = "SELECT n FROM NotificationEvents n WHERE n.defaultNotificationMessage = :defaultNotificationMessage")})
public class NotificationEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "event_description")
    private String eventDescription;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "default_notification_message")
    private String defaultNotificationMessage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<Notifications> notificationsCollection;

    public NotificationEvents() {
    }

    public NotificationEvents(Integer eventId) {
        this.eventId = eventId;
    }

    public NotificationEvents(Integer eventId, String eventType, String priority, String defaultNotificationMessage) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.priority = priority;
        this.defaultNotificationMessage = defaultNotificationMessage;
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

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDefaultNotificationMessage() {
        return defaultNotificationMessage;
    }

    public void setDefaultNotificationMessage(String defaultNotificationMessage) {
        this.defaultNotificationMessage = defaultNotificationMessage;
    }

    public Collection<Notifications> getNotificationsCollection() {
        return notificationsCollection;
    }

    public void setNotificationsCollection(Collection<Notifications> notificationsCollection) {
        this.notificationsCollection = notificationsCollection;
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
        if (!(object instanceof NotificationEvents)) {
            return false;
        }
        NotificationEvents other = (NotificationEvents) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NotificationEvents[ eventId=" + eventId + " ]";
    }
    
}
