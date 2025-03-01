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
@Table(name = "transaction_audit_logs")
@NamedQueries({
    @NamedQuery(name = "TransactionAuditLogs.findAll", query = "SELECT t FROM TransactionAuditLogs t"),
    @NamedQuery(name = "TransactionAuditLogs.findByAuditId", query = "SELECT t FROM TransactionAuditLogs t WHERE t.auditId = :auditId"),
    @NamedQuery(name = "TransactionAuditLogs.findByActionType", query = "SELECT t FROM TransactionAuditLogs t WHERE t.actionType = :actionType"),
    @NamedQuery(name = "TransactionAuditLogs.findByTimestamp", query = "SELECT t FROM TransactionAuditLogs t WHERE t.timestamp = :timestamp"),
    @NamedQuery(name = "TransactionAuditLogs.findByDetails", query = "SELECT t FROM TransactionAuditLogs t WHERE t.details = :details")})
public class TransactionAuditLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "audit_id")
    private Integer auditId;
    @Basic(optional = false)
    @Column(name = "action_type")
    private String actionType;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "details")
    private String details;
    @JoinColumn(name = "performed_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account performedBy;
    @JoinColumn(name = "billing_id", referencedColumnName = "billing_id")
    @ManyToOne(optional = false)
    private BillingInfo billingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auditId")
    private Collection<Payments> paymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auditId")
    private Collection<Transactions> transactionsCollection;

    public TransactionAuditLogs() {
    }

    public TransactionAuditLogs(Integer auditId) {
        this.auditId = auditId;
    }

    public TransactionAuditLogs(Integer auditId, String actionType, Date timestamp) {
        this.auditId = auditId;
        this.actionType = actionType;
        this.timestamp = timestamp;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Account getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(Account performedBy) {
        this.performedBy = performedBy;
    }

    public BillingInfo getBillingId() {
        return billingId;
    }

    public void setBillingId(BillingInfo billingId) {
        this.billingId = billingId;
    }

    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditId != null ? auditId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionAuditLogs)) {
            return false;
        }
        TransactionAuditLogs other = (TransactionAuditLogs) object;
        if ((this.auditId == null && other.auditId != null) || (this.auditId != null && !this.auditId.equals(other.auditId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TransactionAuditLogs[ auditId=" + auditId + " ]";
    }
    
}
