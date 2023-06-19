-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 21, 2023 at 11:27 PM
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
-- Table structure for table `bill_det`
--

DROP TABLE IF EXISTS `bill_det`;
CREATE TABLE IF NOT EXISTS `bill_det` (
  `bill_no` int NOT NULL,
  `itemid` int NOT NULL,
  `qty` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bill_det`
--

INSERT INTO `bill_det` (`bill_no`, `itemid`, `qty`) VALUES
(1, 1, 2),
(1, 5, 2),
(1, 5, 2),
(3, 1, 1),
(3, 1, 1),
(3, 1, 1),
(3, 1, 3),
(3, 6, 3),
(3, 9, 5),
(3, 1, 2),
(3, 1, 2),
(3, 1, 3),
(3, 6, 30),
(3, 1, 5),
(3, 24, 1),
(3, 2, 1),
(4, 1, 1),
(5, 2, 1),
(5, 58, 2),
(6, 1, 1),
(7, 1, 1),
(8, 1, 1),
(9, 1, 1),
(10, 5, 1),
(11, 6, 1),
(12, 6, 1),
(13, 5, 1),
(14, 5, 1),
(15, 5, 1),
(16, 5, 1),
(17, 5, 1),
(18, 2, 1),
(19, 5, 1),
(20, 5, 1),
(21, 5, 1),
(22, 5, 1),
(23, 5, 1),
(24, 5, 1),
(24, 0, 1),
(25, 6, 1),
(26, 5, 1),
(27, 5, 1),
(28, 5, 1),
(29, 5, 1),
(30, 5, 1),
(30, 0, 1),
(31, 5, 1),
(31, 0, 1),
(31, 0, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
