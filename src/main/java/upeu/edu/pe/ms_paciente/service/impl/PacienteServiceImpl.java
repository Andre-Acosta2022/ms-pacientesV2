package upeu.edu.pe.ms_paciente.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_paciente.domain.Paciente;
import upeu.edu.pe.ms_paciente.repository.PacienteRepository;
import upeu.edu.pe.ms_paciente.service.PacienteService;


import java.util.List;
import java.util.Optional;
@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository repository;
    @Override
    public Paciente create(Paciente c) {
        return repository.save(c);
    }

    @Override
    public Paciente update(Paciente c) {
        return repository.save(c);
    }

    @Override
    public void delete(Long id) {
repository.deleteById(id);
    }

    @Override
    public Optional<Paciente> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Paciente> readAll() {
        return repository.findAll();
    }
}
