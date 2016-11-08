package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.RiskItem;
import com.springapp.mvc.dao.RiskItemDao;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by WH on 2016/11/8.
 */
@Repository("riskItemDao")
public class RiskItemDaoImpl extends JdbcDaoSupport implements RiskItemDao{
    /**
     *
     * @param project
     * 传入RiskItem对象，分别插入到两张表中risk_descripts和risk_items
     */
    @Override
    @Transactional
    public void insert(final RiskItem project) {
        final String insertToRiskDescripts = "insert into risk_descripts (risk_descript) values (?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(insertToRiskDescripts,
                                new String[]{"risk_descript_id"});
                        ps.setString(1, project.getDescript());
                        return ps;
                    }
                },
                keyHolder
        );
        final String insertToRiskItems = "insert into risk_items " +
                "( project_id, creater_id," +
                "risk_type_id, risk_descript_id," +
                "risk_prob, risk_affect) values " +
                "(?,?,?,?, ?,?)";

        KeyHolder riskKey = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(insertToRiskItems,
                                new String[]{"risk_item_id"});
                        ps.setInt(1, project.getProjectId());
                        ps.setInt(2, project.getCreaterId());
                        ps.setInt(3, project.getTypeId());
                        ps.setInt(4, keyHolder.getKey().intValue());
                        ps.setInt(5, project.getProb());
                        ps.setInt(6, project.getAffect());
                        return ps;
                    }
                },
                riskKey
        );
        System.out.println("新增一条风险条目，id是: "+riskKey.getKey());
    }

    @Override
    public void delete(RiskItem project) {

    }

    @Override
    public void modify(RiskItem project) {

    }

    @Override
    public RiskItem findRiskItemByRid(long rid) {
        return null;
    }

    @Override
    public RiskItem findRiskItemByPid(long pid) {
        return null;
    }
}