-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 16 Juin 2015 à 00:42
-- Version du serveur: 5.5.43-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `DAVDB`
--

-- --------------------------------------------------------

--
-- Structure de la table `Employee`
--

CREATE TABLE IF NOT EXISTS `Employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `empaddress` varchar(255) DEFAULT NULL,
  `empAge` int(11) DEFAULT NULL,
  `empname` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `Employee`
--

INSERT INTO `Employee` (`empid`, `empaddress`, `empAge`, `empname`, `salary`) VALUES
(1, '34 rue du vercors appt 13 - 38000 Grenoble FRANCE', 33, 'NADIR FOUKA', 35000),
(2, '53 Rue des Mathématiques UJF GRENOBLE', 54, 'Pierre Saramito', 78000),
(7, '859 , Rue de la paix , France', 65, 'Armond Thierry', 78500);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
