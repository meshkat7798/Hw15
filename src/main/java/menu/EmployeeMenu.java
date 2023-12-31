package menu;

import entity.*;
import service.*;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeMenu {

    Scanner scanner = new Scanner(System.in);

    EmployeeService employeeService = ApplicationContext.getEmployeeService();
    StudentService studentService = ApplicationContext.getStudentService();
    TeacherService teacherService = ApplicationContext.getTeacherService();
    CourseService courseService = ApplicationContext.getCourseService();
    LessonService lessonService = ApplicationContext.getLessonService();

    MainMenu menu = new MainMenu();

    String userName;
    String passWord;

    public EmployeeMenu(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        login();
    }

    public void login() {
        if (employeeService.existByUserNameAndPassword(userName, passWord)) {
            System.out.println("SUCCESSFULLY LOGGED IN");
            Employee employee = employeeService.findByUserName(userName);
            SecurityContext.fillContext(employee);
            employeeServices();
        } else {
            System.out.println("INVALID USERNAME AND PASSWORD");
            menu.start();
        }
    }

    public void employeeServices() {
        while (true) {
            String text = """
                    1- STUDENT CRUD
                    2- TEACHER CRUD
                    3- EMPLOYEE CRUD
                    4- COURSE CRUD
                    5- SHOW PAYSLIP
                    6- LOGOUT
                    """;
            System.out.println("*** PLEASE ENTER YOUR CHOICE : ***");
            System.out.println(text);
            int select = input();
            switch (select) {
                case 1:
                    studentCrud();
                    break;
                case 2:
                    teacherCrud();
                    break;
                case 3:
                    employeeCrud();
                    break;
                case 4:
                    courseCrud();
                    break;
                case 5:
                    showPaySlip();
                    break;
                case 6:
                    menu.start();
                    break;
                default:
                    System.out.println("INVALID INPUT ! ");
                    employeeServices();
                    break;
            }
        }
    }


    private void studentCrud() {
        while (true) {
            switch (selectCrud()) {
                case 1: {
                    Student student = fillStudent();
                    studentService.saveOrUpdate(student);
                    System.out.println("STUDENT SUCCESSFULLY REGISTERED");
                    break;

                }
                case 2: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN STUDENT ID");
                    Integer id = input();
                    if (studentService.existsById(id)) {
                        Student student = fillStudent();
                        student.setId(id);
                        studentService.saveOrUpdate(student);
                        System.out.println("STUDENT SUCCESSFULLY UPDATED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 3: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN STUDENT ID");
                    Integer id = input();
                    if (studentService.existsById(id)) {
                        studentService.delete(id);
                        System.out.println("STUDENT SUCCESSFULLY DELETED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 4:
                    employeeServices();
                    break;
                default:
                    System.out.println("INVALID INPUT ! ");
                    studentCrud();
            }
        }
    }

    private Student fillStudent() {
        System.out.println("PLEASE ENTER FIRST Name : ");
        String firstName = scanner.next();
        System.out.println("PLEASE ENTER LAST Name : ");
        String lastName = scanner.next();
        System.out.println("PLEASE ENTER USERNAME : ");
        String userName = scanner.next();
        System.out.println("PLEASE ENTER PASSWORD : ");
        String passWord = scanner.next();
        System.out.println("PLEASE ENTER STUDENT NUMBER : ");
        String studentNumber = scanner.next();
        return new Student(firstName, lastName, userName, passWord, studentNumber);
    }

    private void teacherCrud() {
        while (true) {
            switch (selectCrud()) {
                case 1: {
                    Teacher teacher = fillTeacher();
                    teacherService.saveOrUpdate(teacher);
                    System.out.println("TEACHER SUCCESSFULLY REGISTERED");
                    break;

                }
                case 2: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN TEACHER ID");
                    Integer id = input();
                    if (teacherService.existsById(id)) {
                        Teacher teacher = fillTeacher();
                        teacher.setId(id);
                        teacherService.saveOrUpdate(teacher);
                        System.out.println("TEACHER SUCCESSFULLY UPDATED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 3: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN TEACHER ID");
                    Integer id = input();
                    if (teacherService.existsById(id)) {
                        teacherService.delete(id);
                        System.out.println("TEACHER SUCCESSFULLY DELETED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 4:
                    employeeServices();
                    break;
                default:
                    System.out.println("INVALID INPUT ! ");
                    teacherCrud();
            }
        }
    }

    private Teacher fillTeacher() {
        System.out.println("PLEASE ENTER FIRST Name : ");
        String firstName = scanner.next();
        System.out.println("PLEASE ENTER LAST Name : ");
        String lastName = scanner.next();
        System.out.println("PLEASE ENTER USERNAME : ");
        String userName = scanner.next();
        System.out.println("PLEASE ENTER PASSWORD : ");
        String passWord = scanner.next();
        System.out.println("PLEASE ENTER TEACHER NUMBER : ");
        String teacherNumber = scanner.next();
        System.out.println("PLEASE CHOOSE TEACHER TYPE");
        String text = """
                1- ACADEMIC_STAFF
                2- HOURLY_TEACHING
                """;
        System.out.println(text);
        int teacherType = input();
        TeacherType type = null;
        switch (teacherType) {
            case 1:
                type = TeacherType.ACADEMIC_STAFF;
                break;
            case 2:
                type = TeacherType.HOURLY_TEACHING;
                break;
            default:
                System.out.println("INVALID INPUT ! ");
                fillTeacher();
        }
        return new Teacher(firstName, lastName, userName, passWord, teacherNumber, type);
    }


    private void employeeCrud() {
        while (true) {
            switch (selectCrud()) {
                case 1: {
                    Employee employee = fillEmployee();
                    employeeService.saveOrUpdate(employee);
                    System.out.println("EMPLOYEE SUCCESSFULLY REGISTERED");
                    break;

                }
                case 2: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN EMPLOYEE ID");
                    Integer id = input();
                    if (employeeService.existsById(id)) {
                        Employee employee = fillEmployee();
                        employee.setId(id);
                        employeeService.saveOrUpdate(employee);
                        System.out.println("EMPLOYEE SUCCESSFULLY UPDATED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 3: {
                    System.out.println("PLEASE ENTER YOUR CHOSEN EMPLOYEE ID");
                    Integer id = input();
                    if (employeeService.existsById(id)) {
                        employeeService.delete(id);
                        System.out.println("EMPLOYEE SUCCESSFULLY DELETED");
                    } else System.out.println("THIS ID DOES NOT EXIST !");
                    break;
                }
                case 4:
                    employeeServices();
                    break;
                default:
                    System.out.println("INVALID INPUT ! ");
                    teacherCrud();
            }
        }
    }

    private Employee fillEmployee() {
        System.out.println("PLEASE ENTER FIRST Name : ");
        String firstName = scanner.next();
        System.out.println("PLEASE ENTER LAST Name : ");
        String lastName = scanner.next();
        System.out.println("PLEASE ENTER USERNAME : ");
        String userName = scanner.next();
        System.out.println("PLEASE ENTER PASSWORD : ");
        String passWord = scanner.next();
        System.out.println("PLEASE ENTER EMPLOYEE NUMBER : ");
        String employeeNumber = scanner.next();
        return new Employee(firstName, lastName, userName, passWord, employeeNumber);
    }

    private void courseCrud() {
        switch (selectCrud()) {
            case 1: {
                Course course = fillCourse();
                courseService.saveOrUpdate(course);
                System.out.println("COURSE SUCCESSFULLY REGISTERED");
                break;

            }
            case 2: {
                System.out.println("PLEASE ENTER YOUR CHOSEN COURSE ID");
                Integer id = input();
                if (courseService.existsById(id)) {
                    Course course = fillCourse();
                    course.setId(id);
                    courseService.saveOrUpdate(course);
                    System.out.println("COURSE SUCCESSFULLY UPDATED");
                } else System.out.println("THIS ID DOES NOT EXIST !");
                break;
            }
            case 3: {
                System.out.println("PLEASE ENTER YOUR CHOSEN COURSE ID");
                Integer id = input();
                if (courseService.existsById(id)) {
                    courseService.delete(id);
                    System.out.println("COURSE SUCCESSFULLY DELETED");
                } else System.out.println("THIS ID DOES NOT EXIST !");
                break;
            }
            case 4:
                employeeServices();
                break;
            default:
                System.out.println("INVALID INPUT ! ");
                teacherCrud();
        }


    }

    private Course fillCourse() {

        System.out.println("PLEASE CHOOSE LESSON :");
        Collection<Lesson> all = lessonService.findAll();
        all.forEach(System.out::println);
        Integer id = input();
        Optional<Lesson> lessonById = lessonService.findById(id);

        System.out.println("PLEASE CHOOSE TEACHER :");
        Collection<Teacher> allTeacher = teacherService.findAll();
        allTeacher.forEach(System.out::println);
        Integer idTeacher = input();
        Optional<Teacher> teacherById = teacherService.findById(idTeacher);

        System.out.println("PLEASE ENTER TERM YEAR :");
        Integer year = input();
        System.out.println("PLEASE CHOOSE MIDTERM :");
        String text = """
                1- FIRST
                2- SECOND
                """;
        System.out.println(text);
        int midTerm = input();
        MidTerm type = null;
        switch (midTerm) {
            case 1:
                type = MidTerm.FIRST;
                break;
            case 2:
                type = MidTerm.SECOND;
                break;
            default:
                System.out.println("INVALID INPUT ! ");
                courseCrud();
        }
        return new Course(lessonById.orElse(null), teacherById.orElse(null), new Term(year, type));
    }

    private void showPaySlip() {
        System.out.println(employeeService.showPaySlip());
    }

    public int selectCrud() {
        String text = """
                ******************
                1- ADD
                2- UPDATE
                3- DELETE
                4- BACK
                ******************
                """;
        System.out.println(text);
        return input();
    }

    public Integer input() {
        int i;
        while (true) {
            try {
                i = scanner.nextInt();
                scanner.nextLine();
                return i;
            } catch (InputMismatchException in) {
                scanner.nextLine();
                System.out.println("PLEASE ENTER VALID NUMBER !");
            }
        }
    }
}