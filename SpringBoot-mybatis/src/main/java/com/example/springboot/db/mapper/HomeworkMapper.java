package com.example.springboot.db.mapper;

import com.example.springboot.db.model.Homework;
import com.example.springboot.db.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HomeworkMapper {


    /*
     查看老师布置的的作业Homework
      */
    @Select("SELECT * FROM s_homework")
    public List<Homework> selectHomework();

    /*
    添加作业Homework
    */
    @Insert("INSERT INTO s_homework(id,title,content,create_time,total_score) VALUES (#{id},#{title},#{content},#{createTime},#{totalScore})")
    public void addStudentHomework(Homework hw) ;


}
