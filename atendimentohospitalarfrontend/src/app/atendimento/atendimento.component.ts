import { Atendimento } from './../model/atendimento.model';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AtendimentoService } from './atendimento.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mt-atendimento',
  templateUrl: './atendimento.component.html',
  providers: [AtendimentoService]
})
export class AtendimentoComponent implements OnInit {

  pacientes: any;
  especialidades: any;

  formAtendimento: FormGroup;
  possuiAutorizacao: boolean;

  solicitouAtendimento: boolean = false;

  constructor(
    private atendimentoService: AtendimentoService,
    private fb: FormBuilder) { }

  ngOnInit() {
    this.atendimentoService.listarPacientes().subscribe((resposta: any) => {
      this.pacientes = resposta;
    })
    this.atendimentoService.listarEspecialidades().subscribe((resposta: any) => {
      this.especialidades = resposta;
    })

  this.formAtendimento = this.fb.group({
    paciente: ['', [Validators.required]],
    dataAtendimento: ['', []],
    especialidade: ['', [Validators.required]]
  });

  }
  
  get f() { return this.formAtendimento.controls; }

  salvarAtendimento () {
    
    let json = this.formAtendimento.value;
    
    this.atendimentoService.salvarAtendimento(json).subscribe((resposta: any) => {
      this.solicitouAtendimento = true;
      this.possuiAutorizacao = resposta;
    });

  }

}
