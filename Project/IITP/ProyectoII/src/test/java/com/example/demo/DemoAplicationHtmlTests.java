package com.example.demo;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DemoAplicationHtmlTests {

        @Test
        public void homePage_Firefox() throws Exception {

            String uri = "http://localhost:8082/";
            try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                final HtmlPage page = webClient.getPage(uri);
                assertEquals("Venta", page.getTitleText());
            }
        }

        @Test
        public void homePage_Chrome() throws Exception {
            String uri = "http://localhost:8082/";
            try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                final HtmlPage page = webClient.getPage(uri);
                assertEquals("Venta", page.getTitleText());
            }
        }

        @Test
        public void fillLoginCliente() throws Exception {
            String uri = "http://localhost:8082/loginView";
            try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                final HtmlPage page = webClient.getPage(uri);
                final HtmlTextInput usernameField = (HtmlTextInput) page.getElementById("login");
                final HtmlTextInput passwordField = (HtmlTextInput) page.getElementById("password");
                usernameField.setValueAttribute("208220979");
                passwordField.setValueAttribute("jp123");

                final HtmlPage page2 = page.getElementById("loginButton").click();

                // Hizo el logIn de manera correcta
                assertEquals("Vista Cliente", page2.getTitleText());
            }
        }

    @Test
    public void fillLogInWithBadPassword() throws Exception {
        String uri = "http://localhost:8082/loginView";
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            final HtmlPage page = webClient.getPage(uri);
            final HtmlTextInput usernameField = (HtmlTextInput) page.getElementById("login");
            final HtmlTextInput passwordField = (HtmlTextInput) page.getElementById("password");
            usernameField.setValueAttribute("208220979");
            passwordField.setValueAttribute("1234");

            final HtmlPage page2 = page.getElementById("loginButton").click();

            // Hizo el logIn de manera correcta
            assertNotEquals("Vista Cliente", page2.getTitleText());

            // Quiere decir que no avanzo a la vista del cliente
            assertEquals("", page2.getTitleText());
        }
    }


    @Test
    public void fillLogInAdmin() throws Exception {
        String uri = "http://localhost:8082/loginView";
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            final HtmlPage page = webClient.getPage(uri);
            final HtmlTextInput usernameField = (HtmlTextInput) page.getElementById("login");
            final HtmlTextInput passwordField = (HtmlTextInput) page.getElementById("password");
            usernameField.setValueAttribute("208400222");
            passwordField.setValueAttribute("oscar123");

            final HtmlPage page2 = page.getElementById("loginButton").click();

            // Está entrando en la vista de cliente (No debería)
            assertNotEquals("Vista Cliente", page2.getTitleText());

            // Quiere decir que entró en la vista de admin
            assertEquals("Vista Administrador", page2.getTitleText());
        }
    }

    @Test
    public void fillSearchCliente() throws Exception {
        String uri = "http://localhost:8082/get_cliente";
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            final HtmlPage page = webClient.getPage(uri);
            final HtmlInput usernameField = (HtmlInput) page.getElementById("fname");
            usernameField.setValueAttribute("209800222");

            final HtmlPage page2 = page.getElementById("sendButton").click();

            // Encontró el cliente y listó sus datos
            assertEquals ("Facturas", page2.getTitleText());
        }
    }


}
