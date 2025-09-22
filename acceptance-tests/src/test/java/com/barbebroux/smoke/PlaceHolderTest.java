package com.barbebroux.smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = com.barbebroux.bikereservationsystem.BikeReservationSystemApplication.class
)
public class PlaceHolderTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // Automatically download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome");
        options.addArguments("--headless=new"); // headless for CI/local
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void placeholderTest() {
        String base = "http://localhost:" + port; // connect to your Spring Boot app
        driver.get(base + "/");

        // Example: check the page contains expected text
        WebElement body = driver.findElement(By.tagName("body"));
        assertThat(body.getText().contains("Available Bikes")).isTrue();
    }
}
