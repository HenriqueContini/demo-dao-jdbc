import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 - findById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2 - findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3 - insert ===");
        Department newDep = new Department(null, "Teste");
        departmentDao.insert(newDep);
        System.out.println(newDep);

        System.out.println("\n=== TEST 4 - update ===");
        dep = departmentDao.findById(8);
        dep.setName("Music");
        departmentDao.update(dep);
        System.out.println("Update completed: " + dep);

        System.out.println("\n=== TEST 5 - delete ===");
        departmentDao.deleteById(6);
        System.out.println("Delete completed: ");
        list = departmentDao.findAll();
        list.forEach(System.out::println);
    }
}