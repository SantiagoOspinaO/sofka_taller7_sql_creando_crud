package com.sofka.controller;

import com.sofka.domain.Contact;
import com.sofka.service.ContactService;
import com.sofka.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Se crea el ContactController.
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @version 1.00.000 14-03-2022
 *
 * @since 1.00.000 14-03-2022
 */
@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    private Response response;

    /**
     * Index map.
     *
     * @return the map
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @GetMapping(path = "/")
    public Map<String, String> index() {
        var respuesta = new HashMap<String, String>();
        respuesta.put("message", "Hola Mundo");
        return respuesta;
    }

    /**
     * List list.
     *
     * @return the list
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @GetMapping(path = "/contacts")
    public List<Contact> list() {
        var contacts = contactService.list();
        return contacts;
    }

    /**
     * Create response entity.
     *
     * @param contact the contact
     *
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @PostMapping(path = "/contact")
    public ResponseEntity<Response> create(Contact contact) {
        response.data = contact;
        try {
            log.info("Contacto a crear: {}", contact);
            contactService.save(contact);
            return new ResponseEntity<Response>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete response entity.
     *
     * @param contact the contact
     *
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> delete(Contact contact) {
        log.info("Contacto a borrar: {}", contact);
        contactService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param contact the contact
     * @param id      the id
     *
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> update(Contact contact, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", contact);
        contactService.update(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Update name response entity.
     *
     * @param contact the contact
     * @param id      the id
     *
     * @return the response entity
     *
     * @author Santiago Ospina Osorio - santiago.m200@outlook.es
     *
     * @since 1.00.000 14-03-2022
     */
    @PatchMapping(path = "/contact/name/{id}")
    public ResponseEntity<Contact> updateName(Contact contact, @PathVariable("id") Long id) {
        log.info("Usuario a modificar nombre: {}", contact);
        contactService.updateName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
