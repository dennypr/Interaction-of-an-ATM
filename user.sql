-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2022 at 01:38 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`) VALUES
(1, 'denny', 'prayudi', 'dennyprayudigm@gmail.com', '$2a$10$LK9eK8zC0/B3BOl07KBqNOKV3V3nnwPOKq1.Vwb830U4U6oGE6Wl6'),
(2, 'admin', 'admin', 'admin', '$2a$10$9wHbZryFrM.5.pLhLOvSbu0ZnFEG6nkE5BxqFCU.kmeyG2QJTTzYu'),
(5, 'ada', 'ada', 'ada', '$2a$10$B5c9hiBRU8EEqzisjHa0uuIVWbFzFqXMb.vAuzvL8aoepT8jjzxRO'),
(6, 'spring', 'spring', 'spring', '$2a$10$UQdL2mXt1gxFb8KF5FDteuoq.j3EQZaB01hUNcbxxn.TbKAJ2rbni'),
(7, 'admin2', 'admin2', 'admin2', '$2a$10$RpCSH67jJbI/fu6USH3h6OiswINgnAvIpaDZkfzOeP.1qg/V04WTu'),
(8, 'yana', 'yana', 'yana', '$2a$10$o4Y1vwzfkDMG7wiCGBLdcucTCw6He25jVzYolr47it/O0MNA0.HNy'),
(9, 'Denny', 'Prayudi', 'Denny', '$2a$10$OB3whHnzgb0pqcbH7bnz2eo.9o0RKKyj1RROWoyFNnMzitraWb2kK');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
