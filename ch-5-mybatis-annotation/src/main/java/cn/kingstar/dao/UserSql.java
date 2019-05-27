package cn.kingstar.dao;

import cn.kingstar.domain.UserParam;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author wujinxing
 * date 2019 2019/5/27 15:26
 * description
 */
public class UserSql {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSql.class);

    public String getList(UserParam userParam){
        StringBuffer sql = new StringBuffer("select id, userName, passWord, user_sex, as userSex, nick_name as nickName");
        sql.append(" from users where 1=1 ");
        if (userParam != null){
            if (!StringUtils.isEmpty(userParam.getUserName())){
                sql.append(" add userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())){
                sql.append(" add user_sex = #{userSex}");
            }
        }
        sql.append(" order by id desc");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        LOGGER.info("getList sql is :" +sql.toString());
        return sql.toString();
    }

    public String getCount(UserParam userParam) {
        String sql= new SQL(){{
            SELECT("count(1)");
            FROM("users");
            if (!StringUtils.isEmpty(userParam.getUserName())) {
                WHERE("userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())) {
                WHERE("user_sex = #{userSex}");
            }
            //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接
        }}.toString();

        LOGGER.info("getCount sql is :" +sql);
        return sql;
    }
}
