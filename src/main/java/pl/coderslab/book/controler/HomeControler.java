package pl.coderslab.book.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.model.Book;

@Controller
public class HomeControler {
    @GetMapping("/")
    @ResponseBody
    public Book home(){
        return new Book();
    }
}
