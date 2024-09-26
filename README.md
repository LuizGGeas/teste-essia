# teste essia

Para rodar este projeto existem duas formas:

Via docker:
-   
1) Instale o docker na sua máquina, seguindo as instruções no site [Docker](https://www.docker.com/);
2) Navegue até a pasta do projeto, onde se encontra o arquivo Dockerfile;
2) Rode o comando `docker build -t teste-essia .` no terminal;
3) Rode o comando `docker run -p 8080:8080 teste-essia`.

Via Gradle:
-
1) Tenha no Path do sistema a variável JAVA_HOME configurada;
2) Navegue até a pasta do projeto onde se encontra o arquivo gradlew;
3) Rode o comando `gradlew bootRun` no windows linha de comando(CMD) ou `./gradlew bootRun` 
para rodar via Powershell ou em outras distros.

A porta a qual o projeto estará apontando será a porta 8080.

Caso precise de ajuda, pode acessar o arquivo [HELP.md](HELP.md) para acessar a documentação 
das tecnologias utlizadas nesse projeto.