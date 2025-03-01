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
@Table(name = "users_roles")
@NamedQueries({
    @NamedQuery(name = "UsersRoles.findAll", query = "SELECT u FROM UsersRoles u"),
    @NamedQuery(name = "UsersRoles.findByUserRoleId", query = "SELECT u FROM UsersRoles u WHERE u.userRoleId = :userRoleId"),
    @NamedQuery(name = "UsersRoles.findByRole", query = "SELECT u FROM UsersRoles u WHERE u.role = :role")})
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_role_id")
    private Integer userRoleId;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public UsersRoles() {
    }

    public UsersRoles(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UsersRoles(Integer userRoleId, String role) {
        this.userRoleId = userRoleId;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UsersRoles[ userRoleId=" + userRoleId + " ]";
    }
    
}
