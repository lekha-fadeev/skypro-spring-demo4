package pro.sky.skyprospringdemo4.controller;

import pro.sky.skyprospringdemo4.entity.Employee;
import pro.sky.skyprospringdemo4.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e){
        return "Code: " + e.getStatusCode() + "Error: " + e.getMessage();
    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.find(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}

