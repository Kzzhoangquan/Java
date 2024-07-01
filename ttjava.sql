USE ttjava;


 /********* A. BASIC QUERY *********/
 
-- 1. Liệt kê danh sách sinh viên sắp xếp theo thứ tự:
-- select *
-- from student
-- order by 
--   id ASC, -- a. id tăng dần
--   gender ASC, -- b. giới tính
--   birthday ASC, -- c. ngày sinh tăng dần
--   IFNULL(scholarship, 0) DESC; -- học bổng giảm dần

-- 2. Môn học có tên bắt đầu bằng chữ 'T'
-- select *
-- from subject
-- where substring(name,1,1) = 'T'

-- 3. Sinh viên có chữ cái cuối cùng trong tên là 'i'
-- SELECT *
-- FROM student
-- WHERE SUBSTRING(name, -1 ) = 'i';

-- 4. Những khoa có ký tự thứ hai của tên khoa có chứa chữ 'n'
-- select *
-- from faculty
-- where substring(name, 2,1) = 'n'

-- 5. Sinh viên trong tên có từ 'Thị'
-- select *
-- from student
-- where name like '%Thị%'

-- 6. Sinh viên có ký tự đầu tiên của tên nằm trong khoảng từ 'a' đến 'm', sắp xếp theo họ tên sinh viên
-- SELECT *
-- FROM student
-- WHERE SUBSTRING(name, 1, 1) BETWEEN 'a' AND 'm'
-- ORDER BY name;

-- 7. Sinh viên có học bổng lớn hơn 100000, sắp xếp theo mã khoa giảm dần
-- select *
-- from student
-- where scholarship > 100000
-- order by faculty_id desc;

-- 8. Sinh viên có học bổng từ 150000 trở lên và sinh ở Hà Nội
-- SELECT *
-- FROM student
-- WHERE scholarship >= 150000
--   AND hometown = 'Hà Nội';

-- 9. Những sinh viên có ngày sinh từ ngày 01/01/1991 đến ngày 05/06/1992
-- SELECT *
-- FROM student
-- WHERE birthday BETWEEN '1991-01-01' AND '1992-06-05';


-- 10. Những sinh viên có học bổng từ 80000 đến 150000
-- SELECT *
-- FROM student
-- WHERE scholarship BETWEEN 80000 AND 150000;

-- 11. Những môn học có số tiết lớn hơn 30 và nhỏ hơn 45
-- SELECT *
-- FROM subject
-- WHERE lesson_quantity > 30 AND lesson_quantity < 45;

-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho biết thông tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, Giới tính, Mã 
		-- khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu giá trị 
		-- của học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình”.

-- SELECT s.id AS 'Mã sinh viên', s.gender AS 'Giới tính', s.faculty_id AS 'Mã khoa',
--     CASE
--         WHEN s.scholarship > 500000 THEN 'Học bổng cao'
--         ELSE 'Mức trung bình'
--     END AS 'Mức học bổng'
-- FROM student s;

-- 2. Tính tổng số sinh viên của toàn trường
-- SELECT COUNT(*) AS 'Tổng số sinh viên'
-- FROM student;

-- 3. Tính tổng số sinh viên nam và tổng số sinh viên nữ.
-- SELECT 
--     SUM(CASE WHEN gender = 'Nam' THEN 1 ELSE 0 END) AS 'Tổng số sinh viên nam',
--     SUM(CASE WHEN gender = 'Nữ' THEN 1 ELSE 0 END) AS 'Tổng số sinh viên nữ'
-- FROM student;

-- 4. Tính tổng số sinh viên từng khoa
-- SELECT 
--     faculty_id AS 'Mã khoa',
--     COUNT(*) AS 'Tổng số sinh viên'
-- FROM student
-- GROUP BY faculty_id;

-- 5. Tính tổng số sinh viên của từng môn học
-- SELECT 
--     s.id AS 'Mã môn học',
--     s.name AS 'Tên môn học',
--     COUNT(em.student_id) AS 'Tổng số sinh viên'
-- FROM subject s
-- LEFT JOIN exam_management em ON s.id = em.subject_id
-- GROUP BY s.id, s.name;

-- 6. Tính số lượng môn học mà sinh viên đã học
-- select 
-- 	stu.id as 'Ma sinh vien',
--     stu.name as 'Ten sinh vien',
--     count(em.subject_id) as 'Tong so mon ma sinh vien hoc'
-- from student stu
-- inner join exam_management em on stu.id = em.student_id
-- group by stu.id,stu.name

-- 7. Tổng số học bổng của mỗi khoa	
-- SELECT 
--     faculty_id AS 'Mã khoa',
--     SUM(scholarship) AS 'Tổng số học bổng'
-- FROM student
-- GROUP BY faculty_id;

