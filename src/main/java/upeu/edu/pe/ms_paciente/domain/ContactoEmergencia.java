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
@Table(name="contactos_emergencia")
public class ContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="relacion")
    private String relacion;

    @Column(name="telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name="paciente_id", referencedColumnName="id")
    private Paciente paciente;

}
