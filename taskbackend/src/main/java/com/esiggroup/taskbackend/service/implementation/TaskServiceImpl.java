package com.esiggroup.taskbackend.service.implementation;

import com.esiggroup.taskbackend.model.dto.TaskDTO;
import com.esiggroup.taskbackend.model.entity.Task;
import com.esiggroup.taskbackend.repository.TaskRepository;
import com.esiggroup.taskbackend.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDTO> listAll() {
        return taskRepository.findAll()
                .stream()
                .filter( task -> !task.isDone())
                .map(Task::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<TaskDTO> listPageable(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(Task::toDTO);
    }

    @Override
    public List<TaskDTO> getTaskByFilters(Long id, String titulo, String descricao, String responsavel, String situacao) {
        return taskRepository.getTaskByFilters(id, titulo, descricao, responsavel, situacao)
                .stream().map(Task::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(Long id) {
        existById(id);
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTaskSituacaoToConcluida(Long id) {
        existById(id);
        taskRepository.updateTaskSituacaoToConcluida(id);
    }

    @SneakyThrows
    public void existById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new Exception("Task not exist with id: " + id);
        }
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return taskRepository
                .save(taskDTO.toEntity())
                .toDTO();
    }

    @Override
    public TaskDTO update(Long id, TaskDTO taskDTO) {
        existById(id);
        return taskRepository.save(taskDTO.toEntity())
                .toDTO();
    }

    @Override
    public TaskDTO findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id" + id))
                .toDTO();
    }
}
