package com.example.mybookcatal;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookModelTest {
    @Test
    public void testBookCreation() {
        Book book = new Book("Test Title", "Test Author", "Test Genre", "Test Description");
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("Test Genre", book.getGenre());
        assertEquals("Test Description", book.getDescription());
    }
}
