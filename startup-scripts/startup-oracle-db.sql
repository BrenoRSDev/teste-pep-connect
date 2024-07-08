alter session set "_ORACLE_SCRIPT"=true;  

CREATE USER consumer IDENTIFIED BY pass54321;

GRANT ALL PRIVILEGES TO consumer;
