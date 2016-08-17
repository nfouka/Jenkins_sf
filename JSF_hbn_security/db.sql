-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- GÃ©nÃ©rÃ© le :  Jeu 18 AoÃ»t 2016 Ã  01:41
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de donnÃ©es :  `db`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `uid` int(20) NOT NULL,
    `uname` varchar(60) NOT NULL,
      `password` varchar(60) NOT NULL
      ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

      --
      -- Contenu de la table `users`
      --

      INSERT INTO `users` (`uid`, `uname`, `password`) VALUES
      (1, 'root', 'root'),
      (2, 'nfouka', 'nfouka');

      --
      -- Index pour les tables exportÃ©es
      --

      --
      -- Index pour la table `users`
      --
      ALTER TABLE `users`
        ADD PRIMARY KEY (`uid`);

	--
	-- AUTO_INCREMENT pour les tables exportÃ©es
	--

	--
	-- AUTO_INCREMENT pour la table `users`
	--
	ALTER TABLE `users`
	  MODIFY `uid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
	  /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
	  /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
	  /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

