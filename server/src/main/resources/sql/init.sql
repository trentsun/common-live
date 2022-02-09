CREATE TABLE `live_room`
(
    `id`       varchar(10) NOT NULL,
    `room_id`  varchar(20)  DEFAULT NULL,
    `isReplay` varchar(2)   DEFAULT NULL,
    `name`     varchar(20)  DEFAULT NULL,
    `live_url` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user`
(
    `userid`   varchar(10) NOT NULL,
    `username` varchar(255) DEFAULT NULL,
    `sex`      varchar(2)   DEFAULT NULL,
    `age`      int(3) DEFAULT NULL,
    PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `platform`
(
    `id` varchar(10) NOT NUll,
    `name` varchar(20) NOT NULL,
    `icon_url` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8