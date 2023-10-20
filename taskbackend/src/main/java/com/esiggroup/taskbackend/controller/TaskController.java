package com.esiggroup.taskbackend.controller;

import com.esiggroup.taskbackend.controller.docs.TaskControllerDocs;
import com.esiggroup.taskbackend.model.dto.TaskDTO;
import com.esiggroup.taskbackend.service.implementation.TaskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController implements TaskControllerDocs {

    private final TaskServiceImpl taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {

        return ResponseEntity.ok(taskService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TaskDTO>> getTasksByFilter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "titulo", required = false) String titulo,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "responsavel", required = false) String responsavel,
            @RequestParam(name = "situacao", required = false) String situacao) {
        return ResponseEntity.ok(taskService.getTaskByFilters(id, titulo, descricao, responsavel, situacao));
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable("id") Long id, @Valid @RequestBody TaskDTO taskDTO) {
        return taskService.update(id, taskDTO);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TaskDTO create(@Valid @RequestBody TaskDTO taskDTO) {
        taskDTO.setSituacao("Em andamento");
        return taskService.save(taskDTO);
    }

    @PutMapping("/updateSituacaoToConcluida/{id}")
    public void updateTaskSituacaoToConcluida(@PathVariable("id") Long id) {
        taskService.updateTaskSituacaoToConcluida(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        taskService.deleteById(id);
    }
}
