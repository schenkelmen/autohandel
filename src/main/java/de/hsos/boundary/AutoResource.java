package de.hsos.boundary;

import de.hsos.boundary.dto.AutoDTO;
import de.hsos.boundary.dto.NewAutoDTO;
import de.hsos.control.AutoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("autos")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class AutoResource {

    @Inject
    AutoService autoService;

    @GET
    @Path("/{id}")
    public Response getAutoById(@PathParam("id") Long id){
        AutoDTO autoDTO = autoService.getAuto(id)
                .map(AutoDTO::toDTO)
                .orElseThrow(() -> new NotFoundException("Auto not found with id " + id));
        if (autoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(autoDTO).build();
    }

    @POST
    public Response addAuto(NewAutoDTO newAutoDTO){
        Long id = autoService.addAuto(newAutoDTO.getMarke(), newAutoDTO.getHersteller());
        return Response.status(Response.Status.CREATED).entity(id).build();
    }

}