-- 8. Cho biết học bổng cao nhất của mỗi khoa
-- SELECT 
--     faculty_id AS 'Mã khoa',
--     MAX(scholarship) AS 'Hoc bong cao nhat'
-- FROM student
-- GROUP BY faculty_id;

-- 9. Cho biết tổng số sinh viên nam và tổng số sinh viên nữ của mỗi khoa
-- SELECT 
--     faculty_id AS 'Mã khoa',
--     SUM(CASE WHEN gender = 'Nam' THEN 1 ELSE 0 END) AS 'Tổng số sinh viên nam',
--     SUM(CASE WHEN gender = 'Nữ' THEN 1 ELSE 0 END) AS 'Tổng số sinh viên nữ'
-- FROM student
-- GROUP BY faculty_id;

-- 10. Cho biết số lượng sinh viên theo từng độ tuổi
-- select 
-- 	case
-- 		when timestampdiff(year,birthday,curdate()) between 0 and 20 then 'Duoi 20 tuoi'
-- 		WHEN TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 20 AND 29 THEN '20 - 29 tuổi'
--         WHEN TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 30 AND 39 THEN '30 - 39 tuổi'
--         WHEN TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 40 AND 49 THEN '40 - 49 tuổi'
--         ELSE 'Trên 50 tuổi'
--     end as 'Do tuoi',
--     count(*) as 'So luong hoc sinh'
-- from student
-- group by 'Do tuoi'

-- 11. Cho biết những nơi nào có ít nhất 2 sinh viên đang theo học tại trường
-- select 
-- 	hometown as 'Dia diem',
--     count(*) as 'So luong sinh vien'
-- from 
-- 	student
-- group by hometown
-- having count(*) >= 2;




-- 12. Cho biết những sinh viên thi lại ít nhất 2 lần
-- SELECT 
--     student_id AS 'Mã sinh viên',
--     COUNT(*) AS 'Số lần thi lại'
-- FROM exam_management
-- where number_of_exam_taking >=2 
-- GROUP BY student_id
-- HAVING COUNT(*) >= 2;

-- 13. Cho biết những sinh viên nam có điểm trung bình lần 1 trên 7.0 
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     em.mark AS 'Điểm trung bình lần 1'
-- FROM student s
-- inner join exam_management em ON s.id = em.student_id
-- WHERE s.gender = 'Nam' AND em.number_of_exam_taking = 1 AND em.mark > 7.0;

-- 14. Cho biết danh sách các sinh viên rớt ít nhất 2 môn ở lần thi 1 (rớt môn là điểm thi của môn không quá 4 điểm)
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     COUNT(CASE WHEN em.mark < 4 AND em.number_of_exam_taking = 1 THEN 1 END) AS 'Số môn rớt lần 1'
-- FROM student s
-- JOIN exam_management em ON s.id = em.student_id
-- GROUP BY s.id, s.name
-- HAVING COUNT(CASE WHEN em.mark < 4 AND em.number_of_exam_taking = 1 THEN 1 END) >= 2;

-- 15. Cho biết danh sách những khoa có nhiều hơn 2 sinh viên nam
-- SELECT 
--     f.id AS 'Mã khoa',
--     f.name AS 'Tên khoa',
--     COUNT(CASE WHEN s.gender = 'Nam' THEN 1 END) AS 'Số sinh viên nam'
-- FROM faculty f
-- JOIN student s ON f.id = s.faculty_id
-- GROUP BY f.id, f.name
-- HAVING COUNT(CASE WHEN s.gender = 'Nam' THEN 1 END) > 2;

-- 16. Cho biết những khoa có 2 sinh viên đạt học bổng từ 200000 đến 300000
-- SELECT 
--     f.id AS 'Mã khoa',
--     f.name AS 'Tên khoa',
--     COUNT(*) AS 'Số lượng sinh viên đạt học bổng'
-- FROM faculty f
-- JOIN student s ON f.id = s.faculty_id
-- WHERE s.scholarship BETWEEN 200000 AND 300000
-- GROUP BY f.id, f.name
-- HAVING COUNT(*) = 2;

-- 17. Cho biết sinh viên nào có học bổng cao nhất
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     s.scholarship AS 'Học bổng'
-- FROM student s
-- ORDER BY s.scholarship DESC
-- LIMIT 1;

/********* C. DATE/TIME QUERY *********/
-- 1. Sinh viên có nơi sinh ở Hà Nội và sinh vào tháng 02
-- SELECT 
--     id AS 'Mã sinh viên',
--     name AS 'Tên sinh viên',
--     hometown AS 'Nơi sinh',
--     birthday AS 'Ngày sinh'
-- FROM student
-- WHERE hometown = 'Hà Nội' AND MONTH(birthday) = 2;

-- 2. Sinh viên có tuổi lớn hơn 20
-- select *
-- from student
-- where timestampdiff(year,birthday,curtime()) > 20

