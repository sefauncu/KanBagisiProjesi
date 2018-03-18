package _01.kanbagisi.jpa.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.primefaces.context.RequestContext;
import _01.kanbagisi.jpa.utility.JPAUtility;
import _01.kanbagisi.jpa.model.Bagisci;

public class BagisciDAOImpl implements BagisciDAO {
	

	private EntityManager entityManager;
	

	public BagisciDAOImpl() {
		EntityManagerFactory emf = JPAUtility.getEntityManagerFactory();
		entityManager = emf.createEntityManager();
	}

	@Override
	public void insertBagisci(Bagisci bagisci) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(bagisci);
			entityManager.getTransaction().commit();
			
		
		} catch (Exception e) {
			
			RequestContext.getCurrentInstance().update("grow2");
			FacesContext context=FacesContext.getCurrentInstance();
			context.addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Kayýt Baþarýsýz"));
				
			
		}finally {
			//if(entityManager.isOpen())
				//entityManager.close();
		}
	
		
	}

	@Override
	public Bagisci findBagisci(int id) {
		return entityManager.find(Bagisci.class, id);
	}

	@Override
	public void removeBagisci(int id) {
		
		Bagisci b = findBagisci(id);
		entityManager.getTransaction().begin();
		entityManager.remove(b);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public boolean login(String kullaniciAdi, int kullaniciSifre) {
		  try {
			  Bagisci login=entityManager.createNamedQuery("Login.control",Bagisci.class)
					  .setParameter("kullaniciAdi", kullaniciAdi)
					  .setParameter("kullaniciSifre", kullaniciSifre)
					  .getSingleResult();
			if(login!=null){
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
	        return false;
		  }
	}


	@Override
	public List<Bagisci> SearchBagisci(String key) {
		TypedQuery<Bagisci> query = entityManager.createQuery("select e from Bagisci e where e.kanGrubu LIKE :key",Bagisci.class);
	    query.setParameter("key", "%"+key+"%");
	    return query.getResultList();
	    
	}

	@Override
	public void updateBagisci(Bagisci b, int id) {
		entityManager.getTransaction().begin();
	
		Bagisci bagisci2 = entityManager.find(Bagisci.class, b.getId());
        bagisci2.setAdSoyad(b.getAdSoyad());
        bagisci2.setId(b.getId());
        bagisci2.setAdSoyad(b.getAdSoyad());
        bagisci2.setAdres(b.getAdres());
        bagisci2.setMail(b.getMail());
        bagisci2.setTelefon(b.getTelefon());
        bagisci2.setKanGrubu(b.getKanGrubu());
        bagisci2.setKullaniciMesaj(b.getKullaniciMesaj());
		entityManager.merge(bagisci2);
		entityManager.getTransaction().commit();
		
		
	}

	@Override
	public List<Bagisci> findByIDBagisci(Bagisci bagisci) {
		List<Bagisci> query = entityManager.createNamedQuery("LoginList.control",Bagisci.class)
				.setParameter("kullaniciAdi", bagisci.getKullaniciAdi())
				.setParameter("kullaniciSifre", bagisci.getKullaniciSifre())
				.setParameter("kullaniciMesaj", bagisci.getKullaniciMesaj())
				.getResultList();
		return query;
		
	
	}

	@Override
	public boolean loginForgot(String kullaniciAdi, String kullaniciMesaj) {
		  try {
			  Bagisci loginForgot=entityManager.createNamedQuery("LoginForgot.control",Bagisci.class)
					  .setParameter("kullaniciAdi", kullaniciAdi)
					  .setParameter("kullaniciMesaj", kullaniciMesaj)
					  .getSingleResult();
			if(loginForgot!=null){
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
	        return false;
		  }
	}

	@Override
	public void updatePassword(Bagisci b, int id) {
		entityManager.getTransaction().begin();
		
		Bagisci bagisciPass = entityManager.find(Bagisci.class, b.getId());
		bagisciPass.setId(b.getId());
		bagisciPass.setKullaniciAdi(b.getKullaniciAdi());
		bagisciPass.setKullaniciSifre(b.getKullaniciSifre());
   
		entityManager.merge(bagisciPass);
		entityManager.getTransaction().commit();
		
	}



	

}