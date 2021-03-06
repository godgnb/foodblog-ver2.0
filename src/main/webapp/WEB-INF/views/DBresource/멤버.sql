--------------------------------------------------------
--  파일이 생성됨 - 목요일-9월-26-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "ADMIN"."MEMBER" 
   (	"ID" VARCHAR2(20 BYTE), 
	"PASSWD" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"PHONE" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"REG_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "ADMIN"."MEMBER"."ID" IS '아이디';
   COMMENT ON COLUMN "ADMIN"."MEMBER"."PASSWD" IS '패스워드';
   COMMENT ON COLUMN "ADMIN"."MEMBER"."NAME" IS '이름';
   COMMENT ON COLUMN "ADMIN"."MEMBER"."PHONE" IS '휴대폰번호';
   COMMENT ON COLUMN "ADMIN"."MEMBER"."EMAIL" IS '이메일';
   COMMENT ON COLUMN "ADMIN"."MEMBER"."REG_DATE" IS '가입날짜';
REM INSERTING into ADMIN.MEMBER
SET DEFINE OFF;
Insert into ADMIN.MEMBER (ID,PASSWD,NAME,PHONE,EMAIL,REG_DATE) values ('aaaaa','12345678','홍길동','01011111111','aaaaa@naver.com',to_date('19/09/24','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."MEMBER_PK" ON "ADMIN"."MEMBER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "ADMIN"."MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("PASSWD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
