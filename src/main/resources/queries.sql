Create Stream DATA_STREAM (
	subscriber varchar,
	patient varchar,
	service varchar,
	acase varchar
) WITH (KAFKA_TOPIC='auth-topic', VALUE_FORMAT='json');

Create Stream SUBSCRIBER WITH (KAFKA_TOPIC='subscriber', VALUE_FORMAT='json') AS
 	SELECT 
	EXTRACTJSONFIELD (subscriber, '$.caseNumber') AS CASE_NUMBER,
	EXTRACTJSONFIELD (subscriber, '$.memberId') AS MEM_ID,
	EXTRACTJSONFIELD (subscriber, '$.firstName') AS MEM_FIRST_NAME,
	EXTRACTJSONFIELD (subscriber, '$.middleName') AS MEM_MIDDLE_NAME,
	EXTRACTJSONFIELD (subscriber, '$.lastName') AS MEM_LAST_NAME,
	EXTRACTJSONFIELD (subscriber, '$.addr1') AS MEM_ADD_1,
	EXTRACTJSONFIELD (subscriber, '$.addr2') AS MEM_ADD_2,
	EXTRACTJSONFIELD (subscriber, '$.city') AS MEM_CITY,
	EXTRACTJSONFIELD (subscriber, '$.pin') AS MEM_PIN
FROM DATA_STREAM;

Create Stream PATIENT WITH (KAFKA_TOPIC='patient', VALUE_FORMAT='json') AS
 	SELECT 
	EXTRACTJSONFIELD (patient, '$.caseNumber') AS CASE_NUMBER,
	EXTRACTJSONFIELD (patient, '$.id') AS PAT_ID,
	EXTRACTJSONFIELD (patient, '$.firstName') AS PAT_FIRST_NAME,
	EXTRACTJSONFIELD (patient, '$.middleName') AS PAT_MIDDLE_NAME,
	EXTRACTJSONFIELD (patient, '$.lastName') AS PAT_LAST_NAME,
	EXTRACTJSONFIELD (patient, '$.sex') AS PAT_SEX,
	EXTRACTJSONFIELD (patient, '$.dob') AS PAT_DOB,
	EXTRACTJSONFIELD (patient, '$.planType') AS PAT_PLAN_TYPE,
	EXTRACTJSONFIELD (patient, '$.planName') AS PAT_PLAN_NAME
FROM DATA_STREAM;

Create Stream SERVICE WITH (KAFKA_TOPIC='service', VALUE_FORMAT='json') AS
 	SELECT 
	EXTRACTJSONFIELD (service, '$.caseNumber') AS CASE_NUMBER,
	EXTRACTJSONFIELD (service, '$.id') AS SVC_ID,
	EXTRACTJSONFIELD (service, '$.type') AS SVC_TYPE,
	EXTRACTJSONFIELD (service, '$.code') AS SVC_CODE,
	EXTRACTJSONFIELD (service, '$.facId') AS SVC_FAC_ID,
	EXTRACTJSONFIELD (service, '$.facName') AS SVC_FAC_NAME,
	EXTRACTJSONFIELD (service, '$.phyId') AS SVC_PHY_ID,
	EXTRACTJSONFIELD (service, '$.phyName') AS SVC_PHY_NAME
FROM DATA_STREAM;

Create Stream CASES WITH (KAFKA_TOPIC='cases', VALUE_FORMAT='json') AS
 	SELECT 
	EXTRACTJSONFIELD (acase, '$.caseNumber') AS CASE_NUMBER,
	EXTRACTJSONFIELD (acase, '$.caseType') AS CASE_TYPE,
	EXTRACTJSONFIELD (acase, '$.code') AS CASE_CODE,
	EXTRACTJSONFIELD (acase, '$.startDate') AS CASE_START_DATE,
	EXTRACTJSONFIELD (acase, '$.endDate') AS CASE_END_DATE,
	EXTRACTJSONFIELD (acase, '$.authType') AS CASE_AUTH_TYPE,
	EXTRACTJSONFIELD (acase, '$.status') AS CASE_STATUS
FROM DATA_STREAM;