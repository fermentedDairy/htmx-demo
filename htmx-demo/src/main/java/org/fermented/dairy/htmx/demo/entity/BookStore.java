package org.fermented.dairy.htmx.demo.entity;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import java.util.Objects;

public class BookStore {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    @FormParam("name")
    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @FormParam("address")
    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BookStore) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "BookStore[" +
                "name=" + name + ", " +
                "address=" + address + ']';
    }

}
