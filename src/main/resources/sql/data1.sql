
-- --------------------------------------------------------
INSERT INTO `type_product` (`id`, `created`, `updated`, `visible`, `type`) VALUES (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'pizza');
INSERT INTO `type_product` (`id`, `created`, `updated`, `visible`, `type`) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'snacks');
INSERT INTO `type_product` (`id`, `created`, `updated`, `visible`, `type`) VALUES (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'drinks');
--
-- Структура таблицы `addition`
--
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Бургер\"', 'бургер.png', 200, 300,  '25');
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Бургер\"', 'бургер.png', 270, 420,  '30');
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Бургер\"', 'бургер.png', 360, 650,  '45');
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Креветки\"', 'креветки.png', 150, 450,  '30');
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Сирна\"', 'сырная.png', 320, 550,  '45');
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (6, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 3, 'Cola 0.5', 'cola.png', 80, 500,  NULL);
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (7, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  1, 'Піца \"Пепероні\"', 'пеперони.png', 320, 250,  NULL);
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (8, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 'Піца \"Курча BBQ\"', 'цыпленок.png', 550, 450,  NULL);
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (9, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 3, 'Вода 0.5', 'вода.png', 75, 500,   NULL);
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES (10, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2, 'Паста з сиром', 'паста.png', 200, 350,  NULL);
INSERT INTO `product` (`id`, `created`, `updated`, `visible`,  `productType_id`,  `name`, `picture`, `price`, `weight`, `size`) VALUES  (11, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2, 'Картопля фрі', 'фри.png', 120, 100,   NULL);

-- --------------------------------------------------------

--
-- Дамп данных таблицы `addition`
--

INSERT INTO `addition` VALUES (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Сирні бортики', '../сам_введёшь/', 120);
INSERT INTO `addition` VALUES (2,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  'Додаткова порція мяса',  '../сам_введёшь/', 100);
INSERT INTO `addition` VALUES (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Гострий перець халапеньо',  '../сам_введёшь/',50);


INSERT INTO `users` (`id`, `created`, `updated`, `visible`,`enabled`,  `role`, `first_name`, `last_name`, `birth_day`, `email`, `password`, `DTYPE`) VALUES (1,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  true, 'ROLE_ADMIN', 'Іван', 'Корнієнко',CURRENT_TIMESTAMP(), 'ivankor839@gmail.com', '$2a$10$QF4NuVRrnhm.6wZGGYBek.gxfqwU4LWkZ639plzaTOUdgFdH1IINi', 'ADMIN' );
INSERT INTO `users` (`id`, `created`, `updated`, `visible`, `enabled`,`role`, `first_name`, `last_name`, `birth_day`, `email`, `password`, `DTYPE`) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  true, 'ROLE_PERSONAL', 'Леонід', 'Парсай-Салехі', CURRENT_TIMESTAMP(), 'leonkiller@gmail.com', '$2a$10$QF4NuVRrnhm.6wZGGYBek.gxfqwU4LWkZ639plzaTOUdgFdH1IINi','PERSONAL');
INSERT INTO `users` (`id`, `created`, `updated`, `visible`, `enabled`, `role`, `first_name`, `last_name`, `birth_day`, `email`, `password`, `DTYPE`) VALUES (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  true, 'ROLE_PERSONAL', 'Владислав', 'Гончаров', CURRENT_TIMESTAMP() , 'test@ukr.ua', '123', 'PERSONAL');
INSERT INTO `users` (`id`, `created`, `updated`, `visible`, `enabled`, `role`, `first_name`, `last_name`,`birth_day`, `email`, `password`, `DTYPE`) VALUES (4,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true,  true,  'ROLE_ADMIN', 'admin', 'admin', null, 'admin', 'admin','ADMIN');

insert into `card` (id, created, updated, visible, personal_id, quantity) values (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1 , 3);
insert into `card` (id, created, updated, visible, personal_id, quantity) values (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1 , 3);
insert into `card` (id, created, updated, visible, personal_id, quantity) values (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2 , 4);
insert into `card` (id, created, updated, visible, personal_id, quantity) values (4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2 , 4);

--
-- Дамп данных таблицы `ordered`
--

INSERT INTO `ordered` (`id`, `created`, `updated`, `visible`, `adress`, `personal_id`,`card_id`,`admin_id`, `isPaied`, `active`) VALUES  (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Улица 1', 1, 1, 1, true,'В процессе');
INSERT INTO `ordered` (`id`, `created`, `updated`, `visible`, `adress`, `personal_id`, `card_id`, `admin_id`, `isPaied`, `active`) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Улица 2', 1, 2,  1, false, 'В процессе');
INSERT INTO `ordered` (`id`, `created`, `updated`, `visible`, `adress`, `personal_id`, `card_id`, `admin_id`, `isPaied`, `active`) VALUES (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Улица 4', 2, 3, 1, true, 'В процессе');
INSERT INTO `ordered` (`id`, `created`, `updated`, `visible`, `adress`, `personal_id`, `card_id`, `admin_id`, `isPaied`, `active`) VALUES (4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Улица 5', 2, 4, 1, false, 'В процессе');


INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`, `product_id`, `addition_id`, `quantity`) VALUES (1,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 1, 1, 1);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`, `product_id`, `addition_id`,`quantity` ) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 2, NULL, 1);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`, `product_id`, `addition_id`, `quantity`) VALUES (3,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 1, 5, NULL, 1);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`,`card_id`, `product_id`, `addition_id`, `quantity`) VALUES  (4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2, 1, NULL,2 );
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`, `product_id`, `addition_id`, `quantity`) VALUES (5, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 2, 1, 2, 1);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`,  `product_id`, `addition_id`, `quantity`) VALUES  (6, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 3, 1, NULL, 3);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`,  `product_id`, `addition_id`, `quantity`) VALUES (7, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 3, 2, NULL, 1);
INSERT INTO `card_product_addition` (`id`, `created`, `updated`, `visible`, `card_id`,  `product_id`, `addition_id`, `quantity`) VALUES (8, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 4, 1, NULL, 4);


-- --------------------------------------------------------

INSERT INTO `news` (`id`, `created`, `updated`, `visible`, `name`, `description`, `picture`) VALUES (1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, 'Лучшая новость за последнюю тисячу лет!!', 'НОВИНКА', 'слайдер1.webp');
INSERT INTO `news` (`id`, `created`, `updated`, `visible`, `name`, `description`, `picture`) VALUES (2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, '', '', 'слайдер2.webp');
INSERT INTO `news` (`id`, `created`, `updated`, `visible`, `name`, `description`, `picture`) VALUES  (3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, '', 'Скоро кінець акції', 'слайдер3.webp');
INSERT INTO `news` (`id`, `created`, `updated`, `visible`, `name`, `description`, `picture`) VALUES (4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true, '', 'По суботам', 'слайдер4.webp');

-- Дамп данных таблицы `users`
--
