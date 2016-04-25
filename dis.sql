-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 25, 2016 at 08:31 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dis`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_details`
--

CREATE TABLE IF NOT EXISTS `tbl_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact` varchar(50) NOT NULL,
  `Specialization` varchar(50) NOT NULL,
  `Workplace` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_details`
--

INSERT INTO `tbl_details` (`id`, `First_Name`, `Last_Name`, `Address`, `Contact`, `Specialization`, `Workplace`) VALUES
(1, 'Lallit', 'kala', 'Cyamput', '982', 'Orthopaedist', 'Nepal Army');
