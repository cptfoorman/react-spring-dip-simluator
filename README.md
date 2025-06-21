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
-testováno pomocí aplikace Postman -> testy jsou uloženy ve složce PostmanTestCollection
---------------------POZOR---------------------------
pro testovací účely jsem nastavil databazi na spring.jpa.hibernate.ddl-auto=create-drop
pokud máte stejnojmenou databázi nerad bych byl zodpovědný za její vymazání

budu rád za jakékoli návrhy na zlepšení chodu (zvlášť u parsování JSON dat ze souboru :D)
děkuji za záminku se naučit gradle, postgresql a redis v rámci dvou týdnů - byla to bezvadná zkušensot :)