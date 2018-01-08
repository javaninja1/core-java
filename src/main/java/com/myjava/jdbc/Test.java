package com.myjava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class Test {

    public static void main(String[] args) throws Exception {
        int mostCommonAge = getIntResult(SqlQueries. MOST_COMMON_AGE);
        int mostCommonBand = getIntResult(SqlQueries. MOST_COMMON_BAND);
    }

    private static DataSource dataSource;

    public static int getIntResult(String selectSQL) throws Exception {
        // Use try with resources to utilize autoclosable behavior
        int result = 0;
        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(selectSQL);
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            // Error handling code here, convert error to processing exception
        }
        return result;
    }

}
