package org.example.javaee.springmvc.jdbc;
import org.example.javaee.springmvc.bean.Beans;
import org.example.javaee.springmvc.model.Student;
import org.example.javaee.springmvc.model.Homework;
import org.example.javaee.springmvc.model.StudentHomework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    public StudentHomeworkJdbc() {
    }

    public DatabasePool getDatabasePool(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        DatabasePool databasePool=(DatabasePool) context.getBean("databasePool");
        return  databasePool;
    }
    /*
        update操作数据库的方法
         */
    public void connectUpdate(String sql){

        try(Connection connection = getDatabasePool().getHikariDataSource().getConnection()) {
            try(Statement statement = connection.createStatement()){
                //插入
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    查看所有提交的作业
     */
    public List<StudentHomework> selectAll(){

        String sqlString = "SELECT * FROM s_student_homework";

        List<StudentHomework> list = new ArrayList<>();

        try(Connection connection = getDatabasePool().getHikariDataSource().getConnection()) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        sh.setTotal_score(resultSet.getString("total_score"));
                        sh.setScore(resultSet.getString("score"));
                        sh.setSetScoreTime(resultSet.getTimestamp("set_score_time"));


                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    /*
      查看老师布置的的作业Homework
       */
    public List<Homework> selectHomework(){

        String sqlString = "SELECT * FROM s_homework";

        List<Homework> list = new ArrayList<>();

        try(Connection connection = getDatabasePool().getHikariDataSource().getConnection()) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Homework hw = new Homework();
                        hw.setId(resultSet.getLong("id"));
                        hw.setTitle(resultSet.getString("title"));
                        hw.setContent(resultSet.getString("content"));
                        hw.setCreateTime(resultSet.getTimestamp("create_time"));
                        hw.setUpdateTime(resultSet.getTimestamp("update_time"));
                        hw.setTotal_score(resultSet.getString("total_score"));
                        list.add(hw);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /*
    查看学生列表student
     */
    public List<Student> selectStudent() {

        String sqlString = "SELECT * FROM s_student";

        List<Student> list = new ArrayList<>();

        try(Connection connection = getDatabasePool().getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        Student sh = new Student();
                        sh.setId(resultSet.getLong("id"));
                        sh.setName(resultSet.getString("name"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
      查看自已提交的作业
       */
    public List<StudentHomework> selectMy(Long stuId){

        String sqlString = "SELECT * FROM s_student_homework where student_id='" + stuId+ "'";

        List<StudentHomework> list = new ArrayList<>();

        try(Connection connection = getDatabasePool().getHikariDataSource().getConnection()) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        sh.setTotal_score(resultSet.getString("total_score"));
                        sh.setScore(resultSet.getString("score"));
                        sh.setSetScoreTime(resultSet.getTimestamp("set_score_time"));

                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    /*
     添加作业Homework
      */
    public String addStudentHomework(Homework hw){

        String sqlString = "INSERT INTO s_homework(id,title,content,create_time,total_score) VALUES (null,'" + hw.getTitle() + "','" + hw.getContent() + "','" + hw.getCreateTime()+ "','" + hw.getTotal_score()+"')";
        connectUpdate(sqlString);
        return "添加成功";
    }
    /*
       添加学生Student
   */
    public String addStudent(Student sh){

        String sqlString = "INSERT INTO s_student(id,name,create_time) VALUES ('" + sh.getId() + "','" + sh.getName() + "','" + sh.getCreateTime()+ "')";
        connectUpdate(sqlString);
        return "添加成功";
    }
    /*
     提交作业StudentHomework
    */
    public String submitHomework(StudentHomework sh) {

        String sqlString = "INSERT INTO s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) VALUES" +
                "(null,'" + sh.getStudentId() + "','" + sh.getHomeworkId() + "','"
                + sh.getHomeworkTitle() + "','" + sh.getHomeworkContent() + "','" + sh.getCreateTime() + "')";
        connectUpdate(sqlString);
        return "提交成功";
    }
    /*
    删除自己的作业Homework
     */

    public  String deleteHomework(String ids) {
        String sqlString = "delete from s_student_homework where id in ("+ids+")";
        connectUpdate(sqlString);
        return "删除成功";
    }
    /*
    修改自己已提交的作业
     */
    public String updateHomework(StudentHomework sh) {
        String sqlString = "update s_student_homework set homework_title='"+sh.getHomeworkTitle()+"',homework_content='"+sh.getHomeworkContent()+"',update_time='"+sh.getUpdateTime()+"'where id='"+sh.getId()+ "'";
        connectUpdate(sqlString);
        return "修改成功";
    }

    /*
  教师提交成绩
   */
    public String submitScore(StudentHomework sh) {
        String sqlString = "update s_student_homework set score='"+sh.getScore()+"',set_score_time='"+sh.getSetScoreTime()+"'where id='"+sh.getId()+ "'";
        connectUpdate(sqlString);
        return "修改成功";
    }


}
