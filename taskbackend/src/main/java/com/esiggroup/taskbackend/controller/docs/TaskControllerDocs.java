package com.esiggroup.taskbackend.controller.docs;

import com.esiggroup.taskbackend.model.dto.TaskDTO;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@Api("Task API")
public interface TaskControllerDocs {

    @ApiOperation("List all tasks with pagination")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of tasks returned successfully")
    })
    @GetMapping
    ResponseEntity<List<TaskDTO>> findAllTasks();
    @ApiOperation("Delete a task by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Task deleted successfully"),
            @ApiResponse(code = 404, message = "Task not found with the specified ID")
    })

    @GetMapping("/{id}")
    ResponseEntity<TaskDTO> findTaskById(
            @ApiParam("ID of the task to be find") @PathVariable("id") Long id);
    @ApiOperation("Search task by filters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tasks found successfully"),
            @ApiResponse(code = 404, message = "No tasks found with the specified filters")
    })
    @GetMapping("/search")
    ResponseEntity<List<TaskDTO>> getTasksByFilter(
            @ApiParam("Search term")   @RequestParam(name = "id", required = false) Long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("responsavel") String responsavel,
            @RequestParam("situacao") String situacao);

    @ApiOperation("Update an existing task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Task updated successfully"),
            @ApiResponse(code = 404, message = "Task not found with the specified ID")
    })
    @PutMapping("/{id}")
    TaskDTO update(
            @ApiParam("ID of the task to be updated") @PathVariable("id") Long id,
            @ApiParam("Data of the task to be updated") @Valid @RequestBody TaskDTO taskDTO);

    @ApiOperation("Create a new task")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Task created successfully")
    })
    @PostMapping
    TaskDTO create(
            @ApiParam("Data of the new task to be created") @Valid @RequestBody TaskDTO taskDTO);


    @ApiOperation("Delete a task by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Task deleted successfully"),
            @ApiResponse(code = 404, message = "Task not found with the specified ID")
    })
    @DeleteMapping("/{id}")
    void deleteById(
            @ApiParam("ID of the task to be deleted") @PathVariable("id") Long id);

}
