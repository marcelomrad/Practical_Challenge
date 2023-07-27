    #language: pt
    Funcionalidade:
      Contexto:
        Dado que o usuario esteja na página de login

      Cenario: Login com sucesso
        Dado que o usuario insere o email
        E o usuario insere a senha
        Quando o usuario clica em 'Sign in'
        Entao o usuario deve ser redirecionado para a página 'My Account'


      Esquema do Cenario:
        Dado que o usuario insere no <campo> com um <valor> que nao esteja no formato correto
        Quando o usuario clica fora do campo
        Entao o <campo> deve ficar vermelho

        Exemplos:
          | campo | valor |
          | email | tester |
          | passwd | 1234 |


      Esquema do Cenario: Testar diferentes credenciais que dão erro ao tentar logar
        Dado o usuario insere o email <email>
        E o usuario insere a senha <senha>
        Quando o usuario clica em 'Sign in'
        Entao o usuario deve ver a mensagem de erro <mensagem>

        Exemplos:
          | email | senha | mensagem |
          | tester_invalido@gmail.com | 12345 | Authentication failed. |
          | tester@gmail.com | 123455 | Authentication failed. |
          | tester | 12345 | Invalid email address. |
          | tester@gmail.com | 1234 | Invalid password. |
          |  | 1234 | An email address required. |
          | tester@gmail.com |  | Password is required. |

      Cenario: Esqueci minha senha
        Dado que o usuario clica em 'Forgot your password?'
        Quando o usuario insere o email
        E o usuario clica em 'Retrieve Password'
        Entao o usuario deve ver a mensagem de sucesso 'A confirmation email has been sent to your address: tester@gmail.com'