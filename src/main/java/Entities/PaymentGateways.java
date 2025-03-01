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
@Table(name = "payment_gateways")
@NamedQueries({
    @NamedQuery(name = "PaymentGateways.findAll", query = "SELECT p FROM PaymentGateways p"),
    @NamedQuery(name = "PaymentGateways.findByGatewayId", query = "SELECT p FROM PaymentGateways p WHERE p.gatewayId = :gatewayId"),
    @NamedQuery(name = "PaymentGateways.findByGatewayName", query = "SELECT p FROM PaymentGateways p WHERE p.gatewayName = :gatewayName"),
    @NamedQuery(name = "PaymentGateways.findByApiUrl", query = "SELECT p FROM PaymentGateways p WHERE p.apiUrl = :apiUrl"),
    @NamedQuery(name = "PaymentGateways.findByStatus", query = "SELECT p FROM PaymentGateways p WHERE p.status = :status"),
    @NamedQuery(name = "PaymentGateways.findBySupportedCurrencies", query = "SELECT p FROM PaymentGateways p WHERE p.supportedCurrencies = :supportedCurrencies"),
    @NamedQuery(name = "PaymentGateways.findByTransactionFee", query = "SELECT p FROM PaymentGateways p WHERE p.transactionFee = :transactionFee"),
    @NamedQuery(name = "PaymentGateways.findByIntegrationDate", query = "SELECT p FROM PaymentGateways p WHERE p.integrationDate = :integrationDate")})
public class PaymentGateways implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gateway_id")
    private Integer gatewayId;
    @Basic(optional = false)
    @Column(name = "gateway_name")
    private String gatewayName;
    @Basic(optional = false)
    @Column(name = "api_url")
    private String apiUrl;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "supported_currencies")
    private String supportedCurrencies;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "transaction_fee")
    private BigDecimal transactionFee;
    @Basic(optional = false)
    @Column(name = "integration_date")
    @Temporal(TemporalType.DATE)
    private Date integrationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gatewayId")
    private Collection<Transactions> transactionsCollection;

    public PaymentGateways() {
    }

    public PaymentGateways(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public PaymentGateways(Integer gatewayId, String gatewayName, String apiUrl, String status, String supportedCurrencies, BigDecimal transactionFee, Date integrationDate) {
        this.gatewayId = gatewayId;
        this.gatewayName = gatewayName;
        this.apiUrl = apiUrl;
        this.status = status;
        this.supportedCurrencies = supportedCurrencies;
        this.transactionFee = transactionFee;
        this.integrationDate = integrationDate;
    }

    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public void setSupportedCurrencies(String supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Date getIntegrationDate() {
        return integrationDate;
    }

    public void setIntegrationDate(Date integrationDate) {
        this.integrationDate = integrationDate;
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
        hash += (gatewayId != null ? gatewayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentGateways)) {
            return false;
        }
        PaymentGateways other = (PaymentGateways) object;
        if ((this.gatewayId == null && other.gatewayId != null) || (this.gatewayId != null && !this.gatewayId.equals(other.gatewayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PaymentGateways[ gatewayId=" + gatewayId + " ]";
    }
    
}
