SELECT DISTINCT CITY FROM STATION WHERE REGEXP_LIKE(LOWER(CITY), '^[^aeiou]|[^aeiou]$');
