package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.bean.Result;
import com.test.helper.JDBCConnection;

public class ResultDaoImpl implements ResultDao{

	private static final String Check_Result2="Select * from RESULT WHERE USERNAME=?";
	
	public List<Result> show(String username) throws ClassNotFoundException, SQLException, IOException{
		List<Result> resultList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(Check_Result2);
		preparedStatement.setString(1,username);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()){
			int subjectId = rs.getInt("SUBJECT_ID");
			int result = rs.getInt("RESULT");
			Date date = rs.getDate("TIME_");
			Result res = new Result(username, subjectId, result, date);
			resultList.add(res);
		}
		preparedStatement.close();
		connection.close();
		return resultList;
	}
}
