-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: localhost    Database: quiz_system_database
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `math_questions`
--

DROP TABLE IF EXISTS `math_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `math_questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) NOT NULL,
  `choice_A` varchar(45) NOT NULL,
  `choice_B` varchar(45) NOT NULL,
  `choice_C` varchar(45) NOT NULL,
  `choice_D` varchar(45) NOT NULL,
  `answer` varchar(45) NOT NULL,
  `difficulty_id` int NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `math_questions`
--

LOCK TABLES `math_questions` WRITE;
/*!40000 ALTER TABLE `math_questions` DISABLE KEYS */;
INSERT INTO `math_questions` VALUES (1,'What is 1-1 ?','A) 2','B) 1','C) 0','D) 3','C',1),(2,'What is 2+1 ?','A) 2','B) 1','C) 4','D) 3','D',1),(3,'What is the 2+3 ?','A) 2','B) 1','C) 5','D) 3','C',1),(4,'What is 10+10 ?','A) 2','B) 20','C) 4','D) 10','B',1),(5,'What is 3+5 ?','A) 2','B) 1','C) 0','D) 8','D',1),(6,'What is 9+1 ?','A) 2','B) 10','C) 4','D) 2','B',1),(7,'What is 4-2 ?','A) 2','B) 1','C) 0','D) 3','A',1),(8,'What is 2+10 ?','A) 20','B) 12','C) 3','D) 2','B',1),(9,'What is 10-10 ?','A) 20','B) 100','C) 0','D) 10','C',1),(10,'What is 9+1 ?','A) 91','B) 10','C) 49','D) 20','B',1),(11,'What is 5-5 ?','A) 10','B) 5','C) 0','D) 3','C',1),(12,'What is 20+1 ?','A) 21','B) 1','C) 4','D) 201','A',1),(13,'What is 8+11 ?','A) 19','B) 1','C) 10','D) 3','A',1),(14,'What is 2+1 ?','A) 2','B) 1','C) 4','D) 3','D',1),(15,'What is 6+6 ?','A) 66','B) 1','C) 0','D) 12','D',1),(16,'What is 3+9 ?','A) 6','B) 12','C) 4','D) 3','B',1),(17,'What is 9+4 ?','A) 94','B) 1','C) 13','D) 3','C',1),(18,'What is 8+8 ?','A) 2','B) 1','C) 16','D) 3','C',1),(19,'What is 10+15 ?','A) 150','B) 105','C) 100','D) 25','D',1),(20,'What is 15+10 ?','A) 150','B) 105','C) 100','D) 25','D',1),(21,'What is 2*2 ?','A) 2','B) 1','C) 0','D) 4','D',2),(22,'What is 3*3 ?','A) 2','B) 9','C) 4','D) 3','B',2),(23,'What is 2*3 ?','A) 2','B) 6','C) 0','D) 4','B',2),(24,'What is 4*5 ?','A) 20','B) 9','C) 4','D) 3','A',2),(25,'What is 6*6 ?','A) 2','B) 10','C) 30','D) 36','D',2),(26,'What is 5*3 ?','A) 53','B) 15','C) 4','D) 8','B',2),(27,'What is 3*8 ?','A) 2','B) 10','C) 0','D) 24','D',2),(28,'What is 3*7 ?','A) 21','B) 9','C) 10','D) 3','A',2),(29,'What is 9*9 ?','A) 18','B) 72','C) 63','D) 81','D',2),(30,'What is 10*9 ?','A) 109','B) 19','C) 1','D) 90','D',2),(31,'What is 1*100 ?','A) 1','B) 99','C) 101','D) 100','D',2),(32,'What is 0*1000000000000000 ?','A) 1000000000000','B) 1000000000500','C) 0','D) 1100000000000','C',2),(33,'What is 5*20 ?','A) 100','B) 510','C) 520','D) 4','A',2),(34,'What is 4*20 ?','A) 420','B) 80','C) 4200','D) 42000','B',2),(35,'What is 42*10 ?','A) 42','B) 420','C) 4200','D) 42000','B',2),(36,'What is 210*2 ?','A) 42','B) 420','C) 4200','D) 42000','B',2),(37,'What is 840/2 ?','A) 1000','B) 1680','C) 420','D) 1890','C',2),(38,'What is 2940/7 ?','A) 720','B) 270','C) 520','D) 420','D',2),(39,'What is 1050/2.5 ?','A) 52','B) 146','C) 758','D) 420','D',2),(40,'What is 107.1/0.255 ?','A) 255','B) 454','C) 420','D) 857','C',2),(41,'What is 3*3/2 ?','A) 4.5','B) 9','C) 4','D) 3','B',3),(42,'What is 3+2*3 ?','A) 3','B) 15','C) 9','D) 10','C',3),(43,'What is 4*5/5 ?','A) 4','B) 20','C) 5','D) 3','A',3),(44,'Combine terms: 12a + 26b -4b – 16a','A) 4a + 22b','B) -28a + 30b','C) -4a + 22b','D) 28a + 30b','C',3),(45,'Simplify: (4 – 5) – (13 – 18 + 2)','A) -1','B) –2','C) 1','D) 2','D',3),(46,'What is |-26|?','A) -26','B) 26','C) 0','D) 1','B',3),(47,'Multiply: (x – 4)(x + 5)','A) x2 + 5x - 20','B) x2 - 4x - 20','C) x2 - x - 20','D) x2 + x - 20','D',3),(48,'Factor: 5x2 – 15x – 20','A) 5(x-4)(x+1)','B) -2(x-4)(x+5)','C) -5(x+4)(x-1)','D) 5(x+4)(x+1)','A',3),(49,'Factor: 3y(x – 3) -2(x – 3)','A) (x – 3)(x – 3)','B) (x – 3)2','C) (x – 3)(3y – 2)','D) 3y(x – 3)','C',3),(50,'Solve for x: 2x – y = (3/4)x + 6','A) (y + 6)/5','B) 4(y + 6)/5','C) (y + 6)','D) 4(y - 6)/5','B',3),(51,'Find the value of 3 + 2 • (8 – 3)','A) 25','B) 13','C) 17','D) 24','D',3),(52,'What is 1+2+3+4+5+...+999+1000?','A) 501000','B) 500000','C) 505000','D) 500500','D',3),(53,'Find the value of p: 2p+8p-6=7p+2p','A) 6','B) 7','C) 8','D) 9','A',3),(54,'Simplify: (24sp)/(3s)','A) 8p','B) 24sp/3s','C) 24p/3s','D) 7p','A',3),(55,'Rewrite 3/8 as a decimal','A) 0.225','B) 0.375','C) 0.535','D) 0.455','B',3),(56,'What is |2 − 7| ?','A) 9','B) 5','C) -5','D) -9','B',3),(57,'What is the speed 1 m/sec expressed in km/h?','A) 0.277 km/h','B) 0.36 km/h','C) 0.6 km/h','D) 3.6 km/h','D',3),(58,'Use long division to calculate 468 ÷ 24','A) 19.5','B) 19.6','C) 19.7','D) 19.8','A',3),(59,'How many integers are there on the number lin','A) 11','B) 12','C) 13','D) 14','C',3),(60,'The numbers 40, 45, 80, 75 and 10 have weights 1, 2, 3, 4 and 5 respectively. What is the weighted mean?','A) 47','B) 49','C) 48','D) 50','C',3);
/*!40000 ALTER TABLE `math_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-23 14:28:56
