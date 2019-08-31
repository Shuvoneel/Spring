# ROLE table
CREATE TABLE IF NOT EXISTS role (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       role_name varchar(255) NOT NULL UNIQUE,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# COUNTRY table
CREATE TABLE IF NOT EXISTS country (
                                    id bigint(20) NOT NULL AUTO_INCREMENT,
                                    name varchar(255) NOT NULL UNIQUE,
                                    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# DIVISION table
CREATE TABLE IF NOT EXISTS division (
                                       id bigint(20) NOT NULL AUTO_INCREMENT,
                                       name varchar(255) NOT NULL UNIQUE,
                                       country_id bigint(20),
                                       PRIMARY KEY (id),
                                       CONSTRAINT fk_cnt_div FOREIGN KEY (country_id) REFERENCES country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# DISTRICT table
CREATE TABLE IF NOT EXISTS district (
                                        id bigint(20) NOT NULL AUTO_INCREMENT,
                                        name varchar(255) NOT NULL UNIQUE,
                                        division_id bigint(20),
                                        PRIMARY KEY (id),
                                        CONSTRAINT fk_div_dis FOREIGN KEY (division_id) REFERENCES division(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# CITY table
CREATE TABLE IF NOT EXISTS city (
                                    id bigint(20) NOT NULL AUTO_INCREMENT,
                                    name varchar(255) NOT NULL UNIQUE,
                                    district_id bigint(20),
                                    PRIMARY KEY (id),
                                    CONSTRAINT fk_dis_cit FOREIGN KEY (district_id) REFERENCES district(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Academic Degree
CREATE TABLE IF NOT EXISTS degree (
                                    id bigint(20) NOT NULL AUTO_INCREMENT,
                                    name varchar(255) NOT NULL UNIQUE,
                                    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Company Category
CREATE TABLE IF NOT EXISTS category (
                                      id bigint(20) NOT NULL AUTO_INCREMENT,
                                      name varchar(255) NOT NULL UNIQUE,
                                      PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;