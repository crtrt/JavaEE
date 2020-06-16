package com.example.springboot.mapper;

import com.example.springboot.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    /*
    学生登录
     */
    @Select("SELECT * FROM s_student where id=#{id} and psw=#{psw}" )
    List<Student> studentLogin(Student sh);

    /*
    查看学生列表student
     */
    @Select("SELECT * FROM s_student")
    List<Student> selectStudent();

    /*
   添加学生Student
    */
    @Insert("INSERT INTO s_student(id,name,create_time) VALUES (#{id},#{name},#{create_time})")
    void addStudent(Student sh);
}
