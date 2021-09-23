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
-- Table structure for table `ge_questions`
--

DROP TABLE IF EXISTS `ge_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ge_questions` (
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
-- Dumping data for table `ge_questions`
--

LOCK TABLES `ge_questions` WRITE;
/*!40000 ALTER TABLE `ge_questions` DISABLE KEYS */;
INSERT INTO `ge_questions` VALUES (1,'What is Earth\'s largest continent?','A) Antarctica','B) Africa','C) Europe','D) Asia','D',1),(2,'What is the capital of China?','A) Beijing','B) Tokyo','C) London','D) New York City','A',1),(3,'In which US city is the Golden Gate Bridge located?','A) New York City','B) San Francisco','C) Nashville','D) Austin','B',1),(4,'How many states are there in the United States?','A) 13','B) 700','C) 20','D) 50','D',1),(5,'Which country has the largest population in the world?','A) United Kingdom','B) Germany','C) China','D) United States of America','C',1),(6,'What is the capital of the United States?','A) New York City','B) Washington D.C.','C) Tokyo','D) Texas','B',1),(7,'Kabul is the capital of which country?','A) Japan','B) China','C) Korea','D) Afghanistan','C',1),(8,'On which island is the Statue of Liberty located?','A) Liberty Island','B) Oahu','C) Maui','D) Hawai\'i','A',1),(9,'Which continent is Russia a part of?','A) Asia','B) South America','C) North America','D) Africa','A',1),(10,'Istanbul is a city in which country?','A) South Korea','B) Russia','C) Mauritania','D) Turkey','D',1),(11,'Which large river flows through London?','A) Porvoo','B) Mississippi','C) Thames','D) Colorado','C',1),(12,'Luxembourg City is the capital of which country?','A) United States of America','B) Luxembourg','C) Russia','D) North Korea','B',1),(13,'Dublin is a city in which country?','A) South Korea','B) Tajikistan','C) England','D) Ireland','D',1),(14,'What is the hottest continent on Earth?','A) Africa','B) South America','C) Antarctica','D) Asia','A',1),(15,'Which desert covers much of northern Africa?','A) Kalahari','B) Gobi','C) Sahara','D) Arabian','C',1),(16,'What is a nickname for New York City','A) Windy City','B) Music City','C) Stoplight City','D) The Big Apple','D',1),(17,'Which mountain range is Mount Everest located in?','A) Himalayas','B) Andes','C) Alps','D) Snowdonia','A',1),(18,'In which country would you find the Great Pyramid of Giza?','A) Russia','B) Egypt','C) Turkey','D) China','B',1),(19,'Which of these countries is in Europe?','A) Egypt','B) Canada','C) Germany','D) Nigeria','C',1),(20,'What is the coldest continent on Earth?','A) Antarctica','B) Asia','C) Africa','D) South America','A',1),(21,'Which of these US states does NOT border Canada?','A) Maine','B) Alaska','C) Indiana','D) Minnesota','C',2),(22,'Which of these countries was NOT a part of the Soviet Union?','A) Georgia','B) Belarus','C) Poland','D) Ukraine','C',2),(23,'Which of these cities is NOT a national capital?','A) Cairo','B) Bangkok','C) Prague','D) Sydney','D',2),(24,'Which of these cities DOESN\"T border the Meditteranean Sea?','A) Alexandria','B) Lisbon','C) Barcelona','D) Monaco','B',2),(25,'Which of these countries was NEVER part of the British Empire?','A) Ireland','B) Kenya','C) New Zealand','D) Thailand','D',2),(26,'Which of these cities is NOT in the Southern Hemisphere?','A) Johannesburg','B) Colombo','C) Brisbane','D) Brasilia','B',2),(27,'Which one of these countries is NOT in Central America?','A) Honduras','B) Belize','C) Suriname','D) Panama','C',2),(28,'Which of these cities does NOT border the Great Lakes?','A) Toronto','B) Chicago','C) Pittsburgh','D) Cleveland','C',2),(29,'Which of these countries is NOT majority-Muslim?','A) Albania','B) Ethiopia','C) Morocco','D) Indonesia','B',2),(30,'Which of these countries is NOT recognized by the United Nations?','A) Taiwan','B) Israel','C) Cyprus','D) Iran','A',2),(31,'Which of these mountain ranges is NOT in Europe?','A) The Alps','B) Carpathian Mountains','C) The Pyrenees','D) Atlas Mountains','D',2),(32,'Which of these things is NOT located in Africa?','A) Aswan Dam','B) Zambezi River','C) Gobi Desert','D) Lake Victoria','C',2),(33,'Which of these countries is NOT one of the top 20 oil producers?','A) Iraq','B) Morocco','C) United States','D) Norway','B',2),(34,'Which of these cities is NOT in India?','A) Karachi','B) Bhopal','C) Bangalore','D) Chennai','A',2),(35,'Which of these countries does NOT only have one border?','A) North Korea','B) Ireland','C) Portugal','D) Haiti','A',2),(36,'Which of these countries has the largest population?','A) Brazil','B) Russia','C) Iran','D) Germany','A',2),(37,'Which of these mountain ranges has the highest maximum elevation?','A) Rockies','B) Andes','C) Alps','D) Urals','B',2),(38,'Which of these rivers flows past the most countries?','A) Danube','B) Euphrates','C) Amazon','D) Mississippi','A',2),(39,'Which of these cities has the highest population?','A) San Francisco','B) Shanghai','C) Singapore','D) Santiago','B',2),(40,'Which of these islands has the largest area?','A) Iceland','B) Cuba','C) Great Britain','D) Madagascar','D',2),(41,'What is the only sea without any coasts?','A) Adriatic Sea','B) Celebes Sea','C) Sargasso Sea','D) Mediterranean Sea','C',3),(42,'What was the capital of Brazil before 1960?','A) Sao Paulo','B) Manaus','C) Rio de Janeiro','D) Curitiba','C',3),(43,'What is New York City\'s \"Street of Forgotten Men\"?','A) 17th Street','B) The Bowery','C) Wall Street','D) Main Street','B',3),(44,'What river flows above the Holland Tunnel?','A) The Hudson','B) Colorado River','C) Rio Grande','D) Sabine River','A',3),(45,'What is the capital of Uganda?','A) Gulu','B) Fort Portal','C) Mukono','D) Kampala','D',3),(46,'What U.S. state is home of the headwaters of the Mississippi River?','A) Minnesota','B) Mississippi','C) Montana','D) Wyoming','A',3),(47,'What is the official language of Papua New Guinea?','A) Arabic','B) English','C) German','D) Sepik','B',3),(48,'What city does Beacon Hill light?','A) Philadelphia','B) New York City','C) Boston','D) Baltimore','C',3),(49,'What country has the longest coastline in the world?','A) Canada','B) Russia','C) Brazil','D) United States','A',3),(50,'What city is surrounded by Rome?','A) Vatican City','B) Naples','C) Florence','D) Bologna','A',3),(51,'What city has the Alhambra Palace?','A) Paris, France','B) Versailles, France','C) Madrid, Spain','D) Granada, Spain','D',3),(52,'What is the capital of Malta?','A) St. Julian\'s','B) Valetta','C) Mgarr','D) Tunis','B',3),(53,'In which UK city would you find the river Clyde?','A) Manchester','B) Leeds','C) Glasgow','D) London','C',3),(54,'What is the capital of Peru?','A) Chimbote','B) Lima','C) Ayacucho','D) Quito','B',3),(55,'Mount Vesuvius overlooks which modern Italian city?','A) Bari','B) Florence','C) Venice','D) Naples','D',3),(56,'In which US state would you find Fort Knox?','A) Kentucky','B) Illinois','C) Indiana','D) Ohio','A',3),(57,'Which is the most southerly US state?','A) Alabama','B) Florida','C) Texas','D) Hawaii','D',3),(58,'The Needles off the western tip of the Isle of Wight are an example of what type of geographical feature?','A) Arch','B) Stump','C) Stack','D) Basin','C',3),(59,'In which country will you find the city of Shiraz?','A) Syria','B) Iran','C) Saudi Arabia','D) Iraq','B',3),(60,'Which country has Africa\'s largest population?','A) Nigeria','B) Ethiopia','C) South Africa','D) Egypt','A',3);
/*!40000 ALTER TABLE `ge_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-23 14:28:55
