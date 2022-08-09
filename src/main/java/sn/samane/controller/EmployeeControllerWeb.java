package sn.samane.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.samane.domain.Employee;
import sn.samane.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class EmployeeControllerWeb {
    private EmployeeService employeeService;

    //Documentation https://www.baeldung.com/spring-thymeleaf-pagination
    @PostAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/allemployees")
    public String employees (Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(1);
        Page<Employee> employeesPage = employeeService.getEmployees(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("employees", employeesPage);

        int totalPages = employeesPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "employees/list";
    }
    @GetMapping("/index")
    public String index () {
        return "accueil";
    }
    @GetMapping("/")
    public String home () {
        return "accueil";
    }
    @GetMapping("/accueil")
    public String accueil () {
        return "accueil";
    }

    @GetMapping("/logout")
    public String logout (HttpServletRequest request) throws ServletException {
         request.logout();
        return "redirect:/";
    }
}
