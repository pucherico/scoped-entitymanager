package es.claro.persistence;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author puche
 */
public class ScopedPersistenceManager extends PersistenceManager {
  
  protected ScopedPersistenceManager() {
  }
  
  protected EntityManagerFactory createEntityManagerFactory() {
    
    return new ScopedEntityManagerFactory(super.createEntityManagerFactory());
  }
}