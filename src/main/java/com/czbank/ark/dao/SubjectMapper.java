package com.czbank.ark.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.Subject;
import com.czbank.ark.model.SubjectType;
@Mapper
@Repository
public interface SubjectMapper {
   
    @Select("select * from subject where subject_type=#{type}")
    List<Subject> selectSubjectByType(String type);
    
    @Select("select * from subject where subject_name like CONCAT('%',#{0},'%')")
    List<Subject> selectSubjectByKeyword(String keyword);
    
    @Select("select * from subject")
    List<Subject> selectAllSubject();
    
    @Insert("insert into subject (subject_content, scan_num, subject_type, company_id, answer_num,  start_date, end_date) VALUES (#{subjectContent}, #{scanNum}, #{subjectType}, #{companyId}, #{answerNum}, #{startDate},#{endDate})")
    int inserSubject(Subject subject);
    
    @Update("update subject set subject_content = #{subjectContent},scan_num = #{scanNum},subject_type = #{subjectType},company_id = #{companyId},answer_num=#{answerNum},start_date=#{startDate},end_date=#{endDate} where id = #{id}") 
    int updateSubjectById(Subject subject);
    
    @Select("select * from subjectType")
    List<SubjectType> selectSubjectType();
    
    @Select("select subject_id,subject_name,subject_content,scan_num  from subject  order by answer_num limit #{top}")
    List<Subject> selectSubjectRank(int top);
}