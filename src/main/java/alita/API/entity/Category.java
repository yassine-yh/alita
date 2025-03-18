package alita.API.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(unique = true, nullable = false)
    private String categoryName;

    private String description;




    // Getters and Setters
}
