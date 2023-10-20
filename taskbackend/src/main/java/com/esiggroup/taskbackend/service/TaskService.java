package com.esiggroup.taskbackend.service;

import com.esiggroup.taskbackend.model.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    List<TaskDTO> listAll();
    Page<TaskDTO> listPageable(Pageable pageable);
    List<TaskDTO> getTaskByFilters(Long id, String titulo, String descricao, String responsavel, String situacao);
    void deleteById (Long id);
    void updateTaskSituacaoToConcluida(Long id);
    TaskDTO save (TaskDTO taskDTO);
    TaskDTO update(Long id, TaskDTO taskDTO);
    TaskDTO findTaskById(Long id);
}
