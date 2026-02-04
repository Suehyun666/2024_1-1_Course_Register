package controller.strategy;

import constant.Constants;
import dao.CollegeDAO;
import model.IndexItem;
import model.MCollege;

import java.util.List;
import java.util.Vector;

public class CampusStrategy implements DirectoryStrategy {
    private CollegeDAO collegeDAO;

    public CampusStrategy() {
        this.collegeDAO = new CollegeDAO();
    }

    @Override
    public Vector<IndexItem> getItems(int campusId) {
        Vector<IndexItem> items = new Vector<>();
        List<MCollege> colleges = collegeDAO.findByCampusId(campusId);
        for (MCollege c : colleges) {
            items.add(new IndexItem(
                String.valueOf(c.getCollegeId()),
                c.getName(),
                Constants.Directory.COLLEGE_PREFIX + c.getCollegeId()
            ));
        }
        return items;
    }
}
