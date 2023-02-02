# Introduction;
When you want to apply pagination with using Spring Data, you could define a method in your repository something as follows;

````java
public interface ...extends JpaRepository<...>{

    // method 1
    Page<...>findSomeTastyData(...);

    // method 2 with using HQL
    @Query("HQL to fetch data")    
    Page<...>findSomeTastyData(...);

    // method 3: you could also use some custom count query 
    @Query(
        value = "HQL to fetch data"
        countQuery = "HQL to count data"
    )    
    Page<...>findSomeTastyData(...);

}
````

# Problem
Let's assume we have two entity as follows;
- Book [see](./src/main/java/com/maemresen/springpaginationexample/entity/Book.java) 
- Chapter [see](./src/main/java/com/maemresen/springpaginationexample/entity/Chapter.java) 

**Where** one book having many chapters.\
So there are `OneToMany` relation between `Book` and `Chapter` entities.

Now, again, assume that we need to query book as following
We will have a query something as follows;

````java
public interface BookRepository<Book> extends JpaRepository<Book, Long> {

  @Query("SELECT b FROM Book b LEFT JOIN b.chapters WHERE ....")
  Page<Book> getBooks(Pageable pageable);
}
````

But what happens if we do something like this;

````java
public interface BookRepository<Book> extends JpaRepository<Book, Long> {

  @Query(
      value = "SELECT b FROM Book b LEFT JOIN b.chapters WHERE ....",
      countQuery = "SELECT b FROM Book b"
  )
  Page<Book> getBooks(Pageable pageable);
}
````

As you can see, query contains `LEFT JOIN` where count query not.

# Testing
After clone and build application, check the following API
### API
- **URI:** `/book`
- **Params:**
  - page: page number (index based, starts from 0)
  - size: page size

Example API call to get first page with size 1;
```
http://localhost:8080/book?page=0&size=1
```