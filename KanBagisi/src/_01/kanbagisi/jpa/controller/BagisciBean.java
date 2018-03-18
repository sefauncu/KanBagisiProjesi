package _01.kanbagisi.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import _01.kanbagisi.jpa.dao.BagisciDAO;
import _01.kanbagisi.jpa.dao.BagisciDAOImpl;
import _01.kanbagisi.jpa.model.Bagisci;

@ManagedBean(name="bagisciBean")
@SessionScoped
public class BagisciBean {

	private BagisciDAO bagisciDAO;
	private Bagisci bagisci;
	private List<Bagisci> bagiscilar;
	private String search;
	

	
	public BagisciBean() {
		bagisci = new Bagisci();
		bagiscilar = new ArrayList<>();	
		bagisciDAO = new BagisciDAOImpl();
		
	}
	
	
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}


	public Bagisci getBagisci() {
		return bagisci;
	}
	public void setBagisci(Bagisci bagisci) {
		this.bagisci = bagisci;
	}
	public List<Bagisci> getBagiscilar() {
		return bagiscilar;
	}
	public void setBagiscilar(List<Bagisci> bagiscilar) {
		this.bagiscilar = bagiscilar;
	}
	

	
	
	public String addBagisci(){
    	BagisciDAO bagisciDAO = new BagisciDAOImpl();
    	bagisciDAO.insertBagisci(bagisci);
    	bagiscilar = bagisciDAO.findByIDBagisci(bagisci);
  
    	return "info.xhtml?faces-redirect=true";
    }
	
	 
	
    public void deleteBagisci(int id){
    	BagisciDAO bagisciDAO = new BagisciDAOImpl();
    	bagisciDAO.removeBagisci(id);
    	bagiscilar = bagisciDAO.findByIDBagisci(bagisci);
    	logout();   	
    	
    }
    public List<Bagisci> getListBagiscilar(){
       return bagisciDAO.findByIDBagisci(bagisci);
    }

   
    public List<Bagisci> getsearchBagisci() {
    	BagisciDAO bagisciDAO = new BagisciDAOImpl();
        return bagisciDAO.SearchBagisci(search);
    }
    
    public String login(int id){
		if(bagisciDAO.login(bagisci.getKullaniciAdi(),bagisci.getKullaniciSifre())){
			bagiscilar = bagisciDAO.findByIDBagisci(bagisci);
				return "list.xhtml?faces-redirect=true";
				
	}
		
			RequestContext.getCurrentInstance().update("grow1");
			FacesContext context=FacesContext.getCurrentInstance();
			context.addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Kullanýcý Adý veya Þifre Yanlýþ"));
			return "";
		}
	
    public String loginForgot(int id){
		if(bagisciDAO.loginForgot(bagisci.getKullaniciAdi(),bagisci.getKullaniciMesaj())){
			bagiscilar = bagisciDAO.findByIDBagisci(bagisci);
				return "listpass.xhtml?faces-redirect=true";
				
	}
		
			RequestContext.getCurrentInstance().update("grow1");
			FacesContext context=FacesContext.getCurrentInstance();
			context.addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Kullanýcý Adý veya Mesaj Yanlýþ"));
			return "loginforgot.xhtml?faces-redirect=true";
		}
	
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
	
    public void reset() {  
        RequestContext.getCurrentInstance().reset("form:f");  
    }  
    
    
    
  
  }
  
