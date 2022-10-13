-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: fichapaciente
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ATENDIMENTO`
--

DROP TABLE IF EXISTS `ATENDIMENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ATENDIMENTO` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `IdPaciente` float DEFAULT NULL,
  `data_atendimento` date DEFAULT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_ATENDIMENTO_0` (`IdPaciente`),
  CONSTRAINT `FK_ATENDIMENTO_0` FOREIGN KEY (`IdPaciente`) REFERENCES `PACIENTE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ATENDIMENTO`
--

LOCK TABLES `ATENDIMENTO` WRITE;
/*!40000 ALTER TABLE `ATENDIMENTO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ATENDIMENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESPECIALIDADE`
--

DROP TABLE IF EXISTS `ESPECIALIDADE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESPECIALIDADE` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESPECIALIDADE`
--

LOCK TABLES `ESPECIALIDADE` WRITE;
/*!40000 ALTER TABLE `ESPECIALIDADE` DISABLE KEYS */;
INSERT INTO `ESPECIALIDADE` VALUES (1,'Exames simples'),(2,'Consultas em clinicas'),(3,'Consultas hospitalares'),(4,'Fisioterapia'),(5,'Acupuntura'),(6,'Cardiologia'),(7,'Cirurgia geral'),(8,'Clinica medica'),(9,'Dermatologia'),(10,'Endoscopia'),(11,'Exames especiais'),(12,'Exames simples'),(13,'Pediatria'),(14,'Fonoaudiologia'),(15,'Cirurgia plastica');
/*!40000 ALTER TABLE `ESPECIALIDADE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOGIN`
--

DROP TABLE IF EXISTS `LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOGIN` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOGIN`
--

LOCK TABLES `LOGIN` WRITE;
/*!40000 ALTER TABLE `LOGIN` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOGIN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PACIENTE`
--

DROP TABLE IF EXISTS `PACIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PACIENTE` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `sexo` char(2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nome_pai` varchar(100) DEFAULT NULL,
  `nome_mae` varchar(100) DEFAULT NULL,
  `plano` int(11) DEFAULT NULL,
  `numero_carteira` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PACIENTE`
--

LOCK TABLES `PACIENTE` WRITE;
/*!40000 ALTER TABLE `PACIENTE` DISABLE KEYS */;
INSERT INTO `PACIENTE` VALUES (1,'sad','','2019-02-19','asd','','','','',NULL,324324324),(2,'teste','','2019-02-19','asd','M','','','',NULL,324324324),(3,'erwter','',NULL,'2345435','','dsaf@dfgdgsdgfdgdfg','pai','mae',NULL,2345345),(4,'erwter','31778833212','2019-02-12','2345435','','dsaf@dfgdgsdgfdgdfg','pai','mae',NULL,2345345),(5,'erwter','31778833212','2019-02-12','2345435','','dsaf@dfgdgsdgfdgdfg','pai','mae',NULL,2345345),(6,'erwter','31778833212','2019-02-12','2345435','','dsaf@dfgdgsdgfdgdfg','pai','mae',NULL,2345345),(7,'qewrqwer','',NULL,'453452','M','','','',NULL,32455),(8,'qewrqwer','',NULL,'453452','M','','','',NULL,32455),(9,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',NULL,324324),(10,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',NULL,32434),(11,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',NULL,324324),(12,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',NULL,324324),(13,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',NULL,324324),(14,'xxxxxxxxxxxxxxxxxxxx','',NULL,'ertertewrter','','','','',2,324324),(15,'DIOGO','(31)98793-9168',NULL,'049.187.886.96','','','','',2,154578),(16,'Diogo Lages','',NULL,'04918788696','','','','',3,45123788),(17,'Diogo Lages','',NULL,'04918788696','','','','',3,45123788),(18,'asd','3188059999','2019-02-12','4353252345','M','diogolages@gmail.com','sdfdsf','asdsad',1,123),(19,'carlos','',NULL,'4512121','','','','',2,78456456),(20,'erwtwert','',NULL,'43523452','','','','',2,3435345),(21,'sad','',NULL,'32432','','','','',2,32432),(22,'sadsadsad','',NULL,'34324324','','','','',2,432432),(23,'sadsad','',NULL,'32432','','','','',2,324234),(24,'dsafdsdsf','',NULL,'324324','','','','',2,324324),(25,'sadsad','',NULL,'324324','','','','',2,324324),(26,'sadsad','',NULL,'324324','','','','',2,324324),(27,'teryryt','',NULL,'5464','','','','',1,34566),(28,'etryerty','',NULL,'3465456','','','','',1,435656),(29,'wertert','',NULL,'43','','','','',2,22),(30,'tew','',NULL,'43','','','','',2,34),(31,'wqe','',NULL,'32234','','','','',1,32),(32,'erwt','',NULL,'34543','','','','',3,43),(33,'ertyerty','',NULL,'3452354','','','','',2,434535),(34,'erwtertert','',NULL,'4356','','','','',2,43566465),(35,'erwtertert','',NULL,'3245','M','','','',2,2345345),(36,'sdfgsfdgdfg','',NULL,'546543643','','','','',2,345643),(37,'bernardo','','2019-02-12','2345324532','','','','',2,325555555);
/*!40000 ALTER TABLE `PACIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLANO_ESPECIALIDADE`
--

DROP TABLE IF EXISTS `PLANO_ESPECIALIDADE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLANO_ESPECIALIDADE` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `especialidade_Id` float DEFAULT NULL,
  `plano_Id` float DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_PLANO_ESPECIALIDADE_0` (`especialidade_Id`),
  KEY `FK_PLANO_ESPECIALIDADE_1` (`plano_Id`),
  CONSTRAINT `FK_PLANO_ESPECIALIDADE_0` FOREIGN KEY (`especialidade_Id`) REFERENCES `ESPECIALIDADE` (`Id`),
  CONSTRAINT `FK_PLANO_ESPECIALIDADE_1` FOREIGN KEY (`plano_Id`) REFERENCES `PLANO_SAUDE` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLANO_ESPECIALIDADE`
--

LOCK TABLES `PLANO_ESPECIALIDADE` WRITE;
/*!40000 ALTER TABLE `PLANO_ESPECIALIDADE` DISABLE KEYS */;
INSERT INTO `PLANO_ESPECIALIDADE` VALUES (1,1,1),(2,8,1),(3,3,1),(4,6,2),(5,7,2),(6,8,2),(7,9,2),(8,10,2),(9,1,3),(10,2,3),(11,3,3),(12,4,3),(13,5,3),(14,6,3),(15,7,3),(16,8,3),(17,9,3),(18,10,3),(19,11,3),(20,12,3),(21,13,3),(22,14,3),(23,15,3);
/*!40000 ALTER TABLE `PLANO_ESPECIALIDADE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLANO_SAUDE`
--

DROP TABLE IF EXISTS `PLANO_SAUDE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLANO_SAUDE` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLANO_SAUDE`
--

LOCK TABLES `PLANO_SAUDE` WRITE;
/*!40000 ALTER TABLE `PLANO_SAUDE` DISABLE KEYS */;
INSERT INTO `PLANO_SAUDE` VALUES (1,'Básico'),(2,'Plus'),(3,'Vip');
/*!40000 ALTER TABLE `PLANO_SAUDE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fichapaciente'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-13 14:19:27
