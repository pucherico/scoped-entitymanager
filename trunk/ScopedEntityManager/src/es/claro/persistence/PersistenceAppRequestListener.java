package es.claro.persistence;

import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;

/**
 *
 * @author  puche
 *
 * Web application lifecycle listener.
 */

public class PersistenceAppRequestListener implements ServletRequestListener {
  /**
   * ### Method from ServletRequestListener ###
   * 
   * The request is about to come into scope of the web application.
   */
  public void requestInitialized(ServletRequestEvent evt) {
    // TODO add your code here:
  }

  /**
   * ### Method from ServletRequestListener ###
   * 
   * The request is about to go out of scope of the web application.
   */
  public void requestDestroyed(ServletRequestEvent evt) {
    
    PersistenceManager pm = PersistenceManager.getInstance();
    
    if (pm instanceof ScopedPersistenceManager) {
      LazyCloseEntityManager em = ((ScopedEntityManagerFactory)pm
              .getEntityManagerFactory()).getEntityManager();

      // solo si ya existía se cierra, pero es posible que no exista
      if (em != null)
        em.lazyClose();
    }
  }
}