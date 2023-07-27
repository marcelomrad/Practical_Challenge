# Sistema de Testes Automatizados de Interface

Este é um sistema de testes automatizados de interface desenvolvido como parte do processo de seleção para a vaga de estágio em QA.

## Descrição

Este sistema de testes automatizados de interface utiliza a biblioteca Cucumber com Java e Selenium para realizar testes de aceitação em uma aplicação web de exemplo. O projeto inclui cenários de teste para verificar o login do usuário, validação de campos e recuperação de senha.

## Premissas Assumidas

1. Ambiente de Teste Configurado: Pressupõe-se que o ambiente de teste esteja corretamente configurado com todas as dependências necessárias, incluindo o Java (versão 17) e Maven

2. Compatibilidade do Navegador: O sistema de testes foi desenvolvido e testado com o Google Chrome (versão 4.10.0) em modo "headless". Não foi testado em outros navegadores, portanto, podem ocorrer problemas de compatibilidade se utilizado com navegadores diferentes.

3. Validade dos Cenários de Teste: Os cenários de teste refletem corretamente os requisitos e comportamentos esperados da interface de usuário. Alterações nos requisitos podem exigir revisão e atualização dos cenários de teste.

4. Conhecimento Prévio: O usuário deve possuir um conhecimento básico em desenvolvimento de software, Java, Maven e Selenium WebDriver.

## Decisões de Projeto

1. **IDE: IntelliJ IDEA:** Utilizou-se o IntelliJ IDEA como a IDE principal para o desenvolvimento do projeto de testes automatizados. O IntelliJ IDEA oferece suporte avançado e eficiente para escrever, depurar e executar código Java.

2. **Framework de Teste: Cucumber:** O Cucumber foi escolhido como o framework de teste para a escrita dos cenários em linguagem natural (Gherkin) e para a execução dos testes automatizados de interface.

3. **Framework de Teste Unitário: JUnit 5:** O JUnit 5 foi utilizado como o framework de testes unitários para testar componentes individuais do sistema de testes automatizados de interface. O JUnit 5 é uma biblioteca de testes amplamente utilizada no ecossistema Java, oferecendo recursos robustos para escrever e executar testes unitários de forma concisa e organizada.


## Pré-requisitos

Para executar o sistema de testes automatizados de interface, você precisa ter os seguintes softwares instalados:

- Java 17
- ChromeDriver 4.10.0
- Google Chrome Browser
- Maven

## Configuração e Execução

Siga as etapas abaixo para configurar o ambiente e executar os testes automatizados:

1. Clone o repositório em sua máquina local:
`https://github.com/marcelomrad/Practical_Challenge.git`
cd practical_challenge

2. Instale as dependências usando o Maven:
`mvn clean install`

3. Execute os testes automatizados:
`mvn test`


## Cenários de Teste

O sistema de testes automatizados de interface inclui os seguintes cenários de teste:

1. Cenário: Login com sucesso
   - O usuário insere o email
   - O usuário insere a senha
   - O usuário clica em 'Sign in'
   - O usuário deve ser redirecionado para a página 'My Account'

2. Cenário: Validação de Campos Inválidos
   - O usuário insere no campo com um valor que não esteja no formato correto
   - O usuário clica fora do campo
   - O campo deve ficar vermelho

3. Cenário: Testar Diferentes Credenciais que Dão Erro ao Tentar Logar
   - O usuário insere o email e senha
   - O usuário clica em 'Sign in'
   - O usuário deve ver a mensagem de erro correspondente

4. Cenário: Esqueci minha senha
   - O usuário clica em 'Forgot your password?'
   - O usuário insere o email
   - O usuário clica em 'Retrieve Password'
   - O usuário deve ver a mensagem de sucesso


