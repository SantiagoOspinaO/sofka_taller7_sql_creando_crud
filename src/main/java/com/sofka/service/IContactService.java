package com.sofka.service;

import com.sofka.domain.Contact;

import java.util.List;
import java.util.Optional;

/**
 * Se crea la interface IContactService.
 *
 * @version 1.00.000 14-03-2022
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 14-03-2022
 */
public interface IContactService {

    /**
     * List list.
     *
     * @return the list
     */
    public List<Contact> list();

    /**
     * Save contact.
     *
     * @param contact the contact
     * @return the contact
     */
    public Contact save(Contact contact);

    /**
     * Update contact.
     *
     * @param id      the id
     * @param contact the contact
     * @return the contact
     */
    public Contact update(Long id, Contact contact);

    /**
     * Delete.
     *
     * @param contact the contact
     */
    public void delete(Contact contact);

    /**
     * Find contact optional.
     *
     * @param contact the contact
     * @return the optional
     */
    public Optional<Contact> findContact(Contact contact);
}
