package org.arunm.aws.appforfun.web

import io.restassured.RestAssured
import io.restassured.response.Response
import org.arunm.aws.appforfun.AppforfunApplication
import org.arunm.aws.appforfun.persistence.Book
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric
import static org.junit.Assert.assertEquals

@RunWith(SpringRunner.class)
@SpringBootTest(classes = [ AppforfunApplication ], webEnvironment
        = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LiveTest {

    private static final String API_ROOT = "http://localhost:8081/api/books"

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    void whenGetAllBooks_thenOK() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    void whenGetCreatedBookById_thenOK() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(book.getTitle(), response.jsonPath()
                .get("title"));
    }


    @Test
    public void whenCreateNewBook_thenCreated() {
        Book book = createRandomBook();
        Response response = RestAssured.given()
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .body(book)
        .post(API_ROOT);

            assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());

    }
    @Test
    void whenGetNotExistBookById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}