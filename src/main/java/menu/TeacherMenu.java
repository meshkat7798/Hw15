package menu;

import entity.*;
import service.CourseService;
import service.ReportCardService;
import service.StudentService;
import service.TeacherService;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class TeacherMenu {

    TeacherService teacherService = ApplicationContext.getTeacherService();
    StudentService studentService = ApplicationContext.getStudentService();
    ReportCardService reportCardService = ApplicationContext.getReportCardService();
    CourseService courseService = ApplicationContext.getCourseService();

    MainMenu menu = new MainMenu();

    Scanner scanner = new Scanner(System.in);

    String userName;
    String passWord;

    public TeacherMenu(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        login();
    }

    public void login() {
        if (teacherService.existByUserNameAndPassword(userName, passWord)) {
            System.out.println("SUCCESSFULLY LOGGED IN");
            Teacher teacher = teacherService.findByUserName(userName);
            SecurityContext.fillContext(teacher);
            teacherMenu();
        } else {
            System.out.println("INVALID USERNAME AND PASSWORD");
        }
    }

    void teacherMenu() {
        while (true) {
            String text = """
                    *********
                    1- SHOW INFO
                    2- RECORD MARK FOR STUDENT
                    3- SHOW PAY SLIP
                    4- BACK
                    **********
                    """;
            System.out.println(text);
            int input = input();
            switch (input) {
                case 1:
                    showInfo();
                    break;
                case 2:
                    recordMarkForStudent();
                    break;
                case 3:
                    showPaySlip();
                    break;
                case 4:
                    menu.start();
                    break;
                default:
                    System.out.println("INVALID INPUT !");
                    teacherMenu();
                    break;
            }
        }
    }


    private void showInfo() {
        Integer currentUserId = SecurityContext.getCurrentUserId();
        Optional<Teacher> byId = teacherService.findById(currentUserId);
        System.out.println(byId.orElse(null));
    }

    private void recordMarkForStudent() {
        Integer currentUserId = SecurityContext.getCurrentUserId();
        Optional<Teacher> byId = teacherService.findById(currentUserId);
        Teacher teacher = byId.orElse(null);
        studentService.findAll().forEach(System.out::println);
        System.out.println("PLEASE CHOSE STUDENT ID : ");
        int id = input();
        Optional<Student> byId2 = studentService.findById(id);
        Student student = byId2.orElse(null);
        reportCardService.findCourseByStudentAndTeacher(student, teacher).forEach(System.out::println);
        System.out.println("PLEASE CHOSE COURSE ID :");
        int courseId = input();
        if (courseService.existsById(courseId)) {
            Optional<Course> byId3 = courseService.findById(courseId);
            Course course = byId3.orElse(null);
            System.out.println("PLEASE ENTER MARK :");
            double mark = scanner.nextDouble();
            if (!teacherService.recordStudentMark(mark, student, course)) {
                System.out.println("INVALID MARK");
                teacherMenu();
            }
        } else {
            System.out.println("WRONG ID !");
            teacherMenu();
        }
    }

    private void showPaySlip() {
        System.out.println("PLEASE ENTER TERM YEAR :");
        Integer year = input();
        System.out.println("PLEASE CHOOSE MIDTERM :");
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
                teacherMenu();
        }
        System.out.println(teacherService.showPaySlip(new Term(year, type)));
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