INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `ims`.`items` (`name`, `value`) VALUES ('The lord of the rings', 14.96);

INSERT INTO `ims`.`orders` (`customer_id`) VALUES (1);

INSERT INTO `ims`.`order_items` (`order_id`, `item_id`, `quantity`) VALUES (1, 1, 2);
