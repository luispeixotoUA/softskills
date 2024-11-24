# **Documentação - SoftSk!lls Activity Provider**

Esta documentação descreve os endpoints disponíveis para interação com o *SoftSk!lls Activity Provider* para a plataforma Inven!RA. A API permite registrar, configurar, fazer o deploy, fornecer e obter analytics de atividades de *soft skills*.

## GitHub Repository
Todo o código fonte também está disponível no [GitHub](https://github.com/luispeixotoUA/softskills)

##  URL dos Pedidos Inven!RA:
```

```

### **1. Registro da Atividade**

**Endpoint:** `/register-activity`  
**Método:** `GET`

Este endpoint retorna os dados principais da atividade, incluindo os URLs de configuração, parâmetros e endpoints de analytics.

**Resposta Exemplo:**

```
{
    "name": "SoftSk!lls",
    "config_url": "https://softskills.onrender.com/config-activity",
    "json_params_url": "https://softskills.onrender.com/json-params-activity",
    "user_url": "https://softskills.onrender.com/deploy-activity/123",
    "analytics_url": "https://softskills.onrender.com/analytics/activity",
    "analytics_list_url": "https://softskills.onrender.com/analytics/analytics-list"
}
```

> **Nota:** A URL retornada para cada endpoint está a ser gerada dinamicamente com base na variável `baseUrl`, que pode ser configurada no arquivo de configuração do sistema.

---

### **2. Página de Configuração da Atividade**

**Endpoint:** `/config-activity`  
**Método:** `GET`

Este endpoint retorna a página HTML para configurar a atividade. A plataforma Inven!RA irá embutir esta página na sua interface, permitindo que o utilizador configure a atividade conforme necessário.

**Resposta Exemplo:**

```
<!DOCTYPE html>
<html lang="pt">
<head>...</head>
<body>...</body>
</html>
```

### **3. Lista de Parâmetros de Configuração**

**Endpoint:** `/json-params-activity`  
**Método:** `GET`

Este endpoint retorna uma lista dos parâmetros configuráveis para a atividade. A plataforma Inven!RA pode obter e salvar esses parâmetros ao configurar a atividade.

**Resposta Exemplo:**

```
[
{
"name": "activity_info_url",
"type": "url"
},
{
"name": "question_1",
"type": "text/plain"
},
{
"name": "reward_level_1",
"type": "text/plain"
},
...
]
```

### **4. Deploy da Atividade**

**Endpoint:** `/deploy-activity/{activityId}`  
**Método:** `GET`

Este endpoint gera um URL para acessar a atividade, passando o ID da atividade.

**Parâmetros:**

- **activityId** (Path Parameter): O ID da instância da atividade na Inven!RA.

**Resposta Exemplo:**

```
{
"activityURL": "http://localhost:8080/deploy-activity/12345"
}
```

### **5. Fornecimento da Atividade**

**Endpoint:** `/provide-activity`  
**Método:** `POST`

Este endpoint fornece a URL de redirecionamento para o aluno com o ID de atividade e do estudante/formando.

**Request Body Exemplo:**

```
{
"activityID": "12345",
"Inven!RAstdID": "67890",
"json_params": {
"s1":"abc",
"s2":"def"
}
}
```

**Resposta Exemplo:**

```
{
"redirect_url": "http://activityprovider.com/activity/12345?studentID=67890"
}
```

### **6. Lista de Analytics da Atividade**

**Endpoint:** `/analytics/analytics-list`  
**Método:** `GET`

Este endpoint retorna a lista de analytics disponíveis para a atividade.

**Resposta Exemplo:**

```
{
  "qualAnalytics": [
    {
      "name": "access_info_before_answering",
      "type": "boolean"
    },
    {
      "name": "participation_in_quiz",
      "type": "boolean"
    }
  ],
  "quantAnalytics": [
    {
      "name": "accessed_activity",
      "type": "boolean"
    },
    {
      "name": "activity_completion_time",
      "type": "integer"
    },
    {
      "name": "correct_answers_quiz",
      "type": "integer"
    },
    {
      "name": "incorrect_answers_quiz",
      "type": "integer"
    },
    {
      "name": "accuracy_percentage",
      "type": "number"
    },
    {
      "name": "reward_level_achieved",
      "type": "integer"
    },
    {
      "name": "reaction_time",
      "type": "integer"
    },
    {
      "name": "feedback_received",
      "type": "boolean"
    },
    {
      "name": "certificate_issued",
      "type": "boolean"
    }
  ]
}
```

### **7. Obter Analytics de uma Atividade**

**Endpoint:** `/analytics/activity`  
**Método:** `POST`

Este endpoint retorna os dados analíticos de todos os alunos para uma atividade específica, com base no ID da atividade.

**Request Body Exemplo:**

```
{
"activityID": "activity-12345"
}
```

**Resposta Exemplo:**

```
[
    {
        "inveniraStdID": "1001",
        "quantAnalytics": [
            {"name": "accessed_activity", "value": true},
            {"name": "activity_completion_time", "value": 120}
        ],
        "qualAnalytics": [
            {"name": "Student activity profile", "value": "https://ActivityProvider/?APAnID=11111111"}
        ]
    },
    {
        "inveniraStdID": "1002",
        "quantAnalytics": [
            {"name": "accessed_activity", "value": true},
            {"name": "activity_completion_time", "value": 140}
        ],
        "qualAnalytics": [
            {"name": "Student activity profile", "value": "https://ActivityProvider/?APAnID=11111112"}
        ]
    }
]
```