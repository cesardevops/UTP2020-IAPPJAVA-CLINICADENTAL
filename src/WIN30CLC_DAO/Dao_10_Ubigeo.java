
package WIN30CLC_DAO;

import WIN31CLC_DTO.Ubigeo;
import java.util.List;

/**
 *
 * @author Carlos Jimenez Gomez
 */
public interface Dao_10_Ubigeo extends Dao<Ubigeo, Long> {
      public List<Ubigeo> getdepartamentos() throws DaoException;
        public List<Ubigeo> getprovincia(String departamento) throws DaoException;
          public List<Ubigeo> getdistrito(String departamento,String provincia) throws DaoException;

//    public List<Ubigeo> getdepartamentos() throws DaoException;
//
//    public List<Ubigeo> getprovincia(Ubigeo entity) throws DaoException;
//
//    public List<Ubigeo> getdistrito(Ubigeo entity) throws DaoException;
}
