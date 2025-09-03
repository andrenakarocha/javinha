package com.dasa.dasa.infrastructure.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dasa.dasa.domain.entities.Product;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper converting DB rows into Product entities
    private RowMapper<Product> productRowMapper = new RowMapper<>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            String id = rs.getString("ID");
            String name = rs.getString("NAME");
            String barcode = rs.getString("BARCODE");
            LocalDateTime createdAt = rs.getTimestamp("CREATED_AT").toLocalDateTime();
            LocalDateTime updatedAt = rs.getTimestamp("UPDATED_AT").toLocalDateTime();

            return Product.fromDb(id, name, barcode, createdAt, updatedAt);
        }
    };

    // Create a new product
    public int createProduct(Product product) {
        String sql = "INSERT INTO PRODUCT (ID, NAME, BARCODE, CREATED_AT, UPDATED_AT) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                product.getId().toString(),
                product.getName(),
                product.getBarCode(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    // Get all products
    public List<Product> findAll() {
        String sql = "SELECT * FROM PRODUCT";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    // Get product by ID
    public Product findById(UUID id) {
        String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper, id.toString());
    }

    // Update product
    public int updateProduct(Product product) {
        String sql = "UPDATE PRODUCT SET NAME = ?, BARCODE = ?, UPDATED_AT = ? WHERE ID = ?";
        return jdbcTemplate.update(sql,
                product.getName(),
                product.getBarCode(),
                product.getUpdatedAt(),
                product.getId().toString()
        );
    }

    // Delete product
    public int deleteProduct(UUID id) {
        String sql = "DELETE FROM PRODUCT WHERE ID = ?";
        return jdbcTemplate.update(sql, id.toString());
    }
}