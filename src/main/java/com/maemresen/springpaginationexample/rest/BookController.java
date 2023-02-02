package com.maemresen.springpaginationexample.rest;

import com.maemresen.springpaginationexample.entity.Book;
import com.maemresen.springpaginationexample.model.CountQueryTest;
import com.maemresen.springpaginationexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@RequestMapping("/book")
@RestController
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public CountQueryTest<Book> getBooks(@RequestParam int page, @RequestParam int size) {
        final Pageable pageable = PageRequest.of(page, size);
        Function<Function<Pageable, Page<Book>>, List<Book>> getBooks = function -> function.apply(pageable).getContent();
        return CountQueryTest.<Book>builder()
                .distinctWithoutCustomCountQuery(getBooks.apply(bookRepository::getDistinctWithoutCustomCountQuery))
                .withoutCustomCountQuery(getBooks.apply(bookRepository::getWithoutCustomCountQuery))
                .withCustomCountQuery(getBooks.apply(bookRepository::getWithCustomCountQuery))
                .build();
    }
}
