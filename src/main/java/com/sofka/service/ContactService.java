package com.sofka.service;

import com.sofka.dao.ContactDao;
import com.sofka.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Se crea el servicio ContactService que implementa IContactService.
 *
 * @version 1.00.000 14-03-2022
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 14-03-2022
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts;
        try {
            contacts = (List<Contact>) contactDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        contact.setId(id);
        return contactDao.save(contact);
    }

    /**
     * Update name.
     *
     * @param id      the id
     * @param contact the contact
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @Transactional
    public void updateName(Long id, Contact contact) {
        contactDao.updateName(id, contact.getName());
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        return contactDao.findById(contact.getId());
    }
}
