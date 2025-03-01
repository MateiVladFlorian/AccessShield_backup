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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByCnp", query = "SELECT a FROM Account a WHERE a.cnp = :cnp"),
    @NamedQuery(name = "Account.findByLocation", query = "SELECT a FROM Account a WHERE a.location = :location"),
    @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status"),
    @NamedQuery(name = "Account.findByDatetimeconnected", query = "SELECT a FROM Account a WHERE a.datetimeconnected = :datetimeconnected")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "cnp")
    private String cnp;
    @Column(name = "location")
    private String location;
    @Column(name = "status")
    private String status;
    @Column(name = "datetimeconnected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeconnected;
    @OneToMany(mappedBy = "accountId")
    private Collection<UserIdentifier> userIdentifierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Booking> bookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<ReservationsHistory> reservationsHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "performedBy")
    private Collection<TransactionAuditLogs> transactionAuditLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Payments> paymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<UsersRoles> usersRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<UserProfile> userProfileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AuditLogs> auditLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<SecurityLogs> securityLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Building> buildingCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Feedback feedback;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<BillingInfo> billingInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Reviews> reviewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccessLogs> accessLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<AccessRoom> accessRoomCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<RoomAccessCards> roomAccessCardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Transactions> transactionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Promotions> promotionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Reservations> reservationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<UsersSessions> usersSessionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Notifications> notificationsCollection;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String username, String email, String password, String cnp) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cnp = cnp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatetimeconnected() {
        return datetimeconnected;
    }

    public void setDatetimeconnected(Date datetimeconnected) {
        this.datetimeconnected = datetimeconnected;
    }

    public Collection<UserIdentifier> getUserIdentifierCollection() {
        return userIdentifierCollection;
    }

    public void setUserIdentifierCollection(Collection<UserIdentifier> userIdentifierCollection) {
        this.userIdentifierCollection = userIdentifierCollection;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Collection<ReservationsHistory> getReservationsHistoryCollection() {
        return reservationsHistoryCollection;
    }

    public void setReservationsHistoryCollection(Collection<ReservationsHistory> reservationsHistoryCollection) {
        this.reservationsHistoryCollection = reservationsHistoryCollection;
    }

    public Collection<TransactionAuditLogs> getTransactionAuditLogsCollection() {
        return transactionAuditLogsCollection;
    }

    public void setTransactionAuditLogsCollection(Collection<TransactionAuditLogs> transactionAuditLogsCollection) {
        this.transactionAuditLogsCollection = transactionAuditLogsCollection;
    }

    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    public Collection<UsersRoles> getUsersRolesCollection() {
        return usersRolesCollection;
    }

    public void setUsersRolesCollection(Collection<UsersRoles> usersRolesCollection) {
        this.usersRolesCollection = usersRolesCollection;
    }

    public Collection<UserProfile> getUserProfileCollection() {
        return userProfileCollection;
    }

    public void setUserProfileCollection(Collection<UserProfile> userProfileCollection) {
        this.userProfileCollection = userProfileCollection;
    }

    public Collection<AuditLogs> getAuditLogsCollection() {
        return auditLogsCollection;
    }

    public void setAuditLogsCollection(Collection<AuditLogs> auditLogsCollection) {
        this.auditLogsCollection = auditLogsCollection;
    }

    public Collection<SecurityLogs> getSecurityLogsCollection() {
        return securityLogsCollection;
    }

    public void setSecurityLogsCollection(Collection<SecurityLogs> securityLogsCollection) {
        this.securityLogsCollection = securityLogsCollection;
    }

    public Collection<Building> getBuildingCollection() {
        return buildingCollection;
    }

    public void setBuildingCollection(Collection<Building> buildingCollection) {
        this.buildingCollection = buildingCollection;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Collection<BillingInfo> getBillingInfoCollection() {
        return billingInfoCollection;
    }

    public void setBillingInfoCollection(Collection<BillingInfo> billingInfoCollection) {
        this.billingInfoCollection = billingInfoCollection;
    }

    public Collection<Reviews> getReviewsCollection() {
        return reviewsCollection;
    }

    public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    public Collection<AccessLogs> getAccessLogsCollection() {
        return accessLogsCollection;
    }

    public void setAccessLogsCollection(Collection<AccessLogs> accessLogsCollection) {
        this.accessLogsCollection = accessLogsCollection;
    }

    public Collection<AccessRoom> getAccessRoomCollection() {
        return accessRoomCollection;
    }

    public void setAccessRoomCollection(Collection<AccessRoom> accessRoomCollection) {
        this.accessRoomCollection = accessRoomCollection;
    }

    public Collection<RoomAccessCards> getRoomAccessCardsCollection() {
        return roomAccessCardsCollection;
    }

    public void setRoomAccessCardsCollection(Collection<RoomAccessCards> roomAccessCardsCollection) {
        this.roomAccessCardsCollection = roomAccessCardsCollection;
    }

    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    public Collection<Promotions> getPromotionsCollection() {
        return promotionsCollection;
    }

    public void setPromotionsCollection(Collection<Promotions> promotionsCollection) {
        this.promotionsCollection = promotionsCollection;
    }

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    public Collection<UsersSessions> getUsersSessionsCollection() {
        return usersSessionsCollection;
    }

    public void setUsersSessionsCollection(Collection<UsersSessions> usersSessionsCollection) {
        this.usersSessionsCollection = usersSessionsCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Account[ id=" + id + " ]";
    }
    
}
