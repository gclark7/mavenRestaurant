/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wctc.gclark7.mavenrestaurant.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author greg clark <gclark7@my.wctc.edu>
 */
@Entity
@Table(name = "type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t"),
    @NamedQuery(name = "Type.findByItemType", query = "SELECT t FROM Type t WHERE t.itemType = :itemType"),
    @NamedQuery(name = "Type.findByType", query = "SELECT t FROM Type t WHERE t.type = :type")})
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_type")
    private Integer itemType;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "itemType")
    private Collection<Menu> menuCollection;

    public Type() {
    }

    public Type(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemType != null ? itemType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.itemType == null && other.itemType != null) || (this.itemType != null && !this.itemType.equals(other.itemType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.wctc.gclark7.mavenrestaurant.entity.Type[ itemType=" + itemType + " ]";
    }
    
}
