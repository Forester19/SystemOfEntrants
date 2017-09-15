CREATE TABLE questionnareForAdmin (
  id                 INT          NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  firstName          VARCHAR(255) NOT NULL,
  lastName           VARCHAR(255) NOT NULL,
  email              VARCHAR(255) NOT NULL,
  faculty            VARCHAR(255) NOT NULL,
  mathScope          INT          NOT NULL,
  ukrainianLangScope INT          NOT NULL
)