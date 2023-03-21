package com.example.mapper;

import com.example.domain.Clazz;
import com.example.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     *学生只有一个班级 所以是多对一
     * @param studentId
     * @return
     */
    Student selectManyToOne(int studentId);


    int batchInsert(@Param("students")List<Student> students);

    int batchUpdate(@Param("students") List<Student> students);
    int batchDelete(@Param("idList") List<Integer> idList);

    int updateById(@Param("student") Student student);

    @Delete("delete from t_student where student_id = #{studentId}")
    int deleteById(int studentId);

    @Insert("insert into t_student values (#{student.studentId}, #{student.clazzId}, #{student.studentName},#{student.hometown},#{student.birthday})")
    int insert(@Param("student") Student student);

    Student getSelectedCourses(@Param("studentId") int studentId);

    List<Student> dynamicSelect(Student student);



}
