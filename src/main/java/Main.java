import com.myschooljournal.dao.BookDao;
import com.myschooljournal.dao.LessonDao;
import com.myschooljournal.repo.LessonDaoImpl;
import com.myschooljournal.service.DinamycsService;
import com.myschooljournal.service.LessonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        BookDao bookDao= (BookDao) context.getBean("bookDao");
        //System.out.println(bookDao);
        DinamycsService dncsrv= (DinamycsService) context.getBean("dinamycsService");
        dncsrv.getDynamicsByPeriod(LocalDate.of(2017,01,01),LocalDate.of(2018,02,13));
        LessonDaoImpl lessonDaoImpl= (LessonDaoImpl) context.getBean("lessonDao");
        //System.out.println(lessonDaoImpl);
        LessonService lessonService= (LessonService) context.getBean("lessonService");
        //System.out.println(lessonService.getByName("Lena"));



    }
}
