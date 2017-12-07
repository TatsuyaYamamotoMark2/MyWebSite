CREATE DATABASE IF NOT EXISTS `music_ec` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `music_ec`;


CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `login_id` varchar(256) UNIQUE NOT NULL,
  `name` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `birth_date` date NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `email` varchar(256) NOT NULL
);

CREATE TABLE `album` (
  `al_id` int(11) NOT NULL,
  `al_name` varchar(256) NOT NULL,
  `image` varchar(256),
  `release_date` date NOT NULL,
  `al_price` int(11)
);

CREATE TABLE `artist` (
  `ar_id` int(11) NOT NULL,
  `ar_name` varchar(256)  NOT NULL
);

CREATE TABLE `music` (
  `m_id` int(11) NOT NULL,
  `al_id` int(11) NOT NULL,
  `ae_id` int(11) NOT NULL,
  `m_name` varchar(256) NOT NULL,
  `m_price` int(11) NOT NULL,
  `DL_path` varchar(256) NOT NULL,
  `mp3` varchar(256),
  `track_no` int(11) NOT NULL
);

CREATE TABLE `buy_history` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `buy_date` date NOT NULL
);

CREATE TABLE `buy_detail` (
  `id` int(11) NOT NULL,
  `buy_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL
);

ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

ALTER TABLE `album`
  ADD PRIMARY KEY (`al_id`);

ALTER TABLE `artist`
  ADD PRIMARY KEY (`ar_id`);

ALTER TABLE `music`
  ADD PRIMARY KEY (`m_id`);

ALTER TABLE `buy_history`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `buy_detail`
  ADD PRIMARY KEY (`id`);



ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `album`
  MODIFY `al_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `artist`
  MODIFY `ar_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `music`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `buy_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `buy_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


insert into `user`(`login_id`, `name`, `password`, `birth_date`, `create_date`, `update_date`, `email`) value ('admin', '管理者', 'password',now(), now(), now(), 'adminmin@gmail.com');
