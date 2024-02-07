package org.fermented.dairy.htmx.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class BookStore {
    private long id;

    @Setter(onMethod = @__({@FormParam("name")}))
    private String name;
    @Setter(onMethod = @__({@FormParam("address")}))
    private String address;

}
