#language: ru

@all @costs
Функционал: Расходы

  @FinalTask_Test_1
  Структура сценария: Поиск видеокарты. Функционал фильтров [цена, производитель, наименование]
    * Открываем стартовую страницу сайта 'Регард'
    * Нажимаем на кнопку 'Каталог'
    * Проверяем, что страница 'Каталог' открыта
    * Выбираем категорию товаров <mainCategory>
    * Выбираем подкатегорию товаров <subCategory>
    * Проверить, что открыта страница подкатегории товаров <subCategory>
    * Заполняем поля формы:
      | Цена от       | <price>        |
      | Производитель | <manufacturer> |
    * Проверяем, что список товаров на странице обновился
    * Проверяем, что на странице отображается 24 товара
    * Сохранить название товара под номером 2 во временную переменную
    * Заполняем поле Поиск значением сохраненным ранее
    * Ожидаем таймаут 2 секунд
    * Проверяем, что на странице отображается 1 товар
    * Сравнить название товара под номером 1 с сохраненным
    Примеры:
      | mainCategory         | subCategory | price | manufacturer |
      | Комплектующие для ПК | Видеокарты  | 20000 | Gigabyte     |

  @FinalTask_Test_2
  Структура сценария: Поиск клавиатуры. Функционал фильтров [цена, производитель, наименование]
    * Открываем стартовую страницу сайта 'Регард'
    * Нажимаем на кнопку 'Каталог'
    * Проверяем, что страница 'Каталог' открыта
    * Выбираем категорию товаров <mainCategory>
    * Выбираем подкатегорию товаров <subCategory>
    * Проверить, что открыта страница подкатегории товаров <subCategory>
    * Заполняем поля формы:
      | Цена от       | <price>        |
      | Производитель | <manufacturer> |
    * Проверяем, что список товаров на странице обновился
    * Проверяем, что на странице отображается 24 товара
    * Сохранить название товара под номером 2 во временную переменную
    * Заполняем поле Поиск значением сохраненным ранее
    * Ожидаем таймаут 2 секунд
    * Проверяем, что на странице отображается 1 товар
    * Сравнить название товара под номером 1 с сохраненным
    Примеры:
      | mainCategory | subCategory | price | manufacturer |
      | Периферия    | Клавиатуры  | 2000  | A4Tech       |
