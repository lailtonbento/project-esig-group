package com.esiggroup.taskbackend.service;


import com.esiggroup.taskbackend.model.dto.TaskDTO;
import com.esiggroup.taskbackend.model.entity.Task;
import com.esiggroup.taskbackend.model.enums.Prioridade;
import com.esiggroup.taskbackend.repository.TaskRepository;
import com.esiggroup.taskbackend.service.implementation.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.mockito.Mockito.when;

@Service
@RequiredArgsConstructor
public class TaskServiceTest {

    private TaskDTO taskDTO;
    private TaskServiceImpl taskService;
    private final TaskRepository taskRepository = Mockito.mock(TaskRepository.class);

    @BeforeEach
    void setUp() {
        taskService = new TaskServiceImpl(taskRepository);

        taskDTO = new TaskDTO();
        taskDTO.setTitulo("Create Basic Task");
        taskDTO.setDescricao("Criacao de uma task basica para test");
        taskDTO.setResponsavel("Joao");
        taskDTO.setPrioridade(Prioridade.ALTA);
        taskDTO.setSituacao("Em andamento");
        taskDTO.setDeadline(new Date(2021, 1, 1));
    }


    @Test
    void shouldSavedTask() {

        when(taskRepository.save(Mockito.any(Task.class))).thenAnswer(invocation -> {
            Task taskEntity = invocation.getArgument(0);
            taskEntity.setId(1L);
            return taskEntity;
        });

        TaskDTO savedTask = taskService.save(taskDTO);

        Assertions.assertEquals(1L, savedTask.getId());
        Assertions.assertEquals("Create Basic Task", savedTask.getTitulo());


        Mockito.verify(taskRepository, Mockito.times(1)).save(Mockito.any(Task.class));
    }

}
