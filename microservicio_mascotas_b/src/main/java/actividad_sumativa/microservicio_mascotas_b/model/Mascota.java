package actividad_sumativa.microservicio_mascotas_b.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

// Librería de Lombok que genera automáticamente los métodos getters y setters
import lombok.AllArgsConstructor;

// Lombok genera automáticamente métodos como toString(), equals(), hashCode(), getters y setters
import lombok.Data;

// Lombok genera un constructor vacío sin parámetros
import lombok.NoArgsConstructor;

@Data // Genera getters y setters automáticamente
@AllArgsConstructor // Constructor con parámetros
@NoArgsConstructor // Constructor vacío
@Entity // 🔵 Indicamos que es una entidad de base de datos
@Table(name = "MASCOTA") // 🔵 Mapeamos a la tabla "mascota"
public class Mascota {

    @Id
    @NotNull(message = "El ID no puede ser nulo")
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "La Especie no puede ser nulo")
    @Column(name = "ESPECIE")
    private String especie;
    
    @NotNull(message = "El ID no puede ser nulo")
    @Column(name = "RAZA")
    private String raza;

    @Column(name = "FECHANACIMIENTO")
    private LocalDate fechaNacimiento;

   
}
    