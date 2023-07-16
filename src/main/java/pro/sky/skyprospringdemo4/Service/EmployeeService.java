package pro.sky.skyprospringdemo4.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo4.entity.Employee;
import pro.sky.skyprospringdemo4.exception.EmployeeNotFoundException;
import pro.sky.skyprospringdemo4.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo4.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
   private final Map<String, Employee> employees;

   public EmployeeService(){this.employees = new HashMap<>();}

    public Employee add(String firstName, String lastName){
       Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee find(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);

        if (employees.containsKey(employee.getFullName())){
                return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);

        if (employees.containsKey(employee.getFullName())){
            return employees.remove(employee.getFullName());
        }
            throw new EmployeeNotFoundException("Сотрудник не удален - не был найден в базе");
        }

    public Collection<Employee> findAll(){
       return Collections.unmodifiableCollection(employees.values());
    }
}
