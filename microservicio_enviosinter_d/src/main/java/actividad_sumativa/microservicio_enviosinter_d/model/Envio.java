package actividad_sumativa.microservicio_enviosinter_d.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ENVIO")   // o "envio", Oracle no distingue mayúsculas
public class Envio {
    @Id
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "CODIGOTRACKING")
    private String codigoTracking;

    @NotNull
    @Column(name = "PAISORIGEN")
    private String paisOrigen;

    @NotNull
    @Column(name = "PAISDESTINO")
    private String paisDestino;

    @NotNull
    @Column(name = "FECHAENVIO")
    private LocalDate fechaEnvio;

    @NotNull
    @Column(name = "FECHAENTREGA")
    private LocalDate fechaEntrega;

    @NotNull
    @Column(name = "ESTADO")
    private String estado;

    @NotNull
    @Column(name = "COSTOENVIO")
    private BigDecimal costoEnvio;

    @NotNull
    @Column(name = "DIVISA")
    private String divisa;
}
