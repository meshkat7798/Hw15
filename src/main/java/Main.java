import menu.MainMenu;

public class Main {
    public static void main(String[] args) {

        MainMenu menu =new MainMenu();
//        EmployeeService employeeService = ApplicationContext.getEmployeeService();
//        Employee employee = new Employee("sama","bos","samaaa","12345","1234567");
//        employeeService.saveOrUpdate(employee);
        menu.start();

//        createFakeStudent();



    }

//    private static void createFakeStudent() {
//        Faker faker = new Faker();
//        EmployeeService employeeService = ApplicationContext.getEmployeeService();
//        StudentService service = ApplicationContext.getStudentService();
//        for (int i = 0; i < 500; i++) {
//            service.saveOrUpdate(
//                    new Student(
//                            faker.name().firstName(),
//                            faker.name().lastName(),
//                            faker.name().username(),
//                            RandomStringUtils.randomNumeric(9),
//                            RandomStringUtils.randomNumeric(9)
//                    )
//            );
//        }
//    }
}