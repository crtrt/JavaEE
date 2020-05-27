package com.example.springboot.db.mapper;

import com.example.springboot.db.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {


    /*
    查看学生列表student
     */
    @Select("SELECT * FROM s_student")
    public List<Student> selectStudent();

    /*
   添加学生Student
    */
    @Insert("INSERT INTO s_student(id,name,create_time) VALUES (#{id},#{name},#{createTime})")
    public void addStudent(Student sh);
}
