import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {

  private urlSalvarAtendimento: string = environment.domain_ambiente + '/atendimentohospitalarbackend-web/rest/atendimento/salvarAtendimento';

  private urlBuscarTodosPacientes: string = environment.domain_ambiente + '/atendimentohospitalarbackend-web/rest/atendimento/buscarPaciente';

  private urlBuscarEspecialidades: string = environment.domain_ambiente + '/atendimentohospitalarbackend-web/rest/atendimento/buscarEspecialidades';

  constructor(private http: HttpClient) { }

  listarPacientes(){
    return this.http.get<any>(`${this.urlBuscarTodosPacientes}`);
  }

  listarEspecialidades(){
    return this.http.get<any>(`${this.urlBuscarEspecialidades}`);
  }

  salvarAtendimento(json: any){
    return this.http.post<any>(`${this.urlSalvarAtendimento}`, json);
  }
  

}
