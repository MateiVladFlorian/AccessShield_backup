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
@Table(name = "billing_info")
@NamedQueries({
    @NamedQuery(name = "BillingInfo.findAll", query = "SELECT b FROM BillingInfo b"),
    @NamedQuery(name = "BillingInfo.findByBillingId", query = "SELECT b FROM BillingInfo b WHERE b.billingId = :billingId"),
    @NamedQuery(name = "BillingInfo.findByBillingAddress", query = "SELECT b FROM BillingInfo b WHERE b.billingAddress = :billingAddress"),
    @NamedQuery(name = "BillingInfo.findByCardType", query = "SELECT b FROM BillingInfo b WHERE b.cardType = :cardType"),
    @NamedQuery(name = "BillingInfo.findByCardNumber", query = "SELECT b FROM BillingInfo b WHERE b.cardNumber = :cardNumber"),
    @NamedQuery(name = "BillingInfo.findByExpiryDate", query = "SELECT b FROM BillingInfo b WHERE b.expiryDate = :expiryDate")})
public class BillingInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "billing_id")
    private Integer billingId;
    @Basic(optional = false)
    @Column(name = "billing_address")
    private String billingAddress;
    @Basic(optional = false)
    @Column(name = "card_type")
    private String cardType;
    @Basic(optional = false)
    @Column(name = "card_number")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private Collection<TransactionAuditLogs> transactionAuditLogsCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private Collection<Reservations> reservationsCollection;

    public BillingInfo() {
    }

    public BillingInfo(Integer billingId) {
        this.billingId = billingId;
    }

    public BillingInfo(Integer billingId, String billingAddress, String cardType, String cardNumber, Date expiryDate) {
        this.billingId = billingId;
        this.billingAddress = billingAddress;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public Integer getBillingId() {
        return billingId;
    }

    public void setBillingId(Integer billingId) {
        this.billingId = billingId;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Collection<TransactionAuditLogs> getTransactionAuditLogsCollection() {
        return transactionAuditLogsCollection;
    }

    public void setTransactionAuditLogsCollection(Collection<TransactionAuditLogs> transactionAuditLogsCollection) {
        this.transactionAuditLogsCollection = transactionAuditLogsCollection;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billingId != null ? billingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillingInfo)) {
            return false;
        }
        BillingInfo other = (BillingInfo) object;
        if ((this.billingId == null && other.billingId != null) || (this.billingId != null && !this.billingId.equals(other.billingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.BillingInfo[ billingId=" + billingId + " ]";
    }
    
}
