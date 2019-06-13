package org.ss.jdbc.dao.domain;

import java.util.Set;

public class Address {
    //memnbers
    private Long id;
    private String details;
    private Set<Contact> contacts;

    //constr

    public Address() {

    }

    //set get

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
//other


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", details='").append(details).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
