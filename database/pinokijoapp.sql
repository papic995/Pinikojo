-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2017 at 08:43 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pinokijoapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_slani`
--

CREATE TABLE `add_slani` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_slani`
--

INSERT INTO `add_slani` (`id`, `name`) VALUES
(1, 'kackavalj'),
(2, 'pavlaka'),
(3, 'urnebes'),
(4, 'kajmak'),
(5, 'sremski sir'),
(6, 'funge');

-- --------------------------------------------------------

--
-- Table structure for table `add_slatki`
--

CREATE TABLE `add_slatki` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_slatki`
--

INSERT INTO `add_slatki` (`id`, `name`) VALUES
(1, 'plazma'),
(2, 'banana'),
(3, 'preliv karamela'),
(4, 'plazma u mleku'),
(5, 'kikiriki'),
(6, 'orah'),
(7, 'indiski orah');

-- --------------------------------------------------------

--
-- Table structure for table `main_slani`
--

CREATE TABLE `main_slani` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_slani`
--

INSERT INTO `main_slani` (`id`, `name`) VALUES
(1, 'sunka'),
(2, 'kulen'),
(3, 'pecenica');

-- --------------------------------------------------------

--
-- Table structure for table `main_slatki`
--

CREATE TABLE `main_slatki` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_slatki`
--

INSERT INTO `main_slatki` (`id`, `name`) VALUES
(1, 'nutela'),
(2, 'eurokrem'),
(3, 'cipirip'),
(4, 'med');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_slani`
--
ALTER TABLE `add_slani`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `add_slatki`
--
ALTER TABLE `add_slatki`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `main_slani`
--
ALTER TABLE `main_slani`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `main_slatki`
--
ALTER TABLE `main_slatki`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_slani`
--
ALTER TABLE `add_slani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `add_slatki`
--
ALTER TABLE `add_slatki`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `main_slani`
--
ALTER TABLE `main_slani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `main_slatki`
--
ALTER TABLE `main_slatki`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
