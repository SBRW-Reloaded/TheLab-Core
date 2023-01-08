CREATE TABLE `EVENT_DATA_SETUPS` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`hash` VARCHAR(255) NULL DEFAULT NULL,
	`personaId` BIGINT(20) NULL DEFAULT NULL,
	`carId` BIGINT(20) NULL DEFAULT NULL,
	`carSetup` LONGTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

ALTER TABLE `EVENT_DATA`
	ADD COLUMN `eventDataSetupHash` VARCHAR(255) NULL DEFAULT NULL AFTER `speedMedian`;
