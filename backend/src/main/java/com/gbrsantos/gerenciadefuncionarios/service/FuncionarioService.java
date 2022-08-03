package com.gbrsantos.gerenciadefuncionarios.service;

import com.gbrsantos.gerenciadefuncionarios.exception.UserNotFoundException;
import com.gbrsantos.gerenciadefuncionarios.model.Funcionario;
import com.gbrsantos.gerenciadefuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario adicionarFuncionario(Funcionario funcionario){
        funcionario.setCodigoFuncionario(UUID.randomUUID().toString());
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> buscarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteFuncionarioById(id);
    }
    public Funcionario buscarFuncionarioPorId(Long id){
        return funcionarioRepository.findFuncionarioById(id)
                .orElseThrow(()-> new UserNotFoundException("Usuário com o id"+id+ "não foi encontrado"));
    }
}
