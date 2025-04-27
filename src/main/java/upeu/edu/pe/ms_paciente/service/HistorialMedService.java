package upeu.edu.pe.ms_paciente.service;
import upeu.edu.pe.ms_paciente.domain.historialmedico;

import java.util.List;
import java.util.Optional;
public interface HistorialMedService {
    historialmedico create(historialmedico h);
    historialmedico update(historialmedico h);
    void delete(Long id);
    Optional<historialmedico> read(Long id);
    List<historialmedico> readAll();
}
