package com.example.springboot.db.mapper;

import com.example.springboot.db.model.StudentHomework;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/*
操作model
 */
public interface StudentHomeworkMapper  {



    @Insert("insert into student_homework(homeworkId,studentId,homeworkTitle,homeworkContent,submitDate) " +
            "values (#{homeworkId},#{studentId},#{homeworkTitle},#{homeworkContent},#{submitDate})")
    void insertOne(StudentHomework studentHomework);

    /*
    查看所有提交的作业
     */
    @Select("SELECT * FROM s_student_homework")
    public List<StudentHomework> selectAll();

    /*
    查看自已提交的作业
     */
    @Select("SELECT * FROM s_student_homework where student_id=#{stuId}")
    public List<StudentHomework> selectMy(Long stuId);

    /*
    提交作业StudentHomework
    */
    @Insert("INSERT INTO s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) " +
            "values (null,#{studentId},#{homeworkId},#{homeworkTitle},#{homeworkContent},#{createTime})")
    public void submitHomework(StudentHomework sh) ;
/*
    删除自己的作业Homework
     */
    @Delete("delete from s_student_homework where id in #{ids}")
    public  void deleteHomework(String ids) ;

    /*
    修改自己已提交的作业
  */
//    @Update()
//    public String updateHomework(StudentHomework sh) {
//        String sqlString = "update s_student_homework set homework_title='"+sh.getHomeworkTitle()+"',homework_content='"+sh.getHomeworkContent()+"',update_time='"+sh.getUpdateTime()+"'where id='"+sh.getId()+ "'";
//        connectUpdate(sqlString,"updateHomework");
//        return "修改成功";
//    }

    /*
  教师提交成绩
   */
//    public String submitScore(StudentHomework sh) {
//        String sqlString = "update s_student_homework set score='"+sh.getScore()+"',set_score_time='"+sh.getSetScoreTime()+"'where id='"+sh.getId()+ "'";
//        connectUpdate(sqlString,"submitScore");
//        return "修改成功";
//    }


}

