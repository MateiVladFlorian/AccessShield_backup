/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "promotions")
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p"),
    @NamedQuery(name = "Promotions.findByPromotionId", query = "SELECT p FROM Promotions p WHERE p.promotionId = :promotionId"),
    @NamedQuery(name = "Promotions.findByPromoCode", query = "SELECT p FROM Promotions p WHERE p.promoCode = :promoCode"),
    @NamedQuery(name = "Promotions.findByDescription", query = "SELECT p FROM Promotions p WHERE p.description = :description"),
    @NamedQuery(name = "Promotions.findByDiscountPercentage", query = "SELECT p FROM Promotions p WHERE p.discountPercentage = :discountPercentage"),
    @NamedQuery(name = "Promotions.findByStartDate", query = "SELECT p FROM Promotions p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Promotions.findByEndDate", query = "SELECT p FROM Promotions p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Promotions.findByMaxUses", query = "SELECT p FROM Promotions p WHERE p.maxUses = :maxUses"),
    @NamedQuery(name = "Promotions.findByUsesCount", query = "SELECT p FROM Promotions p WHERE p.usesCount = :usesCount")})
public class Promotions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "promotion_id")
    private Integer promotionId;
    @Basic(optional = false)
    @Column(name = "promo_code")
    private String promoCode;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "max_uses")
    private Integer maxUses;
    @Column(name = "uses_count")
    private Integer usesCount;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;

    public Promotions() {
    }

    public Promotions(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Promotions(Integer promotionId, String promoCode, Date startDate, Date endDate) {
        this.promotionId = promotionId;
        this.promoCode = promoCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(Integer maxUses) {
        this.maxUses = maxUses;
    }

    public Integer getUsesCount() {
        return usesCount;
    }

    public void setUsesCount(Integer usesCount) {
        this.usesCount = usesCount;
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
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.promotionId == null && other.promotionId != null) || (this.promotionId != null && !this.promotionId.equals(other.promotionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Promotions[ promotionId=" + promotionId + " ]";
    }
    
}
