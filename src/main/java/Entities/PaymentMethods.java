/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
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

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "payment_methods")
@NamedQueries({
    @NamedQuery(name = "PaymentMethods.findAll", query = "SELECT p FROM PaymentMethods p"),
    @NamedQuery(name = "PaymentMethods.findByMethodId", query = "SELECT p FROM PaymentMethods p WHERE p.methodId = :methodId"),
    @NamedQuery(name = "PaymentMethods.findByMethodName", query = "SELECT p FROM PaymentMethods p WHERE p.methodName = :methodName"),
    @NamedQuery(name = "PaymentMethods.findByDescription", query = "SELECT p FROM PaymentMethods p WHERE p.description = :description")})
public class PaymentMethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "method_id")
    private Integer methodId;
    @Basic(optional = false)
    @Column(name = "method_name")
    private String methodName;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private Payments paymentId;

    public PaymentMethods() {
    }

    public PaymentMethods(Integer methodId) {
        this.methodId = methodId;
    }

    public PaymentMethods(Integer methodId, String methodName) {
        this.methodId = methodId;
        this.methodName = methodName;
    }

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Payments getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payments paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (methodId != null ? methodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethods)) {
            return false;
        }
        PaymentMethods other = (PaymentMethods) object;
        if ((this.methodId == null && other.methodId != null) || (this.methodId != null && !this.methodId.equals(other.methodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PaymentMethods[ methodId=" + methodId + " ]";
    }
    
}
