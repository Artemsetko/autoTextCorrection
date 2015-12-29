# autoTextCorrection
autoTextCorrection mechanism
Запустить проект можно открыв у себя в среде разработки.
Я использовал Intellij Idea. Проект собирается Maven’ом. Можно просто запустить главный класс Application.java, либо в терминале прописать mvn spring-boot:run. 
В проекте использованы post запросы, поэтому нужен сервис чтоб их отправлять. Я использовал Postman от гугл.
http://localhost:8080/corrected и в теле запроса вводим текст с ошибками. Исправляет только те опечатки, которые есть по ссылке: https://en.wikipedia.org/wiki/Wikipedia:Lists_of_common_misspellings/For_machines
В проекте эти варианты представлены в файле misp.txt. Скриншоты работы приведены ниже:
