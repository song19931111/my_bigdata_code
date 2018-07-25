package com.nd.s414567;

import com.nd.s414567.entity.TUser;
import com.nd.s414567.entity.TUserRole;
import com.nd.s414567.mapper.SupplierMapper;
import com.nd.s414567.mapper.TUserMapper;
import com.nd.s414567.mapper.TUserRoleMapper;
import com.nd.s414567.mapper.UserMapper;
import com.nd.s414567.po.Supplier;
import com.nd.s414567.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/12
 */
public class MybatisMain {

    public static void main(String args[]) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        TUserRoleMapper mapper = sqlSession.getMapper(TUserRoleMapper.class);
        //List<TUser> tUsers = mapper.selectUserJobList();
        List<TUserRole> tUserRoles= mapper.selectUserAndRole();
        //List<TUser> tUsers = mapper.selectUserJobList();
        for(TUserRole userRole:tUserRoles){
            System.out.println(userRole.getRole().getRoleName());
        }

    }
}
