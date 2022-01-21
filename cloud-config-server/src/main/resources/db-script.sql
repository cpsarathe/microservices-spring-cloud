CREATE TABLE `properties` (
                              `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                              `CREATED_DATE` datetime DEFAULT NULL,
                              `UPDATED_DATE` datetime DEFAULT NULL,
                              `APPLICATION` text,
                              `PROFILE` text,
                              `LABEL` text,
                              `PROP_KEY` text,
                              `VALUE` text,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


INSERT INTO `cloud-config-server`.`properties` (`CREATED_DATE`, `UPDATED_DATE`, `APPLICATION`, `PROFILE`, `LABEL`, `PROP_KEY`, `VALUE`) VALUES (now(), now(), 'cloud-config-server', 'jdbc', 'latest', 'hello', 'hello');
INSERT INTO `cloud-config-server`.`properties` (`CREATED_DATE`, `UPDATED_DATE`, `APPLICATION`, `PROFILE`, `LABEL`, `PROP_KEY`, `VALUE`) VALUES (now(), now(), 'user-ws', 'jdbc', 'latest', 'user.message', 'cp');
INSERT INTO `cloud-config-server`.`properties` (`CREATED_DATE`, `UPDATED_DATE`, `APPLICATION`, `PROFILE`, `LABEL`, `PROP_KEY`, `VALUE`) VALUES (now(), now(), 'user-ws', 'dev', 'latest', 'user.message', 'vihaan');

