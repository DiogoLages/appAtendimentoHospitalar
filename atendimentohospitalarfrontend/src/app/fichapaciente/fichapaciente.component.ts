import { Component, OnInit } from '@angular/core';
import { FichapacienteService } from './fichapaciente.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Plano } from 'app/model/plano.model';
import { Ficha } from 'app/model/ficha.model';

@Component({
  selector: 'mt-fichapaciente',
  templateUrl: './fichapaciente.component.html',
  providers: [FichapacienteService]
}) 
export class FichapacienteComponent implements OnInit {

  fichaForm: FormGroup;
  planos: any;
  msgSucesso: string;

  constructor(
    private fichaService: FichapacienteService,
    private fb: FormBuilder) { }

  ngOnInit() {
    this.fichaService.listarPlanos().subscribe((resposta: any) => {
      this.planos = resposta;
    })

    this.fichaForm = this.fb.group({
      nome: ['', [Validators.required]],
      celular: ['', []],
      dataNascimento: ['', []],
      cpf: ['', [Validators.required]],
      sexo: ['', []],
      email: ['', []],
      nomePai: ['', []],
      nomeMae: ['', []],
      numeroCarteira: ['', [Validators.required]],
      plano: ['', [Validators.required]]
    });

  }

  get f() { return this.fichaForm.controls; }

  salvarFicha() {

    let plano = new Plano(this.fichaForm.value.plano)

    let ficha = new Ficha(
      this.fichaForm.value.nome,
      this.fichaForm.value.celular,
      this.fichaForm.value.dataNascimento,
      this.fichaForm.value.cpf,
      this.fichaForm.value.sexo,
      this.fichaForm.value.email,
      this.fichaForm.value.nomePai,
      this.fichaForm.value.nomeMae,
      this.fichaForm.value.numeroCarteira,
      plano
    );

    this.fichaService.salvarFichar(ficha).subscribe((resposta: any) => {
      this.msgSucesso = "Salvo com sucesso";
    });
    this.fichaForm.reset();
  }

}
