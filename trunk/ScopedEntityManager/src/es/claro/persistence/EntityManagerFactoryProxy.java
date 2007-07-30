package es.claro.persistence;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author puche
 */
abstract class EntityManagerFactoryProxy implements EntityManagerFactory {
  
  protected final EntityManagerFactory delegate;
  
  protected EntityManagerFactoryProxy(EntityManagerFactory emf) {
    
    this.delegate = emf;
  }

  public EntityManager createEntityManager() {
    
    return delegate.createEntityManager();
  }
  
  public EntityManager createEntityManager(Map map) {
    
    return delegate.createEntityManager(map);
  }

  public boolean isOpen() {
    
    return delegate.isOpen();
  }

  public void close() {
    
    delegate.close();
  } 
}