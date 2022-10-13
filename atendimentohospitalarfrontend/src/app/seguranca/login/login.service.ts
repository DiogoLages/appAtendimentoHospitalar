import { Injectable } from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { environment } from '../../../environments/environment';
import { Usuario } from "./login.model";

@Injectable()
export class LoginService{

    private urlLogin: string = environment.domain_ambiente + '/login';

    constructor(private http:HttpClient){}

    login(email: string, password: string): Observable<Usuario>{
        return this.http.post<Usuario>(this.urlLogin, {email: email, password: password})
    }
}