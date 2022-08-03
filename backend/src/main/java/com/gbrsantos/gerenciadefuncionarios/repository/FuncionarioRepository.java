package com.gbrsantos.gerenciadefuncionarios.repository;

import com.gbrsantos.gerenciadefuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    void deleteFuncionarioById(Long id);

    Optional<Funcionario> findFuncionarioById(Long id);
}
