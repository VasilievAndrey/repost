package ru.vav.repost.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.vav.repost.entity.Order;

/**
 * Order repository
 *
 * @author vav
 */
@Repository
public class OrderRepository implements IOrderRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final RowMapper<Order> ROW_MAPPER = new OrderMapper();

    private static final String FIND_BY_ID = "SELECT * FROM ORDERS WHERE id=:id";

    @Override
    public Order findById(Integer id) throws RepositoryException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        Order result;
        try {
            result = namedParameterJdbcTemplate.queryForObject(FIND_BY_ID, params, ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            throw new RepositoryException();
        }

        return result;
    }


    private static String SQL_ORDER_INS = "INSERT INTO ORDERS(TITLE, DESCRIPTION, TARGET_LINK, BACK_LINK) "
            + "VALUES(:title, :description, :target_link, :back_link)";

    @Override
    public Order insert(Order order) throws RepositoryException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            namedParameterJdbcTemplate.update(SQL_ORDER_INS, getSqlParameterByModel(order), keyHolder);
            List<Map<String, Object>> keyList = keyHolder.getKeyList();
            if (keyList != null) {
                Integer id = (Integer) keyList.listIterator().next().get("id");
                order.setOrderId(id.longValue());
            }

            return order;
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    private static String SQL_ORDER_UPDATE = "UPDATE ORDERS SET TITLE=:title , DESCRIPTION=:description, TARGET_LINK=:target_link, BACK_LINK=:back_link) WHERE ID=:id";

    @Override
    public void update(Order order) throws RepositoryException {
        try {
            namedParameterJdbcTemplate.update(SQL_ORDER_UPDATE, getSqlParameterByModel(order));
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    private static String SQL_SELECT_ALL = "SELECT * FROM ORDERS";

    @Override
    public List<Order> getAllOrders() throws RepositoryException {
        try {
            List<Order> result = namedParameterJdbcTemplate.query(SQL_SELECT_ALL, ROW_MAPPER);
            return result;
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    private static final class OrderMapper implements RowMapper<Order> {
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order or = new Order();
            or.setOrderId(rs.getLong("ID"));
            or.setTitle(rs.getString("TITLE"));
            or.setDescription(rs.getString("DESCRIPTION"));
            or.setTargetLink(rs.getString("TARGET_LINK"));
            or.setComeBackLink(rs.getString("BACK_LINK"));
            return or;
        }
    }

    private SqlParameterSource getSqlParameterByModel(Order order) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", order.getOrderId());
        paramSource.addValue("title", order.getTitle());
        paramSource.addValue("description", order.getDescription());
        paramSource.addValue("target_link", order.getTargetLink());
        paramSource.addValue("back_link", order.getComeBackLink());

        return paramSource;
    }
}
