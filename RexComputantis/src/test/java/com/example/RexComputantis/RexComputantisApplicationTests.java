package com.example.RexComputantis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Nested
@DisplayName("Прикладные тесты RexComputantis")
public class RexComputantisApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    @DisplayName("Должен вернуться Hello World")
    void thenReturnHelloWorld() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello World");
    }

    @Test
    @DisplayName("Должен вернуть приветствие с указанным именем")
    public void whenNameParameterIsProvided_thenReturnHelloName() {

        ResponseEntity<String> response = restTemplate.getForEntity("/hello?name=John", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello John");
    }

    @DisplayName("Палиндромные тесты")
    public boolean isPalindrome(String str) {

        return true;
    }

    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @ValueSource(strings = {"John", "Max", "Erena", "Vlad", "Nazar"})
    @DisplayName("Проверьте, является ли слово палиндромом")
    void testPalindrome(String word) {
        assertTrue(isPalindrome(word));

    }
}