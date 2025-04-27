package upeu.edu.pe.ms_paciente.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_paciente.domain.historialmedico;
import upeu.edu.pe.ms_paciente.repository.historialmedRepository;
import upeu.edu.pe.ms_paciente.service.HistorialMedService;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedServiceImpl implements HistorialMedService {

    @Autowired
    private historialmedRepository repository;

    @Override
    public historialmedico create(historialmedico h) {
        return repository.save(h);
    }

    @Override
    public historialmedico update(historialmedico h) {
        return repository.save(h);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<historialmedico> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<historialmedico> readAll() {
        return repository.findAll();
    }
}