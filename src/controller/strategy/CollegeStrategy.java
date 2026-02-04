package controller.strategy;

import constant.Constants;
import dao.DepartmentDAO;
import model.IndexItem;
import model.MDepartment;

import java.util.List;
import java.util.Vector;

public class CollegeStrategy implements DirectoryStrategy {
    private DepartmentDAO departmentDAO;

    public CollegeStrategy() {
        this.departmentDAO = new DepartmentDAO();
    }

    @Override
    public Vector<IndexItem> getItems(int collegeId) {
        Vector<IndexItem> items = new Vector<>();
        List<MDepartment> depts = departmentDAO.findByCollegeId(collegeId);
        for (MDepartment d : depts) {
            items.add(new IndexItem(
                String.valueOf(d.getDeptId()),
                d.getName(),
                Constants.Directory.DEPT_PREFIX + d.getDeptId()
            ));
        }
        return items;
    }
}
