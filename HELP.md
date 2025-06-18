# Getting Started

Приложение реализовано с использованием spring-boot

Подключение БД с помощью следующих параметров:
    spring.datasource.url=jdbc:postgresql://localhost:5432/flights
    spring.datasource.username=student
    spring.datasource.password=chocolatefrog

Эндпойнты для запуска операций:
    http://localhost:8080/flights/init      Инициализация проекта с помощью FlightBuilder
    http://localhost:8080/flights/printall  Вывод всех перелётов без учёта условий
    http://localhost:8080/flights/filter1   Вывод перелётов, соответствующих первому заданному фильтру
    http://localhost:8080/flights/filter2   Вывод перелётов, соответствующих второму заданному фильтру
    http://localhost:8080/flights/filter3   Вывод перелётов, соответствующих третьему заданному фильтру