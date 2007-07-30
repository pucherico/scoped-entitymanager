package es.claro.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author puche
 */
public class PersistenceManager {
 
  public static final boolean DEBUG = true;
  public static final String PERSISTENCE_UNIT = "TercerosPU";
  
  private static final PersistenceManager singleton = 
          new ScopedPersistenceManager(); // for request scope (lazy close) (requiere declarar request listener)
          //new PersistenceManager(); // For not scoped em
  
  private EntityManagerFactory emf;
  
  public static PersistenceManager getInstance() {
    
    return singleton;
  }
  
  protected PersistenceManager() {
  }
 
  public synchronized EntityManagerFactory getEntityManagerFactory() {
    
    if (emf == null) {
      emf = createEntityManagerFactory();
      if (DEBUG)
        System.out.println(
              "\n*** Persistencia Inicializada " + new java.util.Date());
    }
    return emf;
  }
  
  public synchronized void closeEntityManagerFactory() {
    
    if (emf != null) {
      emf.close();
      emf = null;
      if (DEBUG)
        System.out.println(
            "\n*** Persistencia Finalizada " + new java.util.Date());
    }
  }
  
  protected EntityManagerFactory createEntityManagerFactory() {
    
    return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
  }
}