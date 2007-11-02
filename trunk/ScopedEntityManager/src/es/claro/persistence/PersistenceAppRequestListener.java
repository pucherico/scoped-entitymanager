package es.claro.persistence;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;

/**
 *
 * @author  puche
 *
 * Web application lifecycle listener.
 */

public class PersistenceAppRequestListener
implements ServletContextListener, ServletRequestListener {
  
  private static final String PU_PARAMETER_NAME =
      "es.claro.persistence.PERSISTENCE_UNIT";
  
  public void contextInitialized(ServletContextEvent evt) {

    PersistenceManager pm = PersistenceManager.getInstance();
    
    if (pm instanceof ScopedPersistenceManager) {
      
      // If the name of the persistence unit has not been set yet
      if (PersistenceManager.getPersistenceUnit() == null) {
        String pu = evt.getServletContext().getInitParameter(PU_PARAMETER_NAME);
        PersistenceManager.setPersistenceUnit((pu != null)? pu
                               : PersistenceManager.DEFAULT_PERSISTENCE_UNIT);
      }
    }
  }

  public void contextDestroyed(ServletContextEvent evt) {
    
    PersistenceManager.getInstance().closeEntityManagerFactory();
  }
  
  /**
   * ### Method from ServletRequestListener ###
   * 
   * The request is about to come into scope of the web application.
   */
  public void requestInitialized(ServletRequestEvent evt) {
   
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