# CompletedTask
Автоматизированные тесты для gmail

Тест-кейс Gmail: https://docs.google.com/spreadsheets/d/1BlF22uBML9SCyiA6_s2TserfyiUWegFJj1dii6i9ykk/edit?usp=sharing

 Шаги, для запуска тестов:
  1. Разархивировать проект "ProjectTestGmail" в любое удобное место.
  2. Запустить IntelliJ IDEA Community Edition. 
  3. Открыть проект "ProjectTestGmail" 
  4. Подгрузить библиотеку Selenium в файле "pom.xml"
  5. Запустить тесты в порядке очередности, тесты расположены по пути: (ProjectTestGmail\src\main\java\TestGmail)
 
 Описание тестов:
  1. TestTask_1 - авторизация в gmail.
  2. TestTask_2 - отправка письма.
  3. TestTask_3 - проверка отправленного письма.
  4. TestTask_4 - создание подписи и отправка письма с подписью.
  5. TestTask_5 - проверка отправленного письма с подписью.
  
 Версии всех инструментов для создания тестов:
   1. IntelliJ IDEA Community Edition 2023.1
   2. Библиотека Selenium-java 4.8.0 
   3. ChromeDriver 111.0.5563.64
   4. Google Chrome 111.0.5563.147
   
 Возникшие сложности при написании тестов:
   1. При запуске каждого теста будет проходить авторизация.
   2. Не удалось создать cookie для пропуска модуля авторизации.
