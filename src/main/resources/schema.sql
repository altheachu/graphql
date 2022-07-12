CREATE TABLE IF NOT EXISTS location (
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(40) NOT NULL,
  address VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
);