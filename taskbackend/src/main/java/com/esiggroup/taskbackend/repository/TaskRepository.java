package com.esiggroup.taskbackend.repository;

import com.esiggroup.taskbackend.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t " +
            "WHERE (:id IS NULL OR t.id = :id) " +
            "AND (:titulo IS NULL OR t.titulo = :titulo) " +
            "AND (:descricao IS NULL OR t.descricao = :descricao) " +
            "AND (:situacao IS NULL OR t.situacao = :situacao)" +
            "AND (:responsavel IS NULL OR t.responsavel = :responsavel)"
    )
    List<Task> getTaskByFilters(
            @Param("id") Long id,
            @Param("titulo") String titulo,
            @Param("descricao") String descricao,
            @Param("responsavel") String responsavel,
            @Param("situacao") String situacao
    );

    @Modifying
    @Query("UPDATE Task t SET t.situacao = 'Concluida', t.done = true WHERE t.id = :id")
    void updateTaskSituacaoToConcluida(@Param("id") Long id);

}
