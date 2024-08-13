create user book identified by book default tablespace users temporary tablespace temp;
grant connect,DBA to book;

select dbms_xdb.gethttpport() from dual; -- 오라클sql의 포트 확인하기(8080)
exec dbms_xdb.sethttpport(9090); --xe에서는 안됨 , cmd에서 된다(commit해줘야한다)
