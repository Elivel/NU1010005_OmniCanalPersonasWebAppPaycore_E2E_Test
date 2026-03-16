--As400:
--Consultar cuentas por usuario
--SELECT acmast , acmcon, ACMACc  FROM BACCYFILES.acmst WHERE ACMcun = 16846 ;

--Actualizar estado de las cuentas por usuario para activarlas:
--update BACCYFILES.acmst set acmast = 'A', acmcon='' where acmcun = 16846;

--Actualizar las cuentas por usuario
--update BACCYFILES.acmst set  acmcun = 16846  where acmacc IN (5030483877);

--Consultar prestamo
--SELECT * FROM baccyfiles.DEALS d1 WHERE DEATYP='LNS' and deapro ='0416' and dealsn = 0 and deapri >1000 and deamei > 0 and DEASTS = '' and deaacc in (select numptmo from baccyfiles.Prhisnl0 where deacun = 1928657 AND fec_cont01='2025'  group by numptmo having count(*)>2 order by count(*));

--Actualizar prestamo
--update baccyfiles.deals set deacun =1448650 where deaacc in (2126228817,2128576188);
--update baccyfiles.deals set deacun =16846 where deaacc = 2129398482;

----------------------------------------------------------------------------------
--Oracle:
--Omniqa y Omnidesa 

--Borrar Caché
UPDATE omniqa.ATTEMPTS SET ATTEMPTS = 0;
update omniqa.ENVIRONMENTS e set e.LAST_SYNCHRONIZATION = NULL;
