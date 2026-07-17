-- 코드를 작성해주세요
select sum(SCORE) as score, gr.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_GRADE gr
join HR_EMPLOYEES em
on em.EMP_NO = gr.EMP_NO
group by gr.EMP_NO
order by score desc
limit 1;