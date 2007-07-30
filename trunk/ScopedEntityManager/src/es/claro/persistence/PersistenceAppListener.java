package es.claro.persistence;

import es.claro.persistence.PersistenceManager;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 *
 * @author  puche
 *
 * Web application lifecycle listener.
 */

public class PersistenceAppListener implements ServletContextListener {

  public void contextInitialized(ServletContextEvent evt) {
  }

  public void contextDestroyed(ServletContextEvent evt) {

    PersistenceManager.getInstance().closeEntityManagerFactory();
  }
}