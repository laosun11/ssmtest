package ssmtest.scy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ssmtest.scy.pojo.User;

public interface UserDao {
	//增加
	int add(User user);
	//删除
	int delete(String id);
	//修改
	int update(User user);
	//根据id查询
	User findById(String id);
	//查询全部
	List<User> find(@Param("params")Map<String, Object> params);
	//保存用户信息
	int save(User u);
}
