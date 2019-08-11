CREATE TABLE if not exists `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `item_categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `selling_items` (
  `id` bigint(20) NOT NULL,
  `seller_id` bigint(20) NOT NULL,
  `model_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `manufacture_year` integer DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` longtext DEFAULT NULL,
  `price` double DEFAULT NULL,
  `item_condition` varchar(20) NOT NULL,
   item_type varchar(20) DEFAULT NULL,
  `transmission` varchar(50) DEFAULT NULL,
  `fuel_type` varchar(50) DEFAULT NULL,
  `engine_capacity` varchar(15) DEFAULT NULL,
  `millage` bigint(20) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(100) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoaippuobnow3pdjkgglk0y7x5` (`category_id`),
  KEY `FKppnl83wb7hj4y0yyb1haevt28` (`seller_id`),
  KEY `FK2gny171no5f7bjyvmuq23fctj` (`model_id`)
);
