import { Injectable, ErrorHandler } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Observable'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'


@Injectable()
export class FichapacienteService {

  private urlSalvar: string = environment.domain_ambiente + '/atendimentohospitalarbackend-web/rest/ficha/salvarFichaPaciente';

  private urlBuscarPlano: string = environment.domain_ambiente + '/atendimentohospitalarbackend-web/rest/ficha/buscarPlanoSaude';

  constructor(private http: HttpClient) { }

  listarPlanos(){
    return this.http.get<any>(`${this.urlBuscarPlano}`);
  }

  salvarFichar(json: any) {
    return this.http.post<any>(`${this.urlSalvar}`, json);
  }

}
