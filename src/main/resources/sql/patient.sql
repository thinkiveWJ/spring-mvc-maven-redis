#病人信息表
#sex（性别：0-男；1-女；）
CREATE TABLE IF NOT EXISTS patient(
  id_card VARCHAR(100) NOT NULL,
  sex INT(1) NOT NULL,
  birthday DATE,
  update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY ( id_card )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#tempDic：0-36度以下 1-36~37度 2-37~38度 3-38~39度 4-39度以上

#新增时间戳
alter table patient add `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP;

#新增是否在院 1-在院 0-离院 hospitalization
alter table patient add hospitalization int default 1;

#新增体温字段
alter table patient add temp DECIMAL(3,1) NOT NULL;
#新增位置字段
alter table patient add position VARCHAR(20) NOT NULL;


INSERT INTO patient (id_card, sex , birthday ,name)
                       VALUES
                       ( '412826199111116610', 0, '19911111', '张三' );
INSERT INTO patient (id_card, sex , birthday ,name)
                       VALUES
                       ( '412826199111116612', 0, '1998-01-22', '王二' );

INSERT INTO patient (id_card, sex , birthday ,name)
                       VALUES
                       ( '41282619911111661X', 0, '1991-11-12', '李四' );

#体温表
#temp摄氏度℃
CREATE TABLE IF NOT EXISTS patient_temperature(
  id VARCHAR(100) NOT NULL,
  temp DECIMAL(3,1) NOT NULL,
  update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into patient_temperature(id, temp)
  select id_card,sex from patient

#位置表
CREATE TABLE IF NOT EXISTS patient_position(
  id VARCHAR(100) NOT NULL,
  position VARCHAR(20) NOT NULL,
  update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#查询出病人的信息以及其体温
select p.id_card, p.sex, p.name, p.birthday, t.temp  from patient p, patient_temperature t
where p.id_card = t.id