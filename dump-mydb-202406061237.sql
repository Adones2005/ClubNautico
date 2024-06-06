-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barco`
--

DROP TABLE IF EXISTS `barco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barco` (
  `id_barco` int NOT NULL AUTO_INCREMENT,
  `cuota` double DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `n_amarre` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_barco`),
  KEY `FK3kvdhc7ujlb76hgau34e2s4vw` (`id_usuario`),
  CONSTRAINT `FK3kvdhc7ujlb76hgau34e2s4vw` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barco`
--

LOCK TABLES `barco` WRITE;
/*!40000 ALTER TABLE `barco` DISABLE KEYS */;
INSERT INTO `barco` VALUES (2,100,'ABC123',5,'Mi Barco',1),(3,300,'ABC123',7,'Mi Barco 2',1),(4,100,'ABC123',5,'Mi Barco',3),(5,100,'ABC123',5,'Mi Barco',1);
/*!40000 ALTER TABLE `barco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salida`
--

DROP TABLE IF EXISTS `salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salida` (
  `id_salida` int NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_barco` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_salida`),
  KEY `FKlenf4k107whuap8tl64sdbffi` (`id_barco`),
  KEY `FK7p5d7f6usd4cwedtevgfe09gs` (`id_usuario`),
  CONSTRAINT `FK7p5d7f6usd4cwedtevgfe09gs` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKlenf4k107whuap8tl64sdbffi` FOREIGN KEY (`id_barco`) REFERENCES `barco` (`id_barco`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salida`
--

LOCK TABLES `salida` WRITE;
/*!40000 ALTER TABLE `salida` DISABLE KEYS */;
INSERT INTO `salida` VALUES (7,'Puerto de destino','2024-06-06',3,3),(8,'Puerto de destino','2024-06-06',3,3),(9,'Puerto de destino','2024-06-06',3,3);
/*!40000 ALTER TABLE `salida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `cod_patron` int DEFAULT NULL,
  `cod_socio` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_s0i699wt9icv4muds25puiwo4` (`cod_patron`),
  UNIQUE KEY `UK_gogt0hmdnawokvvamtlar4llw` (`cod_socio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Propietario Apellido',789012,123456,'propietario@example.com','Propietario Nombre'),(3,'Propietario Apellido',789019,NULL,'propietario@example.com','Propietario Nombre2'),(4,'Propietario Apellido',NULL,193545,'propietario@example.com','Propietario Nombre2');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06 12:37:04
