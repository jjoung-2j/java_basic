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
