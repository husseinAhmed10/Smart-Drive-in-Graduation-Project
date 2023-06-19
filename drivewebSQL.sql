-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 13, 2023 at 09:31 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `driveweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `available`
--

DROP TABLE IF EXISTS `available`;
CREATE TABLE IF NOT EXISTS `available` (
  `slotnum` varchar(20) NOT NULL,
  `valid` int DEFAULT NULL,
  `temp` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `available`
--

INSERT INTO `available` (`slotnum`, `valid`, `temp`) VALUES
('11', 2, 0),
('12', 1, 0),
('13', 1, 0),
('14', 2, 0),
('15', 2, 0),
('16', 1, 0),
('21', 0, 0),
('22', 1, 0),
('23', 0, 0),
('24', 0, 0),
('25', 0, 0),
('26', 0, 0),
('31', 0, 0),
('32', 0, 0),
('33', 0, 0),
('34', 0, 0),
('35', 0, 0),
('36', 0, 0),
('41', 0, 0),
('42', 0, 0),
('43', 0, 0),
('44', 0, 0),
('45', 0, 0),
('46', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
CREATE TABLE IF NOT EXISTS `basket` (
  `order_id` int NOT NULL,
  `order_content` varchar(256) NOT NULL,
  `price` int DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `bill_no` int NOT NULL AUTO_INCREMENT,
  `bill_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=MyISAM AUTO_INCREMENT=171 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_no`, `bill_date`, `phone`) VALUES
(170, '2023-06-11 23:09:36', ''),
(169, '2023-06-11 16:15:48', ''),
(168, '2023-06-11 16:09:47', ''),
(167, '2023-06-11 16:07:43', ''),
(166, '2023-06-11 16:04:16', ''),
(165, '2023-06-11 16:02:08', ''),
(164, '2023-06-11 00:15:26', ''),
(163, '2023-06-11 00:13:54', ''),
(162, '2023-06-11 00:09:02', ''),
(161, '2023-06-11 00:06:38', ''),
(160, '2023-06-10 23:57:50', ''),
(159, '2023-06-10 23:43:58', ''),
(158, '2023-06-10 23:39:49', ''),
(157, '2023-06-10 23:18:54', ''),
(156, '2023-06-10 22:50:33', ''),
(155, '2023-06-10 22:49:40', ''),
(154, '2023-06-10 22:47:49', ''),
(153, '2023-06-10 22:42:27', ''),
(66, '2023-06-08 23:14:48', ''),
(67, '2023-06-08 23:15:51', ''),
(68, '2023-06-08 23:19:14', ''),
(69, '2023-06-08 23:30:27', ''),
(70, '2023-06-08 23:31:10', ''),
(71, '2023-06-08 23:33:05', ''),
(72, '2023-06-08 23:35:27', ''),
(73, '2023-06-08 23:36:51', ''),
(74, '2023-06-08 23:44:38', ''),
(75, '2023-06-08 23:54:06', ''),
(76, '2023-06-08 23:56:57', ''),
(77, '2023-06-09 12:33:40', ''),
(78, '2023-06-09 12:35:58', ''),
(79, '2023-06-09 12:50:36', ''),
(80, '2023-06-09 12:55:25', ''),
(81, '2023-06-09 12:57:17', ''),
(82, '2023-06-09 13:31:53', ''),
(83, '2023-06-09 13:32:39', ''),
(84, '2023-06-09 13:34:33', ''),
(85, '2023-06-09 13:40:21', ''),
(86, '2023-06-09 13:48:52', ''),
(87, '2023-06-09 13:53:26', ''),
(88, '2023-06-09 14:30:41', ''),
(89, '2023-06-09 14:56:07', ''),
(90, '2023-06-09 14:58:06', ''),
(91, '2023-06-09 20:03:53', ''),
(92, '2023-06-09 20:09:53', ''),
(93, '2023-06-09 20:13:15', ''),
(94, '2023-06-09 20:18:07', ''),
(95, '2023-06-09 20:34:55', ''),
(96, '2023-06-09 20:54:03', ''),
(97, '2023-06-09 21:34:43', ''),
(98, '2023-06-09 21:36:59', ''),
(99, '2023-06-09 21:40:56', ''),
(100, '2023-06-09 21:42:54', ''),
(101, '2023-06-09 21:44:02', ''),
(102, '2023-06-09 21:50:16', ''),
(103, '2023-06-09 21:55:34', ''),
(104, '2023-06-09 21:58:02', ''),
(105, '2023-06-09 22:07:17', ''),
(106, '2023-06-09 22:11:09', ''),
(107, '2023-06-10 13:07:22', ''),
(108, '2023-06-10 13:18:49', ''),
(109, '2023-06-10 13:33:22', ''),
(110, '2023-06-10 13:37:42', ''),
(111, '2023-06-10 13:41:06', ''),
(112, '2023-06-10 13:42:15', ''),
(113, '2023-06-10 13:47:15', ''),
(114, '2023-06-10 13:49:17', ''),
(115, '2023-06-10 13:51:02', ''),
(116, '2023-06-10 13:52:59', ''),
(117, '2023-06-10 13:54:03', ''),
(118, '2023-06-10 13:59:33', ''),
(119, '2023-06-10 14:00:40', ''),
(120, '2023-06-10 14:01:33', ''),
(121, '2023-06-10 14:03:31', ''),
(122, '2023-06-10 14:19:53', ''),
(123, '2023-06-10 14:27:00', ''),
(124, '2023-06-10 14:32:52', ''),
(125, '2023-06-10 14:35:12', ''),
(126, '2023-06-10 14:36:14', ''),
(127, '2023-06-10 14:37:49', ''),
(128, '2023-06-10 14:40:45', ''),
(129, '2023-06-10 14:41:16', ''),
(130, '2023-06-10 14:42:14', ''),
(131, '2023-06-10 15:18:06', ''),
(132, '2023-06-10 15:22:31', ''),
(133, '2023-06-10 15:25:56', ''),
(134, '2023-06-10 15:26:57', ''),
(135, '2023-06-10 15:28:26', ''),
(136, '2023-06-10 15:34:22', ''),
(137, '2023-06-10 15:38:10', ''),
(138, '2023-06-10 15:57:55', ''),
(139, '2023-06-10 15:59:01', ''),
(140, '2023-06-10 16:19:22', ''),
(141, '2023-06-10 16:23:34', ''),
(142, '2023-06-10 19:02:18', '');

-- --------------------------------------------------------

--
-- Table structure for table `bill_det`
--

DROP TABLE IF EXISTS `bill_det`;
CREATE TABLE IF NOT EXISTS `bill_det` (
  `bill_no` int NOT NULL,
  `itemid` int NOT NULL,
  `qty` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_det`
