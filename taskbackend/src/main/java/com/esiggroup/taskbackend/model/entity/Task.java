package com.esiggroup.taskbackend.model.entity;

import com.esiggroup.taskbackend.model.dto.TaskDTO;
import com.esiggroup.taskbackend.model.enums.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;
    public String responsavel;
    @Enumerated(EnumType.STRING)
    public Prioridade prioridade;
    public String situacao;
    public boolean done = false;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date deadline = new Date();


    public TaskDTO toDTO() {
        return TaskDTO.builder()
                .id(id)
                .titulo(titulo)
                .descricao(descricao)
                .responsavel(responsavel)
                .prioridade(prioridade)
                .situacao(situacao)
                .done(done)
                .deadline(deadline)
                .build();
    }

}
