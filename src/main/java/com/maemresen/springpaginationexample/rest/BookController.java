package com.maemresen.springpaginationexample.rest;

import com.maemresen.springpaginationexample.entity.Book;
import com.maemresen.springpaginationexample.model.CountQueryTest;
import com.maemresen.springpaginationexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/book")
@RestController
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public CountQueryTest<Book> getBooks(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return CountQueryTest.<Book>builder()
                .withoutCustomCountQuery(bookRepository.getWithoutCustomCountQuery(pageable).getContent())
                .withCustomCountQuery(bookRepository.getWithCustomCountQuery(pageable).getContent())
                .build();
    }
}
