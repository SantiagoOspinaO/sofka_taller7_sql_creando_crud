package com.sofka.dao;

import com.sofka.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Se crea la interface ContactDao que extiende de CrudRepository.
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @version 1.00.000 14-03-2022
 *
 * @since 1.00.000 14-03-2022
 */
public interface ContactDao extends CrudRepository<Contact, Long> {

    /**
     * Update name.
     *
     * @param id   the id
     * @param name the name
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @Modifying
    @Query("update Contact con set con.name = :name where con.id = :id")
    public void updateName (
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );
}
