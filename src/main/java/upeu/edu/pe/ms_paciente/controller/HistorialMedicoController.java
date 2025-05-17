package upeu.edu.pe.ms_paciente.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ms_paciente.domain.historialmedico;
import upeu.edu.pe.ms_paciente.service.HistorialMedService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historiales")
public class HistorialMedicoController {
    @Autowired
    private HistorialMedService historialMedicoService;

    @GetMapping
    public ResponseEntity<List<historialmedico>> readAll() {
        try {
            List<historialmedico> historiales = historialMedicoService.readAll();
            if (historiales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(historiales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<historialmedico> guardarHistorial(@Valid @RequestBody historialmedico historial) {
        try {
            historialmedico h = historialMedicoService.create(historial);
            return new ResponseEntity<>(h, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<historialmedico> getHistorialById(@PathVariable("id") Long id) {
        try {
            historialmedico h = historialMedicoService.read(id).get();
            return new ResponseEntity<>(h, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable("id") Long id) {
        try {
            historialMedicoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHistorial(@PathVariable("id") Long id, @Valid @RequestBody historialmedico historial) {
        Optional<historialmedico> h = historialMedicoService.read(id);
        if (!h.isEmpty()) {
            historial.setId(id); // Asigna el ID para evitar crear uno nuevo
            return new ResponseEntity<>(historialMedicoService.update(historial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
