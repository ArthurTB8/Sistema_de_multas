# Exercicio-Sistema-De-Multas

<p align="center">
    <img alt="Badge indicando que o projeto foi criado em dezembro de 2022" src="https://img.shields.io/badge/Data%20de%20cria%C3%A7%C3%A3o-Dezembro%2F2022-blue">
    <img alt="Badge indicando que o status do projeto é 'Finalizado'" src="https://img.shields.io/badge/Status-Finalizado-green">
</p>

<p align="center">
    • <a href="#SistemaDeMultas">Sistema de multas</a>
    • <a href="#descricao">Descrição</a>
    • <a href="#Desenvolvedor">Desenvolvedor</a>
</p>

<h2 id="SistemaDeMultas"> :computer_mouse: Sistema de multas</h2>

O exercício proposto pela academia 1000 Devs, realizado pela Mesttra em parceria com a Johnson & Johnson MedTech, simula uma interface de gerenciamento de um sistema de multas, sem interface gráfica definida e rodando através do terminal do sistema operacional. O programa está conectado a um banco de dados (postgres) local, para realização da persistência dos dados. Utilizando ferramentas como Hibernate para gerenciar as operações com o banco de dados, fazendo o correto mapeamento entre as entidades com suas respectivas cardinalidades.<br>

<h2 id="descricao">:pencil2: Descrição</h2>

### O que faz?
#### O programa conta com diversas funções comuns a um sistema de multas:
    • Cadastro de condutores, veiculos e multas
    • Remoção
    • Consulta
    • Transferencia de veiculos
O sistema possui algumas validações, como por exemplo, não podemos criar um veiculo sem um condutor, ou uma multa sem um veiculo associado, explorando as opções de mapeamento como Optional, Cascade e Fetch.

### Qual o objetivo?
    • O objetivo pricipal é a comunicação de uma aplicação com o banco de dados e a persistência das informações.
    • A conexão é realizada via Hibernate, e a aplicação usa conceitos de POO, como herança e polimorfismo.
   
<h2 id="Desenvolvedor"> Desenvolvedor</h2>
<p>
<p align="center">
  <a href="https://github.com/ArthurTB8">
    <img width="120px" src="https://avatars.githubusercontent.com/u/107354840?v=4" alt="Foto Arthur Teixeira">
  </a>

<p align="center">
<a href="https://www.linkedin.com/in/arthur-teixeira-8885b1241/">@Arthur Teixeira</a>

</p>
</p>
