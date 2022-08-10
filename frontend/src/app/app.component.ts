import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Optional } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Funcionario } from './funcionario';
import { FuncionarioService } from './funcionario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public funcionarios: Funcionario[] | undefined;
  public editFuncionario: Funcionario | undefined;
  public deleteFuncionario! : Funcionario;

  constructor(private funcionarioservice : FuncionarioService){}

  ngOnInit(): void {
    this.getFuncionario();
  }
  public getFuncionario(): void{
    this.funcionarioservice.getFuncionarios().subscribe(
      (response: Funcionario[]) =>{
        this.funcionarios = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public onAddFuncionario(addForm: NgForm):void{
    document.getElementById("add-funcionario-form")?.click();
    this.funcionarioservice.adicionarFuncionarios(addForm.value).subscribe(
      (response: Funcionario) => {        
        this.getFuncionario();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  
  public onEditarFuncionario(funcionario: Funcionario):void{
    document.getElementById("edit-funcionario-form")?.click();
    this.funcionarioservice.atualizarFuncionario(funcionario).subscribe(
      (response: Funcionario) => {        
        this.getFuncionario();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public onDeletarFuncionario(idFuncionario: number):void{
    document.getElementById("delete-funcionario-form")?.click();
    this.funcionarioservice.deletarFuncionario(idFuncionario).subscribe(
      (response) => {        
        this.getFuncionario();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public procurarFuncionario(key:string):void{
    const result: Funcionario[] = [];  
    for(const funcionario of this.funcionarios!){
      if(funcionario.nome.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || funcionario.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || funcionario.telefone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || funcionario.cargo.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        result.push(funcionario);
      }      
    }
    this.funcionarios = result;
      if(result.length === 0 || !key ){
        this.getFuncionario();
      }
  }
  public onOpenModalAdd(mode: string):void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type= 'button';
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal')
    if(mode=== 'add'){
      button.setAttribute('data-target', '#addFuncionarioModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onOpenModal(funcionario: Funcionario, mode: string):void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type= 'button';
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal')
    if(mode=== 'add'){
      button.setAttribute('data-target', '#addFuncionarioModal');
    }
    if(mode=== 'edit'){
      this.editFuncionario = funcionario;
      button.setAttribute('data-target', '#updateFuncionarioModal');
    }
    if(mode=== 'delete'){
      this.deleteFuncionario = funcionario;
      button.setAttribute('data-target', '#deleteFuncionarioModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
