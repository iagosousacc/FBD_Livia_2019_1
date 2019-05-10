-- 1 --
SELECT AVG(salario) FROM universidade.professor
WHERE categoria = 'Adjunto I';
-- 2 --
SELECT nome FROM universidade.disciplina
WHERE carga_horaria = 60;
-- 3 --
SELECT p.nome, d.nome FROM universidade.professor p, universidade.disciplina d, universidade.ministra m
WHERE p.siape = m.siape and d.cod_disciplina = m.cod_disciplina and m.periodo = '2013.2';
-- 4 --
SELECT DISTINCT p.nome FROM universidade.professor p
WHERE NOT EXISTS
(SELECT DISTINCT m FROM universidade.ministra m
WHERE p.siape = m.siape);
-- 5 --
SELECT nome FROM universidade.professor
WHERE NOT EXISTS
(SELECT p.nome FROM universidade.professor p, universidade.ministra m
WHERE p.siape = m.siape AND m.periodo = '2013.1');
-- 6 --
-- 7 --
SELECT COUNT( DISTINCT p.nome) FROM universidade.professor p, universidade.ministra m
WHERE p.cod_depto = 1 AND m.cod_disciplina = 1 AND p.siape = m.siape;
-- 8 --

-- 9 --
-- 0 --
-- 1 --