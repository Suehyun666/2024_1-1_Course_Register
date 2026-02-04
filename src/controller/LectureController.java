package controller;

import dao.LectureDAO;
import model.IndexItem;
import model.MLecture;

import controller.strategy.CampusStrategy;
import controller.strategy.CollegeStrategy;
import controller.strategy.DirectoryStrategy;
import controller.strategy.RootStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class LectureController {
    private LectureDAO lectureDAO;
    private Map<String, DirectoryStrategy> strategies;

    public LectureController() {
        this.lectureDAO = new LectureDAO();
        this.strategies = new HashMap<>();
        
        strategies.put(constant.Constants.Directory.ROOT, new RootStrategy());
        strategies.put(constant.Constants.Directory.CAMPUS_PREFIX.replace(":", ""), new CampusStrategy());
        strategies.put(constant.Constants.Directory.COLLEGE_PREFIX.replace(":", ""), new CollegeStrategy());
    }

    public Vector<IndexItem> getDirectories(String link) {
        if (link == null || link.isEmpty()) {
            link = constant.Constants.Directory.ROOT;
        }

        String prefix = constant.Constants.Directory.ROOT;
        int id = 0;

        // Parse link to find prefix and ID
        if (!link.equals(constant.Constants.Directory.ROOT)) {
            String[] parts = link.split(":");
            if (parts.length == 2) {
                prefix = parts[0];
                try {
                    id = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return new Vector<>();
                }
            }
        }

        DirectoryStrategy strategy = strategies.get(prefix);
        if (strategy != null) {
            return strategy.getItems(id);
        }
        
        // Return empty vector if no strategy found
        return new Vector<>();
    }

    public List<MLecture> getLectures(String link) {
        if (link != null && link.startsWith("dept:")) {
            try {
                int deptId = Integer.parseInt(link.split(":")[1]);
                return lectureDAO.findByDeptId(deptId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public List<MLecture> searchLectures(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return lectureDAO.search(keyword);
        }
        return new ArrayList<>();
    }
}
