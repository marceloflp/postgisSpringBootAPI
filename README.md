# 🌍 GeoData API - Sistema de Consultas Geoespaciais

## 📋 Sobre o Projeto

Essa aplicação desenvolvida em Spring Boot oferece uma API para consulta de dados geoespaciais do Brasil. O sistema utiliza PostgreSQL com extensão PostGIS para armazenar e processar informações geográficas de municípios, estados, rodovias, aeroportos, portos e pontos de fronteira.

### 🎯 Objetivos

- Fornecer consultas geoespaciais sobre a infraestrutura brasileira
- Calcular distâncias entre entidades geográficas
- Listar vizinhanças entre estados e municípios
- Quantificar a distribuição de infraestrutura por região
- Oferecer uma API documentada e de fácil integração

## 🗺️ Funcionalidades

### 🌐 Unidades Federativas (Estados)
- Listagem de estados por região
- Listagem de regiões brasileiras
- Estados vizinhos de um determinado estado
- Distância entre dois estados

### 🏙️ Municípios
- Listagem de municípios vizinhos
- Distância entre dois municípios
- Filtro de municípios por estado e sigla
- Fronteira com estados específicos
- Quantidade de municípios por estado

### 🛤️ Rodovias
- Quantidade de rodovias por município
- Quantidade de rodovias por estado
- Tipos de rodovia presentes em um município

### ✈️ Aeroportos
- Lista de municípios com aeroportos por estado
- Aeroportos por região
- Quantidade de aeroportos por estado
- Quantidade de aeroportos por município

### 🚢 Portos
- Portos por região
- Quantidade de portos por estado

### 📍 Fronteiras
- Municípios com fronteira por região
- Municípios com fronteira por estado

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17+** - Linguagem de programação
- **Spring Boot 3.x** - Framework de desenvolvimento
- **Spring Data JPA** - ORM para acesso a dados
- **PostgreSQL** - Banco de dados relacional
- **PostGIS** - Extensão para dados geoespaciais
- **Hibernate Spatial** - Suporte a dados espaciais
- **OpenAPI/Swagger** - Documentação da API

### Dependências Principais
```xml
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- postgresql
- hibernate-spatial
- lombok
- springdoc-openapi-starter-webmvc-ui
```

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/example/
│   │       ├── controller/          # Controladores REST
│   │       │   ├── UnidadeFederativaController.java
│   │       │   ├── MunicipioController.java
│   │       │   ├── RodoviaController.java
│   │       │   ├── AeroportoController.java
│   │       │   ├── PortoController.java
│   │       │   └── FronteiraController.java
│   │       ├── model/              # Entidades e VOs
│   │       │   ├── UnidadeFederativa.java
│   │       │   ├── Municipio.java
│   │       │   ├── MunicipioVO.java
│   │       │   ├── Rodovia.java
│   │       │   ├── Aeroporto.java
│   │       │   ├── Porto.java
│   │       │   └── Fronteira.java
│   │       └── repository/         # Repositórios JPA
│   │           ├── UnidadeFederativaRepository.java
│   │           ├── MunicipioRepository.java
│   │           ├── RodoviaRepository.java
│   │           ├── AeroportoRepository.java
│   │           ├── PortoRepository.java
│   │           └── FronteiraRepository.java
│   └── resources/
│       └── application.properties  # Configurações da aplicação
```

## 📊 Banco de Dados

### Entidades Principais

| Tabela | Descrição | Coluna Geoespacial |
|--------|-----------|-------------------|
| `br_uf_2020` | Unidades Federativas | `geom` (Polygon) |
| `br_municipios_2020` | Municípios | `geom` (Polygon) |
| `rodovia_2014` | Rodovias | `geom` (Linestring) |
| `aeroportos_2014` | Aeroportos | `geom` (Point) |
| `porto_2014` | Portos | `geom` (Point) |
| `pontos_fronteira_2014` | Pontos de Fronteira | `geom` (Point) |

### Funções Geoespaciais Utilizadas
- `touches()` - Verifica toque entre geometrias
- `within()` - Verifica se uma geometria está dentro de outra
- `contains()` - Verifica se uma geometria contém outra
- `distance(geography())` - Calcula distância em metros
- `intersects()` - Verifica interseção entre geometrias

## 🚀 Como Executar

### Pré-requisitos

- Java 11 ou superior
- PostgreSQL 14+ com PostGIS instalado
- Maven 3.8+

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL:
```sql
CREATE DATABASE bdgeo;
```

2. Habilite a extensão PostGIS:
```sql
CREATE EXTENSION postgis;
CREATE EXTENSION postgis_topology;
```

### Configuração da Aplicação

Edite o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bdgeo
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.properties.hibernate.dialect=org.hibernate.spatial.dialect.postgis.PostgisPG10Dialect
```

