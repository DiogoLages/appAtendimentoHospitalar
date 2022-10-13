import { Plano } from "./plano.model";

export class Ficha {
    nome: string;
    celular: string;
    dataNascimento: Date;
    cpf: string;
    sexo: string;
    email: string; 
    nomePai: string; 
    nomeMae: string;
    numeroCarteira: string;
    plano: Plano;

    constructor(nome, celular, dataNascimento, cpf, sexo, email, nomePai, nomeMae, numeroCarteira, plano: Plano){
        this.nome = nome;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email= email;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.numeroCarteira = numeroCarteira;
        this.plano = plano;
    }

}