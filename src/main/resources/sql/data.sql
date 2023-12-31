-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Июл 07 2022 г., 01:51
-- Версия сервера: 8.0.29
-- Версия PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `pizzav2`
--

-- --------------------------------------------------------

--
-- Структура таблицы `addition`
--

CREATE TABLE `addition` (
                            `id` int NOT NULL,
                            `name` varchar(50) NOT NULL,
                            `price` int NOT NULL,
                            `picture` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `addition`
--

INSERT INTO `addition` (`id`, `name`, `price`, `picture`) VALUES
                                                                       (1, 'Сырные бортики', 120, '../сам_введёшь/'),
                                                                       (2, 'Дополнительная порция мяса', 100, '../сам_введёшь/'),
                                                                       (3, 'Острый перец халапеньо', 50, '../сам_введёшь/');

-- --------------------------------------------------------

--
-- Структура таблицы `cart`
--

CREATE TABLE `cart` (
                        `id_cart` int NOT NULL,
                        `id_order` int DEFAULT NULL,
                        `amount` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `cart`
--

INSERT INTO `cart` (`id_cart`, `id_order`, `amount`) VALUES
                                                         (46, 49, 4),
                                                         (47, 50, 3),
                                                         (48, 51, 4),
                                                         (49, 52, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `cart_product`
--

CREATE TABLE `cart_product` (
                                `id_cart_product` int NOT NULL,
                                `id_cart` int DEFAULT NULL,
                                `id_product` int DEFAULT NULL,
                                `id_addition` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `cart_product`
--

INSERT INTO `cart_product` (`id_cart_product`, `id_cart`, `id_product`, `id_addition`) VALUES
                                                                                           (110, 46, 1, NULL),
                                                                                           (111, 46, 2, NULL),
                                                                                           (112, 46, 3, NULL),
                                                                                           (113, 46, 5, NULL),
                                                                                           (114, 47, 1, NULL),
                                                                                           (115, 47, 1, NULL),
                                                                                           (116, 47, 1, NULL),
                                                                                           (117, 48, 1, NULL),
                                                                                           (118, 48, 1, NULL),
                                                                                           (119, 48, 1, NULL),
                                                                                           (120, 48, 2, NULL),
                                                                                           (121, 49, 1, NULL),
                                                                                           (122, 49, 1, NULL),
                                                                                           (123, 49, 1, NULL),
                                                                                           (124, 49, 1, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `news`
--

CREATE TABLE `news` (
                        `id_news` int NOT NULL,
                        `name` varchar(100) NOT NULL,
                        `description` varchar(1000) NOT NULL,
                        `picture` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `news`
--

INSERT INTO `news` (`id_news`, `name`, `description`, `picture`) VALUES
                                                                     (1, 'Лучшая новость за последнюю тисячу лет!!', 'НОВИНКА', 'слайдер1.webp'),
                                                                     (2, '', '', 'слайдер2.webp'),
                                                                     (3, '', 'Скоро конец акции', 'слайдер3.webp'),
                                                                     (4, '', 'По субботам', 'слайдер4.webp');

-- --------------------------------------------------------

--
-- Структура таблицы `ordered`
--

CREATE TABLE `ordered` (
                           `id_order` int NOT NULL,
                           `order_date` datetime NOT NULL,
                           `adress` varchar(50) NOT NULL,
                           `id_user` int DEFAULT NULL,
                           `isPaied` tinyint(1) NOT NULL,
                           `active` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `ordered`
--

INSERT INTO `ordered` (`id_order`, `order_date`, `adress`, `id_user`, `isPaied`, `active`) VALUES
                                                                                               (49, '2022-07-07 00:00:00', 'Улица 1', 12, 1, 'В процессе'),
                                                                                               (50, '2022-07-07 00:00:00', 'Улица 2', 12, 1, 'В процессе'),
                                                                                               (51, '2022-07-07 00:00:00', 'Улица 4', 12, 1, 'В процессе'),
                                                                                               (52, '2022-07-07 01:49:51', 'Улица 5', 12, 1, 'В процессе');

-- --------------------------------------------------------

--
-- Структура таблицы `product`
--

CREATE TABLE `product` (
                           `id` int NOT NULL,
                           `id_type_product` int DEFAULT NULL,
                           `name` varchar(50) NOT NULL,
                           `price` int NOT NULL,
                           `weight` int DEFAULT NULL,
                           `availability` tinyint(1) NOT NULL,
                           `picture` varchar(150) NOT NULL,
                           `size` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `product`
--

INSERT INTO `product` (id, `id_type_product`, `name`, `price`, `weight`, `availability`, `picture`, `size`) VALUES
                                                                                                                          (1, 1, 'Пицца \"Бургер\"', 200, 300, 1, 'бургер.png', 'small'),
                                                                                                                          (2, 1, 'Пицца \"Креветки\"', 150, 450, 1, 'креветки.png', 'medium'),
                                                                                                                          (3, 1, 'Пицца \"Сирная\"', 320, 550, 1, 'сырная.png', 'big'),
                                                                                                                          (4, 3, 'Pepsi 0.5', 80, 500, 1, 'cola.png', NULL),
                                                                                                                          (5, 1, 'Пицца \"Пэпер0ни\"', 320, 250, 1, 'пеперони.png', NULL),
                                                                                                                          (6, 1, 'Пицца \"Цыпленок Ранч\"', 550, 450, 0, 'цыпленок.png', NULL),
                                                                                                                          (7, 3, 'Вода 0.5', 75, 500, 1, 'вода.png', NULL),
                                                                                                                          (8, 2, 'Паста с сыром', 200, 350, 1, 'паста.png', NULL),
                                                                                                                          (9, 2, 'Картофель фриии', 120, 100, 1, 'фри.png', NULL);

-- --------------------------------------------------------


--
-- Структура таблицы `type_product`
--

CREATE TABLE `type_product` (
                                `id` int NOT NULL,
                                `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `type_product`
--

INSERT INTO `type_product` (id, `type`) VALUES
                                                           (1, 'pizza'),
                                                           (2, 'snacks'),
                                                           (3, 'drinks');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
                         `id_user` int NOT NULL,
                         `role` varchar(100) NOT NULL,
                         `name` varchar(100) NOT NULL,
                         `phone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                         `email` varchar(100) DEFAULT NULL,
                         `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id_user`, `role`, `name`, `phone`, `email`, `password`) VALUES
                                                                                     (1, 'ROLE_ADMIN', 'Иван', '+79511409876', 'ivankor839@gmail.com', '12345'),
                                                                                     (2, 'ROLE_PERSONAL', 'Леонид', '+795698675', 'leon_killer@gmail.com', 'aboba22'),
                                                                                     (12, 'ROLE_PERSONAL', 'Крутой', '', 'test@mail.ru', '123'),
                                                                                     (18, 'ROLE_PERSONAL', 'admin', '', 'admin', 'admin');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `addition`
--
ALTER TABLE `addition`
    ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `cart`
--
ALTER TABLE `cart`
    ADD PRIMARY KEY (`id_cart`),
  ADD KEY `R_6` (`id_order`);

--
-- Индексы таблицы `cart_product`
--
ALTER TABLE `cart_product`
    ADD PRIMARY KEY (`id_cart_product`),
  ADD KEY `R_9` (`id_cart`),
  ADD KEY `R_10` (`id_product`),
  ADD KEY `R_11` (`id_addition`);

--
-- Индексы таблицы `news`
--
ALTER TABLE `news`
    ADD PRIMARY KEY (`id_news`);

--
-- Индексы таблицы `ordered`
--
ALTER TABLE `ordered`
    ADD PRIMARY KEY (`id_order`),
  ADD KEY `R_5` (`id_user`);

--
-- Индексы таблицы `product`
--
ALTER TABLE `product`
    ADD PRIMARY KEY (id),
  ADD KEY `R_12` (`id_type_product`);

--
-- Индексы таблицы `type_product`
--
ALTER TABLE `type_product`
    ADD PRIMARY KEY (id);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `addition`
--
ALTER TABLE `addition`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `cart`
--
ALTER TABLE `cart`
    MODIFY `id_cart` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT для таблицы `cart_product`
--
ALTER TABLE `cart_product`
    MODIFY `id_cart_product` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT для таблицы `news`
--
ALTER TABLE `news`
    MODIFY `id_news` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `ordered`
--
ALTER TABLE `ordered`
    MODIFY `id_order` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT для таблицы `product`
--
ALTER TABLE `product`
    MODIFY id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
--
-- AUTO_INCREMENT для таблицы `type_product`
--
ALTER TABLE `type_product`
    MODIFY id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
    MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `cart`
--
ALTER TABLE `cart`
    ADD CONSTRAINT `R_6` FOREIGN KEY (`id_order`) REFERENCES `ordered` (`id_order`);

--
-- Ограничения внешнего ключа таблицы `cart_product`
--
ALTER TABLE `cart_product`
    ADD CONSTRAINT `R_10` FOREIGN KEY (`id_product`) REFERENCES `product` (id),
  ADD CONSTRAINT `R_11` FOREIGN KEY (`id_addition`) REFERENCES `addition` (`id`),
  ADD CONSTRAINT `R_9` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id_cart`);

--
-- Ограничения внешнего ключа таблицы `ordered`
--
ALTER TABLE `ordered`
    ADD CONSTRAINT `R_5` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Ограничения внешнего ключа таблицы `product`
--
ALTER TABLE `product`
    ADD CONSTRAINT `R_12` FOREIGN KEY (`id_type_product`) REFERENCES `type_product` (id);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
