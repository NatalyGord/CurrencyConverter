# Инструкция по запуску сервиса.

## 1. Для работы сервиса перед запуском необходимо создать новую базу PostgreSQL с именем CurrencyConverter(возможно поменять имя базы данных в файле application.properties)
## 2. Если пункт 1 выполнен, то после запуска автоматически создастся таблица в БД.
## 3. Доступные действия:
###  Запросы на http://localhost:8080/graphql
###  -  Получить все данные из таблицы курсов валют(возвращает список объектов ExchangeRate):
query{
allExchangeRate{name,value}
}
###  - Получить все данные из таблицы конвертаций(возвращает список объектов Conversion):
query{
allConversion{convDate, nameVal1,nameVal2,curs}
}
###  - Получить все данные из таблицы конвертаций с лимитом 10шт.(возвращает список объектов Conversion):
query{
allConversionLimit10{convDate, nameVal1,nameVal2,curs}
}
### - Расчет конвертаций и их запись в БД(возвращает double - получившуюся сумму валюты)
mutation{
createConversion(nameVal1:"Доллар США", nameVal2:"Российский рубль", sumVal1:1000)
}
### -  Парсинг данных с сайта http://www.cbr.ru/scripts/XML_daily.asp и запись курсов валют в БД(возвращает список объектов ExchangeRate за последнюю дату)
mutation{
createExchangeRates{date, nominal, name, value}
}
### -  Получение среднего курса обмена валют(возвращает double - средний курс обмена выбраных валют)
query{
 middleRate(nameVal1:"Доллар США",nameVal2:"Российский рубль")
}