### Instalação e Execução

1. Clone o repositório:
```bash
git clone https://github.com/marceloflp/postgisSpringBootAPI
cd postgisSpringBootAPI
```

2. Compile e instale as dependências:
```bash
mvn clean install
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

4. Acesse a API:
- **Base URL:** `http://localhost:8080`
- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI Docs:** `http://localhost:8080/v3/api-docs`

## 📝 Endpoints da API

### 🌐 Unidades Federativas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/listarEstadosPorRegiao/{regiao}` | Lista estados por região |
| GET | `/listarRegioes` | Lista todas as regiões |
| GET | `/listarEstadosVizinhos/{estado}` | Lista estados vizinhos |
| GET | `/distanciaEntreEstados/{sigla1}/{sigla2}` | Distância entre dois estados |

### 🏙️ Municípios

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/municipiosVizinhos/{nome}` | Lista municípios vizinhos |
| GET | `/distanciaEntreMunicipios/{a}/{b}` | Distância entre municípios |
| GET | `/procurarPorSigla/{sigla}` | Municípios por UF |
| GET | `/listarMunicipiosPorEstado/{nome}` | Municípios por estado |
| GET | `/quantidadeMunicipiosEstado/{uf}` | Quantidade por estado |

### 🛤️ Rodovias

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/quantidadeRodoviasMunicipio/{nome}` | Qtd. por município |
| GET | `/quantidadeRodoviasEstado/{uf}` | Qtd. por estado |
| GET | `/tipoDeRodoviaPorMunicipio/{municipio}` | Tipos por município |

### ✈️ Aeroportos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/municipiosComAeroportosPorEstado/{estado}` | Municípios com aeroportos |
| GET | `/aeroportosPorRegiao/{regiao}` | Aeroportos por região |
| GET | `/quantidadeAeroportoPorEstado/{regiao}` | Qtd. por região |
| GET | `/quantidadeAeroportosMunicipio/{municipio}` | Qtd. por município |

### 🚢 Portos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/portosPorRegiao/{regiao}` | Portos por região |
| GET | `/quantidadePortosEstado/{uf}` | Qtd. por estado |

### 📍 Fronteiras

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/listarMunicipiosComFronteiraPorRegiao/{regiao}` | Municípios com fronteira por região |
| GET | `/listarMuncipiosComFronteiraPorEstado/{uf}` | Municípios com fronteira por estado |

## 📌 Exemplos de Uso

### Listar Estados por Região
```bash
GET /listarEstadosPorRegiao/Sudeste
```

**Resposta:**
```json
[
  "Espírito Santo",
  "Minas Gerais",
  "Rio de Janeiro",
  "São Paulo"
]
```

### Calcular Distância Entre Estados
```bash
GET /distanciaEntreEstados/SP/RJ
```

**Resposta:**
```json
356.78
```
*(Distância em quilômetros)*

### Quantidade de Rodovias por Estado
```bash
GET /quantidadeRodoviasEstado/PR
```

**Resposta:**
```json
245
```

### Listar Municípios Vizinhos
```bash
GET /municipiosVizinhos/São Paulo
```

**Resposta:**
```json
[
  {
    "codigo": "3550308",
    "nome": "Osasco",
    "geometria": { ... }
  },
  {
    "codigo": "3548708",
    "nome": "Taboão da Serra",
    "geometria": { ... }
  }
]
```

## 🔍 Consultas Especiais

O projeto inclui consultas específicas como:

- **Municípios paraibanos com divisa com Pernambuco:**
  ```bash
  GET /listarMunicipiosParaibanosComDivisaComPernambuco
  ```

## 🤝 Como Contribuir

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request