-- 3. Sinh viên sinh vào mùa xuân năm 1990
-- SELECT 
--     id AS 'Mã sinh viên',
--     name AS 'Tên sinh viên',
--     birthday AS 'Ngày sinh'
-- FROM student
-- WHERE YEAR(birthday) = 1990 AND MONTH(birthday) BETWEEN 1 AND 4;

/********* D. JOIN QUERY *********/
-- 1. Danh sách các sinh viên của khoa ANH VĂN và khoa VẬT LÝ
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     f.name AS 'Tên khoa'
-- FROM student s
-- JOIN faculty f ON s.faculty_id = f.id
-- WHERE f.name IN ('Anh - Văn', 'Vật lý');

-- 2. Những sinh viên nam của khoa ANH VĂN và khoa TIN HỌC
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     f.name AS 'Tên khoa'
-- FROM student s
-- JOIN faculty f ON s.faculty_id = f.id
-- WHERE f.name IN ('Anh - Văn', 'Tin học') AND s.gender = 'Nam';

-- 3. Cho biết sinh viên nào có điểm thi lần 1 môn cơ sở dữ liệu cao nhất
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     em.mark AS 'Điểm thi',
--     em.number_of_exam_taking AS 'Lần thi'
-- FROM exam_management em
-- JOIN student s ON em.student_id = s.id
-- JOIN subject sub ON em.subject_id = sub.id
-- WHERE sub.name = 'Cơ sở dữ liệu' AND em.number_of_exam_taking = 1
-- ORDER BY em.mark DESC
-- LIMIT 1;

-- 4. Cho biết sinh viên khoa anh văn có tuổi lớn nhất.
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     s.faculty_id AS 'Mã khoa',
--     TIMESTAMPDIFF(YEAR, s.birthday, CURDATE()) AS 'Tuổi'
-- FROM student s
-- JOIN faculty f ON s.faculty_id = f.id
-- WHERE f.name = 'Anh - Văn'
-- ORDER BY TIMESTAMPDIFF(YEAR, s.birthday, CURDATE()) DESC
-- LIMIT 1;

-- 5. Cho biết khoa nào có đông sinh viên nhất
-- SELECT 
--     f.name AS 'Tên khoa',
--     COUNT(*) AS 'Số lượng sinh viên'
-- FROM student s
-- JOIN faculty f ON s.faculty_id = f.id
-- GROUP BY f.name
-- ORDER BY COUNT(*) DESC
-- LIMIT 1;

-- 6. Cho biết khoa nào có đông nữ nhất
-- SELECT 
--     f.name AS 'Tên khoa',
--     COUNT(*) AS 'Số lượng sinh viên Nữ'
-- FROM student s
-- JOIN faculty f ON s.faculty_id = f.id
-- where s.gender = 'Nữ'
-- GROUP BY f.name
-- ORDER BY COUNT(*) DESC
-- LIMIT 1;

-- 7. Cho biết những sinh viên đạt điểm cao nhất trong từng môn
-- SELECT 
--     em.subject_id AS 'Mã môn học',
--     sub.name AS 'Tên môn học',
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     em.mark AS 'Điểm cao nhất'
-- FROM exam_management em
-- JOIN student s ON em.student_id = s.id
-- JOIN subject sub ON em.subject_id = sub.id
-- WHERE (em.subject_id, em.mark) IN (
--     SELECT subject_id, MAX(mark)
--     FROM exam_management
--     GROUP BY subject_id
-- );

-- 8. Cho biết những khoa không có sinh viên học
-- SELECT 
--     f.id AS 'Mã khoa',
--     f.name AS 'Tên khoa'
-- FROM faculty f
-- left JOIN student s ON f.id = s.faculty_id
-- WHERE s.faculty_id IS NULL;

-- 9. Cho biết sinh viên chưa thi môn cơ sở dữ liệu
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên'
-- FROM student s
-- LEFT JOIN exam_management em ON s.id = em.student_id AND em.subject_id = 1
-- WHERE em.id IS NULL;

-- check qua bang 
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     em.id as 'ma check',
--     em.subject_id AS 'Mã môn học',
--     em.mark AS 'Điểm'
-- FROM student s
-- LEFT JOIN exam_management em ON s.id = em.student_id AND em.subject_id = 1;

-- 10. Cho biết sinh viên nào không thi lần 1 mà có dự thi lần 2
-- SELECT 
--     s.id AS 'Mã sinh viên',
--     s.name AS 'Tên sinh viên',
--     em2.subject_id AS 'Mã môn học'
-- FROM student s
-- LEFT JOIN exam_management em1 ON s.id = em1.student_id AND em1.number_of_exam_taking = 1
-- LEFT JOIN exam_management em2 ON s.id = em2.student_id AND em2.number_of_exam_taking = 2
-- WHERE em1.id IS NULL AND em2.id IS NOT NULL;
