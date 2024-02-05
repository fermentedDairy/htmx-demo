package org.fermented.dairy.htmx.demo.boundary;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class AppResource {

    @GET
    public Response home() {
        return Response.status(Response.Status.TEMPORARY_REDIRECT).header("Location", "/bookstores").build();
    }
}
