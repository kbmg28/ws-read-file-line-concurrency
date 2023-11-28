package br.com.kbmg.wsreadfilelineconcurrency.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "line_information")
public class LineInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String data1;

    private String data2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineInformation that = (LineInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(data1, that.data1) && Objects.equals(data2, that.data2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data1, data2);
    }
}