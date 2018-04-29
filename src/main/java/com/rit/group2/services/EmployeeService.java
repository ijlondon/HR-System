package com.rit.group2.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rit.group2.models.Address;
import com.rit.group2.models.BasicEmployee;
import com.rit.group2.models.Department;
import com.rit.group2.models.Employee;
import com.rit.group2.repositories.DepartmentRepository;
import com.rit.group2.repositories.EmployeeRepository;
import com.rit.group2.responses.ErrorResponse;
import com.rit.group2.responses.Response;
import com.rit.group2.responses.SuccessfulResponse;
import com.rit.group2.security.GoogleOauth2;

@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired 
	DepartmentRepository departmentRepository;

	@Autowired
	GoogleOauth2 googleSecurityService;

	public EmployeeService(){}


	public Response init(){
		Department department1 = new Department("Software Engineering");
		Department department2 = new Department("Business");
		Department department3 = new Department("Front End Developer");

		Employee employee1 = new Employee("Nathan", "Connor", new Address("1 Road", "Rochester", "NY", 14580), "(585) 760-9040", "nxc5929@rit.edu", department1, 1, "Backend Developer");
		Employee employee2 = new Employee("Rachel", "Connor", new Address("2 Road", "Rochester", "NY", 14580), "(585) 111-1111", "vfg3453@rit.edu", department1, 1, "Backend Developer");
		Employee employee3 = new Employee("Brandon", "Connor", new Address("3 Road", "Rochester", "NY", 14580), "(585) 222-2222", "ghr2045@rit.edu", department1, 1, "Backend Developer");
		Employee employee4 = new Employee("Matthew", "Connor", new Address("4 Road", "Rochester", "NY", 14580), "(585) 333-3333", "jwe0345@rit.edu", department1, 1, "Backend Developer");
		employee1.addWorker(employee2);
		employee1.addWorker(employee3);
		employee1.addWorker(employee4);
		employee2.setBoss(employee1);
		employee3.setBoss(employee1);
		employee4.setBoss(employee1);

		Employee employee5 = new Employee("Kaylie", "Glynn", new Address("5 Road", "Rochester", "NY", 14580), "(585) 444-4444", "nfe3920@rit.edu", department2, 1, "Backend Developer");
		Employee employee6 = new Employee("Dayna", "Glynn", new Address("6 Road", "Rochester", "NY", 14580), "(585) 555-5555", "fpo0921@rit.edu", department2, 1, "Backend Developer");
		Employee employee7 = new Employee("Marrie", "Glynn", new Address("7 Road", "Rochester", "NY", 14580), "(585) 666-6666", "psk0937@rit.edu", department2, 1, "Backend Developer");
		employee5.addWorker(employee6);
		employee5.addWorker(employee7);
		employee6.setBoss(employee5);
		employee7.setBoss(employee5);

		Employee employee8 = new Employee("Alex", "Christodoulou", new Address("8 Road", "Rochester", "NY", 14580), "(585) 888-8888", "alc3259@rit.edu", department3, 10000000, "Front Developer");
		Employee employee9 = new Employee("Dan", "Krutz", new Address("2 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 1, "Does Things");
		Employee employee10 = new Employee("Micheal", "Evans", new Address("3 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 1, "Coffee Boy");
		employee8.addWorker(employee9);
		employee8.addWorker(employee10);
		employee9.setBoss(employee8);
		employee10.setBoss(employee8);

		Employee employee11 = new Employee("Ian", "London", new Address("8 Road", "Rochester", "NY", 14580), "(585) 888-8888", "alc3259@rit.edu", department3, 10000000, "Front Developer");
		Employee employee12 = new Employee("Lilly", "Tob", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 1, "Does All The Things");
		Employee employee13 = new Employee("The Pumpkin", "Man", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 1, "Water Boy");
		employee11.addWorker(employee12);
		employee11.addWorker(employee13);
		employee12.setBoss(employee11);
		employee13.setBoss(employee11);

		Employee employee14 = new Employee("Huseen", "Mahkareem", new Address("3590 Road", "Rochester", "NY", 14580), "(585) 888-8888", "alc3259@rit.edu", department3, 10000000, "Front Developer");
		Employee employee15 = new Employee("Stock", "Bean", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 1, "TV Watcher");
		Employee employee16 = new Employee("Apple", "Pie", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 1, "Beer Boy");
		employee14.addWorker(employee15);
		employee14.addWorker(employee16);
		employee15.setBoss(employee14);
		employee16.setBoss(employee14);

		Employee employee17 = new Employee("Peace", "Omiponle", new Address("3890 Road", "Rochester", "NY", 14580), "(585) 888-8888", "alc3259@rit.edu", department3, 10000000, "Front Developer");
		Employee employee18 = new Employee("Corn", "On The Cob", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 1, "Computer Holder Assistant");
		Employee employee19 = new Employee("Sweet", "Caroline", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 1, "Mouse Holder Assistant");
		employee17.addWorker(employee18);
		employee17.addWorker(employee19);
		employee18.setBoss(employee17);
		employee19.setBoss(employee17);

		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);
		employeeRepository.save(employee5);
		employeeRepository.save(employee6);
		employeeRepository.save(employee7);
		employeeRepository.save(employee8);
		employeeRepository.save(employee9);
		employeeRepository.save(employee10);
		employeeRepository.save(employee11);
		employeeRepository.save(employee12);
		employeeRepository.save(employee13);
		employeeRepository.save(employee14);
		employeeRepository.save(employee15);
		employeeRepository.save(employee16);
		employeeRepository.save(employee17);
		employeeRepository.save(employee18);
		employeeRepository.save(employee19);

		return new SuccessfulResponse("Successfully init database", null);
	}

	public Response createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return new SuccessfulResponse("Successfully Created Employee", employee);
	}

	public Response getEmployee(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId);
		if(employee == null){
			return new ErrorResponse("Unable to find employee");
		}
		return new SuccessfulResponse("Successfully found employee", employee);
	}


	public Response editEmployee(String token, int employeeId, Employee employeeEdits) {
		if(canEdit(token, employeeId)){
			Employee originalEmployee = employeeRepository.findById(employeeId);
			if(originalEmployee == null){
				return new ErrorResponse("Unable to find employee");
			}
			if(employeeEdits.getFirstName() != null){
				originalEmployee.setFirstName(employeeEdits.getFirstName());
			}
			if(employeeEdits.getLastName() != null){
				originalEmployee.setLastName(employeeEdits.getLastName());
			}
			if(employeeEdits.getAddress().getStreet() != null){
				originalEmployee.getAddress().setStreet(employeeEdits.getAddress().getStreet());
			}
			if(employeeEdits.getAddress().getCity() != null){
				originalEmployee.getAddress().setCity(employeeEdits.getAddress().getCity());
			}
			if(employeeEdits.getAddress().getState() != null){
				originalEmployee.getAddress().setState(employeeEdits.getAddress().getState());
			}
			if(employeeEdits.getAddress().getZip() != 0){
				originalEmployee.getAddress().setZip(employeeEdits.getAddress().getZip());
			}
			if(employeeEdits.getTelephone() != null){
				originalEmployee.setTelephone(employeeEdits.getTelephone());
			}
			if(employeeEdits.getEmail() != null){
				originalEmployee.setEmail(employeeEdits.getEmail());
			}
			if(employeeEdits.getJobTitle() != null){
				originalEmployee.setJobTitle(employeeEdits.getJobTitle());
			}
			if(employeeEdits.getSalary() != 0){
				originalEmployee.setSalary(employeeEdits.getSalary());
			}
			if(employeeEdits.getDepartment() != null){
				Department department = departmentRepository.findById(employeeEdits.getDepartment().getId());
				if (department != null) {
					originalEmployee.setDepartment(department);
				}
			}
			if(employeeEdits.getBoss() != null){
				Employee boss = employeeRepository.findById(employeeEdits.getBoss().getId());
				if (boss != null) {
					originalEmployee.setBoss(boss);
					boss.addWorker(originalEmployee);
					employeeRepository.save(boss);
				}
			}
			employeeRepository.save(originalEmployee);
			return new SuccessfulResponse("Succesfully edited employee", originalEmployee);
		}else{
			return new ErrorResponse("Unable to edit this employee. Invalid authentication");
		}
	}

	public Response terminateEmployee(String userToken, int employeeId) {
		if(canEdit(userToken, employeeId)){
			Employee employee = employeeRepository.findById(employeeId);
			if(employee == null){
				return new ErrorResponse("Unable to find employee");
			}
			employee.terminate();
			Employee boss = employee.fetchBoss();
			if(boss != null){
				for(Employee worker: employee.fetchRawWorkers()){
					boss.addWorker(worker);
					worker.setBoss(boss);
					employeeRepository.save(worker);
				}
			}
			employeeRepository.save(boss);
			employeeRepository.save(employee);
			return new SuccessfulResponse("Successfully terminated employee", employee);
		}else{
			return new ErrorResponse("Unable to edit this employee. Invalid authentication");
		}
	}

	public Response changeDepartments(int employeeId, int newDepartmentId) {
		Department department = departmentRepository.findById(newDepartmentId);
		Employee employee = employeeRepository.findById(employeeId);

		if(employee == null || department == null){
			return new ErrorResponse("Employee or Department doesn't exist");
		}

		employee.setDepartment(department);
		employeeRepository.save(employee);

		return new SuccessfulResponse("Not implemented yet", employee);
	}

	public Response search(String searchQuery) {
		if(searchQuery == null){
			return new ErrorResponse("Search Query was empty");
		}
		ArrayList<BasicEmployee> employeesFound = new ArrayList<>();
		for(Employee employee: employeeRepository.findAll()){
			String[] searchedFields = {
					employee.getFirstName() + ' ' + employee.getLastName(), // Full Name
					employee.getTelephone(),
					employee.getEmail()
			};
			boolean matchingField = false;
			for (String field : searchedFields) {
				if (field.toLowerCase().contains(searchQuery.toLowerCase())) {
					matchingField = true;
				}
			}
			if (matchingField) {
				employeesFound.add(new BasicEmployee(employee));					
			}
		}
		return new SuccessfulResponse("Found " + employeesFound.size() + " matches", employeesFound);
	}

	public boolean canEdit(String userToken, int userToModifyId){
		Employee loggedInEmployee = googleSecurityService.getEmployeeFromToken(userToken);
		if(loggedInEmployee != null){
			return findIfBelow(loggedInEmployee, userToModifyId);
		}
		return false;
	}

	public Response canUserEdit(String userToken, int userToModifyId){
		boolean canEdit = canEdit(userToken, userToModifyId);
		if(canEdit){
			return new SuccessfulResponse("Successfully found user", true);
		}else{
			return new SuccessfulResponse("Unable to Edit", false);
		}
	}



	private boolean findIfBelow(Employee bossEmployee, int userToModifyId) {
		for(Employee worker: bossEmployee.fetchRawWorkers()){
			if(worker.getId() == userToModifyId){
				return true;
			}else{
				if (findIfBelow(worker, userToModifyId)){
					return true;
				}
			}
		}
		return false;
	}


	public Response userInfo(String userToken){
		Employee loggedInEmployee = googleSecurityService.getEmployeeFromToken(userToken);
		return new SuccessfulResponse("Successfully found user", loggedInEmployee);
	}

	public Response getAll() {
		ArrayList<BasicEmployee> employees = new ArrayList<>();
		for(Employee employee: employeeRepository.findAll()){
			if(employee.getActive()){
				employees.add(new BasicEmployee(employee));
			}
		}
		return new SuccessfulResponse("Retrieved all employees", employees);
	}
}
