package upeu.edu.pe.ms_paciente.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="historial_medico")
public class historialmedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fechaDiagnostico")
    private String fechaDiagnostico;

    @Column(name="descripcionCondicion")
    private String descripcionCondicion;

    @Column(name="tratamiento")
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name="paciente_id", referencedColumnName="id")
    private Paciente paciente;

}
