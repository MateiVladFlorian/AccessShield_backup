/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "payments")
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findByPaymentId", query = "SELECT p FROM Payments p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Payments.findByAmount", query = "SELECT p FROM Payments p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payments.findByPaymentDate", query = "SELECT p FROM Payments p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payments.findByPaymentStatus", query = "SELECT p FROM Payments p WHERE p.paymentStatus = :paymentStatus")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Basic(optional = false)
    @Column(name = "payment_status")
    private String paymentStatus;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")
    @ManyToOne(optional = false)
    private Reservations reservationId;
    @JoinColumn(name = "audit_id", referencedColumnName = "audit_id")
    @ManyToOne(optional = false)
    private TransactionAuditLogs auditId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentId")
    private Collection<PaymentMethods> paymentMethodsCollection;

    public Payments() {
    }

    public Payments(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Payments(Integer paymentId, BigDecimal amount, String paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Reservations getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservations reservationId) {
        this.reservationId = reservationId;
    }

    public TransactionAuditLogs getAuditId() {
        return auditId;
    }

    public void setAuditId(TransactionAuditLogs auditId) {
        this.auditId = auditId;
    }

    public Collection<PaymentMethods> getPaymentMethodsCollection() {
        return paymentMethodsCollection;
    }

    public void setPaymentMethodsCollection(Collection<PaymentMethods> paymentMethodsCollection) {
        this.paymentMethodsCollection = paymentMethodsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Payments[ paymentId=" + paymentId + " ]";
    }
    
}
