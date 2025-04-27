package upeu.edu.pe.ms_paciente.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ms_paciente.domain.ContactoEmergencia;
import upeu.edu.pe.ms_paciente.service.ContEmergenciaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactos-emergencia")
public class ContEmergenciaController {
    @Autowired
    private ContEmergenciaService contactoEmergenciaService;

    @GetMapping
    public ResponseEntity<List<ContactoEmergencia>> readAll() {
        try {
            List<ContactoEmergencia> contactos = contactoEmergenciaService.readAll();
            if (contactos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contactos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ContactoEmergencia> guardarContactoEmergencia(@Valid @RequestBody ContactoEmergencia contacto) {
        try {
            ContactoEmergencia c = contactoEmergenciaService.create(contacto);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoEmergencia> getContactoEmergenciaById(@PathVariable("id") Long id) {
        try {
            ContactoEmergencia c = contactoEmergenciaService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContactoEmergencia(@PathVariable("id") Long id) {
        try {
            contactoEmergenciaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContactoEmergencia(@PathVariable("id") Long id, @Valid @RequestBody ContactoEmergencia contacto) {
        Optional<ContactoEmergencia> c = contactoEmergenciaService.read(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(contactoEmergenciaService.update(contacto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
