SELECT ANIMAL_ID, name
from animal_ins
where lower(name) like lower('%el%')
and animal_type = 'Dog'
order by name