package com.rit.group2.repositories;


import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import com.rit.group2.models.Address;
import com.rit.group2.models.Employee;

public class EmployeeRepository {

	private ArrayList<Employee> employees;

	private static EmployeeRepository employeeRepository;

	public EmployeeRepository(){
		createTestEmployees();
	}

	private void createTestEmployees() {
		employees = new ArrayList<Employee>();

		// Users generated with:
		// fetch('https://randomuser.me/api/?results=20').then(response=>{return response.json();}).then(res=>console.log(res['results']));
		// var constructors = [];
		// constructors = temp1.map(user => `new Employee("${user.name.first}", "${user.name.last}", new Address("${user.location.street}", "Rochester", "NY", 14580), "${user.phone}", "${user.email}", ${Math.random(120000)})`);
		// var finalString = '';
		// constructors.forEach(constru => finalString += (`employees.add(${constru});\n`));
		// First Level
		Employee firstLevelBoss = new Employee("Sam", "Murry", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)658-9050", "test@rit.edu", 1, "Software Engineering Dean");
		
		// Second Level
		Set<Employee> secondLevel = new HashSet<Employee>();
		Employee secondLevelBoss = new Employee("Nathan", "Connor", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)156-5490", "nxc5929@rit.edu", 1, "Department Head");
		secondLevel.add(secondLevelBoss);
		secondLevel.add(new Employee("Matt", "Anacelle", new Address("301 Lomb Rd", "Rochester", "NY", 14580), "(585)586-5975", "max5890@rit.edu", 1, "Secretary"));
		secondLevel.add(new Employee("Kaylie", "Glynn", new Address("300 Lomb Rd", "Rochester", "NY", 14580), "(585)963-1005", "kcg2690@rit.edu", 1, "Secretary"));
		
		
		// Third Level
		Set<Employee> thirdLevel = new HashSet<Employee>();
		Employee thirdLevelBoss = new Employee("petar", "grievink", new Address("6047 paardenveld", "Rochester", "NY", 14580), "(898)-021-9082", "petar.grievink@example.com", 74342, "Advising Head");
		thirdLevel.add(thirdLevelBoss);
		thirdLevel.add(new Employee("hunter", "liu", new Address("8979 richmond ave", "Rochester", "NY", 14580), "393-960-2147", "hunter.liu@example.com", 30370, "Secretary"));
		thirdLevel.add(new Employee("mariam", "derkx", new Address("4505 jutfaseweg", "Rochester", "NY", 14580), "(040)-297-7591", "mariam.derkx@example.com", 91076, "Secretary"));
		thirdLevel.add(new Employee("felix", "gordon", new Address("4500 smokey ln", "Rochester", "NY", 14580), "09-7963-6477", "felix.gordon@example.com", 14941, "Professor"));
		thirdLevel.add(new Employee("amy", "williams", new Address("4871 concession road 6", "Rochester", "NY", 14580), "862-589-7682", "amy.williams@example.com", 64618, "Lecturer"));
		thirdLevel.add(new Employee("eetu", "rantala", new Address("3676 otavalankatu", "Rochester", "NY", 14580), "04-978-439", "eetu.rantala@example.com", 4830, "General Teacher"));
		thirdLevel.add(new Employee("vanessa", "day", new Address("2600 main street", "Rochester", "NY", 14580), "015394 17018", "vanessa.day@example.com", 38686, "Teaching assistant"));
		thirdLevel.add(new Employee("emilie", "ennis", new Address("5737 dieppe ave", "Rochester", "NY", 14580), "358-949-0106", "emilie.ennis@example.com", 69047, "Teaching assistant"));
		thirdLevel.add(new Employee("hannah", "stephan", new Address("2349 beethovenstraße", "Rochester", "NY", 14580), "0340-1210480", "hannah.stephan@example.com", 85770, "Teching AID"));
		thirdLevel.add(new Employee("jessica", "nichols", new Address("2503 south street", "Rochester", "NY", 14580), "017684 53563", "jessica.nichols@example.com", 49048, "Instructor"));
		
		// Fourth Level
		Set<Employee> fourthLevel = new HashSet<>();
		fourthLevel.add(new Employee("angie", "larson", new Address("4874 main road", "Rochester", "NY", 14580), "017683 05885", "angie.larson@example.com", 55302, "Advisor"));
		fourthLevel.add(new Employee("austin", "payne", new Address("7248 bollinger rd", "Rochester", "NY", 14580), "04-3896-0471", "austin.payne@example.com", 66212, "Advisor"));
		fourthLevel.add(new Employee("glen", "morris", new Address("2217 rookery road", "Rochester", "NY", 14580), "071-300-5952", "glen.morris@example.com", 18887, "Advisor"));
		fourthLevel.add(new Employee("مانی", "نكو نظر", new Address("6529 شهید مطهری", "Rochester", "NY", 14580), "068-57868926", "مانی.نكونظر@example.com", 114397, "Advisor"));
		fourthLevel.add(new Employee("nick", "janssen", new Address("5199 ahornweg", "Rochester", "NY", 14580), "0783-2632769", "nick.janssen@example.com", 76632, "Advisor"));
		fourthLevel.add(new Employee("britney", "hughes", new Address("9947 highfield road", "Rochester", "NY", 14580), "016977 9039", "britney.hughes@example.com", 72978, "Co-op cordinator"));
		fourthLevel.add(new Employee("caroline", "larsen", new Address("5248 langgade", "Rochester", "NY", 14580), "62048487", "caroline.larsen@example.com", 77764, "Immersion Cordinator"));
		fourthLevel.add(new Employee("mila", "bernard", new Address("4320 place du 22 novembre 1943", "Rochester", "NY", 14580), "(301)-678-9967", "mila.bernard@example.com", 5043, "Counsoler"));
		fourthLevel.add(new Employee("علیرضا", "احمدی", new Address("4471 دکتر مفتح", "Rochester", "NY", 14580), "069-05673801", "علیرضا.احمدی@example.com", 69797, "Random1"));
		fourthLevel.add(new Employee("titouan", "girard", new Address("2306 rue abel-hovelacque", "Rochester", "NY", 14580), "(479)-105-6623", "titouan.girard@example.com", 62088, "Random2"));		
		
		firstLevelBoss.updateWorkers(secondLevel);
		secondLevelBoss.updateWorkers(thirdLevel);
		thirdLevelBoss.updateWorkers(fourthLevel);

		employees.add(firstLevelBoss);
		employees.addAll(secondLevel);
		employees.addAll(thirdLevel);
		employees.addAll(fourthLevel);

		// TODO: Remove for R2
		int id = 0;
		for (Employee employee : employees) {
			employee.setId(id);
			employee.setJobTitle("Education Teachers");
			id++;
		}
	}

	public static EmployeeRepository getInstance(){
		if(employeeRepository == null){
			employeeRepository = new EmployeeRepository();
		}
		return employeeRepository;
	}

	public void add(Employee employee) {
		employees.add(employee);
	}

	public Employee get(int employeeId) {
		if(employeeId < employees.size()){
			return employees.get(employeeId);
		}
		return null;
	}

	public ArrayList<Employee> getAll() {
		return employees;
	}
}
