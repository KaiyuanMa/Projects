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
-- Table structure for table `cs_questions`
--

DROP TABLE IF EXISTS `cs_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cs_questions` (
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
-- Dumping data for table `cs_questions`
--

LOCK TABLES `cs_questions` WRITE;
/*!40000 ALTER TABLE `cs_questions` DISABLE KEYS */;
INSERT INTO `cs_questions` VALUES (1,'Internet Explorer is a:','A) Any person browsing the net','B) Web Browser','C) Graphing Package','D) News Reader','B',1),(2,'Which one of the followings is a programming ','A) HTTP','B) HTML','C) HPML','D) FTP','B',1),(3,'MAC Operating System is developed by which company?','A) IBM','B) Apple','C) Microsof','D) Samsung','B',1),(4,'Which of the following is not a web browser?','A) MOSAIC','B) WWW','C) Facebook','D) Netscape navigator','C',1),(5,'.gif is an extension of?','A) Image file','B) Video file','C) Audio file','D) Word file','A',1),(6,'In computer world, Trojan refer to?','A) Virus','B) Malware','C) Worm','D) Spyware','B',1),(7,'The main page of a Web site is known as?','A) Home page','B) Book mark page','C) Content page','D) Navigator page','A',1),(8,'Binary system uses the power of?','A) 8','B) 4','C) 2','D) 16','C',1),(9,'Which of the following is not a search engine','A) Yahoo','B) Google','C) Altavista','D) Firebox Mozilla','C',1),(10,'A ________ is a collection of spreadsheet pag','A) Documents','B) Artbook','C) Workbook','D) Worksheet','D',1),(11,'A hyperlink means?','A) Text connected to page','B) Plain text','C) Coloured text','D) None of the above','A',1),(12,'The default page size for word document is?','A) A4','B) Legal','C) Letter','D) A3','A',1),(13,'Which one is the default extension of 2007 office word document?','A) .xls','B) .pdf','C) .doc','D) .docx','D',1),(14,'Which one is not a part of a computer device ','A) Mother board','B) CPU','C) Keyboard','D) Scanner','D',1),(15,'MS Word is an example of:','A) Operating System','B) Processing Device','C) Application Software','D) Input Device','C',1),(16,'The _______ project systems from hackers:','A) Backup','B) 3 disk','C) Firewall','D) Antivirus','C',1),(17,'Errors in computer programmes are called:','A) Mistake','B) Follies','C) Spam','D) Bugs','D',1),(18,'\"IoT\" refers to:','A) Internet of Things','B) Intranet of Teleservices','C) International Organisation of Teleservices','D) Internet Organisation of Telecommunication','A',1),(19,'Virus is a computer _______:','A) File','B) Database','C) Network','D) Program','D',1),(20,'SQL stands for:','A) Simple Query Language','B) Standard Quality Language','C) Structured Query Language','D) Standard Query Language','C',1),(21,'The \"http\" you type at the beginning of any s','A) HTML Transfer Technology Process','B) Hyperspace Terms and Tech Protocol','C) Hyperspace Techniques and Tech Progress','D) Hyper Text Transfer Protocol','D',2),(22,'Number of bit used by the IPv6 address:','A) 64 bit','B) 128 bit','C) 256 bit','D) 32 bit','C',2),(23,'Which of the following is not a component in ','A) Video','B) Audio','C) Data','D) Pen Drive','D',2),(24,'Internet is an example of ______ :','A) Wide Area Network','B) Local Area Network','C) Metropolitan Area Network','D) Storage Network','C',2),(25,'A computer on Internet is uniquely identified','A) Memory address','B) E-mail address ','C) Virtual address ','D) IP address','C',2),(26,'On the Internet, moving from one web site to another is known as ______ :','A) Uploading','B) Downloading','C) Searching','D) Browsing','D',2),(27,'Which are the operations that are performed on RAM?','A) Write only','B) Read only','C) Read and Write both','D) It depends on the user','C',2),(28,'In the process of communication the first step is?','A) Encoding','B) Message','C) Decoding','D) Receiving','A',2),(29,'How many printing characters are these in ASCII?','A) 79','B) 62','C) 85','D) 94','D',2),(30,'URL stands for :','A) Uniform Resource Locator','B) Universal Resource Locator','C) Unique Resource Locator','D) Uniform Reserve Locator','A',2),(31,'The place where accessories are connected in computer is known as :','A) Ring','B) Port','C) Bus','D) Zip','B',2),(32,'How many numbers of home pages a web site can contain?','A) One','B) As many as one would like to have','C) Depends upon the size of the website','D) Depends upon the size of contents','A',2),(33,'System software is an interface between _____','A) 3ware and Application Software','B) Application software and User','C) RAM and COM','D) CPU and UPS','A',2),(34,'A packet of information that travels between a browser and the web server is known as:','A) Adware','B) Malware','C) Spyware','D) Cookie','D',2),(35,'When a computer suddenly stops working, it is said to be?:','A) Crashed','B) Bugged','C) Hanged','D) Held up','C',2),(36,'A complier that automatically detects parallelisms is known as:','A) Run-time complier','B) Optimising complier','C) Interpreter','D) None of the above','B',2),(37,'The information transfer between CPU and cache is in terms of:','A) Bytes','B) Bites','C) Words','D) None of the above','C',2),(38,'In reference to a computer, an assembler is a : ','A) Program','B) Person who assembles the parts','C) Symbol','D) None of the above','A',2),(39,'COBOL stands for :','A) Common Bulck Language','B) Common Block Oriented Language','C) Common Business Oriented Language','D) None of the above','C',2),(40,'Saving a file from the Internet onto your destop is called:','A) Downloading','B) Uploading','C) Transfering','D) Storing','A',2),(41,'Who programmed the first computer game \'Spacewar!\" in 1962 ?','A) Steave Russell','B) Konard Zuse','C) Alan Emtage','D) Tim Berners-Lee','A',3),(42,'Who is known as the father of supercomputing ?','A) David J. Brown','B) Gene Amdahl','C) Adam Bunkels','D) Seymour Cray','D',3),(43,'When NASSCOM (National Association of Software and Service Companies) was established?','A) 1988','B) 1997','C) 1993','D) 1882','A',3),(44,'Who is known as the father of internet?','A) Alan Perlis','B) Jean E. Sammet','C) Vint Cerf','D) Steve Lawrence','C',3),(45,'Which one is the first high level programming language?','A) C','B) COBOL','C) FORTRAN','D) C++','C',3),(46,'Which one is the first word processor application?','A) MS Word','B) Apple i Work','C) Sun StarOffice','D) WordStar','D',3),(47,'India\'s first Super Computer PARAM 8000 was installed in ?','A) 1991','B) 1995','C) 1988','D) 1982','A',3),(48,'One Terabyte (1 TB) is equal to :','A) 1012 GB','B) 1000 GB','C) 1024 GB','D) 1028 GB','C',3),(49,'Which one of the following is not a special program in MS-Office?','A) Clip Art','B) Word Art','C) Paint Art','D) Office Art','D',3),(50,'Which type of files cannot be navigated using CLip Art Browser?','A) AVI','B) BMP','C) WAV','D) MP3','D',3),(51,'Which one of the following represents the binary equivalent of the decimal number 23 ?','A) 01011','B) 10111','C) 10011','D) 11011','B',3),(52,'You can activate a \"cell\" in ES-Excel by:','A) Clicking the Cell','B) Pressing the Tab Key','C) Pressing an Arrow Key','D) All of the above','C',3),(53,'Who is the founder of Bluetooth ?','A) Ericsson','B) IBM','C) Apple','D) Dell','A',3),(54,'Which one IP address cannot be assign to a computer system in a network ?','A) 192.168.1.1','B) 127.0.0.1','C) 192.1.1.27','D) None of the above','B',3),(55,'What is the port number of SMTP ?','A) 25','B) 28','C) 30','D) 52','A',3),(56,'Which one is an example of connectionless protocols?','A) TCP','B) IPX/SPX','C) Frame Relay','D) UDP','D',3),(57,'Which company bought the popular video teleconferencing software \'Skype\' ?','A) Google','B) Accenture','C) Oracle','D) Microsoft','D',3),(58,'Which of the following is not a web browser ?','A) MOSAIC','B) WWW','C) Facebook','D) Netscape navigator','C',3),(59,'In which year \'@\' sign was first chosen for its use in e-mail address :','A) 1980','B) 1977','C) 1972','D) 1976','D',3),(60,'Which one is the latest one from PARSAM SuperSries computers ?','A) PARAM Yuva II','B) PARAM 10000','C) PARAM Padma','D) PARAMnet','A',3);
/*!40000 ALTER TABLE `cs_questions` ENABLE KEYS */;
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
