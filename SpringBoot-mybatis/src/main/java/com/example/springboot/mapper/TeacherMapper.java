package com.example.springboot.mapper;

import com.example.springboot.model.Student;
import com.example.springboot.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    /*
    教师登录
     */
    @Select("SELECT * FROM s_teacher where id=#{id} and psw=#{psw}" )
    public  List<Teacher> teacherLogin(Teacher sh);

}
