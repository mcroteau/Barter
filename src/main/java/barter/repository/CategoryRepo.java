package barter.repository;

import barter.model.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepo {

    private static final Logger log = Logger.getLogger(CategoryRepo.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public long getId() {
        String sql = "select max(id) from categories";
        long id = jdbcTemplate.queryForObject(sql, new Object[]{}, Long.class);
        return id;
    }

    public Long getCount() {
        String sql = "select count(*) from categories";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return count;
    }

    public Long getCount(Long id) {
        String sql = "select count(*) from categories where status_id = ?";
        Long count = jdbcTemplate.queryForObject(sql, new Object[]{ id }, Long.class);
        return count;
    }

    public Category get(long id){
        String sql = "select * from categories where id = ?";
        Category category = jdbcTemplate.queryForObject(sql, new Object[]{ id },
                new BeanPropertyRowMapper<>(Category.class));
        return category;
    }

    public List<Category> getList(){
        String sql = "select * from categories";
        List<Category> categories = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
        return categories;
    }

    public List<Category> getList(Long id){
        String sql = "select * from categories where prospect_id = ?";
        List<Category> categories = jdbcTemplate.query(sql, new Object[]{ id }, new BeanPropertyRowMapper<>(Category.class));
        return categories;
    }

    public Category save(Category category){
        String sql = "insert into categories (uri, name, desciption, image_uri, layout_id) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {
            category.getUri(), category.getName(), category.getDescription(), category.getImageUri(), category.getLayoutId()
        });

        Long id = getId();
        Category savedCategory = get(id);
        return savedCategory;
    }

    public boolean update(Category category) {
        String sql = "update categories set uri = ?, name = ?, description = ?, image_uri = ?, layout_id = ? where id = ?";
        jdbcTemplate.update(sql, new Object[] {
            category.getUri(), category.getName(), category.getDescription(), category.getImageUri(), category.getLayoutId(), category.getId()
        });
        return true;
    }

    public boolean delete(long id){
        String sql = "delete from categories where id = ?";
        jdbcTemplate.update(sql, new Object[] {id });
        return true;
    }
}
