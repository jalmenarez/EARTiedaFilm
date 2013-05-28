package ejbsession;

import entidad.Film;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FilmFacade extends AbstractFacade<Film> {
    @PersistenceContext(unitName = "UPTiendaFilm")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmFacade() {
        super(Film.class);
    }

}
