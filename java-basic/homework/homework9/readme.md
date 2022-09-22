## Мини-проект "Счастливая семья" (продолжение)

Суть проекта: описание структуры семьи с учетом того, что у каждого человека есть кровные родственники, а состав семьи может со временем меняться.

## Работа с датой и временем

## Задание

Усовершенствуйте проект: Сделайте рефакторинг класса `Human` так, чтобы он работал с датой и временем.

#### Технические требования:
- Замените поле `year` на поле `birthDate` которое хранит значение Unix Millis Timestamp (тип `long`).
- Добавьте в класс `Human` метод `describeAge()`, который возвращает строку, указывающую точное количество лет, месяцев и дней жизни человека;
- Создайте конструктор для усыновленных детей описывающий имя, фамилию, дату рождения и IQ. Дата рождения передается в виде строки в формате `20/03/2016`
- Сделайте рефакторинг метода `toString()` чтобы он вместо года рождения указывал дату рождения в формате `20/03/2016`

#### Литература:
- [Period для расчета интервалов между датами](https://www.baeldung.com/java-period-duration)
- [Java 8 New Date/Time API - Часть 1](https://dan-it.gitlab.io/fs-book/java-basic/ext/ext_newDate_and_TimeAPI_part1/ext_newDate_and_TimeAPI_part1.html)
- [Java 8 New Date/Time API - Часть 4](https://dan-it.gitlab.io/fs-book/java-basic/ext/ext_newDate_and_TimeAPI_part4/ext_newDate_and_TimeAPI_part4.html)
- [Creating a LocalDate with Values in Java](https://www.baeldung.com/java-creating-localdate-with-values)
