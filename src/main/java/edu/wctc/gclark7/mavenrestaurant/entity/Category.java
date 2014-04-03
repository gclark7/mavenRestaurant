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
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByItemCategory", query = "SELECT c FROM Category c WHERE c.itemCategory = :itemCategory"),
    @NamedQuery(name = "Category.findByCategory", query = "SELECT c FROM Category c WHERE c.category = :category")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_category")
    private Integer itemCategory;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "itemCategory")
    private Collection<Menu> menuCollection;

    public Category() {
    }

    public Category(Integer itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Integer getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Integer itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        hash += (itemCategory != null ? itemCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.itemCategory == null && other.itemCategory != null) || (this.itemCategory != null && !this.itemCategory.equals(other.itemCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.wctc.gclark7.mavenrestaurant.entity.Category[ itemCategory=" + itemCategory + " ]";
    }
    
}
