package de.hsos.control;

import de.hsos.entity.Auto;
import de.hsos.entity.Hersteller;

import java.util.Optional;

public interface AutoService {
    boolean deleteAuto(Long id);
    Long addAuto(String marke, Hersteller hersteller);
    Optional<Auto> getAuto(Long id);
}
