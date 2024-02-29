package myproject.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gender")
public class Gender {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
