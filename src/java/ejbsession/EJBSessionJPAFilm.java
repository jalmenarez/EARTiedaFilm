package ejbsession;

import entidad.Film;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EJBSessionJPAFilm {
    
    @PersistenceContext(unitName="UPTiendaFilm")
    private EntityManager em;
    
    private Class<Film> claseEntidad;
    
    public EJBSessionJPAFilm(){
        this.claseEntidad=Film.class;
    }
    
    public Film buscar(Object idFilm){
        return em.find(claseEntidad, idFilm);
    }
    
    public void agregar(Film film){
        em.persist(film);
    }
    
    public void eliminar(Film film){
        em.remove(film);
    }

}
