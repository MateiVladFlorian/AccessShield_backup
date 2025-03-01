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
@Table(name = "user_profile")
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findById", query = "SELECT u FROM UserProfile u WHERE u.id = :id"),
    @NamedQuery(name = "UserProfile.findByImageProfile", query = "SELECT u FROM UserProfile u WHERE u.imageProfile = :imageProfile"),
    @NamedQuery(name = "UserProfile.findByName", query = "SELECT u FROM UserProfile u WHERE u.name = :name"),
    @NamedQuery(name = "UserProfile.findByCountry", query = "SELECT u FROM UserProfile u WHERE u.country = :country"),
    @NamedQuery(name = "UserProfile.findByNumberPhone", query = "SELECT u FROM UserProfile u WHERE u.numberPhone = :numberPhone"),
    @NamedQuery(name = "UserProfile.findByDescription", query = "SELECT u FROM UserProfile u WHERE u.description = :description")})
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "image_profile")
    private String imageProfile;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "number_phone")
    private String numberPhone;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public UserProfile() {
    }

    public UserProfile(Integer id) {
        this.id = id;
    }

    public UserProfile(Integer id, String imageProfile, String name, String country, String numberPhone) {
        this.id = id;
        this.imageProfile = imageProfile;
        this.name = name;
        this.country = country;
        this.numberPhone = numberPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UserProfile[ id=" + id + " ]";
    }
    
}
