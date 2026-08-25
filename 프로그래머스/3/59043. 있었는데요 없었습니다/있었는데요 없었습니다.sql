-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
from ANIMAL_OUTS outs
join ANIMAL_INS ins
on outs.ANIMAL_ID = ins.ANIMAL_ID
where outs.DATETIME < ins.DATETIME
order by ins.DATETIME asc;