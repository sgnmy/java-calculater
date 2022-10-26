package com.example.demo.repositories;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entities.ResultEntity;

@Mapper

public interface  Webcalc_Result_Repository {
	  
	  @Insert("INSERT INTO WEBCALC_RESULT(RESULT) VALUES (#{result})")
	 public void insertResult(String result);//上のSQL文を実行させてくれる
	  
	  @Select("SELECT RESULT FROM WEBCALC_RESULT")
	  public List<ResultEntity> findAll();//計算結果の履歴が返ってくる
	  

}



