package org.ss.jdbc.dao.dal;

import org.ss.jdbc.dao.domain.Address;
import org.ss.jdbc.dao.domain.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {
    //members


    //constr

    //get set

    //other
    private static final String INSERT_QUERY = "INSERT INTO contact ( email, firs_name, last_name, address_id) VALUES (?,?,?,?)";

    private static final String UPDATE_QUERY = "UPDATE contact SET email, firs_name, last_name, "

    public void create(Contact c) throws SQLException {
        Connection connection = PersistenceManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)){
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            Address address=c.getAddress();
            if (null != address) {

                if (null == address.getId()) {
                    //daoAddress.create(address);
                    //TODO créer l'adresse pour pouvoir l'associer au contact
                    address.setDetails("5, Rue de la f=Forge");

                }
                ps.setLong(4, address.getId()); // car BIG INT dans la bdd sinon setInt
            }
            ps.executeUpdate();
            //TODO Récupérer la clé générée et l'affecter à l'objet contact
            ResultSet rs= ps.getGeneratedKeys();
            c.setId() = rs;
        }

    }

    public void update(Contact c){
        //TODO
    }

    public void delete(Contact c){
        //TODO

    }

    public Contact findByID (Long id){
        //TODO

        return null;
    }

}
