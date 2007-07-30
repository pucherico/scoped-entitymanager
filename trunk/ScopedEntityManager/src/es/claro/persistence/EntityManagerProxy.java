package es.claro.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;

/**
 *
 * @author puche
 */
 abstract class EntityManagerProxy implements EntityManager {
  
  protected final EntityManager delegate;
  
  public EntityManagerProxy(EntityManager delegate) {
    
    this.delegate = delegate;
  }

  public void persist(Object object) {
    
    delegate.persist(object);
  }

  public <T> T merge(T entity) {
    
    return delegate.merge(entity);
  }

  public void remove(Object object) {
    
    delegate.remove(object);
  }

  public <T> T find(Class<T> entityClass, Object primaryKey) {
    
    return delegate.find(entityClass, primaryKey);
  }

  public <T> T getReference(Class<T> entityClass, Object primaryKey) {
    
    return delegate.getReference(entityClass, primaryKey);
  }

  public void flush() {
    
    delegate.flush();
  }

  public void setFlushMode(FlushModeType flushModeType) {
    
    delegate.setFlushMode(flushModeType);
  }

  public FlushModeType getFlushMode() {
    
    return delegate.getFlushMode();
  }

  public void lock(Object object, LockModeType lockModeType) {
    
    delegate.lock(object, lockModeType);
  }

  public void refresh(Object object) {
    
    delegate.refresh(object);
  }

  public void clear() {
    
    delegate.clear();
  }

  public boolean contains(Object object) {
    
    return delegate.contains(object);
  }

  public Query createQuery(String string) {
    
    return delegate.createQuery(string);
  }

  public Query createNamedQuery(String string) {
    
    return delegate.createNamedQuery(string);
  }

  public Query createNativeQuery(String string) {
    
    return delegate.createNativeQuery(string);
  }

  public Query createNativeQuery(String string, Class aClass) {
    
    return delegate.createNativeQuery(string, aClass);
  }

  public Query createNativeQuery(String string, String string0) {
    
    return delegate.createNativeQuery(string, string0);
  }

  public void joinTransaction() {
    
    delegate.joinTransaction();
  }

  public Object getDelegate() {
    
    return delegate.getDelegate();
  }

  public void close() {
    
    delegate.close();
  }

  public boolean isOpen() {
    
    return delegate.isOpen();
  }

  public EntityTransaction getTransaction() {
    
    return delegate.getTransaction();
  } 
}