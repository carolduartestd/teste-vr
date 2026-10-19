## Autenticação

A aplicação utiliza **HTTP Basic Authentication** conforme especificado no contrato dos serviços.

- **Usuário:** `username`
- **Senha:** `password`

### Decisões técnicas

- As credenciais foram configuradas em memória (`InMemoryUserDetailsManager`) pois o enunciado não exige gerenciamento de usuários.
- A senha é armazenada utilizando `BCryptPasswordEncoder`.
- A sessão foi configurada como `STATELESS`, por se tratar de uma API REST.
- O CSRF foi desabilitado, comportamento padrão e recomendado para APIs que utilizam autenticação via token/Basic Auth.
- Todos os endpoints exigem autenticação. Requisições sem credenciais válidas retornam `401 Unauthorized`.
