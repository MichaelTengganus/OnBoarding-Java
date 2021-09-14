CREATE TABLE `shirts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ProductCode` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Rating` int(11) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;