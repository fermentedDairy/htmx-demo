package org.fermented.dairy.htmx.demo.boundary;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.fermented.dairy.htmx.demo.controller.BookStoreService;
import org.fermented.dairy.htmx.demo.entity.BookStore;

import java.util.List;

import org.jboss.resteasy.annotations.Form;

@Path("/bookstores")
public class BookStoreResource {

    private final BookStoreService bookstoreService;

    @Inject
    public BookStoreResource(final BookStoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GET()
    public TemplateInstance base() {
        return showList(bookstoreService.getBooksters());
    }

    @POST
    public Response add(@Form BookStore bookStore, @HeaderParam("HX-Request") boolean hxRequest) {
        final BookStore addedBookstore = bookstoreService.addBookStore(bookStore);
        if (hxRequest) {
            return Response.ok(Templates.item(addedBookstore)).header("HX-Trigger", "clear-add-bookstore").build();
        }
        return Response.status(Response.Status.FOUND).header("Location", "/bookstores").build();
    }

    private TemplateInstance showList(List<BookStore> bookStores) {
        return Templates.list(bookStores);
    }

    @CheckedTemplate
    public static class Templates {

        public static native TemplateInstance list(List<BookStore> bookstores);
        public static native TemplateInstance item(BookStore bookstore);
    }
}
