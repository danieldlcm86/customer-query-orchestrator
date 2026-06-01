# Project Structure

## Java Package

```
─── 📁 Java/customer
    └── 📁dto
        ├── CustomerQueryRequest.java
        ├── CustomerResponse.java
    └── 📁exception
        ├── CustomerNotFoundException.java
        ├── InvalidCustomerNumberException.java
    └── 📁mapper
        ├── CustomerMapper.java
    └── 📁model
        ├── Customer.java
    └── 📁orchestrator
        ├── CustomerQueryOrchestrator.java
    └── 📁repository
        ├── CustomerRepository.java
    └── 📁resource
        ├── CustomerQueryResource.java
    └── 📁service
        └── CustomerService.java
```

## Test Package

```
─── 📁Test/customer
    └── 📁orchestrator
        ├── CustomerQueryOrchestratorTest.java
    └── 📁resource
        ├── CustomerQueryResourceTest.java
    └── 📁service
        └── CustomerServiceTest.java
```