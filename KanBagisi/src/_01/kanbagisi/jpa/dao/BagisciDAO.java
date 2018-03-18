package _01.kanbagisi.jpa.dao;

import java.util.List;



import _01.kanbagisi.jpa.model.Bagisci;



public interface BagisciDAO {
	
	public void insertBagisci(Bagisci bagisci);
	
	public Bagisci findBagisci(int id);
	
	public void removeBagisci(int id);
	
	public boolean login(String kullaniciAdi,int kullaniciSifre);
	
	public boolean loginForgot(String kullaniciAdi,String kullaniciMesaj);
	
	public List<Bagisci> SearchBagisci(String key);

	public void updateBagisci(Bagisci b, int id);
	
	public void updatePassword(Bagisci b, int id);	
	
	public List<Bagisci> findByIDBagisci(Bagisci bagisci);
	

	 

	


	 

}
