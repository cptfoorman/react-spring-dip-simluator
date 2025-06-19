# DIPcom-simulator

Simulátor pro demonstrační nebo testovací účely, postavený na Spring Boot a běžící v Docker prostředí.

## Použité technologie

- **Java 21** – běhové prostředí
- **Gradle 8.13** – běhové prostředí
- **Spring Boot** – backend aplikace
- **PostgreSQL** – relační databáze
- **Redis** – cache/message broker
- **Docker & Docker Compose** – orchestrace běhového prostředí

## Spuštění projektu

> Předpoklady: nainstalovaný Docker a Docker Compose

```bash
docker-compose up --build
```

#Filip Říha
přidána logika dle zadání
-testováno pomocí aplikace Postman -> bohužel mi Postman nechce exportovat danou kolekci testů
-proto zde jsou http linky pro testování:
-seckce GET
-books with filters
http://localhost:8080/api/books?title=spiritual&type=text&language=english&mimeType=application%2Fpdf&accessRestricted=false&dateFrom=1854-01-01T00%3A00%3A00&dateTo=1854-12-31T23%3A59%3A59&page=0&size=10&sort=title,asc
-all books no filters
http://localhost:8080/api/books
-book by numericalId
http://localhost:8080/api/book/1
-sekce POST
-add 1 book
http://localhost:8080/api/book/new
-add metadata books
http://localhost:8080/api/import
-sekce DELETE
-book by numericalId
http://localhost:8080/api/book/delete/1
-sekce PUT
-book by numericalId
http://localhost:8080/api/book/edit/2
---------------------POZOR---------------------------
pro testovací účely jsem nastavil databazi na spring.jpa.hibernate.ddl-auto=create-drop
pokud máte stejnojmenou databázi nerad bych byl zodpovědný za její vymazání

budu rád za jakékoli návrhy na zlepšení chodu (zvlášť u parsování JSON dat ze souboru :D)
děkuji za záminku se naučit gradle, postgresql a redis v rámci dvou týdnů - byla to bezvadná zkušensot :)