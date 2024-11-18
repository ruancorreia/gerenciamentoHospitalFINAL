# Gestão de Pacientes de um Hospital (Manipulação de arquivos)

Este projeto é uma aplicação que utiliza arquivos de texto para realizar operações de inclusão, alteração, exclusão e consulta de dados de pacientes de um hospital.  
Matéria Ministrada pelo professor [Alexandre Louzada](https://github.com/AlexandreLouzada).

## Funcionalidades

- **Incluir paciente**: Adiciona um novo paciente ao arquivo de dados.
- **Alterar paciente**: Permite modificar os dados de um paciente existente.
- **Excluir paciente**: Remove os dados de um paciente do arquivo.
- **Consultar paciente**: Exibe as informações de um paciente.

## Estrutura da Classe `Paciente`

A aplicação conta com a classe `Paciente`, que possui os seguintes atributos e método:

### Atributos
- `numero` (int): Número identificador do paciente.
- `peso` (double): Peso do paciente.
- `altura` (double): Altura do paciente.

### Método
- `listarPaciente()` (void): Método responsável por exibir os dados do paciente.

## Tecnologias Utilizadas

- Linguagem: **Java**
- Armazenamento: **Arquivo de texto**

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/gestao-pacientes-hospital.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd gestao-pacientes-hospital
   ```
3. Compile o código:
   ```bash
   javac Main.java
   ```
4. Execute o programa
   ```bash
   java Main
   ```
     

  O arquivo de texto gerado terá a seguinte formatação:  
  numero;peso;altura  
  1;70.5;1.75  
  2;80.2;1.80  
  
  ### Contribuições:  
  Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.
  
  Licença
  Este projeto está licenciado sob a MIT License.


💻 Desenvolvido por [Ruan Correia](https://github.com/ruancorreia)
