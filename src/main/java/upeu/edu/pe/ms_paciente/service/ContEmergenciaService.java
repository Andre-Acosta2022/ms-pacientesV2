package upeu.edu.pe.ms_paciente.service;
import upeu.edu.pe.ms_paciente.domain.ContactoEmergencia;

import java.util.List;
import java.util.Optional;
public interface ContEmergenciaService {
    ContactoEmergencia create(ContactoEmergencia c);
    ContactoEmergencia update(ContactoEmergencia c);
    void delete(Long id);
    Optional<ContactoEmergencia> read(Long id);
    List<ContactoEmergencia> readAll();
}
