package com.esiggroup.taskbackend.model.dto;

import com.esiggroup.taskbackend.model.entity.Task;
import com.esiggroup.taskbackend.model.enums.Prioridade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    @NotBlank(message = "Titulo não pode estar vazio")
    private String titulo;
    @NotBlank(message = "Descrição não pode estar vazio")
    private String descricao;
    public String responsavel;
    public Prioridade prioridade;
    public String situacao;
    public boolean done = false;
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date deadline;

    public Task toEntity(){
        return Task.builder()
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
