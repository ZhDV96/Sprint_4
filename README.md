Финальный проект четвертого спринта 
====
## Описание проекта
Финальный проект 4 спринта курса "Автоматизатор тестирования на Java" предназначен для изучения CI/CD-инструмента Jenkins. Проект представляет собой небольшой фрагмент кода для валидации данных держателя карты, автотестов, проверяющих корректность работы валидации; после локального разворачивания Jenkins выполняется автоматическая сборка и прогон тестов. 

## Перед началом работы
Необходимо, чтобы были уставновлены:  
•	IntelliJ IDEA + Maven  
•	Docker desktop   
•	Git Bash  
### Переключитесь на ветку develop.
### Развернуть Jenkins внутри докер-контейнера
1.	Перейдите в репозиторий с заготовкой кода: https://github.com/ZhDV96/Sprint_4
2.	Нажмите кнопку Fork для клонирования репозитория— она на панели справа и сверху. Появится выпадающий список. Выберите свой аккаунт на GitHub.
3.	Откройте терминал(Git Bash) и перейдите в папку проекта, которую удалось создать на компьютере. Для этого понадобится команда cd.
4.	Используя команду git clone git@github.com:username/Sprint_4.git в терминале, скачайте себе данный репозиторий. Укажите имя своего аккаунта на GitHub вместо username.
5.	Чтобы развернуть Jenkins, нужно создать файл docker-compose.yml , его можно создать в текстовом редакторе, сохранив его в любой папке с расширением yml следующий текст:
version: '3.7' # версия описания docker-compose.yml
services: # описание сервисов, которые развернутся при запуске файла
  jenkins: # развернётся Jenkins
    image: jenkins/jenkins:lts # образ, который скачается для установки Jenkins
    privileged: true
    user: root
    ports: # порты, которые использует сервис
      - 8081:8080 # В контейнере Jenkins развернётся на порте 8080,
                  # но на локальной машине этот порт часто занят, 
                  # поэтому порт 8080 контейнера связывается
                  # с портом 8081 на локальной машине. 
                  # Получится адрес localhost:8081
    container_name: jenkins # имя контейнера: оно может быть любым
6.	В командной строке перейдите в эту папку и выполните команду:
docker-compose up
7.	Чтобы настроить Jenkins, понадобится пароль. Откройте новую вкладку в терминале и выполните команду:
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
### Настройка Jenkins
1.	Доступ к нему можно получить по адресу http://localhost:8081/. Если доступа нет, откройте страницу в режиме инкогнито. Чтобы настроить Jenkins, понадобится пароль, полученный с помощью команды в предыдущем шаге инструкции.
2.	На следующем экране выберите Install suggested plugins. Подождите, пока установятся плагины.
3.	Введите свои данные и кликни Save and Continue. Можно не заполнять эту форму: кликнуть Skip and continue as admin.
4.	На следующем экране нажмите Save and Finish. Затем нажмите Start using Jenkins.
### Создание задачи в Jenkins
#### После открытия Jenkins:
1.	В появившемся окне нажмите «Настроить Jenkins».
2.	Выберите «Конфигурация глобальных инструментов».
3.	Найдите кнопку «Добавить Maven». Нажмите на неё и заполните поле «Имя» любым значением. Нажмите Save.
4.	Нажмите «Создать Item».
5.	Введите имя задачи, выберите «Создать задачу со свободной конфигурацией» и нажмите OK.
6.	Найдите пункт «Управление исходным кодом». Заполните поле Repository URL: нужно вставить ссылку на склонированный ранее репозиторий с тестами и файлом pom.xml. В блоке Credentials нажмите Add → Jenkins. Впишите свой логин и пароль от GitHub и нажмите Add.
7.	Выберите свой логин и пароль в выпадающем списке.
8.	Прокрутите вниз до пункта «Сборка». Нажмите «Добавить шаг сборки». В выпадающем списке выберите «Вызвать цели Maven верхнего уровня».
9.	В поле «Версия Maven» выберите название из пункта 3. В «Цели» напишите test: тогда при каждой сборке проекта будут запускаться все тесты. Нажмите «Сохранить».
10.	На следующем экране нажмите «Собрать сейчас».
Когда сборка закончится, должна появиться зелёная галочка: это значит, что всё прошло успешно.
### Отчёт с Allure
#### Чтобы интегрировать Allure в Jenkins, нужно установить плагин.
1.	С главной страницы перейдите к пункту «Настроить Jenkins» и выберите пункт «Управление плагинами».
2.	Переключитесь на вкладку «Доступные», найдите плагин Allure через поле поиска, выберите его и нажмите Install without restart. Напротив плагина должна появится зелёная галочка.
3.	Нажмите «Настроить Jenkins» и выберите пункт «Конфигурация глобальных инструментов». 
4.	Найдите блок Allure Commandline и нажмите «Добавить Allure Commandline».
5.	Введите имя, выберите версию и сохраните конфигурацию.
6.	Откройте задачу и перейдите к настройкам.
7.	Перейдите к разделу «Послесборочные операции». Удалите шаг Publish JUnit test result report. Нажмите «Добавить шаг после сборки» и выберите Allure Report.
8.	Укажите путь, куда попадут файлы отчёта после сборки проекта. Плагин найдёт их в этой папке после сборки и создаст отчёт.
9.	Нажмите кнопку «Собрать сейчас». Дождитесь, пока завершится сборка, и перейдите к отчёту.


