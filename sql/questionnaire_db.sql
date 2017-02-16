-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: questionnaire
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `input_types`
--

DROP TABLE IF EXISTS `input_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `input_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `input_type_name` varchar(80) NOT NULL,
  `display_value` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `survey_name_UNIQUE` (`input_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='This is input type table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input_types`
--

LOCK TABLES `input_types` WRITE;
/*!40000 ALTER TABLE `input_types` DISABLE KEYS */;
INSERT INTO `input_types` VALUES (1,'multilinetext','Multi-line text'),(2,'singlechoice','Single choice'),(3,'multiplechoice','Multiple choice');
/*!40000 ALTER TABLE `input_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option_choices`
--

DROP TABLE IF EXISTS `option_choices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option_choices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `option_choice_name` varchar(45) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_option_choices_questions1_idx` (`question_id`),
  CONSTRAINT `fk_option_choices_questions1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=latin1 COMMENT='This is option choice table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option_choices`
--

LOCK TABLES `option_choices` WRITE;
/*!40000 ALTER TABLE `option_choices` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_choices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `input_type_id` int(11) NOT NULL,
  `question_name` varchar(255) NOT NULL,
  `dependent_question_option_id` int(11) DEFAULT NULL,
  `child` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_questions_question_types1_idx` (`input_type_id`),
  KEY `fk_questions_option_choices1` (`dependent_question_option_id`),
  CONSTRAINT `fk_questions_option_choices1` FOREIGN KEY (`dependent_question_option_id`) REFERENCES `option_choices` (`id`),
  CONSTRAINT `fk_questions_question_types1` FOREIGN KEY (`input_type_id`) REFERENCES `input_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1 COMMENT='This is  questions table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-16 14:26:31
