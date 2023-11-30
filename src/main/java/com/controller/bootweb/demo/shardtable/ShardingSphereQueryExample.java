package com.controller.bootweb.demo.shardtable;

import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ShardingSphereQueryExample {

    private final JdbcTemplate jdbcTemplate;

    public ShardingSphereQueryExample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> queryUserData(long userId) {
        // 使用 HintManager 提供分片键（ShardingSphere 通过Hint进行分片的一种方式）
        try (HintManager hintManager = HintManager.getInstance()) {
//            hintManager.addDatabaseShardingValue("user_table", "user_id", userId);
//            hintManager.addTableShardingValue("user_table", "user_id", userId);
            hintManager.addDatabaseShardingValue("user_table",  userId);
            hintManager.addTableShardingValue("user_table",  userId);
            // 执行查询
            String sql = "SELECT * FROM user_table WHERE user_id = ?";
            return jdbcTemplate.queryForList(sql, userId);
        }
    }

    public static void main(String[] args) {
        // 假设已经创建了 ShardingSphereDataSource，并注入到 JdbcTemplate 中
        JdbcTemplate jdbcTemplate = getShardingSphereJdbcTemplate();

        ShardingSphereQueryExample queryExample = new ShardingSphereQueryExample(jdbcTemplate);

        // 查询用户ID为1001的数据
        long userId = 1001;
        List<Map<String, Object>> result = queryExample.queryUserData(userId);

        // 输出查询结果
        for (Map<String, Object> row : result) {
            System.out.println("User ID: " + row.get("user_id") +
                    ", Username: " + row.get("username"));
        }
    }

    private static JdbcTemplate getShardingSphereJdbcTemplate() {
        // 假设已经创建了 ShardingSphereDataSource，并注入到 JdbcTemplate 中
        // 这里需要根据具体的配置进行创建 ShardingSphereDataSource
        // 这个示例中，假设已经使用 Spring Boot 进行了 ShardingSphere 的配置
        // 需要在 application.properties 或 application.yml 中配置数据源信息和分片规则
        // 可以通过 ShardingSphereAutoConfiguration 或手动配置 ShardingSphereDataSource
        // 参考 ShardingSphere 官方文档：https://shardingsphere.apache.org/document/current/cn/overview/
        return new JdbcTemplate(); // 实际中需要替换为 ShardingSphereDataSource
    }
}
