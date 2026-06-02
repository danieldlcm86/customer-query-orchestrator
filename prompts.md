# Promps utilizados en el curso GitHub Copilot Enterprise: Orquestador de Consulta de Cliente

## Prompt 1: requirements.md

@workspace Analiza requirements.md y genera un plan de implementación técnico.

## Prompt 2: Customer, el DTO CustomerResponse y el CustomerMapper

Basado en requirements.md y en el plan de implementación técnica, implementa el modelo de dominio Customer, el DTO CustomerResponse y el CustomerMapper.

Reglas:

`Customer` puede contener campos sensibles como correo electrónico (`email`) y teléfono (`phone`).
`CustomerResponse` debe exponer únicamente:

 `customerNumber`
 `fullName`
 `segment`
 `status`
Utiliza Java Records cuando sea apropiado.
Mantén la implementación simple, clara y fácil de leer.

## Prompt 3: CustomerRepository

Basado en requirements.md y en el plan de implementación técnica, implementa CustomerRepository.

Reglas:

Utiliza un conjunto de datos en memoria (in-memory dataset).
Devuelve un Optional<Customer>.
Incluye al menos 3 clientes de ejemplo.
Utiliza números de cliente numéricos de exactamente 8 dígitos.
Mantén la implementación simple, clara y fácil de leer.

## Prompt 4: CustomerService

Basado en requirements.md y en el plan de implementación técnica, implementa CustomerService.

Responsabilidades:

- Validar que `customerNumber` no sea `null` ni esté vacío.
- Validar que `customerNumber` contenga exactamente **8 dígitos numéricos**.
- Recuperar el cliente desde `CustomerRepository`.
- Lanzar `InvalidCustomerNumberException` cuando el formato sea inválido.
- Lanzar `CustomerNotFoundException` cuando el cliente no exista.
- Mantener la implementación simple, clara y fácil de leer.

## Prompt 5: CustomerQueryOrchestrator

Basado en requirements.md y en el plan de implementación técnica, implementa CustomerQueryOrchestrator.

Responsabilidades:

- Coordinar el caso de uso de consulta de cliente.
- Usar `CustomerService` para recuperar el cliente.
- Usar `CustomerMapper` para convertir `Customer` a `CustomerResponse`.
- Agregar logs básicos sin exponer información sensible.
- Mantener la implementación simple, clara y fácil de leer.

## Prompt 6: CustomerQueryResource

Basado en requirements.md y en el plan de implementación técnica, implementa CustomerQueryResource y los exception mappers requeridos.

Requisitos:

- Exponer `GET /customers/{customerNumber}`.
- Retornar `CustomerResponse` como JSON.
- Mapear `InvalidCustomerNumberException` a HTTP `400`.
- Mapear `CustomerNotFoundException` a HTTP `404`.
- Usar una respuesta de error consistente con:
- `code`
- `message`
- `timestamp`
- Agregar logs básicos sin exponer información sensible.
- Mantener la implementación simple, clara y fácil de leer.

## Prompt 7: CustomerQueryResourceTest.java

Basado en requirements.md y en la implementación actual, actualiza CustomerQueryResourceTest.

Crea pruebas de API REST usando RestAssured para validar que:

- `GET /customers/12345678` retorna `200`.
- La respuesta contiene:`customerNumber`
- `fullName`
- `segment`
- `status`

- La respuesta no contiene:
- `email`
- `phone`

- `GET /customers/123` retorna `400`.
- `GET /customers/99999999` retorna `404`.

- Las respuestas de error contienen:
- `code`
- `message`
- `timestamp`

Mantén las pruebas simples, claras y fáciles de leer.