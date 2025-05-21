package de.hsos.gateway;

import de.hsos.control.AutoService;
import de.hsos.entity.Auto;
import de.hsos.entity.Hersteller;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.Optional;

@ApplicationScoped
public class AutoRepository implements AutoService {

    private static final Logger LOG = Logger.getLogger(AutoRepository.class);

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Long addAuto(String marke, Hersteller hersteller) {
        Hersteller herstellerNeu = new Hersteller(hersteller.getName(), hersteller.getOrt());
        Auto auto = new Auto(marke, herstellerNeu);
        em.persist(auto);
        LOG.infof("Auto mit ID %d wurde gespeichert", auto.id);
        return auto.id;
    }

    @Override
    public Optional<Auto> getAuto(Long id) {
        LOG.infof("Auto mit ID %d wird gesucht", id);
        try{
            Auto auto = em.find(Auto.class, id);
            return Optional.ofNullable(auto);
        }
        catch(Exception e){
            LOG.error(e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public boolean deleteAuto(Long id) {
        try{
            em.remove(em.find(Auto.class, id));
            return true;
        }
        catch(Exception e){
            System.out.println("Error deleting auto: " + id);
            return false;
        }
    }
}
