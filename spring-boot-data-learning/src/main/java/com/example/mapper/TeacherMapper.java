package com.example.mapper;

import com.example.domain.Clazz;
import com.example.domain.Student;
import com.example.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    /**
     * 一对一查询
     * @param teacherId 教师id
     * @return 教师对象
     */
    Teacher selectOneByOne(int teacherId);

    int updateById(@Param("teacher") Teacher teacher);

    @Delete("delete from t_teacher where teacher_id = #{teacherId}")
    int deleteById(int teacherId);

    @Insert("insert into t_teacher values (#{teacher.teacherId}, #{teacher.teacherName}, #{teacher.clazzId})")
    int insert(@Param("teacher") Teacher teacher);

    int batchInsert(@Param("teacherList") List<Teacher> teacherList);

    int batchUpdate(@Param("teacherList") List<Teacher> teacherList);
    int batchDelete(@Param("idList") List<Integer> idList);
}
