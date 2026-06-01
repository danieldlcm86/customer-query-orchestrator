# Requirements

## Jira Story: Consultar Cliente por Identificador

### Story Description

Como operador del banco, quiero consultar un cliente por identificador, para visualizar información básica del cliente.

### Acceptance Criteria

AC1: El endpoint debe permitir consultar clientes por número de cliente.

AC2: Si el cliente no existe, retornar HTTP 404.

AC3: Si el formato del número es inválido, retornar HTTP 400.

AC4: La respuesta no debe incluir información sensible.

AC5: La operación debe registrar logs básicos.

### Subtasks

1. Crear CustomerDTO con campos.
2. Implementar CustomerService con método de consulta.
3. Implementar CustomerQueryResource con endpoint REST.
4. Agregar validaciones y manejo de excepciones.
5. Crear pruebas unitarias para el servicio y el recurso.
6. Crear endpoint tests para validar comportamiento.

### Validation Rules

Customer number must be numeric and contain exactly 8 digits.

Example: 10024501

## UI Context: Formulario de Consulta de Cliente

### Description

Formulario de consulta de cliente por número de cliente que muestra la información básica del cliente (nombre, número de cliente, segmento, estado).

### Acceptance Criteria

1. El nombre retorna nombre completo del cliente.
2. El número de cliente retorna el identificador único del cliente.
3. El segmento retorna el segmento al que pertenece el cliente: Premium, Standard, Basic.
4. El estado retorna el estado actual del cliente: Activo o Inactivo.

## Technical Context: Orquestador de Consulta de Cliente

### Description

Quarkus Orchestrator para la consulta de cliente por número de cliente.

El orquestador de consulta de cliente es responsable de coordinar la lógica de negocio para consultar un cliente por su número de cliente. Este orquestador interactúa con el servicio de cliente para obtener la información necesaria y manejar cualquier excepción que pueda surgir durante el proceso.