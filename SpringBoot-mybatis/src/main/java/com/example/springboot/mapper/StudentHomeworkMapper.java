package com.example.springboot.mapper;

import com.example.springboot.model.Homework;
import com.example.springboot.model.StudentHomework;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
操作model
 */
@Mapper
public interface StudentHomeworkMapper  {


    /*
    查看所有提交的作业
     */
    @Select("SELECT * FROM s_student_homework")
    List<StudentHomework> selectAll();


    /*
    教师提交成绩
    */
    @Update("update s_student_homework set score=#{score},set_score_time=#{set_score_time} where id=#{id}")
    void submitScore(StudentHomework sh);
      /*
    教师添加作业
     */
      @Insert("INSERT INTO s_homework(id,title,content,create_time,total_score) VALUES " +
                                 "(null,#{title},#{content},#{create_time},#{total_score})")
     void addStudentHomework(Homework hw);

    /*
    提交作业StudentHomework
    */
    @Insert("INSERT INTO s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) " +
            "values (null,#{student_id},#{homework_id},#{homework_title},#{homework_content},#{create_time})")
    void submitHomework(StudentHomework sh) ;

      /*
    查看自已提交的作业
    */
    @Select("SELECT * FROM s_student_homework where student_id=#{student_id}")
    List<StudentHomework> selectMy(StudentHomework studentHomework);

    /*
    删除自己的作业Homework
     */
    @Delete("delete from s_student_homework where id in (${ids})")
    void deleteHomework(String ids) ;

    /*
    修改自己已提交的作业
  */
    @Update("update s_student_homework set homework_title=#{homework_title},homework_content=#{homework_content},update_time=#{update_time} where id=#{id}")
    void updateHomework(StudentHomework sh);

//
//    @Insert("insert into student_homework(homework_id,student_id,homework_title,homework_content,submit_date) " +
//            "values (#{homeworkId},#{studentId},#{homeworkTitle},#{homeworkContent},#{submitDate})")
//    void insertOne(StudentHomework studentHomework);







}

