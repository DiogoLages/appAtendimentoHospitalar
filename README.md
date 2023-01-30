###Instruções AppPD###

Criar banco de dados
CREATE DATABASE fichapaciente;
CREATE USER 'diogo'@'localhost' IDENTIFIED BY '123123123';
GRANT ALL PRIVILEGES ON * . * TO 'diogo'@'localhost';
FLUSH PRIVILEGES;

Importar o script fichapaciente.sql para popular o banco.

No eclipse importar projeto Existente no Maven Projects
	backend -> atendimentohospitalarbackend

	copiar conteudo de atendimentohospitalarbackend\configuracao e standalone.xml para -> \wildfly-13.0.0.Final\standalone\configuration
	atendimentohospitalarbackend\configuracao\com\mysql\main para -> \wildfly-13.0.0.Final\modules

Botão direito atendimentohospitalarbackend-web > Propriedades > Desabilitar JPA no Project Facets


No VsCode importar o projeto
	frontend -> atendimentohospitalarfrontend


nvm install 8.9.4
nmv use 8.9.4
npm install -g @angular/cli@6.0.0
npm install
Após baixar as dependências, subir a aplicação com o comando ng serve
