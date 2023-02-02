package com.maemresen.springpaginationexample.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CountQueryTest<T> {

    private List<T> distinctWithoutCustomCountQuery;
    private List<T> withoutCustomCountQuery;
    private List<T> withCustomCountQuery;
}
