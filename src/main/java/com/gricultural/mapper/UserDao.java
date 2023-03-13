package com.gricultural.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gricultural.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: chongchong
 * @DateTime: 2023/3/10 14:38
 * @Description:
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    //根据用户名查找用户
    @Select("select * from user where username = #{username}")
    User getUserByUserName(String username);

    //根据用户名查询密码
    @Select("select password from user where username = #{username}")
    String getUserPasswordByUserName(String username);

    //修改账号密码
    @Update("update user set username = #{username},password = #{password},picture = #{picture} where id = #{id}")
    boolean updateUserById(User user);

    //修改账号密码带图片
    @Update("update user set username = #{username},password = #{password},picture = #{picture} where id = #{id}")
    boolean updateUserByIdImg(Integer id,String username,String password,String picture);


}
