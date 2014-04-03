package edu.wctc.gclark7.mavenrestaurant.beans;

import edu.wctc.gclark7.mavenrestaurant.entity.Menu;
import edu.wctc.gclark7.mavenrestaurant.bean.util.JsfUtil;
import edu.wctc.gclark7.mavenrestaurant.bean.util.PaginationHelper;
import edu.wctc.gclark7.mavenrestaurant.dao1.CategoryFacade;
import edu.wctc.gclark7.mavenrestaurant.dao1.MenuFacade;
import edu.wctc.gclark7.mavenrestaurant.dao1.TypeFacade;
import edu.wctc.gclark7.mavenrestaurant.entity.Category;
import edu.wctc.gclark7.mavenrestaurant.entity.Type;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named("menuController")
@SessionScoped
public class MenuController implements Serializable {

    private Menu currentSelection;
   
    @Inject
    private MenuFacade ejbMenuFacade;
    @Inject
    private TypeFacade ejbTypeFacade;
    @Inject
    private CategoryFacade ejbCategoryFacade;
    private int selectedItemIndex;
    private Collection<Menu> menus;
    private Collection<Type> itemTypes;
    private Collection<Category>itemCategories;
    
    public MenuController() {
        
    }

    @PostConstruct
    public void initCollections(){
        menus = this.getEjbMenuFacade().findAll();
        itemTypes = this.getEjbTypeFacade().findAll();
        itemCategories = this.getEjbCategoryFacade().findAll();
    }
    public Menu getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(Menu currentSelection) {
        this.currentSelection = currentSelection;
    }

    public MenuFacade getEjbMenuFacade() {
        return ejbMenuFacade;
    }

    public void setEjbMenuFacade(MenuFacade ejbFacade) {
        this.ejbMenuFacade = ejbFacade;
    }

    public TypeFacade getEjbTypeFacade() {
        return ejbTypeFacade;
    }

    public void setEjbTypeFacade(TypeFacade ejbTypeFacade) {
        this.ejbTypeFacade = ejbTypeFacade;
    }

    public CategoryFacade getEjbCategoryFacade() {
        return ejbCategoryFacade;
    }

    public void setEjbCategoryFacade(CategoryFacade ejbCategoryFacade) {
        this.ejbCategoryFacade = ejbCategoryFacade;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<Type> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(Collection<Type> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public Collection<Category> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(Collection<Category> itemCategorys) {
        this.itemCategories = itemCategorys;
    }
    
    
    

   
}
