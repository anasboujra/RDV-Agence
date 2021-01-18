-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 18, 2021 at 04:51 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rdv-agence`
--

-- --------------------------------------------------------

--
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `idEmploye` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEmploye` (`idEmploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `contenu`, `image`, `date`, `idEmploye`) VALUES
(15, 'Ma Premier Annonce', 'Ma Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier PublicationMa Premier Publication', '15701544_304.jpg', '2021-01-18 06:27:08', 1);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `cin` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `numTele` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mot_de_passe` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_debut` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `photoProfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contenu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `cin` varchar(120) NOT NULL,
  `nom` varchar(120) NOT NULL,
  `prenom` varchar(120) NOT NULL,
  `ville` varchar(120) NOT NULL,
  `email` varchar(220) NOT NULL,
  `mot_de_passe` varchar(500) NOT NULL,
  `num_telephone` varchar(500) NOT NULL,
  `date_debut` varchar(120) NOT NULL,
  `photo_profil` varchar(500) NOT NULL,
  `ancien_mot_de_passe` varchar(255) NOT NULL,
  `isAdmin` tinyint(10) NOT NULL DEFAULT 0,
  `isConge` tinyint(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `cin`, `nom`, `prenom`, `ville`, `email`, `mot_de_passe`, `num_telephone`, `date_debut`, `photo_profil`, `ancien_mot_de_passe`, `isAdmin`, `isConge`) VALUES
(1, 'J3344455', 'Anas', 'Boujra', 'Agadir', 'anas.boujra@gmail.com', 'f7c3bc1d808e04732adf679965ccc34ca7ae3441', '0677777777', '17-05-2019', 'boujra.jpg', '123456789', 0, 0),
(2, 'i778877', 'Amiri', 'Mohamed', 'Ouarzazate', 'amiri@gmail.com', 'Amine123', '0635734578', '10-01-2021', 'amiri.jpg', 'Amine123', 0, 0),
(3, 'I737329', 'Benaicha', 'Mohamed Amine', 'Beni Mellal', 'amine98ben90@gmail.com', 'Amine123', '0635734578', '17-01-2021', 'benaicha.jpg', 'Amine1234', 1, 0),
(4, 'D990099', 'Elattar', 'Mohamed', 'Agadir', 'amine98ben90@gmail.com', 'Amine123', '0787980990', '11-01-2021', 'elattar.jpg', 'Amine123', 0, 0),
(6, 'I898767', 'Test', 'Test', 'Test', 'amine98ben90@gmail.com', 'Amine123', '0635734578', '18-01-2021', 'avatar.png', 'Amine123', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4);

-- --------------------------------------------------------

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `idEmploye` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEmploye` (`idEmploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `statut` varchar(255) NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `rservation_client_contrainte` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_employe_contrainte` FOREIGN KEY (`idEmploye`) REFERENCES `employe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id`) REFERENCES `commentaire` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `ClientCommentaireContrainte` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `EmployePublicationContrainte` FOREIGN KEY (`idEmploye`) REFERENCES `employe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `rservation_client_contrainte` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
