# Leque de Vagas API

Este projeto é uma API REST em Java com Spring Boot para gerenciar vagas de emprego.

## 👥 Divisão das Frentes de Trabalho

| Frente | Responsável         | Módulo               | Branch Existente | Endpoints |
| :--- |:--------------------|:---------------------| :--- | :--- |
| **Frente 1** | Luciana Neves       | Gestão de Vagas      | `feature/frente-1-vaga` | `GET /vagas`, `GET /vagas/{id}`, `POST /vagas`, `PUT /vagas/{id}`, `DELETE /vagas/{id}` |
| **Frente 2** | Gabriel Mendonça    | Empresas Parceiras   | `feature/frente-2-empresa` | `GET /empresas`, `GET /empresas/{id}`, `POST /empresas` |
| **Frente 3** | Gabriel Lobão       | Candidaturas         | `feature/frente-3-candidatura` | `POST /pessoas`, `GET /candidaturas`, `POST /candidaturas` |
| **Frente 4** | Ynara Stanislavovna | Busca & Estatísticas | `feature/frente-4-busca-metricas` | `GET /estatisticas`, `GET /vagas/busca` |

## Requisitos

- Java 21
- Maven (opcional, pois o projeto já inclui o wrapper `mvnw`)
- Git

> Observação: o projeto está configurado com `java.version=21` no arquivo `pom.xml`, então a aplicação precisa ser executada com JDK 21.

## 1) Instalando o Java 21

### Windows

1. Baixe o JDK 21 da Adoptium / Temurin ou da Oracle:
   - https://adoptium.net/
2. Instale o JDK em uma pasta como:
   - `C:\Program Files\Java\jdk-21`
3. Abra o Prompt de Comando ou PowerShell e configure as variáveis de ambiente:

```powershell
setx JAVA_HOME "C:\Program Files\Java\jdk-21"
setx PATH "%JAVA_HOME%\bin;%PATH%"
```

4. Feche e abra o terminal novamente.
5. Verifique se a instalação foi concluída com sucesso:

```powershell
java -version
```

Você deve ver algo semelhante a:

```text
openjdk version "21.x"
```

### Linux/macOS

Você pode instalar com SDKMAN, apt, ou diretamente pelo pacote do seu sistema.

Exemplo com SDKMAN: 

```bash
sdk install java 21.0.x-tem
```

Depois confirme:

```bash
java -version
```

## 2) Configurando o ambiente

No Windows, também é possível configurar manualmente no Painel de Controle:

1. Abra "Configurações do Sistema" > "Variáveis de Ambiente"
2. Em "Variáveis do sistema", clique em "Novo"
3. Crie a variável:
   - Nome: `JAVA_HOME`
   - Valor: `C:\Program Files\Java\jdk-21`
4. Edite a variável `Path` e adicione:
   - `%JAVA_HOME%\bin`
5. Reinicie o terminal.

## 3) Rodando o projeto

Acesse a pasta do projeto:

```bash
cd demo
```

### Windows

```powershell
./mvnw.cmd clean install
./mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw clean install
./mvnw spring-boot:run
```

## 4) Acessando a aplicação

Quando a aplicação iniciar, o Spring Boot normalmente sobe na porta 8080.

Você pode testar a API em:

```text
http://localhost:8080/vagas
```

## 5) Troubleshooting

### Erro: "JAVA_HOME is not defined"

Significa que a variável de ambiente do Java não foi configurada corretamente.

Verifique:

```powershell
echo %JAVA_HOME%
```

Se o valor estiver vazio, configure novamente conforme o passo anterior.

### Erro: versão do Java incompatível

Se o projeto mostrar erros de compatibilidade, confirme se a versão instalada é a 21:

```powershell
java -version
```

### Erro ao executar `mvnw`

No Windows, use:

```powershell
./mvnw.cmd
```

No Linux/macOS:

```bash
./mvnw
```

## 6) Dicas adicionais

- Se usar IntelliJ IDEA ou VS Code, é recomendado selecionar o JDK 21 como SDK do projeto.
- Para compilar sem rodar a aplicação:

```bash
./mvnw clean package
```

- Para rodar a aplicação diretamente após o build:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Se quiser, também posso criar uma versão do README com instruções específicas para Windows, Linux e IntelliJ/VS Code.
