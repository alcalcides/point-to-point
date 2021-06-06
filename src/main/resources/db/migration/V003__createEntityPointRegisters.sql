CREATE TABLE `point_registers` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`people` BIGINT NOT NULL,
	`enterprise` BIGINT NOT NULL,
	`time` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `point_registers` 
	ADD CONSTRAINT `point_registers_fk0` 
	FOREIGN KEY (`people`) 
	REFERENCES `people`(`id`);

ALTER TABLE `point_registers` 
	ADD CONSTRAINT `point_registers_fk1`
	FOREIGN KEY (`enterprise`) 
	REFERENCES `enterprises`(`id`);
