CREATE TABLE `t_user`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `c_user_id`     varchar(36) NOT NULL DEFAULT '',
    `c_name`        varchar(22) NOT NULL DEFAULT '',
    `c_province_id` int(11)     NOT NULL,
    `c_city_id`     int(11)     NOT NULL,
    `create_time`   datetime    NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`c_user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE tmp_table
(
    id INT,
    PRIMARY KEY (id)
);