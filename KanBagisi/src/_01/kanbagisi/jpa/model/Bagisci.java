package _01.kanbagisi.jpa.model;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import _01.kanbagisi.jpa.dao.BagisciDAO;
import _01.kanbagisi.jpa.dao.BagisciDAOImpl;

@Entity

@NamedQueries({
@NamedQuery(name="LoginList.control",query="Select e from Bagisci e where  (e.kullaniciAdi=:kullaniciAdi and e.kullaniciSifre=:kullaniciSifre) or (e.kullaniciAdi=:kullaniciAdi and e.kullaniciMesaj=:kullaniciMesaj)"),
@NamedQuery(name="Login.control",query="Select e from Bagisci e where  e.kullaniciAdi=:kullaniciAdi and e.kullaniciSifre=:kullaniciSifre"),
@NamedQuery(name="LoginForgot.control",query="Select e from Bagisci e where  e.kullaniciAdi=:kullaniciAdi and e.kullaniciMesaj=:kullaniciMesaj")

})

@Table(name="Bagisci")
public class Bagisci implements Serializable {
    private static final long serialVersionUID = 1L;

   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bagisciId")
	private int id;
	
	@Column(name="bagisciAdSoyad")
	private String adSoyad;
	
	@Column(name="bagisciMail")
	private String mail;
	
	@Column(name="bagisciTelefon")
	private String telefon;
	
	@Column(name="bagisciAdres")
	private String adres;
	
	@Column(name="bagisciKanGrubu")
	private String kanGrubu;
	
	@Column(name="bagisciKullaniciAdi")
	private String kullaniciAdi;
	
	@Column(name="bagisciKullaniciSifre")
	private int kullaniciSifre;

	@Column(name="bagisciKullaniciMesaj")
	private String kullaniciMesaj;
	


	
	
	
	public Bagisci() {
		
		super();
		
	}
	


	public Bagisci(int id, String adSoyad, String mail, String telefon, String adres, String kanGrubu,
			String kullaniciAdi, int kullaniciSifre, String kullaniciMesaj) {
		super();
		this.id = id;
		this.adSoyad = adSoyad;
		this.mail = mail;
		this.telefon = telefon;
		this.adres = adres;
		this.kanGrubu = kanGrubu;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciSifre = kullaniciSifre;
		this.kullaniciMesaj = kullaniciMesaj;
	}
	
	
	public Bagisci(String adSoyad, String mail, String telefon, String adres, String kanGrubu, String kullaniciAdi,
			int kullaniciSifre, String kullaniciMesaj) {
		super();
		this.adSoyad = adSoyad;
		this.mail = mail;
		this.telefon = telefon;
		this.adres = adres;
		this.kanGrubu = kanGrubu;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciSifre = kullaniciSifre;
		this.kullaniciMesaj = kullaniciMesaj;
	}



	public void getAllByIDShow(int id, String adSoyad, String mail, String telefon, String adres, String kanGrubu,String kullaniciMesaj) {
		this.id = id;
		this.adSoyad = adSoyad;
		this.mail = mail;
		this.telefon = telefon;
		this.adres = adres;
		this.kanGrubu = kanGrubu;
		this.kullaniciMesaj=kullaniciMesaj;
	
		
	}
	

	public void getBagisciPassword(int id,String kullaniciAdi, int kullaniciSifre) {
		
		this.id = id;
		this.kullaniciAdi=kullaniciAdi;
		this.kullaniciSifre = kullaniciSifre;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getKanGrubu() {
		return kanGrubu;
	}

	public void setKanGrubu(String kanGrubu) {
		this.kanGrubu = kanGrubu;
	}

	public String getKullaniciAdi() {
		
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		
		this.kullaniciAdi = kullaniciAdi;
	}


	public int getKullaniciSifre() {
		
		return kullaniciSifre;        
		
	}


	public void setKullaniciSifre(int kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	
	public String getKullaniciMesaj() {
		return kullaniciMesaj;
	}


	public void setKullaniciMesaj(String kullaniciMesaj) {
		this.kullaniciMesaj = kullaniciMesaj;
	}


	 	
	public String getRandomDeger() {
		
		 String alphabet= "a1b2c3d4e5f6g7hi8j9k10l11m12n13o14p15q15r16s18t1u8v20w22x95yz";
		    kullaniciAdi = "";
	        Random random = new Random();
	        int randomLen = 5+random.nextInt(9);
	        for (int i = 0; i < randomLen; i++) {
	            char c = alphabet.charAt(random.nextInt(26));
	            kullaniciAdi+=c;
	        }
	    return kullaniciAdi;
	}

  public void setRandomDeger(String kullaniciAdi){
  	this.kullaniciAdi=kullaniciAdi;
  
    }
  
  public int getRandomDeger2(){
	int randomInt = 0;
	 Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1; ++idx){
	      randomInt = randomGenerator.nextInt(50000000);
	   
	    }
	    
	    return randomInt;
    
 }


  public void setRandomDeger2(int kullaniciSifre){
	
	this.kullaniciSifre=kullaniciSifre;
}
 
	
  public String getGeciciAd() {
	
	  kullaniciAdi = "deneme";

	return kullaniciAdi;
}


  public void setGeciciAd(String kullaniciAdi){
	  
	  this.kullaniciAdi=kullaniciAdi;

}
  
  public int getGeciciSifre(){
		
	    int randomInt = 123456;
	    return randomInt;
	     
	 }

	  public void setGeciciSifre(int kullaniciSifre){
		this.kullaniciSifre=kullaniciSifre;
	}

  public String updateBagisci() {
	 BagisciDAO bagisciDAO = new BagisciDAOImpl();
     Bagisci bagisci = new Bagisci(id,adSoyad, mail, telefon, adres, kanGrubu, kullaniciAdi, kullaniciSifre,kullaniciMesaj);
     bagisciDAO.updateBagisci(bagisci, getId());
     return "";
  }

  public String updatePassword() {
		 BagisciDAO bagisciDAO = new BagisciDAOImpl();
	    Bagisci bagisciPass = new Bagisci(id,adSoyad, mail, telefon, adres, kanGrubu, kullaniciAdi, kullaniciSifre, kullaniciMesaj);
	     bagisciDAO.updatePassword(bagisciPass, getId());
	     return "";
	    
	  }


}
	
