-- [cohort_id] - id of students cohort

-- student@mail.com - "cohort 34.2" -> select from table "cohort"

-- student2@mail.com - "cohort 35"  -> select from table "cohort", to add second cohort "cohort 36"
-- you have to execute src/test/resources/sql/student_cohort.sql

INSERT INTO account (country, email, password_hash, first_name, last_name, is_active, phone, role, state)
    VALUES ("Germany","admin@mail.com","$2a$10$ZRBVssy0mqXLL1Wv80LaROywrAWdW1mo0.8IAfKrxiswmcBlE1bai",
            "Jhon","Admin",true,"+490577777777","ADMIN","CONFIRMED");

INSERT INTO account (country, email, password_hash, first_name, last_name, is_active, phone, role, state)
    VALUES ("Germany","teacher@mail.com","$2a$10$lIVNxb6bl2Uas/bOz6LdAetYzzSfTRIFx4iJS9fR5u1XqkLujcApS","Teacher",
            "Testteach",true,"+401871234567","TEACHER","CONFIRMED");

INSERT INTO account (country, email, password_hash, first_name, last_name, is_active, phone, role, state)
    VALUES ("Germany","student2@mail.com","$2a$10$humjffaz25vyY1zmB2FwuONfXnIuN7AKyTJ4nhBAzXG7WfMeLyc9i","Student",
            "Test",true,"+490571234567","STUDENT","CONFIRMED",[cohort_id]);

INSERT INTO account (country, email, password_hash, first_name, last_name, is_active, phone, role, state)
    VALUES ("Germany","student@mail.com","$2a$10$9QI9ukaxgJTEYMTeuezGKundlfK9pc9WiHmNyQQvxmxaaNyF9y4ca","Student",
            "Test",true,"+490571234567","STUDENT","CONFIRMED",[cohort_id]);

