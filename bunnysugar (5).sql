-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2024-09-16 08:42:02
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `bunnysugar`
--

-- --------------------------------------------------------

--
-- 資料表結構 `cart`
--

CREATE TABLE `cart` (
  `id` int(10) UNSIGNED NOT NULL COMMENT '主鍵ID',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用戶ID',
  `total` int(10) NOT NULL DEFAULT '0' COMMENT '總計',
  `create_time` datetime NOT NULL COMMENT '創建時間',
  `update_time` datetime NOT NULL COMMENT '修改時間'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='購物車表';

--
-- 傾印資料表的資料 `cart`
--

INSERT INTO `cart` (`id`, `user_id`, `total`, `create_time`, `update_time`) VALUES
(1, 5, 0, '2024-09-13 09:57:37', '2024-09-13 09:57:37'),
(2, 6, 0, '2024-09-13 11:45:26', '2024-09-13 11:45:26'),
(3, 7, 0, '2024-09-13 11:50:46', '2024-09-13 11:50:46'),
(4, 8, 0, '2024-09-13 11:52:32', '2024-09-13 11:52:32'),
(5, 9, 0, '2024-09-13 11:57:25', '2024-09-13 11:57:25'),
(6, 10, 0, '2024-09-13 14:02:43', '2024-09-13 14:02:43'),
(9, 16, 0, '2024-09-13 16:16:02', '2024-09-13 16:16:02'),
(10, 17, 0, '2024-09-16 11:06:09', '2024-09-16 11:06:09'),
(11, 18, 0, '2024-09-16 15:15:48', '2024-09-16 15:15:48'),
(12, 19, 0, '2024-09-16 15:37:27', '2024-09-16 15:37:27');

-- --------------------------------------------------------

--
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `account` varchar(1000) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `gender` int(5) NOT NULL,
  `phone` varchar(1000) NOT NULL,
  `birthday` datetime NOT NULL,
  `bunny_coin` int(10) DEFAULT NULL,
  `is_active` varchar(100) DEFAULT '0',
  `verifying_token` varchar(1000) DEFAULT NULL,
  `token_expiration_time` datetime(6) DEFAULT NULL,
  `forget_token` varchar(1000) DEFAULT NULL,
  `login_method` int(100) DEFAULT NULL,
  `google_token` varchar(1000) DEFAULT NULL,
  `facebook_token` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `game_times` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO `users` (`id`, `account`, `password`, `email`, `name`, `gender`, `phone`, `birthday`, `bunny_coin`, `is_active`, `verifying_token`, `token_expiration_time`, `forget_token`, `login_method`, `google_token`, `facebook_token`, `create_time`, `update_time`, `last_login_time`, `game_times`) VALUES
(5, 'user123', 'pass123', 'user123@example.com', 'User Name', 1, '1234567890', '1990-01-01 00:00:00', 100, 'true', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 09:57:37', '2024-09-13 09:57:37', '2024-09-13 09:57:37', 5),
(6, 'johndoe', 'password123', 'johndoe@example.com', 'John Doe', 1, '123-456-7890', '1990-01-01 00:00:00', 100, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(7, 'johndoeeee', 'password123441', 'johnd22oe@example.com', 'John Doe', 1, '123-456-7890', '1990-01-01 00:00:00', 100, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 11:50:46', '2024-09-13 11:50:46', NULL, 0),
(8, 'johndo2eeee', 'password1232441', 'johnd22o2e@example.com', 'John Doe', 1, '123-456-7890', '1990-01-01 00:00:00', 100, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 11:52:32', '2024-09-13 11:52:32', NULL, 0),
(9, 'johndo222eeee', 'passw22ord1232441', 'johnd2222o2e@example.com', 'John2 Doe', 1, '123-456-7890', '1990-01-01 00:00:00', 100, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 11:57:25', '2024-09-13 11:57:25', NULL, 0),
(10, 'johndo222eeee22', 'passwd1232441', 'johnd2222o2e@ex2ample.com', 'John2 Doe', 1, '123-456-7890', '1990-01-01 00:00:00', 100, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 14:02:43', '2024-09-13 14:02:43', NULL, 0),
(16, 'hightwo123', 'hightwo456', 'istoo1028@gmail.com', 'CHIEN-HUNG WU', 0, '123-456-7890', '1998-01-01 00:00:00', 0, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-13 16:16:02', '2024-09-13 16:16:02', NULL, 0),
(17, 'hightwo01', '313131231', 'istoo131230@gmail.com', 'Hightwo', 1, '0933333456', '2020-01-14 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-09-16 11:06:09', '2024-09-16 11:06:09', NULL, NULL),
(18, 'hightwo1105', '11051105', 'istoo164645@gmail.com', 'TestMan1', 1, '0980321124', '2009-07-13 00:00:00', NULL, '0', 'd8e71247-bede-4887-8b7b-ce4a8757e627', '2024-09-16 15:25:48.737696', NULL, NULL, NULL, NULL, '2024-09-16 15:15:48', '2024-09-16 15:15:48', NULL, NULL),
(19, 'hightwo1106', '11051105', 'istoo164635@gmail.com', 'TestMan2', 1, '0980321125', '2009-07-13 00:00:00', NULL, '1', '484d258e-8507-4ea3-9b85-7da9037dca86', '2024-09-16 20:37:27.082434', NULL, NULL, NULL, NULL, '2024-09-16 15:37:27', '2024-09-16 16:10:48', NULL, NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `wish_list`
--

CREATE TABLE `wish_list` (
  `id` int(10) UNSIGNED NOT NULL COMMENT '主鍵ID',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用戶ID',
  `cart_id` int(10) UNSIGNED NOT NULL COMMENT '購物車ID',
  `create_time` datetime NOT NULL COMMENT '創建時間',
  `update_time` datetime NOT NULL COMMENT '修改時間'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='願望清單表';

--
-- 傾印資料表的資料 `wish_list`
--

INSERT INTO `wish_list` (`id`, `user_id`, `cart_id`, `create_time`, `update_time`) VALUES
(1, 5, 1, '2024-09-13 09:57:37', '2024-09-13 09:57:37'),
(2, 10, 6, '2024-09-13 14:02:43', '2024-09-13 14:02:43'),
(5, 16, 9, '2024-09-13 16:16:02', '2024-09-13 16:16:02'),
(6, 17, 10, '2024-09-16 11:06:09', '2024-09-16 11:06:09'),
(7, 18, 11, '2024-09-16 15:15:48', '2024-09-16 15:15:48'),
(8, 19, 12, '2024-09-16 15:37:27', '2024-09-16 15:37:27');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `account` (`account`),
  ADD UNIQUE KEY `email` (`email`);

--
-- 資料表索引 `wish_list`
--
ALTER TABLE `wish_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `cart_id` (`cart_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主鍵ID', AUTO_INCREMENT=13;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `wish_list`
--
ALTER TABLE `wish_list`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主鍵ID', AUTO_INCREMENT=9;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 資料表的限制式 `wish_list`
--
ALTER TABLE `wish_list`
  ADD CONSTRAINT `wish_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `wish_list_ibfk_2` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
