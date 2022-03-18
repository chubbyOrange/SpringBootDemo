-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: book_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  `title` varchar(96) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `year` int DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (201,'余华','活着',59.7,2012,'生的苦难与伟大'),(202,'加西亚·马尔克斯','百年孤独',39.5,2011,'魔幻现实主义文学代表作'),(203,'玛格丽特·米切尔','飘',40,2000,'革命时期的爱情，随风而逝'),(204,'乔治·奥威尔','1984',28,2010,'栗树荫下，我出卖你，你出卖我'),(205,'东野圭吾','白夜行',29.8,2008,'暗夜独行的残破灵魂，爱与恶本就难分难舍'),(206,'圣埃克苏佩里','小王子',22,2003,'献给长成了大人的孩子们'),(207,'乔治·奥威尔','动物农场',10,2007,'太阳底下并无新事'),(208,'三毛','撒哈拉的故事',15.8,2003,'游荡的自由灵魂'),(209,'金庸','天龙八部',96,1994,'有情皆孽，无人不冤'),(210,'钱钟书','围城',19,1991,'幽默的语言和对生活深刻的观察'),(211,'卡勒德·胡赛尼','追风筝的人',29,2006,'为你，千千万万遍'),(212,'加西亚·马尔克斯','霍乱时期的爱情',39.5,2012,'义无反顾地直达爱情的核心'),(213,'阿尔贝·加缪','局外人',22,2010,'人生在世，永远也不该演戏作假'),(214,'王小波','沉默的大多数',27,1997,'沉默是沉默者的通行证'),(215,'毛姆','月亮和六便士',15,2006,'有多少人会经历顿悟，就有更少的人甘愿自我放逐'),(216,'尤瓦尔·赫拉利','人类简史',68,2014,'跟着人类一同走过十万年');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-18 15:01:15
