CREATE SCHEMA IF NOT EXISTS test_db DEFAULT CHARSET UTF8MB4 COLLATE UTF8MB4_BIN;
USE test_db;

DROP TABLE IF EXISTS t_company_path;
DROP TABLE IF EXISTS t_company_affiliation;
DROP TABLE IF EXISTS t_company;

CREATE TABLE IF NOT EXISTS t_company
(
    id        INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
    name      VARCHAR(255) NOT NULL COMMENT '公司名称',
    parent_id INT(11)      NOT NULL DEFAULT 0 COMMENT '父级id',
    UNIQUE (name),
    INDEX (parent_id)
) ENGINE = INNODB
  DEFAULT COLLATE = UTF8MB4_BIN COMMENT '公司表';

CREATE TABLE IF NOT EXISTS t_company_affiliation
(
    id          INT(11)    NOT NULL COMMENT '公司id',
    paternal_id INT(11)    NOT NULL COMMENT '父系id',
    gen         TINYINT(2) NOT NULL DEFAULT 1 COMMENT '隔代系数',
    UNIQUE (id, paternal_id),
    FOREIGN KEY (id) REFERENCES t_company (id),
    FOREIGN KEY (paternal_id) REFERENCES t_company (id)
) ENGINE = INNODB
  DEFAULT COLLATE = UTF8MB4_BIN COMMENT '公司父级关系表';

CREATE TABLE IF NOT EXISTS t_company_path
(
    id   INT(11) PRIMARY KEY COMMENT '公司id',
    path VARCHAR(255) NOT NULL COMMENT '绝对路径',
    UNIQUE (path),
    FOREIGN KEY (id) REFERENCES t_company (id)
) ENGINE = INNODB
  DEFAULT COLLATE = UTF8MB4_BIN COMMENT '公司的路径表';