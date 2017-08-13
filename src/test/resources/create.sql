CREATE TABLE `Book` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Author` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
);