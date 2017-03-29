package colloques.dao;

import java.util.List;



public abstract class DAO<T> {

   
  public DAO(){}
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
   * Méthode retournant toutes les données.
   * @return 
   */
  public abstract List<T> getALL();

}