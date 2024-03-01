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
