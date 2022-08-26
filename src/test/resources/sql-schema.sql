DROP TABLE `order_items`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers`
(
   `id` INT (11) NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR (40) NULL DEFAULT NULL,
   `surname` VARCHAR (40) NULL DEFAULT NULL,
   PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `items`
(
   `id` INT (11) NOT NULL AUTO_INCREMENT,
   `name` VARCHAR (40) NULL DEFAULT NULL,
   `value` DOUBLE NULL DEFAULT NULL,
   PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `orders`
(
   `id` INT (11) UNIQUE NOT NULL AUTO_INCREMENT,
   `customer_id` INT NOT NULL,
   PRIMARY KEY (`id`),
   FOREIGN KEY (`customer_id`) REFERENCES customers (`id`)
);
CREATE TABLE IF NOT EXISTS `order_items`
(
   `id` INT (11) UNIQUE NOT NULL AUTO_INCREMENT,
   `order_id` INT NOT NULL,
   `item_id` INT NOT NULL,
   `quantity` INT NOT NULL,     
   PRIMARY KEY (`id`),
   FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
   FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE
);