package com.zaychik.backend.model;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private DataFormatReaders.Match match;

    @ManyToOne
    @JoinColumn(name = "cell_id")
    private Cell cell;
}
