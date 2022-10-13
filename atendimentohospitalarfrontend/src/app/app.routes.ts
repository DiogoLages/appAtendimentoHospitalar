import {Routes} from '@angular/router'
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { FichapacienteComponent } from './fichapaciente/fichapaciente.component';
import { AtendimentoComponent } from './atendimento/atendimento.component';
import { LoginComponent } from './seguranca/login/login.component';


export const ROUTES: Routes = [
    {path: '', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'fichapaciente', component: FichapacienteComponent},
    {path: 'atendimento', component: AtendimentoComponent},
    {path: 'about', component: AboutComponent}
]