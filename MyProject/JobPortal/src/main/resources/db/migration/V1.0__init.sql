# Create ROLE table
CREATE TABLE IF NOT EXISTS role (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       role_name varchar(50) NOT NULL UNIQUE,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into ROLE table
INSERT INTO role (role_name) VALUES ('ADMIN');
INSERT INTO role (role_name) VALUES ('USER');
INSERT INTO role (role_name) VALUES ('EMPLOYER');
INSERT INTO role (role_name) VALUES ('DEVELOPER');

# -----------------------------------------------------------------------------------------------------------

# Create DEGREE table
CREATE TABLE IF NOT EXISTS degree (
                                       id bigint(20) NOT NULL AUTO_INCREMENT,
                                       name varchar(50) NOT NULL UNIQUE,
                                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into DEGREE table
INSERT INTO degree (name) VALUES ('SSC');
INSERT INTO degree (name) VALUES ('HSC');
INSERT INTO degree (name) VALUES ('Honors');
INSERT INTO degree (name) VALUES ('Masters');
INSERT INTO degree (name) VALUES ('PHD');
INSERT INTO degree (name) VALUES ('Diploma');

# -----------------------------------------------------------------------------------------------------------

# Create COUNTRY table
CREATE TABLE IF NOT EXISTS country (
                                    id bigint(20) NOT NULL AUTO_INCREMENT,
                                    name varchar(50) NOT NULL UNIQUE,
                                    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into COUNTRY table
INSERT INTO country (name) VALUES ('Argentina');
INSERT INTO country (name) VALUES ('Bangladesh');
INSERT INTO country (name) VALUES ('France');
INSERT INTO country (name) VALUES ('Japan');
INSERT INTO country (name) VALUES ('India');

# -----------------------------------------------------------------------------------------------------------

# Create DIVISION table
CREATE TABLE IF NOT EXISTS division (
                                       id bigint(20) NOT NULL AUTO_INCREMENT,
                                       name varchar(50) NOT NULL UNIQUE,
                                       country_id bigint(20),
                                       PRIMARY KEY (id),
                                       CONSTRAINT fk_cnt_div FOREIGN KEY (country_id) REFERENCES country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into DIVISION table
INSERT INTO division (name, country_id) VALUES ('Barishal', 2);
INSERT INTO division (name, country_id) VALUES ('Chattogram', 2);
INSERT INTO division (name, country_id) VALUES ('Dhaka', 2);
INSERT INTO division (name, country_id) VALUES ('Khulna', 2);
INSERT INTO division (name, country_id) VALUES ('Mymensingh', 2);
INSERT INTO division (name, country_id) VALUES ('Rajshahi', 2);
INSERT INTO division (name, country_id) VALUES ('Rangpur', 2);
INSERT INTO division (name, country_id) VALUES ('Sylhet', 2);

# -----------------------------------------------------------------------------------------------------------

# Create DISTRICT table
CREATE TABLE IF NOT EXISTS district (
                                        id bigint(20) NOT NULL AUTO_INCREMENT,
                                        name varchar(50) NOT NULL UNIQUE,
                                        division_id bigint(20),
                                        PRIMARY KEY (id),
                                        CONSTRAINT fk_div_dis FOREIGN KEY (division_id) REFERENCES division(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into DISTRICT table
INSERT INTO district (name, division_id) VALUES ('Barguna', 1);
INSERT INTO district (name, division_id) VALUES ('Barishal', 1);
INSERT INTO district (name, division_id) VALUES ('Bhola', 1);
INSERT INTO district (name, division_id) VALUES ('Jhalokati', 1);
INSERT INTO district (name, division_id) VALUES ('Patuakhali', 1);
INSERT INTO district (name, division_id) VALUES ('Pirojpur', 1);
INSERT INTO district (name, division_id) VALUES ('Bandarban', 2);
INSERT INTO district (name, division_id) VALUES ('Brahmanbaria', 2);
INSERT INTO district (name, division_id) VALUES ('Chandpur', 2);
INSERT INTO district (name, division_id) VALUES ('Chattogram', 2);
INSERT INTO district (name, division_id) VALUES ('Cumilla', 2);
INSERT INTO district (name, division_id) VALUES ('Cox''s Bazar', 2);
INSERT INTO district (name, division_id) VALUES ('Feni', 2);
INSERT INTO district (name, division_id) VALUES ('Khagrachhari', 2);
INSERT INTO district (name, division_id) VALUES ('Lakshmipur', 2);
INSERT INTO district (name, division_id) VALUES ('Noakhali', 2);
INSERT INTO district (name, division_id) VALUES ('Rangamati', 2);
INSERT INTO district (name, division_id) VALUES ('Dhaka', 3);
INSERT INTO district (name, division_id) VALUES ('Faridpur', 3);
INSERT INTO district (name, division_id) VALUES ('Gazipur', 3);
INSERT INTO district (name, division_id) VALUES ('Gopalganj', 3);
INSERT INTO district (name, division_id) VALUES ('Kishoreganj', 3);
INSERT INTO district (name, division_id) VALUES ('Madaripur', 3);
INSERT INTO district (name, division_id) VALUES ('Manikganj', 3);
INSERT INTO district (name, division_id) VALUES ('Munshiganj', 3);
INSERT INTO district (name, division_id) VALUES ('Narayanganj', 3);
INSERT INTO district (name, division_id) VALUES ('Narsingdi', 3);
INSERT INTO district (name, division_id) VALUES ('Rajbari', 3);
INSERT INTO district (name, division_id) VALUES ('Shariatpur', 3);
INSERT INTO district (name, division_id) VALUES ('Tangail', 3);
INSERT INTO district (name, division_id) VALUES ('Bagerhat', 4);
INSERT INTO district (name, division_id) VALUES ('Chuadanga', 4);
INSERT INTO district (name, division_id) VALUES ('Jashore', 4);
INSERT INTO district (name, division_id) VALUES ('Jhenaidah', 4);
INSERT INTO district (name, division_id) VALUES ('Khulna', 4);
INSERT INTO district (name, division_id) VALUES ('Kushtia', 4);
INSERT INTO district (name, division_id) VALUES ('Magura', 4);
INSERT INTO district (name, division_id) VALUES ('Meherpur', 4);
INSERT INTO district (name, division_id) VALUES ('Narail', 4);
INSERT INTO district (name, division_id) VALUES ('Satkhira', 4);
INSERT INTO district (name, division_id) VALUES ('Jamalpur', 5);
INSERT INTO district (name, division_id) VALUES ('Mymensingh', 5);
INSERT INTO district (name, division_id) VALUES ('Netrokona', 5);
INSERT INTO district (name, division_id) VALUES ('Sherpur', 5);
INSERT INTO district (name, division_id) VALUES ('Bogura', 6);
INSERT INTO district (name, division_id) VALUES ('Joypurhat', 6);
INSERT INTO district (name, division_id) VALUES ('Naogaon', 6);
INSERT INTO district (name, division_id) VALUES ('Natore', 6);
INSERT INTO district (name, division_id) VALUES ('Chapainawabganj', 6);
INSERT INTO district (name, division_id) VALUES ('Pabna', 6);
INSERT INTO district (name, division_id) VALUES ('Rajshahi', 6);
INSERT INTO district (name, division_id) VALUES ('Sirajgonj', 6);
INSERT INTO district (name, division_id) VALUES ('Dinajpur', 7);
INSERT INTO district (name, division_id) VALUES ('Gaibandha', 7);
INSERT INTO district (name, division_id) VALUES ('Kurigram', 7);
INSERT INTO district (name, division_id) VALUES ('Lalmonirhat', 7);
INSERT INTO district (name, division_id) VALUES ('Nilphamari', 7);
INSERT INTO district (name, division_id) VALUES ('Panchagarh', 7);
INSERT INTO district (name, division_id) VALUES ('Rangpur', 7);
INSERT INTO district (name, division_id) VALUES ('Thakurgaon', 7);
INSERT INTO district (name, division_id) VALUES ('Habiganj', 8);
INSERT INTO district (name, division_id) VALUES ('Moulvibazar', 8);
INSERT INTO district (name, division_id) VALUES ('Sunamganj', 8);
INSERT INTO district (name, division_id) VALUES ('Sylhet', 8);

# -----------------------------------------------------------------------------------------------------------

# Create CITY table
CREATE TABLE IF NOT EXISTS city (
                                        id bigint(20) NOT NULL AUTO_INCREMENT,
                                        name varchar(50) NOT NULL UNIQUE,
                                        district_id bigint(20),
                                        PRIMARY KEY (id),
                                        CONSTRAINT fk_dis_cit FOREIGN KEY (district_id) REFERENCES district(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# INSERT data into CITY table
INSERT INTO city (name, district_id) VALUES ('Amtali', 1);
INSERT INTO city (name, district_id) VALUES ('Barguna Sadar', 1);
INSERT INTO city (name, district_id) VALUES ('Bamna', 1);
INSERT INTO city (name, district_id) VALUES ('Patharghata', 1);
INSERT INTO city (name, district_id) VALUES ('Taltali', 1);
INSERT INTO city (name, district_id) VALUES ('Agailjhara', 2);
INSERT INTO city (name, district_id) VALUES ('Barishal Sadar', 2);
INSERT INTO city (name, district_id) VALUES ('Hizla', 2);
INSERT INTO city (name, district_id) VALUES ('Muladi', 2);
INSERT INTO city (name, district_id) VALUES ('Wazirpur', 2);
INSERT INTO city (name, district_id) VALUES ('Bhola Sadar', 3);
INSERT INTO city (name, district_id) VALUES ('Char Fasson', 3);
INSERT INTO city (name, district_id) VALUES ('Daulatkhan', 3);
INSERT INTO city (name, district_id) VALUES ('Lalmohan', 3);
INSERT INTO city (name, district_id) VALUES ('Manpura', 3);
INSERT INTO city (name, district_id) VALUES ('Jhalokati Sadar', 4);
INSERT INTO city (name, district_id) VALUES ('Kathalia', 4);
INSERT INTO city (name, district_id) VALUES ('Nalchity', 4);
INSERT INTO city (name, district_id) VALUES ('Rajapur', 4);
INSERT INTO city (name, district_id) VALUES ('Bauphal', 5);
INSERT INTO city (name, district_id) VALUES ('Dumki', 5);
INSERT INTO city (name, district_id) VALUES ('Galachipa', 5);
INSERT INTO city (name, district_id) VALUES ('Kalapara', 5);
INSERT INTO city (name, district_id) VALUES ('Patuakhali Sadar', 5);
INSERT INTO city (name, district_id) VALUES ('Bhandaria', 6);
INSERT INTO city (name, district_id) VALUES ('Kawkhali', 6);
INSERT INTO city (name, district_id) VALUES ('Mathbaria', 6);
INSERT INTO city (name, district_id) VALUES ('Pirojpur Sadar', 6);
INSERT INTO city (name, district_id) VALUES ('Swarupkati', 6);
INSERT INTO city (name, district_id) VALUES ('Ali Kadam', 7);
INSERT INTO city (name, district_id) VALUES ('Bandarban Sadar', 7);
INSERT INTO city (name, district_id) VALUES ('Lama', 7);
INSERT INTO city (name, district_id) VALUES ('Ruma', 7);
INSERT INTO city (name, district_id) VALUES ('Thanchi', 7);
INSERT INTO city (name, district_id) VALUES ('Akhaura', 8);
INSERT INTO city (name, district_id) VALUES ('Brahmanbaria Sadar', 8);
INSERT INTO city (name, district_id) VALUES ('Kasba', 8);
INSERT INTO city (name, district_id) VALUES ('Nasirnagar', 8);
INSERT INTO city (name, district_id) VALUES ('Sarail', 8);
INSERT INTO city (name, district_id) VALUES ('Chandpur Sadar', 9);
INSERT INTO city (name, district_id) VALUES ('Faridganj', 9);
INSERT INTO city (name, district_id) VALUES ('Haimchar', 9);
INSERT INTO city (name, district_id) VALUES ('Kachua', 9);
INSERT INTO city (name, district_id) VALUES ('Matlab', 9);
INSERT INTO city (name, district_id) VALUES ('Anwara', 10);
INSERT INTO city (name, district_id) VALUES ('Hathazari', 10);
INSERT INTO city (name, district_id) VALUES ('Patiya', 10);
INSERT INTO city (name, district_id) VALUES ('Sandwip', 10);
INSERT INTO city (name, district_id) VALUES ('Sitakunda', 10);
INSERT INTO city (name, district_id) VALUES ('Burichang', 11);
INSERT INTO city (name, district_id) VALUES ('Chauddagram', 11);
INSERT INTO city (name, district_id) VALUES ('Homna', 11);
INSERT INTO city (name, district_id) VALUES ('Laksam', 11);
INSERT INTO city (name, district_id) VALUES ('Muradnagar', 11);
INSERT INTO city (name, district_id) VALUES ('Cox''s Bazar Sadar', 12);
INSERT INTO city (name, district_id) VALUES ('Kutubdia', 12);
INSERT INTO city (name, district_id) VALUES ('Maheshkhali', 12);
INSERT INTO city (name, district_id) VALUES ('Ramu', 12);
INSERT INTO city (name, district_id) VALUES ('Teknaf', 12);
INSERT INTO city (name, district_id) VALUES ('Chhagalnaiya', 13);
INSERT INTO city (name, district_id) VALUES ('Daganbhuiyan', 13);
INSERT INTO city (name, district_id) VALUES ('Feni Sadar', 13);
INSERT INTO city (name, district_id) VALUES ('Parshuram', 13);
INSERT INTO city (name, district_id) VALUES ('Sonagazi', 13);
INSERT INTO city (name, district_id) VALUES ('Khagrachhari', 14);
INSERT INTO city (name, district_id) VALUES ('Lakshmichhari', 14);
INSERT INTO city (name, district_id) VALUES ('Manikchhari', 14);
INSERT INTO city (name, district_id) VALUES ('Panchhari', 14);
INSERT INTO city (name, district_id) VALUES ('Ramgarh', 14);
INSERT INTO city (name, district_id) VALUES ('Kamalnagar', 15);
INSERT INTO city (name, district_id) VALUES ('Lakshmipur Sadar', 15);
INSERT INTO city (name, district_id) VALUES ('Raipur', 15);
INSERT INTO city (name, district_id) VALUES ('Ramganj', 15);
INSERT INTO city (name, district_id) VALUES ('Ramgati', 15);
INSERT INTO city (name, district_id) VALUES ('Begumganj', 16);
INSERT INTO city (name, district_id) VALUES ('Companiganj', 16);
INSERT INTO city (name, district_id) VALUES ('Noakhali Sadar', 16);
INSERT INTO city (name, district_id) VALUES ('Hatiya', 16);
INSERT INTO city (name, district_id) VALUES ('Subarnachar', 16);
INSERT INTO city (name, district_id) VALUES ('Bagaichhari', 17);
INSERT INTO city (name, district_id) VALUES ('Betbunia', 17);
INSERT INTO city (name, district_id) VALUES ('Juraichhari', 17);
INSERT INTO city (name, district_id) VALUES ('Kaptai', 17);
INSERT INTO city (name, district_id) VALUES ('Rangamati Sadar', 17);
INSERT INTO city (name, district_id) VALUES ('Dhamrai', 18);
INSERT INTO city (name, district_id) VALUES ('Dohar', 18);
INSERT INTO city (name, district_id) VALUES ('Keraniganj', 18);
INSERT INTO city (name, district_id) VALUES ('Savar', 18);
INSERT INTO city (name, district_id) VALUES ('Tejgaon Circle', 18);
INSERT INTO city (name, district_id) VALUES ('Alfadanga', 19);
INSERT INTO city (name, district_id) VALUES ('Bhanga', 19);
INSERT INTO city (name, district_id) VALUES ('Boalmari', 19);
INSERT INTO city (name, district_id) VALUES ('Faridpur', 19);
INSERT INTO city (name, district_id) VALUES ('Nagarkanda', 19);
INSERT INTO city (name, district_id) VALUES ('Gazipur Sadar', 20);
INSERT INTO city (name, district_id) VALUES ('Kaliakair', 20);
INSERT INTO city (name, district_id) VALUES ('Kapasia', 20);
INSERT INTO city (name, district_id) VALUES ('Sreepur', 20);
INSERT INTO city (name, district_id) VALUES ('Gopalganj Sadar', 21);
INSERT INTO city (name, district_id) VALUES ('Kashiani', 21);
INSERT INTO city (name, district_id) VALUES ('Kotalipara', 21);
INSERT INTO city (name, district_id) VALUES ('Muksudpur', 21);
INSERT INTO city (name, district_id) VALUES ('Tungipara', 21);
INSERT INTO city (name, district_id) VALUES ('Austagram', 22);
INSERT INTO city (name, district_id) VALUES ('Bhairab', 22);
INSERT INTO city (name, district_id) VALUES ('Itna', 22);
INSERT INTO city (name, district_id) VALUES ('Kishoreganj Sadar', 22);
INSERT INTO city (name, district_id) VALUES ('Pakundia', 22);
INSERT INTO city (name, district_id) VALUES ('Kalkini', 23);
INSERT INTO city (name, district_id) VALUES ('Madaripur Sadar', 23);
INSERT INTO city (name, district_id) VALUES ('Rajoir', 23);
INSERT INTO city (name, district_id) VALUES ('Shibchar', 23);
INSERT INTO city (name, district_id) VALUES ('Daulatpur', 24);
INSERT INTO city (name, district_id) VALUES ('Ghior', 24);
INSERT INTO city (name, district_id) VALUES ('Harirampur', 24);
INSERT INTO city (name, district_id) VALUES ('Manikganj Sadar', 24);
INSERT INTO city (name, district_id) VALUES ('Saturia', 24);
INSERT INTO city (name, district_id) VALUES ('Gazaria', 25);
INSERT INTO city (name, district_id) VALUES ('Lohajang', 25);
INSERT INTO city (name, district_id) VALUES ('Munshiganj Sadar', 25);
INSERT INTO city (name, district_id) VALUES ('Sirajdikhan', 25);
INSERT INTO city (name, district_id) VALUES ('Tongibari', 25);
INSERT INTO city (name, district_id) VALUES ('Araihazar', 26);
INSERT INTO city (name, district_id) VALUES ('Bandar', 26);
INSERT INTO city (name, district_id) VALUES ('Narayanganj Sadar', 26);
INSERT INTO city (name, district_id) VALUES ('Rupganj', 26);
INSERT INTO city (name, district_id) VALUES ('Sonargaon', 26);
INSERT INTO city (name, district_id) VALUES ('Belabo', 27);
INSERT INTO city (name, district_id) VALUES ('Narsingdi Sadar', 27);
INSERT INTO city (name, district_id) VALUES ('Palash', 27);
INSERT INTO city (name, district_id) VALUES ('Raipura', 27);
INSERT INTO city (name, district_id) VALUES ('Shibpur', 27);
INSERT INTO city (name, district_id) VALUES ('Baliakandi', 28);
INSERT INTO city (name, district_id) VALUES ('Goalandaghat', 28);
INSERT INTO city (name, district_id) VALUES ('Pangsha', 28);
INSERT INTO city (name, district_id) VALUES ('Kalukhali', 28);
INSERT INTO city (name, district_id) VALUES ('Rajbari Sadar', 28);
INSERT INTO city (name, district_id) VALUES ('Bhedarganj', 29);
INSERT INTO city (name, district_id) VALUES ('Damudya', 29);
INSERT INTO city (name, district_id) VALUES ('Gosairhat', 29);
INSERT INTO city (name, district_id) VALUES ('Shariatpur Sadar', 29);
INSERT INTO city (name, district_id) VALUES ('Zajira', 29);
INSERT INTO city (name, district_id) VALUES ('Basail', 30);
INSERT INTO city (name, district_id) VALUES ('Ghatail', 30);
INSERT INTO city (name, district_id) VALUES ('Kalihati', 30);
INSERT INTO city (name, district_id) VALUES ('Sakhipur', 30);
INSERT INTO city (name, district_id) VALUES ('Tangail Sadar', 30);
INSERT INTO city (name, district_id) VALUES ('Bagerhat Sadar', 31);
INSERT INTO city (name, district_id) VALUES ('Chitalmari', 31);
INSERT INTO city (name, district_id) VALUES ('Fakirhat', 31);
INSERT INTO city (name, district_id) VALUES ('Mongla', 31);
INSERT INTO city (name, district_id) VALUES ('Rampal', 31);
INSERT INTO city (name, district_id) VALUES ('Alamdanga', 32);
INSERT INTO city (name, district_id) VALUES ('Chuadanga Sadar', 32);
INSERT INTO city (name, district_id) VALUES ('Damurhuda', 32);
INSERT INTO city (name, district_id) VALUES ('Jibannagar', 32);
INSERT INTO city (name, district_id) VALUES ('Abhaynagar', 33);
INSERT INTO city (name, district_id) VALUES ('Chaugachha', 33);
INSERT INTO city (name, district_id) VALUES ('Jhikargachha', 33);
INSERT INTO city (name, district_id) VALUES ('Keshabpur', 33);
INSERT INTO city (name, district_id) VALUES ('Sharsha', 33);
INSERT INTO city (name, district_id) VALUES ('Harinakunda', 34);
INSERT INTO city (name, district_id) VALUES ('Kotchandpur', 34);
INSERT INTO city (name, district_id) VALUES ('Maheshpur', 34);
INSERT INTO city (name, district_id) VALUES ('Shailkupa', 34);
INSERT INTO city (name, district_id) VALUES ('Dacope', 35);
INSERT INTO city (name, district_id) VALUES ('Dighalia', 35);
INSERT INTO city (name, district_id) VALUES ('Koyra', 35);
INSERT INTO city (name, district_id) VALUES ('Paikgachha', 35);
INSERT INTO city (name, district_id) VALUES ('Rupsha', 35);
INSERT INTO city (name, district_id) VALUES ('Bheramara', 36);
INSERT INTO city (name, district_id) VALUES ('Khoksa', 36);
INSERT INTO city (name, district_id) VALUES ('Kumarkhali', 36);
INSERT INTO city (name, district_id) VALUES ('Mirpur', 36);
INSERT INTO city (name, district_id) VALUES ('Magura Sadar', 37);
INSERT INTO city (name, district_id) VALUES ('Mohammadpur', 37);
INSERT INTO city (name, district_id) VALUES ('Shalikha', 37);
INSERT INTO city (name, district_id) VALUES ('Gangni', 38);
INSERT INTO city (name, district_id) VALUES ('Meherpur Sadar', 38);
INSERT INTO city (name, district_id) VALUES ('Mujibnagar', 38);
INSERT INTO city (name, district_id) VALUES ('Kalia', 39);
INSERT INTO city (name, district_id) VALUES ('Lohagara', 39);
INSERT INTO city (name, district_id) VALUES ('Narail Sadar', 39);
INSERT INTO city (name, district_id) VALUES ('Naragati', 39);
INSERT INTO city (name, district_id) VALUES ('Assasuni', 40);
INSERT INTO city (name, district_id) VALUES ('Debhata', 40);
INSERT INTO city (name, district_id) VALUES ('Kalaroa', 40);
INSERT INTO city (name, district_id) VALUES ('Tala', 40);
INSERT INTO city (name, district_id) VALUES ('Baksiganj', 41);
INSERT INTO city (name, district_id) VALUES ('Dewanganj', 41);
INSERT INTO city (name, district_id) VALUES ('Islampur', 41);
INSERT INTO city (name, district_id) VALUES ('Jamalpur Sadar', 41);
INSERT INTO city (name, district_id) VALUES ('Sarishabari', 41);
INSERT INTO city (name, district_id) VALUES ('Fulbaria', 42);
INSERT INTO city (name, district_id) VALUES ('Gafargaon', 42);
INSERT INTO city (name, district_id) VALUES ('Mymensingh Sadar', 42);
INSERT INTO city (name, district_id) VALUES ('Muktagachha', 42);
INSERT INTO city (name, district_id) VALUES ('Trishal', 42);
INSERT INTO city (name, district_id) VALUES ('Atpara', 43);
INSERT INTO city (name, district_id) VALUES ('Barhatta', 43);
INSERT INTO city (name, district_id) VALUES ('Durgapur', 43);
INSERT INTO city (name, district_id) VALUES ('Netrokona Sadar', 43);
INSERT INTO city (name, district_id) VALUES ('Madan', 43);
INSERT INTO city (name, district_id) VALUES ('Jhenaigati', 44);
INSERT INTO city (name, district_id) VALUES ('Nakla', 44);
INSERT INTO city (name, district_id) VALUES ('Nalitabari', 44);
INSERT INTO city (name, district_id) VALUES ('SherpurSadar', 44);
INSERT INTO city (name, district_id) VALUES ('Sreebardi', 44);
INSERT INTO city (name, district_id) VALUES ('Adamdighi', 45);
INSERT INTO city (name, district_id) VALUES ('Bogura Sadar', 45);
INSERT INTO city (name, district_id) VALUES ('Dhunat', 45);
INSERT INTO city (name, district_id) VALUES ('Kahaloo', 45);
INSERT INTO city (name, district_id) VALUES ('Sonatola', 45);
INSERT INTO city (name, district_id) VALUES ('Akkelpur', 46);
INSERT INTO city (name, district_id) VALUES ('Joypurhat Sadar', 46);
INSERT INTO city (name, district_id) VALUES ('Kalai', 46);
INSERT INTO city (name, district_id) VALUES ('Khetlal', 46);
INSERT INTO city (name, district_id) VALUES ('Panchbibi', 46);
INSERT INTO city (name, district_id) VALUES ('Atrai', 47);
INSERT INTO city (name, district_id) VALUES ('Badalgachhi', 47);
INSERT INTO city (name, district_id) VALUES ('Dhamoirhat', 47);
INSERT INTO city (name, district_id) VALUES ('Naogaon Sadar', 47);
INSERT INTO city (name, district_id) VALUES ('Patnitala', 47);
INSERT INTO city (name, district_id) VALUES ('Baraigram', 48);
INSERT INTO city (name, district_id) VALUES ('Gurudaspur', 48);
INSERT INTO city (name, district_id) VALUES ('Lalpur', 48);
INSERT INTO city (name, district_id) VALUES ('Natore Sadar', 48);
INSERT INTO city (name, district_id) VALUES ('Singra', 48);
INSERT INTO city (name, district_id) VALUES ('Bholahat', 49);
INSERT INTO city (name, district_id) VALUES ('Gomastapur', 49);
INSERT INTO city (name, district_id) VALUES ('Nachole', 49);
INSERT INTO city (name, district_id) VALUES ('Chapainawabganj Sadar', 49);
INSERT INTO city (name, district_id) VALUES ('Shibganj', 49);
INSERT INTO city (name, district_id) VALUES ('Atgharia', 50);
INSERT INTO city (name, district_id) VALUES ('Bera', 50);
INSERT INTO city (name, district_id) VALUES ('Chatmohar', 50);
INSERT INTO city (name, district_id) VALUES ('Ishwardi', 50);
INSERT INTO city (name, district_id) VALUES ('Pabna Sadar', 50);
INSERT INTO city (name, district_id) VALUES ('Bagha', 51);
INSERT INTO city (name, district_id) VALUES ('Bagmara', 51);
INSERT INTO city (name, district_id) VALUES ('Charghat', 51);
INSERT INTO city (name, district_id) VALUES ('Mohanpur', 51);
INSERT INTO city (name, district_id) VALUES ('Tanore', 51);
INSERT INTO city (name, district_id) VALUES ('Belkuchi', 52);
INSERT INTO city (name, district_id) VALUES ('Kamarkhanda', 52);
INSERT INTO city (name, district_id) VALUES ('Kazipur', 52);
INSERT INTO city (name, district_id) VALUES ('Shahjadpur', 52);
INSERT INTO city (name, district_id) VALUES ('Tarash', 52);
INSERT INTO city (name, district_id) VALUES ('Birampur', 53);
INSERT INTO city (name, district_id) VALUES ('Biral', 53);
INSERT INTO city (name, district_id) VALUES ('Chirirbandar', 53);
INSERT INTO city (name, district_id) VALUES ('Dinajpur Sadar', 53);
INSERT INTO city (name, district_id) VALUES ('Parbatipur', 53);
INSERT INTO city (name, district_id) VALUES ('Gaibandha Sadar', 54);
INSERT INTO city (name, district_id) VALUES ('Gobindaganj', 54);
INSERT INTO city (name, district_id) VALUES ('Palashbari', 54);
INSERT INTO city (name, district_id) VALUES ('Sadullapur', 54);
INSERT INTO city (name, district_id) VALUES ('Sundarganj', 54);
INSERT INTO city (name, district_id) VALUES ('Bhurungamari', 55);
INSERT INTO city (name, district_id) VALUES ('Chilmari', 55);
INSERT INTO city (name, district_id) VALUES ('Kurigram Sadar', 55);
INSERT INTO city (name, district_id) VALUES ('Rajarhat', 55);
INSERT INTO city (name, district_id) VALUES ('Ulipur', 55);
INSERT INTO city (name, district_id) VALUES ('Aditmari', 56);
INSERT INTO city (name, district_id) VALUES ('Hatibandha', 56);
INSERT INTO city (name, district_id) VALUES ('Lalmonirhat Sadar', 56);
INSERT INTO city (name, district_id) VALUES ('Patgram', 56);
INSERT INTO city (name, district_id) VALUES ('Dimla', 57);
INSERT INTO city (name, district_id) VALUES ('Jaldhaka', 57);
INSERT INTO city (name, district_id) VALUES ('Kishoreganj', 57);
INSERT INTO city (name, district_id) VALUES ('Nilphamari Sadar', 57);
INSERT INTO city (name, district_id) VALUES ('Saidpur', 57);
INSERT INTO city (name, district_id) VALUES ('Atwari', 58);
INSERT INTO city (name, district_id) VALUES ('Boda', 58);
INSERT INTO city (name, district_id) VALUES ('Debiganj', 58);
INSERT INTO city (name, district_id) VALUES ('Panchagarh Sadar', 58);
INSERT INTO city (name, district_id) VALUES ('Tetulia', 58);
INSERT INTO city (name, district_id) VALUES ('Badarganj', 59);
INSERT INTO city (name, district_id) VALUES ('Gangachhara', 59);
INSERT INTO city (name, district_id) VALUES ('Kaunia', 59);
INSERT INTO city (name, district_id) VALUES ('Pirganj', 59);
INSERT INTO city (name, district_id) VALUES ('Rangpur Sadar', 59);
INSERT INTO city (name, district_id) VALUES ('Baliadangi', 60);
INSERT INTO city (name, district_id) VALUES ('Haripur', 60);
INSERT INTO city (name, district_id) VALUES ('Ranisankail', 60);
INSERT INTO city (name, district_id) VALUES ('Thakurgaon Sadar', 60);
INSERT INTO city (name, district_id) VALUES ('Ajmiriganj', 61);
INSERT INTO city (name, district_id) VALUES ('Baniyachong', 61);
INSERT INTO city (name, district_id) VALUES ('Chunarughat', 61);
INSERT INTO city (name, district_id) VALUES ('Madhabpur', 61);
INSERT INTO city (name, district_id) VALUES ('Sayestaganj', 61);
INSERT INTO city (name, district_id) VALUES ('Barlekha', 62);
INSERT INTO city (name, district_id) VALUES ('Kamalganj', 62);
INSERT INTO city (name, district_id) VALUES ('Kulaura', 62);
INSERT INTO city (name, district_id) VALUES ('Moulvibazar Sadar', 62);
INSERT INTO city (name, district_id) VALUES ('Sreemangal', 62);
INSERT INTO city (name, district_id) VALUES ('Bishwamvarpur', 63);
INSERT INTO city (name, district_id) VALUES ('Chhatak', 63);
INSERT INTO city (name, district_id) VALUES ('Dharamapasha', 63);
INSERT INTO city (name, district_id) VALUES ('Jagannathpur', 63);
INSERT INTO city (name, district_id) VALUES ('Tahirpur', 63);
INSERT INTO city (name, district_id) VALUES ('Beanibazar', 64);
INSERT INTO city (name, district_id) VALUES ('Companigonj', 64);
INSERT INTO city (name, district_id) VALUES ('Jaintiapur', 64);
INSERT INTO city (name, district_id) VALUES ('Osmani Nagar', 64);
INSERT INTO city (name, district_id) VALUES ('Zakiganj', 64);

# -----------------------------------------------------------------------------------------------------------