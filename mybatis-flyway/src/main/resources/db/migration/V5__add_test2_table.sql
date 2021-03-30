CREATE TABLE `t_test2_interrupt`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `interrupt`     varchar(36) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

alter table t_user add column `a2_column` varchar(128) NOT NULL DEFAULT 'a2';