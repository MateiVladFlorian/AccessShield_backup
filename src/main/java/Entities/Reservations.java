/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "reservations")
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r"),
    @NamedQuery(name = "Reservations.findByReservationId", query = "SELECT r FROM Reservations r WHERE r.reservationId = :reservationId"),
    @NamedQuery(name = "Reservations.findByCheckIn", query = "SELECT r FROM Reservations r WHERE r.checkIn = :checkIn"),
    @NamedQuery(name = "Reservations.findByCheckOut", query = "SELECT r FROM Reservations r WHERE r.checkOut = :checkOut"),
    @NamedQuery(name = "Reservations.findByStatus", query = "SELECT r FROM Reservations r WHERE r.status = :status")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Basic(optional = false)
    @Column(name = "check_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Basic(optional = false)
    @Column(name = "check_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId")
    private Collection<ReservationsHistory> reservationsHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId")
    private Collection<Payments> paymentsCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "billing_id", referencedColumnName = "billing_id")
    @ManyToOne(optional = false)
    private BillingInfo billingId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public Reservations() {
    }

    public Reservations(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Reservations(Integer reservationId, Date checkIn, Date checkOut, String status) {
        this.reservationId = reservationId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<ReservationsHistory> getReservationsHistoryCollection() {
        return reservationsHistoryCollection;
    }

    public void setReservationsHistoryCollection(Collection<ReservationsHistory> reservationsHistoryCollection) {
        this.reservationsHistoryCollection = reservationsHistoryCollection;
    }

    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public BillingInfo getBillingId() {
        return billingId;
    }

    public void setBillingId(BillingInfo billingId) {
        this.billingId = billingId;
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
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Reservations[ reservationId=" + reservationId + " ]";
    }
    
}
