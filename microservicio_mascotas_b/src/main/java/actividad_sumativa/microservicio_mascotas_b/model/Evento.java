package actividad_sumativa.microservicio_mascotas_b.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENTO")
public class Evento {
    @Id
    @NotNull(message = "El ID no puede ser nulo")
    @Column(name = "ID") //
    private Long id;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "MODALIDAD")
    private String modalidad;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "LUGAR")
    private String lugar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MASCOTA_ID", referencedColumnName = "ID")
    private Mascota mascota;

}
