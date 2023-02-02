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