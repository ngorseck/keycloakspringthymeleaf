package sn.samane.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sn.samane.service.DepartmentService;

@Controller
@AllArgsConstructor
public class DepartmentControllerWeb {

    private DepartmentService departmentService;

    @PostAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/alldepartments")
    public String departments (Model model) {
        model.addAttribute("departments", departmentService.getDepartments());
        return "departments/list";
    }
}
