package upeu.edu.pe.ms_paciente.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_paciente.domain.ContactoEmergencia;
import upeu.edu.pe.ms_paciente.repository.ContEmergenciaRepository;
import upeu.edu.pe.ms_paciente.service.ContEmergenciaService;

import java.util.List;
import java.util.Optional;

@Service
public class ContEmergenciaServiceImpl implements ContEmergenciaService {

    @Autowired
    private ContEmergenciaRepository repository;

    @Override
    public ContactoEmergencia create(ContactoEmergencia c) {
        return repository.save(c);
    }

    @Override
    public ContactoEmergencia update(ContactoEmergencia c) {
        return repository.save(c);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ContactoEmergencia> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ContactoEmergencia> readAll() {
        return repository.findAll();
    }
}