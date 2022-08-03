package com.gbrsantos.gerenciadefuncionarios;

import com.gbrsantos.gerenciadefuncionarios.model.Funcionario;
import com.gbrsantos.gerenciadefuncionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/funcionario")
public class FuncionarioResource {
    private final FuncionarioService funcionarioService;


    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionarios();
        return new ResponseEntity(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Funcionario> getFuncionarioPorId(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return new ResponseEntity(funcionario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Funcionario> adicionarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario novoFuncionario = funcionarioService.adicionarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Funcionario> atualizarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(funcionario);
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable("id") Long id){
        funcionarioService.deletarFuncionario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
