# back_end_task
Задача для бек енд.
Для тестирования api создал bootstrap c помощью javafaker в классе DataLoder.

Для работы приложения нужно создать базу back_end_task  c user: postgres password: postgres или изменить настройки.

Описание api.

Все end points находятся здесь:
1) Добавление нового клиента
   http://localhost:8080/api/addClient
   Добавление нового клиента с email
   http://localhost:8080/api/addClient/withEmail
   Добавление нового клиента с phone number
   http://localhost:8080/api/addClient/withPhoneNumber
2) Добавление нового контакта клиента (телефон или email)
   http://localhost:8080/api/addContact/email
   http://localhost:8080/api/addContact/phone_number
3) Получение списка клиентов
   http://localhost:8080/api/allClients
4) Получение информации по заданному клиенту (по id)
   http://localhost:8080/api/findByID/{id}
5) Получение списка контактов заданного клиента
   http://localhost:8080/api/contacts/{id}
6) Получение списка контактов заданного типа заданного клиента
   http://localhost:8080/api/Emails/{id}
   http://localhost:8080/api/phone_numbers/{id}

http://localhost:8080/swagger-ui/