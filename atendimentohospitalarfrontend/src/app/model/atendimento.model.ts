export class Atendimento {
    idEspecialidade: number;
    idPaciente: number;
    dataAtendimento: Date;

    constructor(idEspecialidade, idPaciente, dataAtendimento){
        this.idEspecialidade = idEspecialidade;
        this.idPaciente = idPaciente;
        this.dataAtendimento = dataAtendimento;
    }

}