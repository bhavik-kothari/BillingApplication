CREATE DATABASE  IF NOT EXISTS `billing` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `billing`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: billing
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `short_description` varchar(100) DEFAULT NULL,
  `long_description` varchar(200) DEFAULT NULL,
  `quantity_measured_in_type` varchar(45) NOT NULL,
  `quantity_in_stock` int(20) NOT NULL,
  `selling_price` decimal(20,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product`
  VALUES
    (1,'Refrigerator','ELECTRONICS','This is smart refrigerator','This is smart refrigerator','pieces',10,40000),
    (2,'Television','ELECTRONICS','This is smart television','This is smart television','pieces',5,30000),
    (3,'Banana','GROCERY','Banana is full of glucose','Banana is full of glucose','kgs',50,20),
    (4,'Rice','GROCERY','Real Basmati Rice','Real Basmati Rice','kgs',1000,30),
    (5,'Lipstick','COSMETICS','Nice lipstick','Nice lipstick','peices',30,100);

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `user_type` varchar(45) NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `registration_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `active` int(1) DEFAULT '0',
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user`
  VALUES
      (1,'bhavik','EMPLOYEE','bhavik','kothari','M','b@yahoo.com','1234567890','2015-02-12 16:00:00',NULL,1,0),
      (2,'megha','EMPLOYEE','megha','kothari','F','m@yahoo.com','2345678901','2018-05-25 16:00:00',NULL,0,0),
      (3,'aviraj','AFFILIATE','aviraj','kothari','M','a@yahoo.com','3456789012','2018-01-11 16:00:00',NULL,1,0),
      (4,'jaykumar','CUSTOMER','jaykumar','kothari','M','j@yahoo.com','1234567098','2015-01-11 16:00:00',NULL,1,0),
      (5,'urmi','CUSTOMER','urmi','kothari','F','u@yahoo.com','4567890123','2017-03-18 16:00:00',NULL,1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-27 11:38:32
