package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.Message;
import com.springapp.mvc.bean.mapper.MessageRowMapper;
import com.springapp.mvc.dao.MessageDao;
import com.springapp.mvc.service.MessageService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by NJUYuanRui
 * Created  2016/11/9
 * Modufied 2016/11/9
 */

@Repository("messageDao")
public class MessageDaoImpl extends JdbcDaoSupport implements MessageDao{
    @Override
    public List<Message> findMessagesByUser(long userId) {
        String sql = "select * from messages where status = 1 and userId = " + userId + " order by createAt limit 5" ;
        List messages =  this.getJdbcTemplate().query(sql, new MessageRowMapper());
        return messages;
    }

    @Override
    @Transactional
    public void deleteMessageById(int mId) {
        String sql = "update messages set status = 0 where id=?";
        this.getJdbcTemplate().update(sql,mId);
    }

    @Override
    @Transactional
    public void deleteMessageByUser(long userId) {
        String sql = "update messages set status = 0 where userId=?";
        this.getJdbcTemplate().update(sql,userId);
    }

    @Override
    public void insertMessages(List<Integer> userIds,int riskId,Date createAt){
        String sql = "INSERT INTO messages(riskId,userId,status,createAt) VALUES ";

        for(int userId : userIds){
            sql += ("( "+riskId+", "+userId+", "+1+", '"+createAt+"' ) ");
        }
        this.getJdbcTemplate().execute(sql);
    }
}