--

INSERT INTO `bill_det` (`bill_no`, `itemid`, `qty`) VALUES
(1, 1, 2),
(2, 1, 2),
(4, 2, 2),
(5, 5, 2),
(6, 2, 3),
(6, 6, 2),
(7, 2, 2),
(8, 9, 1),
(9, 5, 1),
(10, 6, 1),
(11, 5, 1),
(12, 2, 1),
(13, 0, 1),
(14, 2, 1),
(15, 6, 2),
(16, 5, 2),
(17, 2, 3),
(18, 1, 1),
(19, 6, 2),
(20, 58, 1),
(21, 1, 6),
(22, 1, 2),
(24, 1, 2),
(25, 5, 1),
(26, 5, 2),
(27, 5, 2),
(28, 5, 2),
(29, 5, 2),
(30, 5, 3),
(31, 6, 10),
(32, 2, 2),
(33, 5, 2),
(34, 2, 1),
(35, 58, 4),
(36, 6, 2),
(37, 58, 4),
(38, 58, 4),
(39, 58, 4),
(40, 6, 5),
(42, 58, 4),
(43, 58, 4),
(44, 58, 4),
(45, 58, 4),
(46, 5, 2),
(47, 1, 1),
(48, 1, 1),
(49, 1, 1),
(50, 1, 1),
(51, 1, 1),
(52, 1, 1),
(53, 1, 1),
(54, 1, 1),
(55, 1, 1),
(56, 1, 1),
(57, 1, 1),
(58, 1, 1),
(59, 1, 1),
(60, 1, 1),
(61, 1, 1),
(62, 1, 1),
(63, 1, 1),
(64, 1, 1),
(65, 1, 1),
(66, 1, 1),
(67, 1, 1),
(68, 1, 1),
(69, 1, 1),
(70, 1, 1),
(71, 1, 1),
(72, 1, 1),
(73, 1, 1),
(74, 1, 1),
(75, 1, 1),
(76, 1, 1),
(77, 1, 1),
(78, 1, 1),
(79, 1, 1),
(80, 1, 1),
(81, 1, 1),
(82, 1, 1),
(83, 1, 1),
(84, 1, 1),
(85, 1, 1),
(86, 1, 1),
(87, 1, 1),
(88, 14, 1),
(88, 5, 1),
(89, 1, 1),
(90, 1, 1),
(91, 1, 1),
(92, 1, 1),
(93, 1, 1),
(94, 1, 1),
(95, 1, 1),
(96, 1, 1),
(97, 1, 1),
(98, 1, 1),
(99, 1, 1),
(100, 1, 1),
(101, 1, 1),
(102, 1, 1),
(103, 1, 1),
(104, 1, 1),
(105, 1, 1),
(106, 1, 1),
(107, 1, 1),
(108, 1, 1),
(109, 1, 1),
(110, 1, 1),
(111, 1, 1),
(112, 1, 1),
(113, 1, 1),
(114, 1, 1),
(115, 1, 1),
(116, 1, 1),
(117, 1, 1),
(118, 1, 1),
(119, 1, 1),
(120, 1, 1),
(121, 1, 1),
(122, 5, 1),
(122, 1, 1),
(123, 1, 1),
(124, 1, 1),
(125, 1, 1),
(126, 1, 1),
(127, 1, 1),
(128, 1, 1),
(129, 1, 1),
(130, 1, 1),
(131, 1, 1),
(132, 1, 1),
(133, 1, 1),
(134, 5, 1),
(135, 1, 1),
(136, 1, 1),
(137, 1, 1),
(138, 1, 1),
(139, 1, 1),
(140, 1, 1),
(141, 1, 1),
(142, 1, 1),
(143, 1, 1),
(144, 1, 1),
(145, 1, 1),
(146, 1, 1),
(147, 1, 1),
(148, 1, 1),
(149, 1, 1),
(150, 1, 1),
(151, 1, 1),
(152, 1, 1),
(153, 1, 1),
(154, 1, 1),
(155, 1, 1),
(156, 1, 1),
(157, 1, 1),
(158, 5, 2),
(159, 2, 2),
(160, 1, 1),
(161, 5, 1),
(162, 1, 1),
(163, 1, 1),
(164, 1, 1),
(165, 1, 1),
(166, 1, 1),
(167, 1, 1),
(168, 1, 1),
(169, 1, 1),
(170, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `deliver`
--

DROP TABLE IF EXISTS `deliver`;
CREATE TABLE IF NOT EXISTS `deliver` (
  `slotnum` int NOT NULL,
  `order_id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `category` varchar(50) NOT NULL,
  `photo` varchar(10000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `category`, `photo`) VALUES
(1, 'Margarita Pizza', 73, 'Pizza', 'MargPizza.webp'),
(2, 'Chicken Alfredo Pizza', 105, 'Pizza', 'ChickenAlfredoPizza.jpg'),
(3, 'Pepperoni Lovers Pizza', 95, 'Pizza', 'pep.webp'),
(4, 'Plain Nutella Pizza', 65, 'Pizza', 'plainneutellapizza.jpg'),
(5, 'Steak Sandwich', 68, 'Sandwich', 'steak.jpg'),
(6, 'Chicken Sandwich', 65, 'Sandwich', 'chicksand.jpg'),
(7, 'Hotdog Sandwich', 55, 'Sandwich', 'hotdogsand.jpg'),
(8, 'Turkey Sandwich', 50, 'Sandwich', 'turksand.jpg'),
(9, 'Caeser Salad', 49, 'Salad', 'caesersalad.jpg'),
(10, 'Greek Salad', 42, 'Salad', 'greeksalad.jpg'),
(12, 'Arabic Salad', 36, 'Salad', 'arabicsalad.jpg'),
(13, 'Tuna Salad', 51, 'Salad', 'tunasalad.jpg'),
(14, 'Pepsi', 15, 'Beverages', 'pepsi.png'),
(15, 'Diet Pepsi', 15, 'Beverages', 'dietpep.jpg'),
(16, 'Mineral Water (Small)', 10, 'Beverages', 'water.jpg'),
(17, 'Boneless Wings', 44, 'Extra', 'wings.jpg'),
(17, 'French Fries', 35, 'Extra', 'fries.jpg'),
(18, 'Potato Wedges', 39, 'Extra', 'potatowidges.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `temp_order`
--

DROP TABLE IF EXISTS `temp_order`;
CREATE TABLE IF NOT EXISTS `temp_order` (
  `phone` varchar(15) NOT NULL,
  `itemid` int NOT NULL,
  `qty` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_order`
--

INSERT INTO `temp_order` (`phone`, `itemid`, `qty`) VALUES
('010182023', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `Spot` int DEFAULT NULL,
  `points` int DEFAULT NULL,
  `Reserved` int NOT NULL,
  `arrived` int NOT NULL,
  `promocode` int DEFAULT NULL,
  `credit` int DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `email`, `phone`, `password`, `Spot`, `points`, `Reserved`, `arrived`, `promocode`, `credit`) VALUES
('Amira', 'amira2023@gmail.com', '010182023', '123456', 16, 0, 0, 1, 0, 1234567899),
('Hussein', 'hus2023@gmail.com', '010692023', '654321', 22, 384, 0, 1, 0, 1234567899),
('amr', 'amr2023@gmail.com', '011282023', 'asdfghjkl', 0, 550, 0, 0, 3, 0),
('amro', 'amr82023@gmail.com', '011272023', '194456', 0, 550, 0, 0, 2, 1234567899),
('Ahmed', 'email@gmail.com', '0123456789', '123pass', 0, 550, 0, 0, 3, 0),
('khaled', 'khaled22023@gmail.com', '01222152001', '123789', 0, 550, 0, 0, 3, 0),
('noura', 'nour22023@gmail.com', '01112152001', '12373', 0, 550, 0, 0, 0, 0),
('ashraf', 'ashraf@gmail.com', '015978546', 'ashraf', 0, 550, 0, 0, 3, 0),
('nouran', 'nouran@gmail.com', '012558745', 'nouran', 0, 550, 0, 0, 3, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
