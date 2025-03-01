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
@Table(name = "user_identifier")
@NamedQueries({
    @NamedQuery(name = "UserIdentifier.findAll", query = "SELECT u FROM UserIdentifier u"),
    @NamedQuery(name = "UserIdentifier.findByUserIdentifierId", query = "SELECT u FROM UserIdentifier u WHERE u.userIdentifierId = :userIdentifierId"),
    @NamedQuery(name = "UserIdentifier.findByUserCode", query = "SELECT u FROM UserIdentifier u WHERE u.userCode = :userCode")})
public class UserIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_identifier_id")
    private Integer userIdentifierId;
    @Basic(optional = false)
    @Column(name = "user_code")
    private String userCode;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne
    private Account accountId;

    public UserIdentifier() {
    }

    public UserIdentifier(Integer userIdentifierId) {
        this.userIdentifierId = userIdentifierId;
    }

    public UserIdentifier(Integer userIdentifierId, String userCode) {
        this.userIdentifierId = userIdentifierId;
        this.userCode = userCode;
    }

    public Integer getUserIdentifierId() {
        return userIdentifierId;
    }

    public void setUserIdentifierId(Integer userIdentifierId) {
        this.userIdentifierId = userIdentifierId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
        hash += (userIdentifierId != null ? userIdentifierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserIdentifier)) {
            return false;
        }
        UserIdentifier other = (UserIdentifier) object;
        if ((this.userIdentifierId == null && other.userIdentifierId != null) || (this.userIdentifierId != null && !this.userIdentifierId.equals(other.userIdentifierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UserIdentifier[ userIdentifierId=" + userIdentifierId + " ]";
    }
    
}
