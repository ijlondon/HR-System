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
		employeeRepository.deleteAll();
		departmentRepository.deleteAll();

		Department department0 = new Department("Administration");		
		Department department1 = new Department("Software Engineering");
		Department department2 = new Department("Business");
		Department department3 = new Department("Front End Developer");


		Employee employee1 = new Employee("Nathan", "Connor", new Address("1 Road", "Rochester", "NY", 14580), "(585) 760-9040", "nxc5929@g.rit.edu", department1, 99130, "Web Developers");
		Employee employee2 = new Employee("Rachel", "Kevin", new Address("2 Road", "Rochester", "NY", 14580), "(585) 111-1111", "vfg3453@rit.edu", department1, 70260, "Software Developers, Applications");
		Employee employee3 = new Employee("Brandon", "Kelly", new Address("3 Road", "Rochester", "NY", 14580), "(585) 222-2222", "ghr2045@rit.edu", department1, 56000, "Database Administrators");
		Employee employee4 = new Employee("Matthew", "Cores", new Address("4 Road", "Rochester", "NY", 14580), "(585) 333-3333", "jwe0345@rit.edu", department1, 56000, "Database Administrators");
		employee1.addWorker(employee2);
		employee1.addWorker(employee3);
		employee1.addWorker(employee4);
		employee2.setBoss(employee1);
		employee3.setBoss(employee1);
		employee4.setBoss(employee1);
		
		Employee employee5 = new Employee("Kaylie", "Glynn", new Address("5 Road", "Rochester", "NY", 14580), "(585) 444-4444", "testboss344@gmail.com", department2, 80671, "Computer Programmers");
		Employee employee6 = new Employee("Dayna", "Cross", new Address("6 Road", "Rochester", "NY", 14580), "(585) 555-5555", "fpo0921@rit.edu", department2, 80672, "Computer Programmers");
		Employee employee7 = new Employee("Marrie", "Richards", new Address("7 Road", "Rochester", "NY", 14580), "(585) 666-6666", "psk0937@rit.edu", department2, 80673, "Computer Programmers");
		employee5.addWorker(employee6);
		employee5.addWorker(employee7);
		employee6.setBoss(employee5);
		employee7.setBoss(employee5);

		Employee employee8 = new Employee("Alex", "Christodoulou", new Address("8 Road", "Rochester", "NY", 14580), "(585) 888-8888", "amc8391@g.rit.edu", department3, 99130, "Web Developers");
		Employee employee9 = new Employee("Dan", "Krutz", new Address("2 Road", "Rochester", "NY", 14580), "(585) 111-1111", "dxkvse@g.rit.edu", department3, 47780, "Technical Writers");
		Employee employee10 = new Employee("Micheal", "Evans", new Address("3 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 27910, "Interpreters and Translators");
		employee8.addWorker(employee9);
		employee8.addWorker(employee10);
		employee9.setBoss(employee8);
		employee10.setBoss(employee8);

		Employee employee11 = new Employee("Ian", "London", new Address("8 Road", "Rochester", "NY", 14580), "(585) 888-8888", "ijl8216@g.rit.edu", department3, 99130, "Web Developers");
		Employee employee12 = new Employee("Lilly", "Tob", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 51410, "Biological Technicians");
		Employee employee13 = new Employee("Coby", "Konkrite", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 61590, "Epidemiologists");
		employee11.addWorker(employee12);
		employee11.addWorker(employee13);
		employee12.setBoss(employee11);
		employee13.setBoss(employee11);

		Employee employee14 = new Employee("Huseen", "Mahkareem", new Address("3590 Road", "Rochester", "NY", 14580), "(585) 888-8888", "hjm3628@g.rit.edu", department3, 99130, "Web Developers");
		Employee employee15 = new Employee("Bob", "Bean", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 42630, "Mental Health Counselors");
		Employee employee16 = new Employee("Joe", "Pie", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "rpe0495@rit.edu", department3, 40820, "Choreographers");
		employee14.addWorker(employee15);
		employee14.addWorker(employee16);
		employee15.setBoss(employee14);
		employee16.setBoss(employee14);

		Employee employee17 = new Employee("Peace", "Omiponle", new Address("3890 Road", "Rochester", "NY", 14580), "(585) 888-8888", "pto7724@g.rit.edu", department3, 99130, "Web Developers");
		Employee employee18 = new Employee("Paul", "Polanco", new Address("7 Road", "Rochester", "NY", 14580), "(585) 111-1111", "fjr9554@rit.edu", department3, 53230, "Computer User Support Specialists");
		Employee employee19 = new Employee("Klein", "Richards", new Address("1126 Road", "Rochester", "NY", 14580), "(585) 222-2222", "spc0495@rit.edu", department3, 94160, "Computer Network Support Specialists");
		employee17.addWorker(employee18);
		employee17.addWorker(employee19);
		employee18.setBoss(employee17);
		employee19.setBoss(employee17);

		Employee employee0 = new Employee("Tom", "Selleck", new Address("1 Drive", "Rochester", "NY", 14580), "(585) 760-9050", "selleckt3@gmail.com", department0, 277800, "Chief Executives");
		Employee employee20 = new Employee("Betty", "White", new Address("2 Drive", "Rochester", "NY", 14580), "(585) 760-9051", "testall344@gmail.com", department0, 215180, "Computer and Information Systems Managers");
		Employee employee21 = new Employee("Tony", "Tony", new Address("3 Drive", "Rochester", "NY", 14580), "(585) 760-9052", "txs@rit.edu", department0, 215180, "Computer and Information Systems Managers");
		employee20.setAdmin(true);
		employee21.setAdmin(true);
		employee0.addWorker(employee20);
		employee0.addWorker(employee21);
		employee0.setAdmin(true);
		employee20.setBoss(employee0);
		employee21.setBoss(employee0);
		employee0.addWorker(employee1);
		employee0.addWorker(employee5);
		employee0.addWorker(employee8);
		employee0.addWorker(employee11);
		employee0.addWorker(employee14);
		employee0.addWorker(employee17);
		employee1.setBoss(employee0);
		employee5.setBoss(employee0);
		employee8.setBoss(employee0);
		employee11.setBoss(employee0);
		employee14.setBoss(employee0);
		employee17.setBoss(employee0);

		
		departmentRepository.save(department0);
		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		employeeRepository.save(employee0);
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
		employeeRepository.save(employee20);
		employeeRepository.save(employee21);

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
		boolean totalEdit = canEdit(token, employeeId);
		boolean isSelf = isLoggenInEmployee(token, employeeId);
		if(totalEdit || isSelf){
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
			if(employeeEdits.getJobTitle() != null && totalEdit){
				originalEmployee.setJobTitle(employeeEdits.getJobTitle());
			}
			if(employeeEdits.getSalary() != 0 && totalEdit){
				originalEmployee.setSalary(employeeEdits.getSalary());
			}
			if(employeeEdits.getDepartment() != null && totalEdit){
				Department department = departmentRepository.findById(employeeEdits.getDepartment().getId());
				if (department != null) {
					originalEmployee.setDepartment(department);
				}
			}
			if(employeeEdits.getBoss() != null && totalEdit){
				Employee boss = employeeRepository.findById(employeeEdits.getBoss().getId());
				Employee orignalBoss = originalEmployee.fetchBoss();
				if(orignalBoss != null){
					orignalBoss.removeWorker(originalEmployee);
					employeeRepository.save(orignalBoss);
				}
				if (boss != null) {
					originalEmployee.setBoss(boss);
					boss.addWorker(originalEmployee);
					System.out.println("Adding Boss");
					employeeRepository.save(boss);
				}
			}
			System.out.println("Adding Employee");
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
				boss.removeWorker(employee);
				employee.setBoss(null);
				Set<Employee> workers = employee.fetchRawWorkers();
				employee.clearAllWorkers();
				employeeRepository.save(employee);
				
				for(Employee worker: workers){
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

	private boolean canEdit(String userToken, int userToModifyId){
		Employee loggedInEmployee = googleSecurityService.getEmployeeFromToken(userToken);
		if(loggedInEmployee.getAdmin()){
			return true;
		}
		if(loggedInEmployee != null){
			return findIfBelow(loggedInEmployee, userToModifyId);
		}
		return false;
	}
	
	private boolean isLoggenInEmployee(String userToken, int employeeId){
		return googleSecurityService.getEmployeeFromToken(userToken).getId() == employeeId;
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
