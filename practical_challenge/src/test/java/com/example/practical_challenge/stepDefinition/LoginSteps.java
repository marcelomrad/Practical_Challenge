package com.example.practical_challenge.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.pt.*;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;

public class LoginSteps {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());

    @Before
    public void setupChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        logger.info("Teste iniciado");
    }


    @Dado("que o usuario esteja na página de login")
    public void usuarioEstejaPaginaLogin() {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Dado("que o usuario insere o email")
    public void usuarioInsereEmail() {
        driver.findElement(By.id("email")).sendKeys("tester@gmail.com");
    }

    @E("o usuario insere a senha")
    public void usuarioInsereSenha() {
        driver.findElement(By.id("passwd")).sendKeys("12345");
    }

    @Quando("o usuario clica em 'Sign in'")
    public void usuarioClicaSignIn() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Entao("o usuario deve ser redirecionado para a página 'My Account'")
    public void usuarioRedirecionadoPaginaMyAccount() {
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("My account - My Shop", pageTitle);
    }

    @ParameterType(".*")
    public String campo(String campo) {
        return campo;
    }

    @ParameterType(".*")
    public String valor(String valor) {
        return valor;
    }

    @Dado("que o usuario insere no {campo} com um {valor} que nao esteja no formato correto")
    public void usuarioInsereCampoValorFormatoCorreto(String campo, String valor) {
        driver.findElement(By.id(campo)).sendKeys(valor);
    }

    @Quando("o usuario clica fora do campo")
    public void usuarioClicaForaDoCampo() {
        driver.findElement(By.id("login_form")).click();
    }

    @Entao("o {campo} deve ficar vermelho")
    public void campoDeveFicarVermelho(String campo) {
        String color = driver.findElement(By.id(campo)).getCssValue("color");
        Assertions.assertEquals("rgba(241, 51, 64, 1)", color);
    }

    @ParameterType(".*")
    public String email(String email) {
        return email;
    }

    @ParameterType(".*")
    public String senha(String senha) {
        return senha;
    }

    @ParameterType(".*")
    public String mensagem(String mensagem) {
        return mensagem;
    }

    @Dado("o usuario insere o email {email}")
    public void usuarioInsereEmailVariavel(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @E("o usuario insere a senha {senha}")
    public void usuarioInsereSenhaVariavel(String senha) {
        driver.findElement(By.id("passwd")).sendKeys(senha);
    }

    @Entao("o usuario deve ver a mensagem de erro {mensagem}")
    public void usuarioVeMensagemDeErro(String mensagem) {
        String alert = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        alert = alert.split("\n")[1];
        Assertions.assertEquals(mensagem, alert);
    }

    @Dado("que o usuario clica em {string}")
    public void usuarioClicaEmForgotYourPassword(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    @Quando("o usuario insere o email")
    public void usuarioInsereEmailRetrievePassword() {
        driver.findElement(By.id("email")).sendKeys("tester@gmail.com");
    }
    @E("o usuario clica em 'Retrieve Password'")
    public void usuarioClicaRetrievePassword() {
        driver.findElement(By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button")).click();
    }

    @Entao ("o usuario deve ver a mensagem de sucesso {string}")
    public void usuarioVeMensagemDeSucesso(String sucesso) {
        String alert = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertEquals(sucesso, alert);
    }

    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
            logger.info("Teste finalizado");
        }
    }

}
