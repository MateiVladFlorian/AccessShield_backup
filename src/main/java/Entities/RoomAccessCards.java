/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vladu
 */
@Entity
@Table(name = "room_access_cards")
@NamedQueries({
    @NamedQuery(name = "RoomAccessCards.findAll", query = "SELECT r FROM RoomAccessCards r"),
    @NamedQuery(name = "RoomAccessCards.findByCardId", query = "SELECT r FROM RoomAccessCards r WHERE r.cardId = :cardId"),
    @NamedQuery(name = "RoomAccessCards.findByCardCode", query = "SELECT r FROM RoomAccessCards r WHERE r.cardCode = :cardCode"),
    @NamedQuery(name = "RoomAccessCards.findByIssueDate", query = "SELECT r FROM RoomAccessCards r WHERE r.issueDate = :issueDate"),
    @NamedQuery(name = "RoomAccessCards.findByExpirationDate", query = "SELECT r FROM RoomAccessCards r WHERE r.expirationDate = :expirationDate"),
    @NamedQuery(name = "RoomAccessCards.findByIsActive", query = "SELECT r FROM RoomAccessCards r WHERE r.isActive = :isActive")})
public class RoomAccessCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "card_id")
    private Integer cardId;
    @Basic(optional = false)
    @Column(name = "card_code")
    private String cardCode;
    @Basic(optional = false)
    @Column(name = "issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "is_active")
    private Boolean isActive;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private Rooms roomId;

    public RoomAccessCards() {
    }

    public RoomAccessCards(Integer cardId) {
        this.cardId = cardId;
    }

    public RoomAccessCards(Integer cardId, String cardCode, Date issueDate) {
        this.cardId = cardId;
        this.cardCode = cardCode;
        this.issueDate = issueDate;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Rooms getRoomId() {
        return roomId;
    }

    public void setRoomId(Rooms roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomAccessCards)) {
            return false;
        }
        RoomAccessCards other = (RoomAccessCards) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoomAccessCards[ cardId=" + cardId + " ]";
    }
    
}
