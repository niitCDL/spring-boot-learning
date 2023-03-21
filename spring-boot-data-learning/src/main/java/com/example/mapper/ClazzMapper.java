package com.example.mapper;

import com.example.domain.Clazz;
import com.example.domain.Student;
import com.example.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ClazzMapper {
    /**
     * 一对一查询
     *
     * @param clazzId 班级id
     * @return 教师对象
     */
    Clazz selectOneByOne(int clazzId);

    /**
     * 班级对应多个学生
     *
     * @param clazzId
     * @return
     */
    Clazz selectOnetoMany(int clazzId);

    int updateById(@Param("clazz") Clazz clazz);

    @Delete("delete from t_clazz where clazz_id = #{clazzId}")
    int deleteById(int clazzId);

    @Insert("insert into t_clazz values (#{clazz.clazzId}, #{clazz.clazzName}, #{clazz.teacherId})")
    int insert(@Param("clazz") Clazz clazz);

    int batchInsert(@Param("clazzList") List<Clazz> clazzList);
    int batchUpdate(@Param("clazzList") List<Clazz> clazzList);
    int batchDelete(@Param("idList") List<Integer> idList);


}
