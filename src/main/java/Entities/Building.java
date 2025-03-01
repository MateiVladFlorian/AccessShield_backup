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
@Table(name = "building")
@NamedQueries({
    @NamedQuery(name = "Building.findAll", query = "SELECT b FROM Building b"),
    @NamedQuery(name = "Building.findById", query = "SELECT b FROM Building b WHERE b.id = :id"),
    @NamedQuery(name = "Building.findByName", query = "SELECT b FROM Building b WHERE b.name = :name"),
    @NamedQuery(name = "Building.findByCountRooms", query = "SELECT b FROM Building b WHERE b.countRooms = :countRooms"),
    @NamedQuery(name = "Building.findByPrice", query = "SELECT b FROM Building b WHERE b.price = :price"),
    @NamedQuery(name = "Building.findByAccessKey", query = "SELECT b FROM Building b WHERE b.accessKey = :accessKey"),
    @NamedQuery(name = "Building.findByAddressLocation", query = "SELECT b FROM Building b WHERE b.addressLocation = :addressLocation"),
    @NamedQuery(name = "Building.findByCreatedAt", query = "SELECT b FROM Building b WHERE b.createdAt = :createdAt")})
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "count_rooms")
    private int countRooms;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "access_key")
    private String accessKey;
    @Basic(optional = false)
    @Column(name = "address_location")
    private String addressLocation;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buildId")
    private Collection<Rooms> roomsCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public Building() {
    }

    public Building(Integer id) {
        this.id = id;
    }

    public Building(Integer id, String name, int countRooms, BigDecimal price, String accessKey, String addressLocation) {
        this.id = id;
        this.name = name;
        this.countRooms = countRooms;
        this.price = price;
        this.accessKey = accessKey;
        this.addressLocation = addressLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Rooms> getRoomsCollection() {
        return roomsCollection;
    }

    public void setRoomsCollection(Collection<Rooms> roomsCollection) {
        this.roomsCollection = roomsCollection;
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
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Building[ id=" + id + " ]";
    }
    
}
