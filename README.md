![LinkedIn cover - 22](https://github.com/user-attachments/assets/812d6092-7437-4297-b700-cb8bfb47f168)


# Sistema de Gerenciamento de Professores - Spring MVC

Este projeto é uma aplicação web desenvolvida com Spring Boot e Spring MVC para gerenciar informações de professores. A aplicação permite realizar operações CRUD (Create, Read, Update, Delete) em uma base de dados de professores.

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Spring Boot** - Framework para desenvolvimento de aplicações Java
- **Spring MVC** - Framework web para criação de aplicações web
- **Spring Data JPA** - Para persistência de dados
- **MySQL** - Sistema de gerenciamento de banco de dados
- **Docker Compose** - Para containerização do banco de dados
- **Thymeleaf** - Template engine para renderização das páginas HTML

## 📋 Funcionalidades

- ✅ Listar todos os professores
- ✅ Visualizar detalhes de um professor específico
- ✅ Criar novo professor
- ✅ Editar informações de professor existente
- ✅ Excluir professor
- ✅ Gerenciamento de status do professor (ATIVO, INATIVO, APOSENTADO, AFASTADO)

## 🗃️ Estrutura do Projeto

```
springmvc/
├── src/main/java/com/dev/gabriellucas/springmvc/
│   ├── Start.java                              # Classe principal da aplicação
│   └── professor/
│       ├── controllers/
│       │   └── ProfessorController.java        # Controller REST
│       ├── entities/
│       │   └── Professor.java                  # Entidade JPA
│       ├── enums/
│       │   └── StatusProfessor.java           # Enum para status
│       └── repository/
│           └── ProfessorRepository.java        # Repository JPA
├── src/main/resources/
│   └── import.sql                              # Script de dados iniciais
└── compose.yaml                                # Configuração Docker Compose
```

## 🐳 Configuração do Banco de Dados

O projeto utiliza MySQL executando em container Docker. A configuração está no arquivo `compose.yaml`:

```yaml
services:
  mysql:
    container_name: mysql_container
    image: 'mysql:latest'
    environment:
      - 'MYSQL_DATABASE=springmvc'
      - 'MYSQL_PASSWORD=admin'
      - 'MYSQL_ROOT_PASSWORD=admin'
      - 'MYSQL_USER=admin'
    ports:
      - '3360:3306'
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven
- Docker e Docker Compose

### Passos para execução

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd springmvc
   ```

2. **Inicie o banco de dados MySQL:**
   ```bash
   docker-compose up -d
   ```

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação:**
   - URL: `http://localhost:8080`
   - Endpoint principal: `http://localhost:8080/professores`

## 📊 Modelo de Dados

### Entidade Professor

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | Identificador único (auto-incremento) |
| nome | String | Nome do professor |
| salario | Double | Salário do professor |
| statusProfessor | StatusProfessor | Status atual do professor |

### Enum StatusProfessor

- `ATIVO` - Professor em atividade
- `INATIVO` - Professor inativo
- `APOSENTADO` - Professor aposentado
- `AFASTADO` - Professor afastado

## 🛣️ Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/professores` | Lista todos os professores |
| GET | `/professor/new` | Formulário para criar novo professor |
| POST | `/professores` | Cria um novo professor |
| GET | `/professor/{id}` | Exibe detalhes de um professor |
| GET | `/professor/edit/{id}` | Formulário para editar professor |
| POST | `/professor/update/{id}` | Atualiza um professor existente |
| GET | `/professor/delete/{id}` | Exclui um professor |

## 💾 Dados Iniciais

A aplicação vem com dados pré-cadastrados definidos no arquivo `import.sql`:

- João Silva - R$ 4.500,00 (ATIVO)
- Maria Oliveira - R$ 5.000,00 (APOSENTADO)
- Carlos Souza - R$ 4.000,00 (INATIVO)
- Ana Lima - R$ 5.500,00 (AFASTADO)
- Paulo Andrade - R$ 4.700,00 (ATIVO)

## 🏗️ Arquitetura

O projeto segue o padrão MVC (Model-View-Controller):

- **Model**: Entidade `Professor` e enum `StatusProfessor`
- **View**: Templates Thymeleaf (referenciados no controller)
- **Controller**: `ProfessorController` gerencia as requisições HTTP

## 🔧 Configurações Adicionais

- Porta do MySQL: `3360` (mapeada para `3306` no container)
- Base de dados: `springmvc`
- Usuário: `admin`
- Senha: `admin`

## 📝 Próximas Melhorias

- [ ] Implementar validação de dados
- [ ] Adicionar paginação na listagem
- [ ] Implementar busca e filtros
- [ ] Adicionar testes unitários
- [ ] Implementar autenticação e autorização
- [ ] Adicionar logs de auditoria

## 📄 Licença

Este projeto é livre para uso educacional e desenvolvimento.

---

**Desenvolvido por:** Gabriel Lucas  
**Tecnologia:** Spring Boot + Spring MVC
