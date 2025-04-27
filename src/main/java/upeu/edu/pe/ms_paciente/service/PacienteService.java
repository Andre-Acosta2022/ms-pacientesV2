package upeu.edu.pe.ms_paciente.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_paciente.domain.Paciente;
import upeu.edu.pe.ms_paciente.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public interface PacienteService {
    Paciente create(Paciente c);
    Paciente update(Paciente c);
    void delete(Long id);
    Optional<Paciente> read(Long id);
    List<Paciente> readAll();
}
