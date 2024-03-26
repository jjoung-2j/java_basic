-- upper, lower, initcap
select upper('aBcdEF aBcdEF')
     , lower('aBcdEF aBcdEF')
     , initcap('aBcdEF aBcdEF')
from dual;

-- substr
select '쫑쫑이 쫑쫑이'
	, substr('쫑쫑이 쫑쫑이', 2, 5)
    , substr('쫑쫑이 쫑쫑이', 5)
from dual;

-- instr
select instr('STUDYstudySTUDYSTUDYsTUDY','STUDY',1,3)
     , instr('STUDYstudySTUDYSTUDYsTUDY','STUDY',3)
from dual;

-- reverse
select reverse(substr(reverse('c:\m\resume.hwp'), 1,
	instr(reverse('c:\m\resume.hwp'),'\',1) - 1)) as filename
-- instr(reverse(filepath),'/',1)
-- filepath를 거꾸로 나열한 것에서 '/' 의 위치 찾기

-- substr(reverse(filepath), 1
-- ,reverse(filepath)에서 첫번째로 '/'이 나오는 위치 -1)

-- reverse ( ) : 뒤집혀서 정리된 것을 최종으로 뒤집어 두기
from dual;

-- lpad, rpad
select lpad('최고최고!',15,'@')
	, rpad('최고최고!',15,0)
from dual;
-- 한글 2byte, 영어 및 특수문자 1byte

-- ltrim, rtrim
select ltrim('abcdababcdabccccaZZabcaaadd','abcd')
	, rtrim('abcdababcdabccccaZZabcaaadd','abcd')
    , rtrim(ltrim('abcdababcdabccccaZZabcaaadd','abcd'),'d')
from dual;

-- translate, replace
select translate('010-0012-1203', '00', '영영')
	, replace('010-0012-1203', '00', '영영')
from dual;

-- mod, round, trunc
select 5/2, mod(5,2)
	, round(987.65,1), round(987.65,0), round(987.65,-1)
    , trunc(987.65,1), trunc(987.65,0), trunc(987.65,-1)
from dual;

-- ceil, floor
select ceil(1.1), ceil(1), ceil(-1.1)
	, floor(1.1), floor(1), floor(-1.1)
from dual;

-- add_day, add_months
select sysdate + 1, sysdate - 2
	, add_months(sysdate,1), add_months(sysdate,-2)
from dual;

-- extract
select sysdate
        , extract(year from sysdate)
        , extract(month from sysdate)
        , extract(day from sysdate)
from dual;

-- next_day
select sysdate, next_day(sysdate,'일')
	, next_day(sysdate,'수')
from dual;

-- to_yminterval, dsinterval
select sysdate
        , sysdate + to_yminterval('01-02') + to_dsinterval('003 04:05:06')
        -- 1-2 도 가능하지만 01-02를 권장            3 4:5:6도 가능 하지만 003 04:05:06 을 권장
from dual;

-- to_char('날짜','형태')
select to_char(sysdate,'yyyy-mm-dd')
	, to_char(sysdate, 'am hh:mi:ss')
    , to_char(sysdate, 'q')
    , to_char(sysdate,'day')
    , to_char(sysdate, 'dy')
from dual;

-- to_char(숫자,'형태')
select to_char(12345,'99,999')
	, to_char(12345,'$99,999')
    , to_char(12345,'L99,999')
    , to_char(0.12,'9.99')
    , to_char(0.12,'0.00')
from dual;

-- 만나이, 정년퇴직일
-- 만나이 => 올해 생일이 미래이면 이번년도 - 태어난년도 - 1
-- 정년퇴직일 기준 : 63세 퇴직, 03~08 : 8월 말 09~02 : 2월 말
-- => 생일에따라 0801, 0201 로 구분한 후, 퇴직년도 : add_months(현재,(63-만나이)*12) 와 합치고
-- last_day 를 통해 월 말 계산하기
SELECT fullname as 사원명
	, rpad(substr(jubun,1,6),13,'*') as 주민번호
    , age as "현재 나이"
    , last_day(to_date
    (
    to_char(add_months(sysdate,(63-age)*12),'yyyy')
    ||
    case when substr(jubun,3,2) between '03' and '08'
    then '0801'
    else '0201'
    end
    ,'yyyy-mm-dd')) as retire_day	-- 정년퇴직일
FROM
(
  SELECT fullname, jubun
      , case when birthday_this_year
      > to_date(to_char(sysdate,'yyyymmdd'),'yyyymmdd')
      then extract(year from sysdate) - birthyear - 1
      else extract(year from sysdate) - birthyear
      end as age	-- 만나이
  FROM
  (
      select first_name || ' ' || last_name as fullname
          , jubun

          , to_date(to_char(sysdate,'yyyy')
       || substr(jubun,3,4),'yyyymmdd')
       as birthday_this_year		-- 올해생일
          , case when substr(jubun,7,1) in('1','2')
              then '19' else '20'
              end || substr(jubun,1,2) as birthyear -- 태어난 년도
      from EMPLOYEES
  ) A
) B;

-- WITH 절을 이용한 inline view ( 만나이 )
WITH
A AS
(
    select first_name || ' ' || last_name as fullname
          , jubun

          , to_date(to_char(sysdate,'yyyy')
       || substr(jubun,3,4),'yyyymmdd')
       as birthday_this_year		-- 올해생일
          , case when substr(jubun,7,1) in('1','2')
              then '19' else '20'
              end || substr(jubun,1,2) as birthyear -- 태어난 년도
      from EMPLOYEES
)
SELECT fullname, jubun
      , case when birthday_this_year
      > to_date(to_char(sysdate,'yyyymmdd'),'yyyymmdd')
      then extract(year from sysdate) - birthyear - 1
      else extract(year from sysdate) - birthyear
      end as age	-- 만나이
FROM A;


/*
        107명의 사원 나타내기
        ----------------------------------------------------------------------------------
         부서번호    부서명    부서주소    부서장성명    사원번호   사원명    성별    나이    연봉
        ----------------------------------------------------------------------------------
        ------------------------------------------------------------------
            연봉소득세액    부서내연봉평균차액    부서내연봉등수     전체연봉등수
        ------------------------------------------------------------------
*/

-- 부서번호 : employees, departments        => department_id
-- 부서명 : departments                    => department_name
-- 부서주소 : departments join locations    => street_address, city, state_province
-- 부서장성명 : employees join departments
-- 사원번호, 사원명, 연봉 : employees
-- 성별, 나이 : employees 통해 구하기
-- 연봉소득세액 : employees join tbl_taxindex
-- 부서내연봉평균차액 : 평균 -> 그룹함수 -> group by ~ employees
-- 부서내연봉등수, 전체연봉등수 : employees

WITH
DEPT AS
(
    -- [부서번호, 부서명, 부서주소, 부서장성명]
        select D.DEPARTMENT_ID                                                -- 부서번호
             , department_name                                                -- 부서명
             , STREET_ADDRESS || CITY || STATE_PROVINCE as department_address -- 부서주소
             , E.FIRST_NAME || ' ' || E.LAST_NAME       as manager_name       -- 부서장성명
        from departments D
                 JOIN locations L
                      ON D.LOCATION_ID = L.LOCATION_ID
                 JOIN EMPLOYEES E
                      ON D.MANAGER_ID = E.EMPLOYEE_ID
)
, EMP AS
(
    -- [사원번호, 사원명, 연봉, 성별, 나이, 연봉소득세액, 부서내연봉등수, 전체연봉등수]
    select DEPARTMENT_ID
        , EMPLOYEE_ID  -- 사원번호
        , fullname      -- 사원명
        , year_money    -- 연봉
        , gender        -- 성별
        , case when this_year_birthday > to_date(to_char(sysdate,'yyyymmdd'),'yyyymmdd')
                            then extract(year from sysdate) - birthyear - 1
                            else extract(year from sysdate) - birthyear
                            end as age      -- 나이
        , year_tax      -- 연봉소득세액
        , dept_rank     -- 부서내연봉등수
        , total_rank    -- 전체연봉등수
    FROM (
            select DEPARTMENT_ID, employee_id
                , FIRST_NAME || ' ' || LAST_NAME as fullname
                , nvl(salary + (salary * COMMISSION_PCT), salary) * 12 as year_money
                , case when substr(jubun,7,1) in('1','3') then '남' else '여' end as gender
                , to_date(to_char(sysdate,'yyyy') || substr(jubun,3,4),'yyyymmdd') as this_year_birthday
                , case when substr(jubun,7,1) in('1','2') then '19' else '20' end || substr(jubun,1,2) as birthyear
                , nvl(salary + (salary * COMMISSION_PCT), salary) * 12 * taxpercent as year_tax
                , rank() over (partition by DEPARTMENT_ID order by nvl(salary + (salary * COMMISSION_PCT), salary)
                            * 12 desc) as dept_rank
                , rank() over (order by nvl(salary + (salary * COMMISSION_PCT), salary) * 12 desc) as total_rank
            from employees JOIN tbl_taxindex
            ON nvl(salary + (salary * COMMISSION_PCT), salary) * 12 between lowerincome and highincome
        ) EMP_TAX
)
, AVG_MONEY AS
(
-- [부서내연봉평균차액]
select DEPARTMENT_ID, avg(nvl(salary + (salary * COMMISSION_PCT), salary) * 12) as avg_dept_money
from employees
group by department_id
)
-- DEPT, EMP, AVG_MONEY JOIN
select DEPT.DEPARTMENT_ID as 부서번호
    , DEPT.DEPARTMENT_NAME as 부서명
    , DEPT.department_address as 부서주소
    , DEPT.manager_name as 부서장성명
    , EMP.EMPLOYEE_ID as 사원번호
    , EMP.fullname as 사원명
    , EMP.gender as 성별
    , EMP.age as 나이
    , to_char(EMP.year_money,'999,999') as 연봉
    , to_char(EMP.year_tax,'99,999') as 연봉소득세액
    , to_char(EMP.year_money - AVG_MONEY.avg_dept_money,'999,999') as 부서내연봉평균차액
    , EMP.dept_rank as 부서내연봉등수
    , EMP.total_rank as 전체연봉등수
from DEPT RIGHT JOIN EMP
ON DEPT.DEPARTMENT_ID = EMP.DEPARTMENT_ID
LEFT JOIN AVG_MONEY
ON EMP.DEPARTMENT_ID = AVG_MONEY.DEPARTMENT_ID
ORDER BY 부서번호, 사원번호, 연봉;

-- 성별함수1(주민번호 입력받아서 사용)
create or replace function func_gender
    (p_jubun in varchar2)   -- varchar2(13) 와 같이 자리수를 쓰면 오류이다.!!!
    return varchar2         -- varchar2(6) 와 같이 자리수를 쓰면 오류이다.!!!
is
    v_result    varchar2(6);
begin
    select case when substr(p_jubun,7,1) in('1','3') then '남' else '여' end
        INTO
        v_result
    from dual;
    return v_result;
end func_gender;
-- Function FUNC_GENDER이(가) 컴파일되었습니다.

-- 성별함수2(주민번호 입력받아서 사용)
create or replace function func_gender_2
    (p_jubun in varchar2)   -- varchar2(13) 와 같이 자리수를 쓰면 오류이다.!!!
    return varchar2         -- varchar2(6) 와 같이 자리수를 쓰면 오류이다.!!!
is
    v_result    varchar2(6);
begin
    v_result := case when substr(p_jubun,7,1) in('1','3') then '남' else '여' end;
    return v_result;
end func_gender_2;
-- Function FUNC_GENDER_2이(가) 컴파일되었습니다.

-- 나이함수1(주민번호 입력받아서 사용)
create or replace function func_age
    (p_jubun in varchar2)   -- varchar2(13) 와 같이 자리수를 쓰면 오류이다.!!!
    return number         -- 타입이 달라도 가능하다. number(6) 와 같이 자리수를 쓰면 오류이다.!!!
is
    v_age    varchar2(6);
begin
    select case when to_date(to_char(sysdate, 'yyyy') || substr(p_jubun, 3, 4), 'yyyymmdd') - to_date(to_char(sysdate,'yyyymmdd'), 'yyyymmdd') > 0
                    then extract(year from sysdate) - ( to_number(substr(p_jubun,1,2)) + case when substr(p_jubun,7,1) in('1','2') then 1900 else 2000 end ) - 1
                    else extract(year from sysdate) - ( to_number(substr(p_jubun,1,2)) + case when substr(p_jubun,7,1) in('1','2') then 1900 else 2000 end )
                    end
    INTO
        v_age
    from dual;
    return v_age;
end func_age;
-- Function FUNC_AGE이(가) 컴파일되었습니다.

-- 나이함수2(주민번호 입력받아서 사용)
create or replace function func_age_2
    (p_jubun in varchar2)   -- varchar2(13) 와 같이 자리수를 쓰면 오류이다.!!!
    return varchar2         -- varchar2(6) 와 같이 자리수를 쓰면 오류이다.!!!
is
    v_age    varchar2(6);
begin
    v_age :=  case when to_date(to_char(sysdate, 'yyyy') || substr(p_jubun, 3, 4), 'yyyymmdd') - to_date(to_char(sysdate,'yyyymmdd'), 'yyyymmdd') > 0
                    then extract(year from sysdate) - ( to_number(substr(p_jubun,1,2)) + case when substr(p_jubun,7,1) in('1','2') then 1900 else 2000 end ) - 1
                    else extract(year from sysdate) - ( to_number(substr(p_jubun,1,2)) + case when substr(p_jubun,7,1) in('1','2') then 1900 else 2000 end )
                    end;
    return v_age;
end func_age_2;
-- Function FUNC_AGE_2이(가) 컴파일되었습니다.

-- 나이함수3
create or replace function func_age_3
    (p_jubun IN varchar2)
    return number
IS
    error_jubun  exception; -- error_jubun은 개발자가 정의하는 exception(예외절)임을 선언한다는 뜻이다.
    v_gender_num varchar2(1) := substr(p_jubun,7,1); -- := 초기값을 넣어주는 것
                                                     -- v_gender_num 에는 입력받은 p_jubun 에서 7번째 부터 1개 글자만 넣어준다.
                                                     -- 즉, v_gender_num 에는 '1' 또는 '2' 또는 '3' 또는 '4' 가 들어올 것이다.
    v_year       number(4);
    v_age        number(3);
BEGIN
    if length(p_jubun) != 13 then raise error_jubun;
    end if;

    if    v_gender_num in ('1','2') then v_year := 1900;
    elsif v_gender_num in ('3','4') then v_year := 2000;
    else raise error_jubun;
    end if;

    if to_date(to_char(sysdate,'yyyy')||substr(p_jubun,3,4),'yyyymmdd') - to_date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') > 0
         then v_age := extract(year from sysdate) - (v_year + to_number(substr(p_jubun,1,2))) - 1;
    else v_age := extract(year from sysdate) - (v_year + to_number(substr(p_jubun,1,2)));
    end if;

    return v_age;

    EXCEPTION
    WHEN error_jubun
    then raise_application_error(-20001, '잘못된 주민등록 번호입니다.'); -- raise_application_error() 는 dbms가 아닌 스크립트 출력창에 오류를 띄워준다.
                          --     -20001 은 오류번호로써, 사용자가 정의해주는 EXCEPTION 에 대해서는 오류번호를 -20001 부터 -20999 까지만 가능하다. 그 이외의 오류번호는 사용할 수 없다.
END func_age_3;
-- Function FUNC_AGE_3이(가) 컴파일되었습니다.

-- 정년퇴직일 함수
create or replace function func_retirement_day
    (p_jubun  IN  varchar2)
    return date
is
 v_retirement_day date; -- 변수명
begin
    select last_day(to_date(to_char(add_months(sysdate,(63-func_age(p_jubun))*12),'yyyy')
    -- 만 63세가 되어지는 오늘날 : add_months(sysdate,(63-현재나이)*12)
    || case when substr(p_jubun,3,2) between '03' and '08' then '0801' else '0201' end,'yyyy-mm-dd'))
    into v_retirement_day
    from dual;
    return v_retirement_day;
end func_retirement_day;
-- Function FUNC_RETIREMENT_DAY이(가) 컴파일되었습니다.


create or replace procedure pcd_tbl_member_test1_insert
    (p_userid IN tbl_member_test1.userid%type
    ,p_passwd IN tbl_member_test1.passwd%type
    ,p_name IN tbl_member_test1.name%type
    )
    is
        error_dayTime   exception;      -- error 변수 선언
        v_passwd_length number(2);
        error_insert    exception;      -- error 변수 선언
        v_ch            varchar2(1);    -- passwd 글자 한개
        v_flag_alphabet number(1) := 0; -- 영문자 확인 용도
        v_flag_number   number(1) := 0; -- 숫자 확인 용도
        v_flag_special  number(1) := 0; -- 특수문자 확인 용도
    begin
        -- 입력(insert)이 불가한 요일명과 시간대를 알아봅니다. --
        if(to_char(sysdate,'d') in ('1','7') or to_number(to_char(sysdate,'hh24')) < 14 or to_number(to_char(sysdate,'hh24')) > 16)
            then raise error_dayTime;
        else    -- 입력(insert)이 가능한 요일명과 시간대 이라면 암호를 검사하겠다.

            v_passwd_length := length(p_passwd);
            if(v_passwd_length < 5 or v_passwd_length > 20) then raise error_insert;    -- 사용자가 정의하는 예외절(Exception)을 구동시켜라.
            else
                For i in 1..v_passwd_length LOOP
                    v_ch := substr(p_passwd,i,1);

                    if(v_ch between 'A' and 'Z') or (v_ch between 'a' and 'z') then     -- 영문자 이라면
                        v_flag_alphabet := 1;
                    elsif(v_ch between '0' and '9') then    -- 숫자 이라면
                        v_flag_number := 1;
                    else    -- 특수문자 이라면
                        v_flag_special := 1;
                    end if;
                END LOOP;   -- end of for loop-------------------------------------------------------------

                if(v_flag_alphabet * v_flag_number * v_flag_special = 1) then
                    insert into tbl_member_test1(userid,passwd,name) values(p_userid,p_passwd,p_name);
                else raise error_insert;     -- 사용자가 정의하는 예외절(Exception)을 구동시켜라.
                end if;
            end if;
        end if;
        Exception   -- 정의내리기
            WHEN error_dayTime THEN raise_application_error(-20003,'>> 영업시간(월~금 14:00 ~ 16:59:59 까지)이 아니므로 입력불가함 <<');
            WHEN error_insert THEN raise_application_error(-20002,'>> 암호는 최소 5글자 이상이면서 영문자 및 숫자 및 특수기호가 혼합되어져야 합니다. <<');
    end pcd_tbl_member_test1_insert;
    -- Procedure PCD_TBL_MEMBER_TEST1_INSERT이(가) 컴파일되었습니다.

    commit;