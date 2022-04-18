import java.time.*;
import java.util.*;
import java.sql.*;

public class FileDatabaseUtilities extends DatabaseUtilities {
    private String fileTableName = "file";

    public void createFile(String userID, String path, String repositoryId, String status, LocalDateTime lastModified, LocalDateTime lastCommitted, LocalDateTime lastPushed) {
        String query = "INSERT INTO " + fileTableName + " (_id, path, repository_id, status, last_modified, last_committed, last_pushed) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userID);
            pstmt.setString(2, path);
            pstmt.setString(3, repositoryId);
            pstmt.setString(4, status);
            pstmt.setObject(5, lastModified);
            pstmt.setObject(6, lastCommitted);
            pstmt.setObject(7, lastPushed);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTrackedFiles(String repositoryId) {
        ArrayList<String> trackedFiles = new ArrayList<String>();
        String query = "SELECT * FROM " + fileTableName + " WHERE repository_id = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, repositoryId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                trackedFiles.add(rs.getString("path"));
            }
            return trackedFiles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
