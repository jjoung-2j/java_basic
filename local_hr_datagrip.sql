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
